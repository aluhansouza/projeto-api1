package api.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import api.dto.PerfilAtualizaDTO;
import api.dto.PerfilCadastroDTO;
import api.dto.PerfilDTO;

public interface PerfilService {
    
    List<PerfilDTO> listarTodos(); // Lista todos os perfis
    PerfilDTO buscarPorId(Long id); // Busca perfil por ID
    PerfilDTO cadastrar(PerfilCadastroDTO dto); // Cria um novo perfil
    PerfilDTO atualizar(Long id, PerfilAtualizaDTO dto); // Atualiza um perfil existente
    void excluir(Long id); // Exclui um perfil pelo ID
    
    
   Page<PerfilDTO> listarPaginado(Pageable pageable);
    
    
    
}