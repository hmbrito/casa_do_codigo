package br.com.hmbrito.casa_do_codigo.domain.service;

import br.com.hmbrito.casa_do_codigo.domain.exception.EmailExistenteException;
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
    public Autor cadastrar(Autor newAutor) {
        // o 'e-mail' do Autor deve ser único
        this.autorRepository
                .findByEmailIgnoreCase(newAutor.getEmail())
                .ifPresent(autor -> {
                    throw new EmailExistenteException("Já existe um Autor cadastrado que esse e-mail, verifique.");
                });

        return autorRepository.save(newAutor);
    }
}
