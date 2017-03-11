package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IProduitDao;
import fr.adaming.model.Produit;
import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;

@Service("produitService")
@Transactional
public class ProduitServiceImpl implements IProduitService {

	@Autowired
	IProduitDao produitDao;

	public void setProduitDao(IProduitDao produitDao) {
		this.produitDao = produitDao;
	}

	/**
	 * méthodes d'authentification et de gestion des produit
	 */

	@Override
	public List<Produit> getAllProduit() {
		return produitDao.getAllProduit();
	}

	@Override
	public Produit getProduitById(int id) {
		return produitDao.getProduitById(id);
	}

	@Override
	public Produit addProduit(Produit produit) {
		return produitDao.addProduit(produit);
	}

	@Override
	public void updateProduit(Produit produit) {
		produitDao.updateProduit(produit);
	}

	@Override
	public void deleteProduit(Produit produit) {
		produitDao.deleteProduit(produit);
	}

	@Override
	public List<Produit> getAllProduitByIdCategorie(int id_cat) {
		return produitDao.getAllProduitByIdCategorie(id_cat);

	}

	@Override
	public List<Produit> getAllProduitsByKeyWord(String keyWord) {
		return produitDao.getAllProduitsByKeyWord(keyWord);
	}

}
