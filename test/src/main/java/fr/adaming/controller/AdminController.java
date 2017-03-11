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
 * d�finition et mapping accueil
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
	public String afficherAdmin(ModelMap model) {
		List<Admin> listeAdmin = adminService.getAllAdmin();

		model.addAttribute("adminListe", listeAdmin);

		return "afficherListe";
	}
	
	
	/**
	 * update d'admin
	 */
	
	
	

	/**
	 * Ajout d'admin
	 */
	
	// Methode pour afficher le formulaire d'ajout et lui attribuer le modele
	@RequestMapping(value = "/affichFormAjout", method = RequestMethod.GET)
	public ModelAndView affichFormAjout() {
		return new ModelAndView("ajouterAdmin", "adminForm", new Admin());
	}
	
	// Methode pour soummettre le formulaire d'ajout et lui attribuer le modele
	@RequestMapping(value = "/soumettreFormAjout", method = RequestMethod.POST)
	public String soumettreFormAjout(Model model, @Valid @ModelAttribute("adminForm") Admin admin,BindingResult resultatValidation ) {
		if(resultatValidation.hasErrors()){
			return "ajouterAdmin";
		}
		if(admin.getIdAdmin()==0){
		// appel de la methode ajouter du service
		adminService.addAdmin(admin);
		}
		
//		else{
//			/**
//			 * appel de la m�thode update du service
//			 */
//			adminService.updateAdmin(admin);
//		}
		// rafraichissement de la liste
		List<Admin> listeAdmin = adminService.getAllAdmin();

		model.addAttribute("adminListe", listeAdmin);

		return "afficherListe";
	}
	
	
	/**
	 * suppression admin
	 */
	
	 // M�thode pour afficher le formulaire de suppression
	@RequestMapping(value = "/affichFormSupp", method = RequestMethod.GET)
	public String affichFormSuppress(){
		return "supprimer";
	}
	
	
	@RequestMapping(value = "/soumettreFormSuppr/{id_param}", method = RequestMethod.GET)
	public String soumettreformulaireSuppr(Model model,@PathVariable("id_param") int idAdmin){
		// appel de la methode getById de service pour chercher l'admin avec l'id recup�r�
		Admin admin=adminService.getAdminById(idAdmin);
		// Appel de la methode delete de service
		adminService.deleteAdmin(admin);
		// raffraichissement de la liste
		List<Admin> listeAdmin = adminService.getAllAdmin();

		model.addAttribute("adminListe", listeAdmin);
		
		return "afficherListe";
	}

	 // M�thode pour afficher le formulaire de suppression
		@RequestMapping(value = "/affichFormmodif", method = RequestMethod.GET)
		public String affichFormModif(ModelMap model,@RequestParam("id_param") int idAdmin ){
			Admin admin=adminService.getAdminById(idAdmin);
			model.addAttribute("adminForm", admin);
			
			return "ajouterAdmin";
		}
	
	
	
	
}
