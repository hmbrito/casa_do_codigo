package br.com.hmbrito.casa_do_codigo.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Rotinas de conversão de Domain (Entidade) para DTO
 * <br>
 * Rotinas de conversão de Input para Domain (Entidade)
 *
 * @param <E> Entidade (Autor.java)
 * @param <R> Response (AutorResponse.java)
 * @param <I> Input (AutorInput.java)
 * @author hmbri
 */
public class ConversorModelDTO<E, R, I> {

    @Autowired
    private ModelMapper modelMapper;

    public E toDomain(I input, Class<E> entidade) {
        return modelMapper.map(input, entidade);
    }

    public R toResponse(E entidade, Class<R> response) {
        return modelMapper.map(entidade, response);
    }

    public List<R> toCollectionResponse(Collection<E> collection, Class<R> response) {
        return collection.stream().map(entidade -> toResponse(entidade, response)).collect(Collectors.toList());
    }

    /*
    public void copyToDomainObject(T originInput, Object destination) {
        modelMapper.map(originInput, destination);
    }
     */
//    public void copyToDomain(I input, Object entidade) {
//        modelMapper.map(input, entidade);
//    }
}
