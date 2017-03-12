package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.Produit;

@Repository("produitDao")

public class ProduitDaoImpl implements IProduitDao {

	/**
	 * création de la SessionFactory
	 */
	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<Produit> getAllProduit() {
		String req = "FROM Produit";
		Session s = sf.getCurrentSession();
		Query query = s.createQuery(req);
		return query.list();
	}

	@Override
	public Produit getProduitById(long idProduit) {
		Session s = sf.getCurrentSession();
		return (Produit) s.get(Produit.class, idProduit);
	}

	@Override
	public void updateProduit(Produit produit) {
		// Session s=sf.getCurrentSession();
		// s.saveOrUpdate(produit);
	}

	@Override
	public Produit addProduit(Produit produit) {
		Session s = sf.getCurrentSession();
		s.save(produit);
		return produit;
	}

	@Override
	public void deleteProduit(Produit produit) {
		Session s = sf.getCurrentSession();
		s.delete(produit);
	}

	@Override
	public List<Produit> getAllProduitByIdCategorie(long id_cat) {
		Session s = sf.getCurrentSession();
		String req = "select p from Produit p where p.categorie.idCategorie=:idProduit";
		Query query = s.createQuery(req);
		query.setParameter("idProduit", id_cat);
		List<Produit> listesProduits = query.list();
		System.out.println("Génération liste prod par cat");

		return listesProduits;
	}

	@Override
	public List<Produit> getAllProduitsByKeyWord(String keyWord) {
		Session s = sf.getCurrentSession();
		if (keyWord.equals("%%")) {
			return null;
		} else {
			String req = "select p from Produit p where p.designation like :pseudoKWord or p.description like :pseudoKWord";
			Query query = s.createQuery(req);
			query.setParameter("pseudoKWord", keyWord);
			List<Produit> listeProduits = query.list();
			return listeProduits;
		}
	}
}