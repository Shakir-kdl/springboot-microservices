package com.fortis.patient.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientRequest {

	private String name;
	private int age;
	private String email;
	private String phone;
	private String address;
	private String disease;
}
