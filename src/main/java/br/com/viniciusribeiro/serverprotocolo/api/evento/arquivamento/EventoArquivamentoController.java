package br.com.viniciusribeiro.serverprotocolo.api.evento.arquivamento;

import br.com.viniciusribeiro.serverprotocolo.api.evento.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/evento/arquivamento")
public class EventoArquivamentoController {

    @Autowired
    private EventoArquivamentoService service;

    @PostMapping
    public ResponseEntity<Evento> arquivar(@RequestBody EventoArquivamento arquivamento) throws Exception {
        return ResponseEntity.ok(service.arquivar(arquivamento));
    }

}
