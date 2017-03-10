/**
 * Déclaration de la classe Produit 
 */


package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

/**
 * 
 * classe Produit
 *
 */
@Entity
@Table(name="produits")
public class Produit implements Serializable {


	
/**
 * d�claration des attributs de la classe Produit
 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_produit")
	private long idProduit;
	@Column(name="designation_produit")
	private String designation;
	@Column(name="description_produit")
	private String description;
	@Column(name="prix_produit")
	private double prix;
	@Column(name="quantite_produit")
	private int quantite=1;
	@Column(name="selectionne_produit")
	private boolean selectionne=false;

/**
 * -------------declaration des liaisons :
 */

	/**
	 * liaison produits et cat�gories :
	 */
	
	@ManyToOne
	@JoinColumn(name="categorie_id_fk", referencedColumnName="id_categorie")
	private Categorie categorie;
	
	
	
/**
 * ---------- d�claration des constructeurs :
 */
	
	/**
	 * un vide	
	 */
	public Produit() {
		super();
	}

/**
 * constructeur avec designation, description, prix (pour création)
 * @param designation
 * @param description
 * @param prix
 */
	public Produit(String designation, String description, double prix) {
		super();
		this.designation = designation;
		this.description = description;
		this.prix = prix;
	}

	
	
	/**
	 * constructeur pour la m�thode d'ajout de produit
	 * l'attribut cat�gorie est assign�e via la m�thode attribuer()
	 * @param designation
	 * @param description
	 * @param prix
	 * @param quantite
	 */
	public Produit(String designation, String description, double prix, int quantite) {
		super();
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
	}

	
	/**
	 * constructeur complet
	 * @param idProduit
	 * @param designation
	 * @param description
	 * @param prix
	 * @param quantite
	 * @param selectionne
	 */
	public Produit(long idProduit, String designation, String description, double prix, int quantite,
			boolean selectionne) {
		super();
		this.idProduit = idProduit;
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
		this.selectionne = selectionne;
		
	}
	




public Produit(long idProduit, String designation, String description, double prix) {
		super();
		this.idProduit = idProduit;
		this.designation = designation;
		this.description = description;
		this.prix = prix;
	}

/**
 * -------------getters et setters :
 * @return
 */
	
	public long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(long idProduit) {
		this.idProduit = idProduit;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public boolean isSelectionne() {
		return selectionne;
	}

	public void setSelectionne(boolean selectionne) {
		this.selectionne = selectionne;
	}

	

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	





/**
 * M�thode toString qui affiche Id, designation, description, prix
 */



	@Override
	public String toString() {
		return "Produit [idProduit=" + idProduit + ", designation=" + designation + ", description=" + description
				+ ", prix=" + prix + "]";
	}

	
}
