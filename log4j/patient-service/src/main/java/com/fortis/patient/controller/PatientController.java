package com.fortis.patient.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fortis.patient.entity.PatientEntity;
import com.fortis.patient.request.PatientRequest;
import com.fortis.patient.service.PatientService;

@RestController
@RequestMapping("/patients")
public class PatientController {
	private static final Logger logger = LogManager.getLogger(PatientController.class);

	@Autowired
	PatientService service;

	@PostMapping("/addPatients")
	public PatientEntity registerPatient(@RequestBody PatientRequest request) {
		return service.registerPatient(request);

	}

	@GetMapping("/{patientId}")
	public PatientEntity getById(@PathVariable Integer patientId) {
		logger.info("API call received to fetch patient with ID: {}", patientId);
		return service.getPatientByID(patientId);
	}
}
