package com.Admin.service;

import java.util.List;
import com.Admin.model.Admin;
import com.Admin.model.Donor;
import com.Admin.model.Requestor;

public interface Service {

	public List<Admin> getAllAdmins();

	public Admin getAdminById(int id);

	public Admin updateAdmin(int id, Admin admin);

	public boolean deleteAdmin(int id);

	public Requestor approveRequestor(int id);

	public Donor approveDonor(int id);

	public Admin createAdmin(Admin admin);

}
