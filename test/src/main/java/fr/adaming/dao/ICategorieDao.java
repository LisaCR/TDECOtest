package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Categorie;


public interface ICategorieDao {


	public Categorie addCategorie(Categorie Categorie);
	public void deleteCategorie();
	public Categorie getCategorieById();
	public List<Categorie> getAllCategorie();
	
}
