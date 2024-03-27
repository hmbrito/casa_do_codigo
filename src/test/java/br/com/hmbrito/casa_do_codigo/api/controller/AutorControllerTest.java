package br.com.hmbrito.casa_do_codigo.api.controller;

import br.com.hmbrito.casa_do_codigo.domain.exception.EmailExistenteException;
import br.com.hmbrito.casa_do_codigo.domain.exception.EntidadeNaoEncontradaException;
import br.com.hmbrito.casa_do_codigo.domain.model.Autor;
import br.com.hmbrito.casa_do_codigo.domain.service.AutorService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@TestPropertySource("/application-test.properties")
class AutorControllerTest {
    @Autowired
    private AutorService autorService;

    @Test
    @DisplayName("Should not be able to register an Autor when an email already exists")
    void deveFalharAoCadastrarAutorComEmailDuplicado() {
        final String existingEmail = "anadias@email.com";

        final Autor initialAuthor = new Autor("A", existingEmail, "B");
        final Autor duplicateEmailAuthor = new Autor("C", existingEmail, "D");

        autorService.cadastrar(initialAuthor);

        final Executable cadastrarComEmailDuplicado = () -> autorService.cadastrar(duplicateEmailAuthor);

        assertThrows(EmailExistenteException.class, cadastrarComEmailDuplicado);
    }
}