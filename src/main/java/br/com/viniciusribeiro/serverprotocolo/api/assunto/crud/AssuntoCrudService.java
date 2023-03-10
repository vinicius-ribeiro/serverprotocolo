package br.com.viniciusribeiro.serverprotocolo.api.assunto.crud;

import br.com.viniciusribeiro.serverprotocolo.api.assunto.Assunto;
import br.com.viniciusribeiro.serverprotocolo.api.assunto.AssuntoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AssuntoCrudService {

    @Autowired
    private AssuntoRepository repository;

    public Assunto save(Assunto assunto) {
        return repository.save(assunto);
    }

    public Assunto edit(Assunto assunto, Long id) throws Exception {
        Assunto assuntoFind = findById(id);
        assunto.setId(assuntoFind.getId());
        save(assunto);

        return assunto;
    }

    public Assunto findById(Long id) throws Exception {
        Optional<Assunto> assunto = repository.findById(id);

        if(!assunto.isPresent()) {
            throw new Exception("Nenhum assunto encontrado com o identificador " + id);
        }

        return assunto.get();
    }
}
