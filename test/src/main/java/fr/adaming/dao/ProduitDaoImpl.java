package fr.adaming.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;

@Repository("produitDao")
public class ProduitDaoImpl extends HibernateDaoSupport implements IProduitDao {

	@Override
	public Produit addProduit(Produit produit) {
		getHibernateTemplate().save(produit);
		return produit;
	}

	@Override
	public void deleteProduit() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Produit getProduitById() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Produit> getAllProduit() {
		// TODO Auto-generated method stub
		return null;
	}

}
