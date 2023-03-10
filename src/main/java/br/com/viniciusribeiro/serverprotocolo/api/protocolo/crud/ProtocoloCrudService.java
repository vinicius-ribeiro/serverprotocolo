package br.com.viniciusribeiro.serverprotocolo.api.protocolo.crud;

import br.com.viniciusribeiro.serverprotocolo.api.protocolo.Protocolo;
import br.com.viniciusribeiro.serverprotocolo.api.protocolo.ProtocoloRepository;
import br.com.viniciusribeiro.serverprotocolo.api.protocolo.Situacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProtocoloCrudService {

    @Autowired
    private ProtocoloRepository repository;

    public Protocolo save(Protocolo protocolo) {
        protocolo.setSituacao(Situacao.NOVO);
        return repository.save(protocolo);
    }

    public Protocolo edit(Protocolo protocolo, Long id) throws Exception {
        Protocolo protocoloFind = findById(id);
        protocolo.setId(protocoloFind.getId());
        save(protocolo);

        return protocolo;
    }

    public Protocolo findById(Long id) throws Exception {
        Optional<Protocolo> protocolo = repository.findById(id);

        if(!protocolo.isPresent()) {
            throw new Exception("Nenhum interessado encontrado com o identificador " + id);
        }

        return protocolo.get();
    }

}
