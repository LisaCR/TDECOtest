package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Categorie;


/**
 * Contient les m�thodes utilis�es lors des op�rations li�es aux cat�gories.
 * @author Lisa Carranque Rios & Vincent Bonillo 
 *
 */
public interface ICategorieDao {
	/**
	 * Charge toutes les cat�gorie depuis la DB.
	 * @return Un objet de type List<Categorie>.
	 */

	public List<Categorie> getAllCategorie();
	
	
	/**
	 * Charge la cat�gorie depuis la DB en fonction de son ID.
	 * @return Un objet de type Categorie.
	 */
	public Categorie getCategorieById(int id_cat);
}
