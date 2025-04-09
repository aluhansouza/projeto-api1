package api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.entity.Perfil;
import api.repository.PerfilRepository;

@Service
public class PerfilServiceImpl implements PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    @Override
    public List<Perfil> listarTodos() {
        return perfilRepository.findAll();
    }

    @Override
    public Optional<Perfil> buscarPorId(Long id) {
        return perfilRepository.findById(id);
    }

    @Override
    public Perfil salvar(Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    @Override
    public Perfil atualizar(Long id, Perfil perfil) {
        perfil.setId(id);
        return perfilRepository.save(perfil);
    }

    @Override
    public void excluir(Long id) {
        perfilRepository.deleteById(id);
    }
}
