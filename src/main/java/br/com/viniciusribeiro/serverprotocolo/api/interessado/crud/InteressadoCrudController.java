package br.com.viniciusribeiro.serverprotocolo.api.interessado.crud;

import br.com.viniciusribeiro.serverprotocolo.api.interessado.Interessado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/interessado")
public class InteressadoCrudController {

    @Autowired
    private InteressadoCrudService service;

    @PostMapping
    public ResponseEntity<Long> save(@RequestBody Interessado interessado) throws Exception {
        return ResponseEntity.ok(service.save(interessado).getId());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> edit(@RequestBody Interessado interessado,
                                     @PathVariable Long id) throws Exception {
        return ResponseEntity.ok(service.edit(interessado, id).getId());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Interessado> getOne(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deactivate(@PathVariable Long id) throws Exception {
        service.deactivate(id);
        return ResponseEntity.ok().build();
    }


}
