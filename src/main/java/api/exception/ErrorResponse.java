package api.exception;

import java.time.LocalDateTime;

public class ErrorResponse {

	 private int codigoStatus;  // Código de status HTTP
	    private String erro;
	    private String mensagem;
	    private LocalDateTime timestamp;

	    // Construtor
	    public ErrorResponse(int codigoStatus, String erro, String mensagem, LocalDateTime timestamp) {
	        this.codigoStatus = codigoStatus;
	        this.erro = erro;
	        this.mensagem = mensagem;
	        this.timestamp = timestamp;
	    }

	    // Getters e Setters
	    public int getCodigoStatus() {
	        return codigoStatus;
	    }

	    public void setCodigoStatus(int codigoStatus) {
	        this.codigoStatus = codigoStatus;
	    }

	    public String getErro() {
	        return erro;
	    }

	    public void setErro(String erro) {
	        this.erro = erro;
	    }

	    public String getMensagem() {
	        return mensagem;
	    }

	    public void setMensagem(String mensagem) {
	        this.mensagem = mensagem;
	    }

	    public LocalDateTime getTimestamp() {
	        return timestamp;
	    }

	    public void setTimestamp(LocalDateTime timestamp) {
	        this.timestamp = timestamp;
	    }
	
}