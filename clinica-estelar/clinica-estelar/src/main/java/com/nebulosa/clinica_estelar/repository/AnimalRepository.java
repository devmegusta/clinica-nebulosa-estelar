package com.nebulosa.clinica_estelar.repository;

import com.nebulosa.clinica_estelar.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnimalRepository extends JpaRepository <Animal, Long>{
    Optional<Animal> findByNameAndTutorId(String name, Long tutorId);

}
