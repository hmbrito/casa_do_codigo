package br.com.hmbrito.casa_do_codigo.domain.repository;

import br.com.hmbrito.casa_do_codigo.domain.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    Optional<Autor> findByEmailIgnoreCase(String email);
}