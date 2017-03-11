package fr.adaming.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

		return "afficherListeCategorieClient";

	}

	@RequestMapping(value = "/afficheProduitFromCategorie/{id_cat_param}", method = RequestMethod.GET)
	public String afficherProdFromCat(ModelMap model, @PathVariable("id_cat_param") int id_cat) {

		Categorie cat = categorieService.getCategorieById(id_cat);

		List<Produit> listeProduits = produitService.getAllProduitByIdCategorie(id_cat);

		model.addAttribute("prodListe", listeProduits);
		model.addAttribute("selectedCat", cat);

		return "afficheProduitFromCategorie";

	}

	@RequestMapping(value = "/ajouterPanier/{id_prod_param}", method = RequestMethod.GET)
	public String ajouterPanier(ModelMap model, @PathVariable("id_prod_param") int id_prod) {

		Produit produit = produitService.getProduitById(id_prod);

		Map<String, Produit> panier;

		if (model.get("panier") == null || ((Map<String, Produit>) model.get("panier")).size() == 0) {
			System.out.println("création panier");
			panier = new HashMap<String, Produit>();

		} else {
			panier = (Map<String, Produit>) model.get("panier");

			if (panier.get(produit).getDesignation() == null) {
				System.out.println("nouveau produit");

			} else {
				System.out.println("maj qte produit");
				int NewQte = produit.getQuantite() + (panier.get(produit.getDesignation())).getQuantite();
				produit.setQuantite(NewQte);
			}

		}
		panier.put(produit.getDesignation(), produit);
		model.addAttribute("panier", panier);
		return "afficheProduitFromCategorie";
	}

	@RequestMapping(value = "/affichFormKW", method = RequestMethod.GET)
	public ModelAndView afficheFormKW() {
		return new ModelAndView("produitByKW", "prodKW", new Produit());
	}

	@RequestMapping(value = "/soumettreFormKW", method = RequestMethod.POST)
	public String soumettreFormKW(ModelMap model, @ModelAttribute("prodKW") Produit prod) {

		String keyWordRequete = "%" + prod.getDesignation() + "%";

		List<Produit> listeProduitsKW = produitService.getAllProduitsByKeyWord(keyWordRequete);

		model.addAttribute("prodListeKW", listeProduitsKW);

		return "produitByKWResultat";
	}

	@RequestMapping(value = "/ajouterPanierKW/{id_prod_param}", method = RequestMethod.GET)
	public String ajouterPanierKW(ModelMap model, @PathVariable("id_prod_param") int id_prod) {

		Produit produit = produitService.getProduitById(id_prod);

		Map<String, Produit> panier;

		if (model.get("panier") == null || ((Map<String, Produit>) model.get("panier")).size() == 0) {
			System.out.println("création panier");
			panier = new HashMap<String, Produit>();

		} else {
			panier = (Map<String, Produit>) model.get("panier");

			if (panier.get(produit).getDesignation() == null) {
				System.out.println("nouveau produit");

			} else {
				System.out.println("maj qte produit");
				int NewQte = produit.getQuantite() + (panier.get(produit.getDesignation())).getQuantite();
				produit.setQuantite(NewQte);
			}

		}
		panier.put(produit.getDesignation(), produit);
		model.addAttribute("panier", panier);
		return "produitByKWResultat";
	}

	@RequestMapping(value = "/afficherPanier", method = RequestMethod.GET)
	public String afficherPanier(ModelMap model) {

		return "afficherPanier";
	}

	@RequestMapping(value = "/supprimerPanier/{id_prod_param}", method = RequestMethod.GET)
	public String supprimerPanier(ModelMap model, @PathVariable("id_prod_param") int id_prod) {

		Produit produit = produitService.getProduitById(id_prod);

		Map<String, Produit> panier = (Map<String, Produit>) model.get("panier");

		panier.remove(produit.getDesignation());

		model.addAttribute("panier", panier);

		return "afficherPanier";
	}
}
