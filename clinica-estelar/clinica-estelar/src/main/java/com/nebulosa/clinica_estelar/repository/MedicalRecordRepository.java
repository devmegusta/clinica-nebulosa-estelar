package com.nebulosa.clinica_estelar.repository;

import com.nebulosa.clinica_estelar.model.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {
}
