package br.com.hmbrito.casa_do_codigo.domain.exception;

public class EmailExistenteException extends NegocioException {

    public EmailExistenteException(String message) {
        super(message);
    }
}
