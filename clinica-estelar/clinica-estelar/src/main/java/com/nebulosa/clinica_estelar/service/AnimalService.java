package com.nebulosa.clinica_estelar.service;
import com.nebulosa.clinica_estelar.model.Animal;
import com.nebulosa.clinica_estelar.model.Tutor;
import com.nebulosa.clinica_estelar.repository.AnimalRepository;
import com.nebulosa.clinica_estelar.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {
    private AnimalRepository animalRepository;
    private TutorRepository tutorRepository;

    @Autowired
    public AnimalService(AnimalRepository animalRepository, TutorRepository tutorRepository) {
        this.animalRepository = animalRepository;
        this.tutorRepository = tutorRepository;
    }

    public List<Animal> getAll() {
        return animalRepository.findAll();
    }

    public Animal findById(Long id) {
        return animalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animalzinho não encontrado com ID " + id));
    }

    public Animal save(Animal animal) {
        validateAnimal(animal);
        return animalRepository.save(animal);
    }

    public Animal update(Long id, Animal animalUpdated) {
        Animal exists = findById(id);
        validateAnimal(animalUpdated);
        exists.setName(animalUpdated.getName());
        exists.setSpecies(animalUpdated.getSpecies());
        exists.setRace(animalUpdated.getRace());
        exists.setAge(animalUpdated.getAge());
        exists.setTutor(animalUpdated.getTutor());

        return animalRepository.save(exists);
    }

    public void delete(Long id) {
        if (!animalRepository.existsById(id)) {
            throw new RuntimeException("Não foi possível deletar. Animalzinho com ID " + id + " não existe.");
        }
        animalRepository.deleteById(id);
    }

    private void validateAnimal(Animal animal) {
        if (animal.getTutor() == null || animal.getTutor().getId() == null) {
            throw new IllegalArgumentException("Animalzinho deve ter um dono vinculado válido!");
        }

        Tutor tutor = tutorRepository.findById(animal.getTutor().getId())
                .orElseThrow(() -> new RuntimeException("Tutor não encontrado com ID " + animal.getTutor().getId()));

        if (animal.getAge() != null && animal.getAge() < 0) {
            throw new IllegalArgumentException("Idade do animalzinho não pode ser negativa!");
        }

        Optional<Animal> exist = animalRepository.findByNameAndTutorId(animal.getName(), tutor.getId());
        if (exist.isPresent() && (animal.getId() == null || !exist.get().getId().equals(animal.getId()))) {
            throw new IllegalArgumentException("Já existe um animal com esse nome para este tutor.");
        }

        animal.setTutor(tutor);
    }
}
