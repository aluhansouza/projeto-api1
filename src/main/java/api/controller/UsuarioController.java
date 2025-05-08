package api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import api.dto.UsuarioAtualizaDTO;
import api.dto.UsuarioCadastroDTO;
import api.dto.UsuarioDTO;
import api.response.PageResponse;
import api.service.UsuarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

	@Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioDTO> cadastrar(@Valid @RequestBody UsuarioCadastroDTO dto) {
        UsuarioDTO usuarioCadastrado = usuarioService.cadastrar(dto);
        return new ResponseEntity<>(usuarioCadastrado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> atualizar(@PathVariable Long id, @Valid @RequestBody UsuarioAtualizaDTO dto) {
        UsuarioDTO usuarioAtualizado = usuarioService.atualizar(id, dto);
        return ResponseEntity.ok(usuarioAtualizado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable Long id) {
        UsuarioDTO usuario = usuarioService.buscarPorId(id);
        return ResponseEntity.ok(usuario);
    }

    //@GetMapping
	/*
	 * public ResponseEntity<List<UsuarioDTO>> listarTodos() { List<UsuarioDTO>
	 * usuarios = usuarioService.listarTodos(); return ResponseEntity.ok(usuarios);
	 * }
	 */
    
	/*
	 * @GetMapping public ResponseEntity<PageResponse<UsuarioDTO>> listar(Pageable
	 * pageable) { Page<UsuarioDTO> page = usuarioService.listarPaginado(pageable);
	 * return ResponseEntity.ok(new PageResponse<>(page)); }
	 */
    
    @GetMapping
    public ResponseEntity<PageResponse<UsuarioDTO>> listar(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String perfilNome,
            Pageable pageable) {

        Page<UsuarioDTO> page = usuarioService.listarFiltrado(nome, email, status, perfilNome, pageable);
        return ResponseEntity.ok(new PageResponse<>(page));
    }
    

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        usuarioService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
