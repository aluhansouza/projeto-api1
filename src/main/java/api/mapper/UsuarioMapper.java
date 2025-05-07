package api.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import api.dto.UsuarioAtualizaDTO;
import api.dto.UsuarioCadastroDTO;
import api.dto.UsuarioDTO;
import api.entity.Usuario;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

	// Entidade → DTO de leitura (UsuarioDTO)
    @Mapping(source = "perfil.nome", target = "perfilNome")
    UsuarioDTO toDTO(Usuario usuario);

    // DTO de criação → Entidade
    @Mapping(source = "perfilId", target = "perfil.id")
    Usuario toEntity(UsuarioCadastroDTO dto);
    
    @Mapping(target = "perfil", ignore = true)
    void updateFromDto(UsuarioAtualizaDTO dto, @MappingTarget Usuario usuario);
    
    List<UsuarioDTO> toDTOList(List<Usuario> usuarios); // ← Esse aqui faz a conversão de lista
    
    
}