package api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import api.dto.PerfilAtualizaDTO;
import api.dto.PerfilCadastroDTO;
import api.dto.PerfilDTO;
import api.entity.Perfil;

@Mapper(componentModel = "spring")
public interface PerfilMapper {

    PerfilMapper INSTANCE = Mappers.getMapper(PerfilMapper.class);

    PerfilDTO toDTO(Perfil entity);

    Perfil toEntity(PerfilCadastroDTO dto);

    void updateFromDTO(PerfilAtualizaDTO dto, @MappingTarget Perfil entity);
}
