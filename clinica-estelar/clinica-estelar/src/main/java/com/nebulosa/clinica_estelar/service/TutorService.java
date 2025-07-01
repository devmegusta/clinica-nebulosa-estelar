package com.nebulosa.clinica_estelar.service;

import com.nebulosa.clinica_estelar.model.Tutor;
import com.nebulosa.clinica_estelar.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorService {
    private final TutorRepository tutorRepository;

    @Autowired
    public TutorService(TutorRepository tutorRepository){
        this.tutorRepository = tutorRepository;
    }

    public List<Tutor> getAllTutors(){
        return tutorRepository.findAll();
    }

    public Tutor findByTutorId(Long id){
        return tutorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tutor não encontrado com ID " + id));
    }

    public Tutor createTutor(Tutor tutor) {
        validateTutor(tutor);
        return tutorRepository.save(tutor);
    }

    public Tutor uptade(Long id, Tutor tutorUpdated){
        Tutor exists = findByTutorId(id);

        exists.setName(tutorUpdated.getName());
        exists.setEmail(tutorUpdated.getEmail());
        exists.setPhoneNumber(tutorUpdated.getPhoneNumber());

        return tutorRepository.save(exists);
    }

    public void delete(Long id){
        Tutor exists = findByTutorId(id);
        tutorRepository.delete(exists);
    }

    private void validateTutor(Tutor tutor) {
        if (tutor.getName() == null || tutor.getName().isBlank()) {
            throw new IllegalArgumentException("O nome do tutor é obrigatório!");
        }
        if (tutor.getEmail() == null || tutor.getEmail().isBlank()) {
            throw new IllegalArgumentException("O e-mail do tutor é obrigatório!");
        }
        if (tutor.getPhoneNumber() == null || tutor.getPhoneNumber().isBlank()) {
            throw new IllegalArgumentException("O telefone do tutor é obrigatório!");
        }
    }
}
