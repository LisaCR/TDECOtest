package fr.adaming.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Admin;
import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;

@Repository("adminDao")
public class AdminDaoImpl extends HibernateDaoSupport implements IAdminDao {

	@Override
	public void isExist(Admin admin) {
		// TODO Auto-generated method stub
		
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
