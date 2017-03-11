package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Admin;


public interface IAdminDao {

	public void isExist(Admin admin);
	public List<Admin> getAllAdmin();
	public Admin getAdminById(int id);
	public Admin addAdmin(Admin admin);
	public Admin gestionAdmin(Admin admin);
	public void updateAdmin(Admin admin);
	public void deleteAdmin(int id);


	
}
