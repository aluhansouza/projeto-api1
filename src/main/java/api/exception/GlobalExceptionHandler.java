package api.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(RecursoNaoEncontradoException.class)
	public ResponseEntity<ErrorResponse> handleRecursoNaoEncontradoException(RecursoNaoEncontradoException ex) {
	    // Código de status HTTP 404 para "Recurso não encontrado"
	    int codigoStatus = HttpStatus.NOT_FOUND.value();  // Ou seja, 404

	    // Cria o objeto de resposta de erro com o código de status HTTP, o erro, a mensagem e o timestamp
	    ErrorResponse erroResponse = new ErrorResponse(
	        codigoStatus, 
	        "Recurso não encontrado", 
	        ex.getMessage(),
	        LocalDateTime.now()  // Gerando o timestamp dinamicamente
	    );

	    // Retorna a resposta com status 404 (Não encontrado)
	    return new ResponseEntity<>(erroResponse, HttpStatus.NOT_FOUND);
	}

	

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<Object> handleBusinessException(BusinessException ex) {
		Map<String, Object> body = new HashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("status", HttpStatus.BAD_REQUEST.value());
		body.put("error", "Regra de negócio");
		body.put("message", ex.getMessage());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleGenericException(Exception ex) {
		Map<String, Object> body = new HashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		body.put("error", "Erro interno");
		body.put("message", "Ocorreu um erro inesperado.");

		// Para ambiente de desenvolvimento, pode logar `ex.printStackTrace();`
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
	}
	
	

}