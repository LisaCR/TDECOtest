package fr.adaming.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Admin;
import fr.adaming.service.IAdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	
	@Autowired
	private IAdminService adminService;

	public void setAdminService(IAdminService adminService) {
		this.adminService = adminService;
	}

/**
 * définition et mapping accueil
 */
	@RequestMapping(value = "/accueil", method = RequestMethod.GET)
	public String accueil(ModelMap model) {
		model.addAttribute("nomApp", "APPLICATION DE GESTION DES ADMINS");

		model.addAttribute("salutation", "Avec SPRING MVC");

		return "accueil";
	}
	
	/**
	 * Afficher liste admin
	 */
	@RequestMapping(value = "/listeAdmin", method = RequestMethod.GET)
	public String afficherEmployes(ModelMap model) {
		List<Admin> listeAdmin = adminService.getAllAdmin();

		model.addAttribute("adminListe", listeAdmin);

		return "afichListe";
	}
	
	
	

	/**
	 * Ajout d'admin
	 */
	
	// Methode pour afficher le formulaire d'ajout et lui attribuer le modele
	@RequestMapping(value = "/affichFormAjout", method = RequestMethod.GET)
	public ModelAndView affichFormAjout() {
		return new ModelAndView("ajouter", "adminForm", new Admin());
	}
	
	// Methode pour soummettre le formulaire d'ajout et lui attribuer le modele
//	@RequestMapping(value = "/soumettreFormAjout", method = RequestMethod.POST)
//	public String soumettreFormAjout(Model model, @Valid @ModelAttribute("adminForm") Admin admin,BindingResult resultatValidation ) {
//		if(resultatValidation.hasErrors()){
//			return "ajouter";
//		}
//		if(admin.getIdAdmin()==0){
//		// appel de la methode ajouter du service
//		adminService.addAdmin(admin);
//		}else{
//			/**
//			 * appel de la méthode update du service
//			 */
//			adminService.updateAdmin(admin);
//		}
//		// rafraichissement de la liste
//		List<Admin> listeAdmin = adminService.getAllAdmin();
//
//		model.addAttribute("adminListe", listeAdmin);
//
//		return "afichListe";
//	}
	
}
