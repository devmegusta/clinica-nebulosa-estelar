package com.nebulosa.clinica_estelar.service;
import com.nebulosa.clinica_estelar.model.Veterinarian;
import com.nebulosa.clinica_estelar.repository.VeterinarianRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeterinarianService {
    private final VeterinarianRepository veterinarianRepository;


    @Autowired
    public VeterinarianService(VeterinarianRepository veterinarianRepository){
        this.veterinarianRepository = veterinarianRepository;
    }

    public List<Veterinarian> getAllVeterinarians(){
        return veterinarianRepository.findAll();
    }

    public Veterinarian getVeterinarianById(Long id){
        return veterinarianRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Veterinário não encontrado"));
    }

    public Veterinarian saveVeterinarian (Veterinarian veterinarian){
        return veterinarianRepository.save(veterinarian);
    }

    public Veterinarian updateVeterinarian(Long id, Veterinarian veterinarian){
        Veterinarian existing =getVeterinarianById(id);
        existing.setName(veterinarian.getName());
        existing.setCrmv(veterinarian.getCrmv());
        existing.setSpecialty(veterinarian.getSpecialty());
        return veterinarianRepository.save(existing);
    }
    public void deleteVeterinarinById(Long id){
        Veterinarian existing = getVeterinarianById(id);
        veterinarianRepository.delete(existing);
    }
}
