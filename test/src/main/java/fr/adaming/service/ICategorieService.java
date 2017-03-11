package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Categorie;

/**
 * 
 * @author Vincent Bonillo
 * @see IMagasinDao
 */
public interface ICategorieService {
	public List<Categorie> getAllCategorie();
}
