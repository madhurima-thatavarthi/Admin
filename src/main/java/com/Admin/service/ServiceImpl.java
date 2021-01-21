package com.Admin.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.Admin.model.Admin;
import com.Admin.repository.Repository;

public class ServiceImpl implements Service{

	@Autowired
	Repository repository;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public List<Admin> getAllAdmins() {
		
		return repository.findAll();
	}

	@Override
	public Admin getAdminById(int id) {
		Optional<Admin> admin = repository.findById(id);
        if (admin.isPresent()) {
            return admin.get();
        } else {
            return null;
        }
		
	}	

	@Override
	public Admin createAdmin(Admin admin) {
		URI uri = URI.create("http://localhost:/9093/createadmin");
		return repository.save(this.restTemplate.getForObject(uri, Admin.class));
	}

	@Override
	public Admin updateAdmin(int id, Admin admin) {
		Optional<Admin> updateAdmin = repository.findById(id);
        if (updateAdmin.isPresent()) {
        	Admin newAdmin = updateAdmin.get();
            newAdmin = admin;
            return repository.save(newAdmin);
        } else {         
            return repository.save(updateAdmin.get());
        }
	}

	@Override
	public boolean deleteAdmin(int id) {
		repository.deleteById(id);
        return true;
	}

}
