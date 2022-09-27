package com.ilionx.pianoapp.api;

import com.ilionx.pianoapp.model.Piano;
import com.ilionx.pianoapp.persistence.PianoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/pianos")
public class PianoController {
    @Autowired
    private PianoRepository pianoRepository;

    @GetMapping
    public ResponseEntity<Iterable<Piano>> pianos () {
        return ResponseEntity.ok(pianoRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Piano> create(@RequestBody Piano piano) {
        return ResponseEntity.ok(this.pianoRepository.save(piano));
    }

    @GetMapping("{id}")
    public ResponseEntity<Piano> findById(@PathVariable long id) {
        Optional<Piano> pianoOptional = this.pianoRepository.findById(id);
        return pianoOptional.isPresent() ? ResponseEntity.ok(pianoOptional.get())
                : ResponseEntity.notFound().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Piano> updateById(@PathVariable long id, @RequestBody Piano source) {
        Optional<Piano> pianoOptional = this.pianoRepository.findById(id);
        return pianoOptional.isPresent() ? ResponseEntity.ok(pianoOptional.get())
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        Optional<Piano> pianoOptional = this.pianoRepository.findById(id);
        if(pianoOptional.isPresent()) {
            this.pianoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
