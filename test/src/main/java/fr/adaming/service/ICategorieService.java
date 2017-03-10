package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Categorie;


public interface ICategorieService {

	/**
	 * gestion des Categories
	 */
	public Categorie addCategorie(Categorie Categorie);
	public void deleteCategorie();
	public Categorie getCategorieById();
	public List<Categorie> getAllCategorie();
	
}
