package br.com.hmbrito.casa_do_codigo.api.controller;

import br.com.hmbrito.casa_do_codigo.api.assembler.ConversorModelDTO;
import br.com.hmbrito.casa_do_codigo.api.model.input.AutorRequest;
import br.com.hmbrito.casa_do_codigo.api.model.output.AutorResponse;
import br.com.hmbrito.casa_do_codigo.domain.model.Autor;
import br.com.hmbrito.casa_do_codigo.domain.service.AutorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorService autorService;
    private final ConversorModelDTO<Autor, AutorResponse, AutorRequest> conversorModelDTO;

    public AutorController(AutorService autorService, ConversorModelDTO<Autor, AutorResponse, AutorRequest> conversorModelDTO) {
        this.autorService = autorService;
        this.conversorModelDTO = conversorModelDTO;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public AutorResponse cadastrar(@Valid @RequestBody AutorRequest autorRequest) {
        Autor autorNew = conversorModelDTO.toDomain(autorRequest, Autor.class);

        Autor autorEntity = autorService.cadastrar(autorNew);

        return conversorModelDTO.toResponse(autorEntity, AutorResponse.class);
    }
}
