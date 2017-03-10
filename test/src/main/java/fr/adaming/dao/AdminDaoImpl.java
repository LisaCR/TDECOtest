package fr.adaming.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Admin;
import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;

@Repository("adminDao")
public class AdminDaoImpl implements IAdminDao {

	/**
	 * création de la SessionFactory
	 */
	@Autowired
	private SessionFactory sf;


	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	

	@Override
	public void isExist(Admin admin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Admin addAdmin(Admin admin) {
		Session s=sf.getCurrentSession();
		s.save(admin);
		return admin;
	}

	@Override
	public Admin gestionAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return null;
	}


	
	
}