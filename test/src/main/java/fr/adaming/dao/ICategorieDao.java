package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Categorie;


/**
 * Contient les méthodes utilisées lors des opérations liées aux catégories.
 * @author Lisa Carranque Rios & Vincent Bonillo 
 *
 */
public interface ICategorieDao {
	/**
	 * Charge toutes les catégorie depuis la DB.
	 * @return Un objet de type List<Categorie>.
	 */

	public List<Categorie> getAllCategorie();
}
