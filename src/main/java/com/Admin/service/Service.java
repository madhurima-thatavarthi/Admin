package com.Admin.service;

import java.util.List;

import com.Admin.model.Admin;

public interface Service {

	public List<Admin> getAllAdmins();
	
	public Admin getAdminById(int id);
	
	public Admin createAdmin(Admin admin);
	
	public Admin updateAdmin(int id , Admin admin);
	
	public boolean deleteAdmin(int id);
	
}
