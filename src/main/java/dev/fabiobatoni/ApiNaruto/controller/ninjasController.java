package dev.fabiobatoni.ApiNaruto.controller;

import dev.fabiobatoni.ApiNaruto.model.ninjas;
import dev.fabiobatoni.ApiNaruto.service.ninjasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ninjas")
public class ninjasController {

    @Autowired
    private ninjasService service;

    @PostMapping("/add")
    public ResponseEntity<ninjas> addNinjas(@RequestBody ninjas ninja) {
        ninjas newNinja = service.createNinja(ninja);
        return new ResponseEntity<>(newNinja, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ninjas>> getAllNinjas() {
        List<ninjas>allNinjas = service.getAllNinjas();
        return new ResponseEntity<>(allNinjas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findNinjaById(@PathVariable Long id) {
        Optional<ninjas> optionalNinja = service.findNinjaById(id);

        if(optionalNinja.isPresent()) {
            return ResponseEntity.ok(optionalNinja.get());
        } else {
             return ResponseEntity.status(HttpStatus.NOT_FOUND)
                     .body("Desculpe, ninja nao encontrado. Passe um id valido");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ninjas> updateNinja(@PathVariable Long id, @RequestBody ninjas ninjas) {
       try {
           ninjas updateNinjaResult = service.updateNinja(id, ninjas);
           return new ResponseEntity<>(updateNinjaResult, HttpStatus.OK);
       } catch (RuntimeException e) {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
       }
    }


    @DeleteMapping("/delete/{id}")
    public void deleteNinja(@PathVariable Long id){
        service.deleteNinja(id);
    }
}
