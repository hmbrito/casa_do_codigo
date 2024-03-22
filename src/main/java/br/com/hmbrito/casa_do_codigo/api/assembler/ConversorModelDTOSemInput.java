package br.com.hmbrito.casa_do_codigo.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Rotinas de conversão de Entidade para Response
 *
 * @param <E> Entidade (Autor.java)
 * @param <R> Response (AutorResponse.java)
 */
public class ConversorModelDTOSemInput<E, R> {
    @Autowired
    private ModelMapper modelMapper;

    public R toDTO(E domain, Class<R> response) {
        return modelMapper.map(domain, response);
    }

    public List<R> toCollectionDTO(Collection<E> collection, Class<R> response) {
        return collection.stream().map(entidade -> toDTO(entidade, response)).collect(Collectors.toList());
    }
}
