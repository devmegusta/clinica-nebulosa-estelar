package com.nebulosa.clinica_estelar.controller;
import com.nebulosa.clinica_estelar.model.Tutor;
import com.nebulosa.clinica_estelar.service.TutorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tutors")
public class TutorController {
    private final TutorService tutorService;

    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;

    }
    @GetMapping
    public ResponseEntity<List<Tutor>> getAllTutors(){
        List<Tutor> tutors = tutorService.getAllTutors();
        return ResponseEntity.ok(tutors);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Tutor> getTutorById(@PathVariable Long id){
        Tutor tutor = tutorService.findByTutorId(id);
        return ResponseEntity.ok(tutor);
    }
    @PostMapping
    public ResponseEntity<Tutor> createTutor(@RequestBody Tutor tutor){
        Tutor newTutor = tutorService.createTutor(tutor);
        return ResponseEntity.ok(newTutor);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Tutor> updateTutor(@PathVariable Long id, @RequestBody Tutor tutor){
        Tutor tutorUpdated = tutorService.uptade(id, tutor);
        return ResponseEntity.ok(tutorUpdated);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTutor(@PathVariable Long id){
        tutorService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
