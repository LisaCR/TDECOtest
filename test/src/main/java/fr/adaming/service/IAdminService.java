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
	public Admin addAdmin(Admin admin);
	public Admin gestionAdmin(Admin admin);
	
}
