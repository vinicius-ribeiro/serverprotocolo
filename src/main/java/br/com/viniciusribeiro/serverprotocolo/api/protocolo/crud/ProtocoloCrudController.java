package br.com.viniciusribeiro.serverprotocolo.api.protocolo.crud;

import br.com.viniciusribeiro.serverprotocolo.api.protocolo.Protocolo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/protocolo")
public class ProtocoloCrudController {

    @Autowired
    private ProtocoloCrudService service;

    @PostMapping
    public ResponseEntity<Long> save(@RequestBody Protocolo protocolo) throws Exception {
        return ResponseEntity.ok(service.save(protocolo).getId());
    }

}
