package br.com.hmbrito.casa_do_codigo.domain.repository;

import br.com.hmbrito.casa_do_codigo.domain.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Integer> {
}