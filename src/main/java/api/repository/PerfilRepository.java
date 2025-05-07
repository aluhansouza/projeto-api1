package api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.entity.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {
	
	boolean existsByNome(String nome);

}
