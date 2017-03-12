package fr.adaming.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
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
@Scope(value = "session")
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
	public String afficherProdFromCat(ModelMap model, @PathVariable("id_cat_param") int id_cat,
			HttpServletRequest req) {

		HttpSession session = req.getSession();

		Categorie categorie = categorieService.getCategorieById(id_cat);

		session.setAttribute("categorieSes", categorie);

		List<Produit> listeProduits = produitService.getAllProduitByIdCategorie(id_cat);

		model.addAttribute("prodListe", listeProduits);
		model.addAttribute("selectedCat", categorie);

		return "afficheProduitFromCategorie";

	}

	@RequestMapping(value = "/ajouterPanier/{id_prod_param}", method = RequestMethod.GET)
	public String ajouterPanier(ModelMap model, @PathVariable("id_prod_param") int id_prod, HttpServletRequest req) {

		HttpSession session = req.getSession();
		Categorie categorie = (Categorie) session.getAttribute("categorieSes");
		System.out.println(categorie);

		// Rechargement des données du tableau
		List<Produit> listeProduits = produitService.getAllProduitByIdCategorie(categorie.getIdCategorie());
		model.addAttribute("prodListe", listeProduits);
		model.addAttribute("selectedCat", categorie);

		// Ajout du produit au panier
		Produit produit = produitService.getProduitById(id_prod);

		Map<String, Produit> panier;

		if (session.getAttribute("panierSes") == null) {
			panier = new HashMap<String, Produit>();
		} else {
			panier = (HashMap<String, Produit>) session.getAttribute("panierSes");
		}

		if (panier.get(produit.getDesignation()) != null) {
			System.out.println("maj qte produit");
			int NewQte = produit.getQuantite() + (panier.get(produit.getDesignation())).getQuantite();
			produit.setQuantite(NewQte);
		}
		panier.put(produit.getDesignation(), produit);
		
		session.setAttribute("panierSes", panier);
		return "afficheProduitFromCategorie";
	}

	@RequestMapping(value = "/affichFormKW", method = RequestMethod.GET)
	public ModelAndView afficheFormKW() {
		return new ModelAndView("produitByKW", "prodKW", new Produit());
	}

	@RequestMapping(value = "/soumettreFormKW", method = RequestMethod.POST)
	public String soumettreFormKW(ModelMap model, @ModelAttribute("prodKW") Produit prod, HttpServletRequest req) {

		String keyWordRequete = "%" + prod.getDesignation() + "%";

		List<Produit> listeProduitsKW = produitService.getAllProduitsByKeyWord(keyWordRequete);

		HttpSession session = req.getSession();
		session.setAttribute("listeKwSes", listeProduitsKW);

		model.addAttribute("prodListeKW", listeProduitsKW);

		return "produitByKWResultat";
	}

	@RequestMapping(value = "/ajouterPanierKW/{id_prod_param}", method = RequestMethod.GET)
	public String ajouterPanierKW(ModelMap model, @PathVariable("id_prod_param") int id_prod, HttpServletRequest req) {

		// Rechargement des données de la liste
		HttpSession session = req.getSession();
		List<Produit> listeProduitsKW = (List<Produit>) session.getAttribute("listeKwSes");
		model.addAttribute("prodListeKW", listeProduitsKW);

		// Ajout au panier
		Produit produit = produitService.getProduitById(id_prod);

		Map<String, Produit> panier;

		if (session.getAttribute("panierSes") == null) {
			panier = new HashMap<String, Produit>();
		} else {
			panier = (HashMap<String, Produit>) session.getAttribute("panierSes");
		}

		if (panier.get(produit.getDesignation()) != null) {
			System.out.println("maj qte produit");
			int NewQte = produit.getQuantite() + (panier.get(produit.getDesignation())).getQuantite();
			produit.setQuantite(NewQte);
		}
		panier.put(produit.getDesignation(), produit);
		
		session.setAttribute("panierSes", panier);
		return "produitByKWResultat";
	}

	@RequestMapping(value = "/afficherPanier", method = RequestMethod.GET)
	public String afficherPanier(ModelMap model, HttpServletRequest req) {
		HttpSession session = req.getSession();
		Map<String, Produit> panier = (HashMap<String, Produit>) session.getAttribute("panierSes");
		
		Set<Entry<String, Produit>> setTemp = panier.entrySet();
		List<Produit> listePanier = new ArrayList<Produit>();
		double totalPanier = 0;
		for (Entry<String, Produit> entry : setTemp) {
			listePanier.add(entry.getValue());
			totalPanier += (entry.getValue().getPrix()) * (entry.getValue().getQuantite());
			System.out.println("tot " + totalPanier);
			System.out.println(entry.getValue());
		}
		model.addAttribute("totalPanier",totalPanier);
		model.addAttribute("panier",listePanier);
		return "afficherPanier";
	}

	@RequestMapping(value = "/supprimerPanier/{id_prod_param}", method = RequestMethod.GET)
	public String supprimerPanier(ModelMap model, @PathVariable("id_prod_param") int id_prod,HttpServletRequest req) {

		HttpSession session = req.getSession();
		
		Map<String, Produit> panier = (HashMap<String, Produit>) session.getAttribute("panierSes");
		
		Produit produit = produitService.getProduitById(id_prod);

		panier.remove(produit.getDesignation());
		
		session.setAttribute("panierSes", panier);

		return "afficherPanier";
	}
}
