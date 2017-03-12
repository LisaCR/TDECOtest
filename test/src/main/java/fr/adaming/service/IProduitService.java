package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Produit;

public interface IProduitService {
	
	/**
	 * authentification
	 * ajout des produitistrateurs super produit
	 * gestion des droits d'accès des produit
	 */ 
	
	public List<Produit> getAllProduit();
	public Produit getProduitById(long id);
	public Produit addProduit(Produit produit);
	public void updateProduit(Produit produit);
	public void deleteProduit(Produit produit);
	public List<Produit> getAllProduitByIdCategorie(long id_cat);
	public List<Produit> getAllProduitsByKeyWord(String keyWord);
	
}
