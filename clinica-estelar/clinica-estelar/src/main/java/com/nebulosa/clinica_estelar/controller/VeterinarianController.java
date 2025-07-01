package com.nebulosa.clinica_estelar.controller;

import com.nebulosa.clinica_estelar.model.Veterinarian;
import com.nebulosa.clinica_estelar.service.VeterinarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veterinarians")
public class VeterinarianController {
    private final VeterinarianService veterinarianService;

    @Autowired
    public VeterinarianController(VeterinarianService veterinarianService){
        this.veterinarianService = veterinarianService;
    }

    @GetMapping
    public List<Veterinarian> getAllVeterinarians(){
        return veterinarianService.getAllVeterinarians();
    }

    @GetMapping("/{id}")
    public Veterinarian getVeterinarianById(@PathVariable Long id){
        return veterinarianService.getVeterinarianById(id);

    }
    @PostMapping
    public Veterinarian createVeterinarian(@RequestBody Veterinarian veterinarian){
        return veterinarianService.saveVeterinarian(veterinarian);
    }

    @PutMapping("/{id}")
    public Veterinarian updateVeterinarian(@PathVariable Long id,
                                           @RequestBody Veterinarian  veterinarian){
     return veterinarianService.updateVeterinarian(id, veterinarian);
    }

    @DeleteMapping
    public void deleteVeterinarianById(@PathVariable Long id){
        veterinarianService.deleteVeterinarinById(id);
    }
}
