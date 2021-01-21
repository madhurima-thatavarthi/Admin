package com.Admin.controller;

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

import com.Admin.model.Admin;
import com.Admin.service.Service;

public class Controller {

	@Autowired
    Service service;

    @GetMapping(value = "/getadmins")
    public ResponseEntity<List<Admin>> getAllAdmins() {
        return new ResponseEntity<List<Admin>>(service.getAllAdmins(), HttpStatus.OK);
    }

    @GetMapping(value = "/getadminbyid/{id}")
    public ResponseEntity<Admin> getRequestorById(@PathVariable("id") int id) {
        if (service.getAdminById(id) != null) {
            return new ResponseEntity<Admin>(service.getAdminById(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<Admin>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(value = "/createadmin")
    public ResponseEntity<Admin> createRequestor(@RequestBody Admin admin) {
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
}
