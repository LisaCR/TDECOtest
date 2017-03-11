package fr.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IProduitService;

/**
 * Controller gérant les interactions du client (sans authentification) à
 * travers le site de E-Commerce: Afficher les liste des produits disponibles
 * par catégories ou par mot clé. Permet l'ajout de ces produit dans un panier.
 * Affichage et gestion du panier. Passer une commande.
 * 
 * @author Lisa Carranque Rios & Vincent Bonillo
 *
 */
@Controller
@RequestMapping("/magasin")
public class MagasinController {

	@Autowired
	IProduitService produitService;

	@Autowired
	ICategorieService categorieService;

	public void setProduitService(IProduitService produitService) {
		this.produitService = produitService;
	}

	public void setCategorieService(ICategorieService categorieService) {
		this.categorieService = categorieService;
	}

	@RequestMapping(value = "/accueilClient", method = RequestMethod.GET)
	public String accueilClient(ModelMap model) {
		model.addAttribute("accueilMessage", "Bienvenue sur notre site de vente en ligne !");

		return "accueilClient";
	}

	@RequestMapping(value = "/listeCategories", method = RequestMethod.GET)
	public String afficherCategories(ModelMap model) {
		List<Categorie> listeCategories = categorieService.getAllCategorie();

		model.addAttribute("catListe", listeCategories);

		return "afficheListeCategories";

	}

	@RequestMapping(value = "/afficheProduitFromCategorie/{id_cat_param}", method = RequestMethod.GET)
	public ModelAndView afficherProdFromCat(ModelMap model,@PathVariable("id_cat_param") int id_cat){
		
		Categorie cat = categorieService.getCategorieById(id_cat);
		
		List<Produit> listeProduits = produitService.getAllProduitByIdCategorie(id_cat);

		model.addAttribute("prodListe", listeProduits );
		model.addAttribute("selectedCat", cat );
		
		return new ModelAndView("afficheProduitFromCategorie", "produitToAdd", new Produit());

	}
	
	
}
