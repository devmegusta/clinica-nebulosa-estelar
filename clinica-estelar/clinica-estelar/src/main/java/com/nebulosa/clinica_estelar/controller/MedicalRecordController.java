package com.nebulosa.clinica_estelar.controller;

import com.nebulosa.clinica_estelar.model.MedicalRecord;
import com.nebulosa.clinica_estelar.service.MedicalRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medical-record")
public class MedicalRecordController {
    private final MedicalRecordService medicalRecordService;

    public MedicalRecordController(MedicalRecordService medicalRecordService) {
        this.medicalRecordService = medicalRecordService;
    }

    @GetMapping
    public List<MedicalRecord> getAllMedicalRecords() {
        return medicalRecordService.getAllMedicalRecords();
    }

    @GetMapping("/{id}")
    public MedicalRecord getMedicalRecordByID(@PathVariable Long id) {
        return medicalRecordService.getMedicalRecordById(id);
    }

    @PostMapping
    public MedicalRecord createMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
        return medicalRecordService.creteMedicalRecord(medicalRecord);
    }

    @PutMapping("/{id}")
    public MedicalRecord updateMedicalRecord(@PathVariable Long id, @RequestBody MedicalRecord medicalRecord){
        return medicalRecordService.updateMedicalRecord(id, medicalRecord);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicalRecord(@PathVariable Long id) {
        medicalRecordService.deleteMedicalRecord(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}