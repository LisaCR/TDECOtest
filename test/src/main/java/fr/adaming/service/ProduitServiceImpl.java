package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.IProduitDao;
import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;


@Service("produitService")
public class ProduitServiceImpl implements IProduitService {
	
	@Autowired
	IProduitDao produitDao;
	
	
	
	public void setProduitDao(IProduitDao produitDao) {
		this.produitDao = produitDao;
	}


	@Override
	public Produit addProduit(Produit produit) {
		return produitDao.addProduit(produit);
	}


	@Override
	public void deleteProduit() {
		produitDao.deleteProduit();
	}


	@Override
	public Produit getProduitById() {
		return produitDao.getProduitById();
	}


	@Override
	public List<Produit> getAllProduit() {
		return produitDao.getAllProduit();
	}


}
