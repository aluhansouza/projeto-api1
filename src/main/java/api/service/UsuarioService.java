package api.service;

import java.util.List;
import java.util.Optional;

import api.entity.Usuario;

public interface UsuarioService {
	
    List<Usuario> listarTodos();
    Optional<Usuario> buscarPorId(Long id);
    Usuario salvar(Usuario usuario);
    Usuario atualizar(Long id, Usuario usuario);
    void excluir(Long id);
    
}
