package com.klef.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klef.soa.entity.Patient;
import com.klef.soa.service.PatientService;


@RestController
@RequestMapping("/patient")
public class PatientController {
	@Autowired
	private PatientService service;
	@GetMapping("/")
	public String test() {
		return "SOA Programming & MicroService";
	}
	@GetMapping("/displayall")
	public ResponseEntity<List<Patient>> displayallpatients() {
		List<Patient> patients=service.displayAllPatients();
		return ResponseEntity.status(200).body(patients);
	}
	@PostMapping("/add")
	public ResponseEntity<Patient> addpatient(@RequestBody Patient p) {
		return ResponseEntity.status(201).body(service.addPatient(p));
	}
	@GetMapping("/display")
	public ResponseEntity<?> displayPatientById(@RequestParam Long id) {
		Patient p=service.displayPatientById(id);
		if(p!=null) {
			return ResponseEntity.status(200).body(p);
		}else {
			return ResponseEntity.status(404).body("Patient Id not found");
		}
	}
		@PutMapping("/update")
		public ResponseEntity<?> updatePatient(@RequestBody Patient p){
			Patient patient=service.updatePatient(p);
			if(patient!=null) {
				return ResponseEntity.ok(p);
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("patient not found");
			}
	}
		@DeleteMapping("/deleteby/{id}")
		public ResponseEntity<String> deletePatientById(@PathVariable Long id) {
			String message=service.deletePatientById(id);
			return new ResponseEntity<>(message,HttpStatus.OK);
		}
		@GetMapping("/displaybygender/{gender}")
		public ResponseEntity<List<Patient>> displayPatientByGender(@PathVariable String gender) {
			List<Patient> patient=service.displayPatientsByGender(gender);
			return ResponseEntity.ok(patient);
		}
		@GetMapping("/count")
		public ResponseEntity<String> displayPatientCount() {
			Long count=service.displayPatientCount();
			String msg="Total Patient="+count;
			return ResponseEntity.ok(msg);
		}
}
