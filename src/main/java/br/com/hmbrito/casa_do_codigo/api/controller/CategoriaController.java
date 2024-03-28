package br.com.hmbrito.casa_do_codigo.api.controller;

import br.com.hmbrito.casa_do_codigo.api.assembler.ConversorModelDTO;
import br.com.hmbrito.casa_do_codigo.api.model.input.CategoriaRequest;
import br.com.hmbrito.casa_do_codigo.api.model.output.CategoriaResponse;
import br.com.hmbrito.casa_do_codigo.domain.model.Categoria;
import br.com.hmbrito.casa_do_codigo.domain.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;
    private final ConversorModelDTO<Categoria, CategoriaResponse, CategoriaRequest> conversorModelDTO;

    public CategoriaController(CategoriaService categoriaService, ConversorModelDTO<Categoria, CategoriaResponse, CategoriaRequest> conversorModelDTO) {
        this.categoriaService = categoriaService;
        this.conversorModelDTO = conversorModelDTO;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public CategoriaResponse cadastrar(@Valid @RequestBody CategoriaRequest categoriaRequest) {
        Categoria categoriaNew = conversorModelDTO.toDomain(categoriaRequest, Categoria.class);

        Categoria categoriaEntity = categoriaService.cadastrar(categoriaNew);

        return conversorModelDTO.toResponse(categoriaEntity, CategoriaResponse.class);
    }
}
