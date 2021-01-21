package com.Admin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.Admin.model.Admin;
import com.Admin.repository.Repository;

public class ServiceImpl implements Service{

	@Autowired
	Repository repository;
	
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
		return repository.save(admin);
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
