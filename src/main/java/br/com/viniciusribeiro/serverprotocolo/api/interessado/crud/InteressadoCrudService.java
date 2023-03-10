package br.com.viniciusribeiro.serverprotocolo.api.interessado.crud;

import br.com.viniciusribeiro.serverprotocolo.api.interessado.Interessado;
import br.com.viniciusribeiro.serverprotocolo.api.interessado.InteressadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InteressadoCrudService {

    @Autowired
    InteressadoRepository repository;

    public Interessado save(Interessado interessado) {
        interessado.setAtivo(true);
        return repository.save(interessado);
    }

    public Interessado edit(Interessado interessado, Long id) throws Exception {
        Interessado interessadoFind = findById(id);
        interessado.setId(interessadoFind.getId());
        save(interessado);

        return interessado;
    }

    public Interessado findById(Long id) throws Exception {
        Optional<Interessado> interessado = repository.findById(id);

        if(!interessado.isPresent()) {
            throw new Exception("Nenhum interessado encontrado com o identificado " + id);
        }

        return interessado.get();
    }

    public void deactivate(Long id) throws Exception {
        Interessado interessadoFind = findById(id);
        interessadoFind.setAtivo(false);
    }

}
