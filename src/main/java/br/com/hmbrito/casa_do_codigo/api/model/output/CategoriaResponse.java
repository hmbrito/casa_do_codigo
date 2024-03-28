package br.com.hmbrito.casa_do_codigo.api.model.output;

/**
 * DTO for {@link br.com.hmbrito.casa_do_codigo.domain.model.Categoria}
 */
public class CategoriaResponse {
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}