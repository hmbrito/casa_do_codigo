package br.com.hmbrito.casa_do_codigo.api.model.output;

import br.com.hmbrito.casa_do_codigo.domain.model.Autor;

import java.io.Serializable;

/**
 * DTO for {@link Autor}
 */
public class AutorResponse implements Serializable {
    private String nome;
    private String email;
    private String descricao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}