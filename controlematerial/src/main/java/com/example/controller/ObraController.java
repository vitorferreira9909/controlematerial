package com.example.controller;

import com.example.model.Obra;
import com.example.service.ObraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/obras")
public class ObraController {

    @Autowired
    private ObraService obraService;

    @PostMapping
    public ResponseEntity<Obra> createObra(@Valid @RequestBody Obra obra) {
        Obra savedObra = obraService.save(obra);
        return ResponseEntity.ok(savedObra);
    }

    @GetMapping
    public ResponseEntity<List<Obra>> getAllObras() {
        List<Obra> obras = obraService.findAll();
        return ResponseEntity.ok(obras);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Obra> getObraById(@PathVariable Long id) {
        Optional<Obra> obra = obraService.findById(id);
        return obra.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Obra> updateObra(@PathVariable Long id, @Valid @RequestBody Obra obraDetails) {
        Optional<Obra> obra = obraService.findById(id);
        if (obra.isPresent()) {
            Obra updatedObra = obraService.update(obraDetails);
            return ResponseEntity.ok(updatedObra);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteObra(@PathVariable Long id) {
        obraService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}