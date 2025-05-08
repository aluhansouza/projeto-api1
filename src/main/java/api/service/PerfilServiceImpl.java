package api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import api.dto.PerfilAtualizaDTO;
import api.dto.PerfilCadastroDTO;
import api.dto.PerfilDTO;
import api.entity.Perfil;
import api.exception.BusinessException;
import api.exception.RecursoNaoEncontradoException;
import api.mapper.PerfilMapper;
import api.repository.PerfilRepository;

@Service
public class PerfilServiceImpl implements PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    @Autowired
    private PerfilMapper perfilMapper;

    @Override
    public PerfilDTO cadastrar(PerfilCadastroDTO dto) {
        if (perfilRepository.existsByNome(dto.getNome())) {
            throw new BusinessException("Perfil com esse nome já existe.");
        }

        Perfil perfil = perfilMapper.toEntity(dto);
        perfil = perfilRepository.save(perfil);
        return perfilMapper.toDTO(perfil);
    }

    @Override
    public PerfilDTO atualizar(Long id, PerfilAtualizaDTO dto) {
        Perfil perfilExistente = perfilRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Perfil não encontrado"));

        perfilMapper.updateFromDTO(dto, perfilExistente);

        perfilExistente = perfilRepository.save(perfilExistente);
        return perfilMapper.toDTO(perfilExistente);
    }

    @Override
    public List<PerfilDTO> listarTodos() {
        return perfilRepository.findAll()
                .stream()
                .map(perfilMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PerfilDTO buscarPorId(Long id) {
        Perfil perfil = perfilRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Perfil não encontrado"));

        return perfilMapper.toDTO(perfil);
    }

    @Override
    public void excluir(Long id) {
        Perfil perfilExistente = perfilRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Perfil não encontrado"));

        perfilRepository.delete(perfilExistente);
    }
    
    @Override
    public Page<PerfilDTO> listarPaginado(Pageable pageable) {
        return perfilRepository.findAll(pageable)
            .map(perfil -> perfilMapper.toDTO(perfil));
    }
}
