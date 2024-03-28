package br.com.hmbrito.casa_do_codigo.api.exceptionhandler;

import br.com.hmbrito.casa_do_codigo.domain.exception.NegocioException;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.*;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    private final MessageSource messageSource;

    public ApiExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(NegocioException.class)
    public ProblemDetail handleNegocio(NegocioException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        problemDetail.setTitle(e.getMessage());
        problemDetail.setType(URI.create("https://algatransito.com/erros/violacao-regra-negocio"));

        return problemDetail;
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(status);
        problemDetail.setTitle("Um ou mais campos estão inválidos, verifique.");
        problemDetail.setDetail("Um detalhe sobre o erro.");
        problemDetail.setType(URI.create("https://deveficiente.com/erros/campos-invalidos"));

        AtomicInteger i = new AtomicInteger(0);

        Map<String, String> invalidFields = ex.getBindingResult().getAllErrors()
                .stream()
                .collect(Collectors.toMap(objectError -> ((FieldError) objectError).getField() + "(" + i.incrementAndGet() + ")",
                        objectError -> messageSource.getMessage(objectError, LocaleContextHolder.getLocale())));


//        Function<ObjectError, String> getFieldName = objectError -> ((FieldError) objectError).getField() + "(" + i.incrementAndGet() + ")";
//        Function<ObjectError, String> getDescriptionError = objectError -> messageSource.getMessage(objectError, LocaleContextHolder.getLocale());
//
//        Map<String, String> invalidFields = ex.getBindingResult().getAllErrors()
//                .stream()
//                .collect(Collectors.toMap(getFieldName, getDescriptionError));

        problemDetail.setProperty("invalidFields", invalidFields);

        return handleExceptionInternal(ex, problemDetail, headers, status, request);
    }

    private Object inserirComMerge(String fieldName, String descriptionError, Map<String, String> invalidFields) {
        return invalidFields.merge(fieldName, descriptionError, (valorAtual, valorNovo) -> invalidFields.get(fieldName) + ", " + descriptionError);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ProblemDetail handleDataIntegrity(DataIntegrityViolationException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.CONFLICT);
        problemDetail.setTitle("Recurso atualmente em uso, verifique.");
        problemDetail.setType(URI.create("https://deveficiente.com/erros/recurso-em-uso"));

        return problemDetail;
    }
}
