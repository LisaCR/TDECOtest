package fr.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.adaming.model.Categorie;
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

	public void setProduitService(IProduitService produitService) {
		this.produitService = produitService;
	}

	@RequestMapping(value = "/accueilClient", method = RequestMethod.GET)
	public String accueilClient(ModelMap model) {
		model.addAttribute("accueilMessage", "Bienvenue sur notre site de vente en ligne !");

		return "accueilClient";
	}
	
	@RequestMapping(value = "/listeCategories", method = RequestMethod.GET)
	public String afficherCategories(ModelMap model) {
//		List<Categorie> listeCategories = 

//		model.addAttribute("catListe", ListeCategories);

		return "afficheListeCategories";
	}
	
	
}
