package api.service;

import java.util.List;
import java.util.Optional;

import api.entity.Perfil;

public interface PerfilService {
	
	List<Perfil> listarTodos();

	Optional<Perfil> buscarPorId(Long id);

	Perfil salvar(Perfil perfil);

	Perfil atualizar(Long id, Perfil perfil);

	void excluir(Long id);
}
