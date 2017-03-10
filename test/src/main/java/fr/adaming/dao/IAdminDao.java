package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Admin;


public interface IAdminDao {

	public void isExist(Admin admin);
	public Admin addAdmin(Admin admin);
	public Admin gestionAdmin(Admin admin);
	
}
