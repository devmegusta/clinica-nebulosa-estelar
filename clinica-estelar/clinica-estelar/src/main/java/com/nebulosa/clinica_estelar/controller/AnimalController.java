package com.nebulosa.clinica_estelar.controller;
import com.nebulosa.clinica_estelar.model.Animal;
import com.nebulosa.clinica_estelar.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {
    private AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping
    public List<Animal> getAll() {
        return animalService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> findById(@PathVariable Long id) {
        Animal animal;
        try {
            animal = animalService.findById(id);
            return ResponseEntity.ok(animal);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<Animal> save(@RequestBody Animal animal){
            try{
                Animal saved = animalService.save(animal);
                return new ResponseEntity<>(saved, HttpStatus.CREATED);
            }catch (RuntimeException e){
                return ResponseEntity.badRequest().body(null);
            }
        }
    @PutMapping("/{id}")
    public ResponseEntity<Animal> update(@PathVariable  Long id, @RequestBody Animal animal){
            try{
                Animal updated = animalService.update(id, animal);
                return ResponseEntity.ok(updated);
            }catch (RuntimeException e){
                return ResponseEntity.badRequest().body(null);
            }
         }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        try{
          animalService.delete(id);
          return ResponseEntity.noContent().build();
          }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }

    }
}



















