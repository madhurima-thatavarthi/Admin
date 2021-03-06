package com.Admin.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Admin.exception.NoContentException;
import com.Admin.model.Admin;
import com.Admin.model.Donor;
import com.Admin.service.Service;
import com.Admin.model.Requestor;

@RestController
public class Controller {

	@Autowired
	Service service;

	@GetMapping(value = "/getadmins")
	public ResponseEntity<List<Admin>> getAllAdmins() {
		return new ResponseEntity<List<Admin>>(service.getAllAdmins(), HttpStatus.OK);
	}

	@GetMapping(value = "/getadminbyid/{id}")
	public ResponseEntity<Admin> getRequestorById(@PathVariable("id") int id) throws NoContentException{
		return new ResponseEntity<Admin>(service.getAdminById(id), HttpStatus.OK);
	}

	@PostMapping(value = "/createadmin")
	public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
		return new ResponseEntity<Admin>(service.createAdmin(admin), HttpStatus.CREATED);
	}

	@PutMapping(value = "/updateadmin/{id}")
	public ResponseEntity<Admin> updateRequestor(int id, @RequestBody Admin admin) {
		return new ResponseEntity<Admin>(service.updateAdmin(id, admin), HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/deleteadmin/{id}")
	public boolean deleteRequestor(@PathVariable("id") int id) {
		return service.deleteAdmin(id);
	}

	@GetMapping(value = "/approverequestor/{id}")
	public ResponseEntity<Requestor> approveRequestor(@PathVariable("id") int id) throws NoContentException {
		try {
			return new ResponseEntity<Requestor>(service.approveRequestor(id), HttpStatus.OK);
		} catch (NoSuchElementException ex) {
			throw new NoContentException(ex.getMessage());
		}
	}

	@GetMapping(value = "/approvedonor/{id}")
	public ResponseEntity<Donor> approveDonor(@PathVariable("id") int id) throws NoContentException {
		try {
			return new ResponseEntity<Donor>(service.approveDonor(id), HttpStatus.OK);
		} catch (NoSuchElementException ex) {
			throw new NoContentException(ex.getMessage());
		}
	}
}