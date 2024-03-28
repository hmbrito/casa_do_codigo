package br.com.hmbrito.casa_do_codigo.api.model.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * DTO for {@link br.com.hmbrito.casa_do_codigo.domain.model.Categoria}
 */
public class CategoriaRequest {
    @NotBlank
    @Size(max = 60)
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}