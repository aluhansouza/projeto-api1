package api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
