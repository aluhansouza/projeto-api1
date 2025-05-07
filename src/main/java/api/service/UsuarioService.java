package api.service;

import java.util.List;

import api.dto.UsuarioAtualizaDTO;
import api.dto.UsuarioCadastroDTO;
import api.dto.UsuarioDTO;
import api.entity.Usuario;

public interface UsuarioService {
	
    //List<Usuario> listarTodos();
    //Optional<Usuario> buscarPorId(Long id);
    //Usuario salvar(Usuario usuario);
    //Usuario atualizar(Long id, Usuario usuario);
    //void excluir(Long id);
    
    List<UsuarioDTO> listarTodos();
    UsuarioDTO buscarPorId(Long id);
    UsuarioDTO cadastrar(UsuarioCadastroDTO usuarioCadastroDto);
    UsuarioDTO atualizar(Long id, UsuarioAtualizaDTO usuarioAtualizaDTO);
    void excluir(Long id);
    
    
    
}
