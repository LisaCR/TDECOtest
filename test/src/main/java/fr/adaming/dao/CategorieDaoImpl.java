package fr.adaming.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Categorie;
import fr.adaming.model.Categorie;

@Repository("CategorieDao")
public class CategorieDaoImpl extends HibernateDaoSupport implements ICategorieDao {

	@Override
	public Categorie addCategorie(Categorie Categorie) {
		getHibernateTemplate().save(Categorie);
		return Categorie;
	}

	@Override
	public void deleteCategorie() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Categorie getCategorieById() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Categorie> getAllCategorie() {
		// TODO Auto-generated method stub
		return null;
	}

}
