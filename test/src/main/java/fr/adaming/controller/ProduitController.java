package fr.adaming.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Produit;
import fr.adaming.service.IProduitService;

@Controller
@RequestMapping("/produit")
public class ProduitController {
	
	
	@Autowired
	private IProduitService produitService;

	public void setProduitService(IProduitService produitService) {
		this.produitService = produitService;
	}

/**
 * définition et mapping accueil
 */
	@RequestMapping(value = "/accueil", method = RequestMethod.GET)
	public String accueil(ModelMap model) {
		model.addAttribute("nomApp", "APPLICATION DE GESTION DES PRODUITS");

		model.addAttribute("salutation", "Avec SPRING MVC");

		return "accueil";
	}
	
	/**
	 * Afficher liste produit
	 */
	@RequestMapping(value = "/listeProduit", method = RequestMethod.GET)
	public String afficherProduit(ModelMap model) {
		List<Produit> listeProduit = produitService.getAllProduit();

		model.addAttribute("produitListe", listeProduit);

		return "afficherListeProduit";
	}
	
	
	/**
	 * update d'produit
	 */
	
	
	

	/**
	 * Ajout d'produit
	 */
	
	// Methode pour afficher le formulaire d'ajout et lui attribuer le modele
	@RequestMapping(value = "/affichFormAjout", method = RequestMethod.GET)
	public ModelAndView affichFormAjout() {
		return new ModelAndView("ajouterProduit", "produitForm", new Produit());
	}
	
	// Methode pour soummettre le formulaire d'ajout et lui attribuer le modele
	@RequestMapping(value = "/soumettreFormAjout", method = RequestMethod.POST)
	public String soumettreFormAjout(Model model, @Valid @ModelAttribute("produitForm") Produit produit,BindingResult resultatValidation ) {
		if(resultatValidation.hasErrors()){
			return "ajouterProduit";
		}
		if(produit.getIdProduit()==0){
		// appel de la methode ajouter du service
		produitService.addProduit(produit);
		}
		
//		else{
//			/**
//			 * appel de la méthode update du service
//			 */
//			produitService.updateProduit(produit);
//		}
		// rafraichissement de la liste
		List<Produit> listeProduit = produitService.getAllProduit();

		model.addAttribute("produitListe", listeProduit);

		return "afficherListeProduit";
	}
	
	
	/**
	 * suppression produit
	 */
	
	 // Méthode pour afficher le formulaire de suppression
	@RequestMapping(value = "/affichFormSupp", method = RequestMethod.GET)
	public String affichFormSuppress(){
		return "supprimer";
	}
	
	
	@RequestMapping(value = "/soumettreFormSuppr/{id_param}", method = RequestMethod.GET)
	public String soumettreformulaireSuppr(Model model,@PathVariable("id_param") int idProduit){
		// appel de la methode getById de service pour chercher l'produit avec l'id recupéré
		Produit produit=produitService.getProduitById(idProduit);
		// Appel de la methode delete de service
		produitService.deleteProduit(produit);
		// raffraichissement de la liste
		List<Produit> listeProduit = produitService.getAllProduit();

		model.addAttribute("produitListe", listeProduit);
		
		return "afficherListeProduit";
	}

	 // Méthode pour afficher le formulaire de suppression
		@RequestMapping(value = "/affichFormmodif", method = RequestMethod.GET)
		public String affichFormModif(ModelMap model,@RequestParam("id_param") int idProduit ){
			Produit produit=produitService.getProduitById(idProduit);
			model.addAttribute("produitForm", produit);
			
			return "ajouterProduit";
		}
	
	
	
	
}
