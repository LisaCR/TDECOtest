package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Admin;

public interface IAdminService {
	
	/**
	 * authentification
	 * ajout des administrateurs super admin
	 * gestion des droits d'accès des admin
	 */ 
	
	public void isExist(Admin admin);
	public List<Admin> getAllAdmin();
	public Admin getAdminById(int id);
	public Admin addAdmin(Admin admin);
	public Admin gestionAdmin(Admin admin);
	public void updateAdmin(Admin admin);
	public void deleteAdmin(Admin admin);
	
}
