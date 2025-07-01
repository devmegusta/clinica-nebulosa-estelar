package com.nebulosa.clinica_estelar.controller;
import com.nebulosa.clinica_estelar.model.Consultation;
import com.nebulosa.clinica_estelar.service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/consultations")
public class ConsultationController {
    private final ConsultationService consultationService;

    @Autowired
    public ConsultationController (ConsultationService consultationService){
        this.consultationService = consultationService;
    }

    @GetMapping
    public List<Consultation> getAllConsultation(){
        return consultationService.getAllConsultation();
    }

    @GetMapping("/{id}")
    public Consultation getConsultationById(@PathVariable Long id){
        return consultationService.getConsultationById(id);
    }
    @GetMapping("/animal/{animalId}")
    public List<Consultation> getConsultationByAnimal(@PathVariable Long animalId){
        return consultationService.getConsultationsByAnimalId(animalId);
    }

    @PostMapping
    public Consultation createConsultation(@RequestBody Consultation consultation){
        return consultationService.saveConsultation(consultation);
    }

    @PostMapping("/{id}")
    public Consultation updateConsultation(@PathVariable Long id,
                                           @RequestBody Consultation consultation){
        return consultationService.updateConsultation(id, consultation);
    }

    @DeleteMapping("/{id}")
    public void deleteConsultationById(@PathVariable Long id){
        consultationService.deleteConsultationById(id);
    }
}
