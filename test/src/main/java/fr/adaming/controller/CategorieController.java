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

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;
import fr.adaming.service.ICategorieService;

@Controller
@RequestMapping("/categorie")
public class CategorieController {
	
	
	@Autowired
	private ICategorieService categorieService;

	public void setCategorieService(ICategorieService categorieService) {
		this.categorieService = categorieService;
	}

/**
 * définition et mapping accueil
 */
	@RequestMapping(value = "/accueil", method = RequestMethod.GET)
	public String accueil(ModelMap model) {
		model.addAttribute("nomApp", "APPLICATION DE GESTION DES CATEGORIES");

		model.addAttribute("salutation", "Avec SPRING MVC");

		return "accueil";
	}
	
	/**
	 * Afficher liste categorie
	 */
	@RequestMapping(value = "/listeCategorie", method = RequestMethod.GET)
	public String afficherCategorie(ModelMap model) {
		List<Categorie> listeCategorie = categorieService.getAllCategorie();

		model.addAttribute("categorieListe", listeCategorie);

		return "afficherListeCategorie";
	}
	
	
	/**
	 * update d'categorie
	 */
	
	
	

	/**
	 * Ajout d'categorie
	 */
	
	// Methode pour afficher le formulaire d'ajout et lui attribuer le modele
	@RequestMapping(value = "/affichFormAjout", method = RequestMethod.GET)
	public ModelAndView affichFormAjout() {
		return new ModelAndView("ajouterCategorie", "categorieForm", new Categorie());
	}
	
	// Methode pour soummettre le formulaire d'ajout et lui attribuer le modele
	@RequestMapping(value = "/soumettreFormAjout", method = RequestMethod.POST)
	public String soumettreFormAjout(Model model, @Valid @ModelAttribute("categorieForm") Categorie categorie,BindingResult resultatValidation ) {
		if(resultatValidation.hasErrors()){
			return "ajouterCategorie";
		}
		if(categorie.getIdCategorie()==0){
		// appel de la methode ajouter du service
		categorieService.addCategorie(categorie);
		}
		
//		else{
//			/**
//			 * appel de la méthode update du service
//			 */
//			categorieService.updateCategorie(categorie);
//		}
		// rafraichissement de la liste
		List<Categorie> listeCategorie = categorieService.getAllCategorie();

		model.addAttribute("categorieListe", listeCategorie);

		return "afficherListeCategorie";
	}
	
	
	/**
	 * suppression categorie
	 */
	
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String deleteCategorie(Model model, @PathVariable("id") long id) {


		Categorie categorie = categorieService.getCategorieById(id);

		categorieService.deleteCategorie(categorie);

		/**
		 * rafraichissement de la liste et affichage d'un message d'alerte
		 */
		List<Categorie> listeCategorie = categorieService.getAllCategorie();

		model.addAttribute("categorieListe", listeCategorie);
		model.addAttribute("css", "success");
		model.addAttribute("msg", "Categorie is deleted!");


		return "afficherListeCategorie";

	}
	
	
}
