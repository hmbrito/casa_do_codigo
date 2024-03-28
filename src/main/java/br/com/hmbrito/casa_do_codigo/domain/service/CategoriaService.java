package br.com.hmbrito.casa_do_codigo.domain.service;

import br.com.hmbrito.casa_do_codigo.domain.exception.CategoriaExistenteException;
import br.com.hmbrito.casa_do_codigo.domain.model.Categoria;
import br.com.hmbrito.casa_do_codigo.domain.repository.CategoriaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Transactional
    public Categoria cadastrar(Categoria newCategoria) {
        // o 'nome' do Categoria deve ser único
        this.categoriaRepository
                .findByNomeIgnoreCase(newCategoria.getNome())
                .ifPresent(categoria -> {
                    throw new CategoriaExistenteException("Já existe uma Categoria cadastrada com esse nome, verifique.");
                });

        return categoriaRepository.save(newCategoria);
    }
}
