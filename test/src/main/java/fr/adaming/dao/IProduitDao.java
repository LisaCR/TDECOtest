package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Produit;


public interface IProduitDao {

	public List<Produit> getAllProduit();
	public Produit getProduitById(int id);
	public Produit addProduit(Produit produit);
	public void updateProduit(Produit produit);
	public void deleteProduit(Produit produit);


	
}
