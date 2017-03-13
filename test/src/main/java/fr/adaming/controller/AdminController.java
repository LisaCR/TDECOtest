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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	@RequestMapping(value = "/accueilAdmin", method = RequestMethod.GET)
	public String accueil(ModelMap model) {
		model.addAttribute("nomApp", "APPLICATION DE GESTION DES ADMINS");
		model.addAttribute("salutation", "Avec SPRING MVC");
		return "accueilAdmin";
	}
	
	/**
	 * retour vers accueil général
	 */
	@RequestMapping(value = "/accueilGeneral", method = RequestMethod.GET)
	public String accueilGeneral(ModelMap model) {
		model.addAttribute("nomApp", "Magasin");
		model.addAttribute("salutation", "Avec SPRING MVC");
		return "index";
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
	@RequestMapping(value = "/admin/{id}/update", method = RequestMethod.GET)
	public String showUpdateUserForm(@PathVariable("id") int id, Model model) {


		Admin admin = adminService.getAdminById(id);
		model.addAttribute("adminForm", admin);

		// rafraichissement de la liste
		List<Admin> listeAdmin = adminService.getAllAdmin();

		model.addAttribute("adminListe", listeAdmin);

		return "adminForm";
	}


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

				else{
					/**
					 * appel de la méthode update du service
					 */
					adminService.updateAdmin(admin);
				}
		// rafraichissement de la liste
		List<Admin> listeAdmin = adminService.getAllAdmin();

		model.addAttribute("adminListe", listeAdmin);

		return "afficherListe";
	}


	/**
	 * suppression admin
	 */
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String deleteAdmin(Model model, @PathVariable("id") long id) {


		Admin admin = adminService.getAdminById(id);

		adminService.deleteAdmin(admin);

		/**
		 * rafraichissement de la liste et affichage d'un message d'alerte
		 */
		List<Admin> listeAdmin = adminService.getAllAdmin();

		model.addAttribute("adminListe", listeAdmin);
		model.addAttribute("css", "success");
		model.addAttribute("msg", "Admin is deleted!");


		return "afficherListe";

	}





}
