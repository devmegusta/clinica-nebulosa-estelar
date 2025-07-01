package com.nebulosa.clinica_estelar.service;
import com.nebulosa.clinica_estelar.model.Consultation;
import com.nebulosa.clinica_estelar.repository.ConsultationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ConsultationService {
    private final ConsultationRepository consultationRepository;

    @Autowired
    public ConsultationService(ConsultationRepository consultationRepository){
        this.consultationRepository = consultationRepository;
    }
    public List<Consultation> getAllConsultation(){
        return consultationRepository.findAll();
    }

    public List<Consultation> getConsultationsByAnimalId(Long animalId) {
        return consultationRepository.findByAnimalId(animalId);
    }

    public Consultation getConsultationById(Long id){
        return consultationRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Consulta não encontrada!"));
    }

    public Consultation saveConsultation(Consultation consultation){
        return consultationRepository.save(consultation);
    }

    public Consultation updateConsultation(Long id, Consultation consultation){
        Consultation existing = getConsultationById(id);
        existing.setDataTime(consultation.getDataTime());
        existing.setDescription(consultation.getDescription());
        existing.setAnimal(consultation.getAnimal());
        existing.setVeterinarian(consultation.getVeterinarian());
        return consultationRepository.save(existing);
    }

    public void deleteConsultationById(Long id){
        Consultation existing = getConsultationById(id);
        consultationRepository.delete(existing);
    }


}
