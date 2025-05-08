package api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import api.dto.UsuarioAtualizaDTO;
import api.dto.UsuarioCadastroDTO;
import api.dto.UsuarioDTO;
import api.entity.Perfil;
import api.entity.Usuario;
import api.exception.RecursoNaoEncontradoException;
import api.mapper.UsuarioMapper;
import api.repository.PerfilRepository;
import api.repository.UsuarioRepository;
import api.specification.UsuarioSpecification;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PerfilRepository perfilRepository;
	
	@Autowired
	private UsuarioMapper usuarioMapper;

	// USANDO DTO E MODEL MAPPER

	@Override
	@Transactional
	public UsuarioDTO cadastrar(UsuarioCadastroDTO dto) {
	    Usuario usuario = usuarioMapper.toEntity(dto);

	    Perfil perfil = perfilRepository.findById(dto.getPerfilId())
	            .orElseThrow(() -> new RecursoNaoEncontradoException("Perfil não encontrado"));
	    usuario.setPerfil(perfil);

	    usuario = usuarioRepository.save(usuario);
	    return usuarioMapper.toDTO(usuario);
	}
	
	

	@Override
	@Transactional
	public UsuarioDTO atualizar(Long id, UsuarioAtualizaDTO dto) {
	    Usuario usuario = usuarioRepository.findById(id)
	        .orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado"));

	    // Mapeia campos atualizáveis, exceto o perfil
	    usuarioMapper.updateFromDto(dto, usuario);

	    // Busca o perfil correto
	    if (dto.getPerfilId() != null) {
	        Perfil perfil = perfilRepository.findById(dto.getPerfilId())
	            .orElseThrow(() -> new RecursoNaoEncontradoException("Perfil não encontrado"));

	        // Seta o perfil existente (e gerenciado) no usuário
	        usuario.setPerfil(perfil);
	    }

	    // Salva e retorna
	    Usuario atualizado = usuarioRepository.save(usuario);
	    return usuarioMapper.toDTO(atualizado);
	}

	@Override
	public UsuarioDTO buscarPorId(Long id) {
	    Usuario usuario = usuarioRepository.findById(id)
	            .orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado"));

	    return usuarioMapper.toDTO(usuario);
	}

	@Override
	public List<UsuarioDTO> listarTodos() {
	    List<Usuario> usuarios = usuarioRepository.findAll();
	    return usuarioMapper.toDTOList(usuarios);
	}

	@Override
	@Transactional
	public void excluir(Long id) {
	    Usuario usuario = usuarioRepository.findById(id)
	            .orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado"));

	    usuarioRepository.delete(usuario);
	}



	@Override
	public Page<UsuarioDTO> listarPaginado(Pageable pageable) {
	    return usuarioRepository.findAll(pageable)
	        .map(usuario -> usuarioMapper.toDTO(usuario)); // ou manual se não estiver usando MapStruct ainda
	}
	
	
	@Override
	public Page<UsuarioDTO> listarFiltrado(String nome, String email, String status, String perfilNome, Pageable pageable) {
	    Specification<Usuario> spec = Specification
	        .where(UsuarioSpecification.nomeContem(nome))
	        .and(UsuarioSpecification.emailContem(email))
	        .and(UsuarioSpecification.statusIgual(status))
	        .and(UsuarioSpecification.perfilIgual(perfilNome));

	    return usuarioRepository.findAll(spec, pageable)
	        .map(usuario -> usuarioMapper.toDTO(usuario)); // ou seu mapper atual
	}




}