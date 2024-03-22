package br.com.hmbrito.casa_do_codigo.core.conversorModelDTO;

import br.com.hmbrito.casa_do_codigo.api.assembler.ConversorModelDTO;
import br.com.hmbrito.casa_do_codigo.api.assembler.ConversorModelDTOSemInput;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Classe de configuração que permite ao Spring instanciar ConversorModelDTO
 *
 * @param <E> Entidade (Autor.java)
 * @param <R> Response (AutorResponse.java)
 * @param <I> Input (AutorInput.java)
 * @author hmbri
 */
@Configuration
public class ConversorModelDTOConfig<E, R, I> {

    @Bean
    public ConversorModelDTO<E, R, I> conversorModelDTO() {
        return new ConversorModelDTO<>();
    }

    @Bean
    public ConversorModelDTOSemInput<E, R> conversorModelDTOSemInput() {
        return new ConversorModelDTOSemInput<>();
    }
}

