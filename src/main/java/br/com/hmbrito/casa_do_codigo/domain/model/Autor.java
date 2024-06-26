package br.com.hmbrito.casa_do_codigo.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.OffsetDateTime;

@Entity
@Table(name = "autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank
    @Column(name = "nome", nullable = false, length = 60)
    private String nome;

    @NotBlank
    @Email
    @Column(name = "email", nullable = false, unique=true, length = 60)
    private String email;

    @NotBlank
    @Column(name = "descricao", nullable = false, length = 400)
    @Size(max = 400)
    private String descricao;

    @NotNull
    @Column(name = "data_registro", nullable = false)
    private OffsetDateTime dataRegistro;

    @Deprecated
    public Autor() {
    }

    public Autor(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    @PrePersist
    public void onNewAutor() {
        dataRegistro = OffsetDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public OffsetDateTime getDataRegistro() {
        return dataRegistro;
    }
}