package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.IAdminDao;
import fr.adaming.model.Admin;
import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;

@Service("adminService")
public class AdminServiceImpl implements IAdminService {

	@Autowired
	IAdminDao adminDao;

	public void setAdminDao(IAdminDao adminDao) {
		this.adminDao = adminDao;
	}

	/**
	 * méthodes d'authentification et de gestion des admin
	 */
	@Override
	public void isExist(Admin admin) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<Admin> getAllAdmin() {
		return adminDao.getAllAdmin();
	}
	
	@Override
	public Admin addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin gestionAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return null;
	}




}
