package com.nebulosa.clinica_estelar.repository;

import com.nebulosa.clinica_estelar.model.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
    List<Consultation> findByAnimalId(Long animalId);
}
