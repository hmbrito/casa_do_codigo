package br.com.hmbrito.casa_do_codigo.domain.repository;

import br.com.hmbrito.casa_do_codigo.domain.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Optional<Categoria> findByNomeIgnoreCase(String nome);
}