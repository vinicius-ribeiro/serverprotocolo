package br.com.viniciusribeiro.serverprotocolo.api.assunto.crud;

import br.com.viniciusribeiro.serverprotocolo.api.assunto.Assunto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/assunto")
public class AssuntoCrudController {

    @Autowired
    private AssuntoCrudService service;

    @PostMapping
    public ResponseEntity<Long> save(@RequestBody Assunto assunto) throws Exception {
        return ResponseEntity.ok(service.save(assunto).getId());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> edit(@RequestBody Assunto assunto,
                                     @PathVariable Long id) throws Exception {
        return ResponseEntity.ok(service.edit(assunto, id).getId());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Assunto> getOne(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok().body(service.findById(id));
    }

}
