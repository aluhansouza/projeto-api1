package api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.dto.PerfilAtualizaDTO;
import api.dto.PerfilCadastroDTO;
import api.dto.PerfilDTO;
import api.service.PerfilService;

@RestController
@RequestMapping("/api/perfis")
@CrossOrigin(origins = "*")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;
    
    
    // Criar perfil
    @PostMapping
    public ResponseEntity<PerfilDTO> cadastrar(@RequestBody PerfilCadastroDTO perfilCadastroDto) {
        PerfilDTO novoPerfil = perfilService.cadastrar(perfilCadastroDto);
        return ResponseEntity.ok(novoPerfil);
    }

    // Atualizar perfil
    @PutMapping("/{id}")
    public ResponseEntity<PerfilDTO> atualizarPerfil(@PathVariable Long id, @RequestBody PerfilAtualizaDTO perfilAtualizaDTO) {
        PerfilDTO perfilAtualizado = perfilService.atualizar(id, perfilAtualizaDTO);
        return ResponseEntity.ok(perfilAtualizado);
    }

    // Listar todos os perfis
    @GetMapping
    public ResponseEntity<List<PerfilDTO>> listarPerfis() {
        List<PerfilDTO> perfis = perfilService.listarTodos();
        return ResponseEntity.ok(perfis);
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<PerfilDTO> buscarPorId(@PathVariable Long id) {
        PerfilDTO perfil = perfilService.buscarPorId(id);
        return ResponseEntity.ok(perfil);
    }

    // Excluir perfil
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirPerfil(@PathVariable Long id) {
        perfilService.excluir(id);
        return ResponseEntity.noContent().build();
    }
    
    
    
    
	/*
	 * @GetMapping public List<Perfil> listarTodos() { return
	 * perfilService.listarTodos(); }
	 * 
	 * @GetMapping("/{id}") public ResponseEntity<Perfil> buscarPorId(@PathVariable
	 * Long id) { return perfilService.buscarPorId(id) .map(ResponseEntity::ok)
	 * .orElse(ResponseEntity.notFound().build()); }
	 * 
	 * @PostMapping public Perfil salvar(@RequestBody Perfil perfil) { return
	 * perfilService.salvar(perfil); }
	 * 
	 * @PutMapping("/{id}") public Perfil atualizar(@PathVariable Long
	 * id, @RequestBody Perfil perfil) { return perfilService.atualizar(id, perfil);
	 * }
	 * 
	 * @DeleteMapping("/{id}") public ResponseEntity<Void> deletar(@PathVariable
	 * Long id) { perfilService.excluir(id); return
	 * ResponseEntity.noContent().build(); }
	 */
}
