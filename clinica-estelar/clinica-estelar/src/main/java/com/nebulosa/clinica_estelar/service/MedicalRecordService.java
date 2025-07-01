package com.nebulosa.clinica_estelar.service;
import com.nebulosa.clinica_estelar.model.Animal;
import com.nebulosa.clinica_estelar.model.MedicalRecord;
import com.nebulosa.clinica_estelar.repository.MedicalRecordRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MedicalRecordService {

    @Autowired
    private  MedicalRecordRepository medicalRecordRepository;


    public MedicalRecordService(MedicalRecordRepository medicalRecordRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
    }


    public List<MedicalRecord> getAllMedicalRecords(){
        return medicalRecordRepository.findAll();
    }

    public MedicalRecord getMedicalRecordById(Long id){
        return medicalRecordRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Receita não encontrada com o código: " + id));
    }

    public MedicalRecord creteMedicalRecord(MedicalRecord medicalRecord){
        return medicalRecordRepository.save(medicalRecord);
    }

    public MedicalRecord updateMedicalRecord(Long id, MedicalRecord medicalRecord){
        getMedicalRecordById(id);
        medicalRecord.setId(id);
        return medicalRecordRepository.save(medicalRecord);
    }
    public void deleteMedicalRecord(Long id) {
        MedicalRecord record = medicalRecordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prontuário não encontrado"));


        Animal animal = record.getAnimal();
        if (animal != null) {
            animal.setMedicalRecord(null); // desvincula o prontuário
        }

        medicalRecordRepository.delete(record);
    }
}
