package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;

public interface IProduitDao {


	public Produit addProduit(Produit produit);
	public void deleteProduit();
	public Produit getProduitById();
	public List<Produit> getAllProduit();
	
}
