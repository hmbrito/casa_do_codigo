package br.com.hmbrito.casa_do_codigo.api.assembler;

import br.com.hmbrito.casa_do_codigo.api.model.input.AutorRequest;
import br.com.hmbrito.casa_do_codigo.api.model.output.AutorResponse;
import br.com.hmbrito.casa_do_codigo.domain.model.Autor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Classe em desuso
 */
@Component
public class AutorAssembler {
    private final ModelMapper modelMapper;

    public AutorAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Autor toEntity(AutorRequest autorRequest) {
        return modelMapper.map(autorRequest, Autor.class);
    }

    public AutorResponse toDto(Autor autor) {
        return modelMapper.map(autor, AutorResponse.class);
    }

    public List<AutorResponse> toCollectionDto(List<Autor> autores) {
        return autores.stream()
                .map(this::toDto)
                .toList();
    }
}
