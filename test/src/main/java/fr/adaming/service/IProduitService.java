package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;

public interface IProduitService {

	/**
	 * gestion des produits
	 */
	public Produit addProduit(Produit produit);
	public void deleteProduit();
	public Produit getProduitById();
	public List<Produit> getAllProduit();
	
}
