package com.fortis.patient.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fortis.patient.entity.PatientEntity;
import com.fortis.patient.repository.PatientRepository;
import com.fortis.patient.request.PatientRequest;

@Service
public class PatientService {

	@Autowired
	PatientRepository repository;

	private static final Logger logger = LogManager.getLogger(PatientService.class);

	public PatientEntity registerPatient(PatientRequest request) {
		logger.info("Register patient request received");
		if (request.getName() == null) {
			logger.error("Patient name is null. Cannot register patient.");
			throw new RuntimeException("Patient name cannot be null");
		}
		PatientEntity entity = new PatientEntity();
		entity.setName(request.getName());
		entity.setEmail(request.getEmail());
		entity.setAge(request.getAge());
		entity.setAddress(request.getAddress());
		entity.setPhone(request.getPhone());
		entity.setDisease(request.getDisease());
		logger.debug("Saving Patient to Database");
		PatientEntity saved = repository.save(entity);
		logger.info("Patient saved successfully with ID: {}", saved.getPatientId());
		return saved;

	}

	public PatientEntity getPatientByID(Integer patientId) {
		logger.info("Fetching patient with ID: {}", patientId);
		PatientEntity entity = repository.findById(patientId).orElse(null);
		if (entity == null) {
			logger.warn("Patient not found with ID:{}", patientId);
		}
		if (patientId == 988) {
			logger.error("Simulated database failure for ID: {}", patientId);
			throw new RuntimeException("Simulated database failure");
		}
		return entity;
	}
}
