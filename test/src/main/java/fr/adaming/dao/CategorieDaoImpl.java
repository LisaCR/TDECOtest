package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import fr.adaming.model.Categorie;

/**
 * 
 * @author Vincent Bonillo
 * @see IMagasinDao
 */

@Repository
public class CategorieDaoImpl implements ICategorieDao{

	@Autowired
	SessionFactory sf;
	
	@Override
	public List<Categorie> getAllCategorie() {
		Session s = sf.getCurrentSession();
		String req = "select c from Categorie c";
		Query query = s.createQuery(req);
		return query.list();
	}

	
}
