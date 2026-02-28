package com.fortis.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fortis.patient.entity.PatientEntity;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Integer> {

}
