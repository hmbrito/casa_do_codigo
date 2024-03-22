package br.com.hmbrito.casa_do_codigo.domain.service;

import br.com.hmbrito.casa_do_codigo.domain.model.Autor;
import br.com.hmbrito.casa_do_codigo.domain.repository.AutorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AutorService {
    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Transactional
    public Autor cadastrar(Autor autor) {
        return autorRepository.save(autor);
    }
}
