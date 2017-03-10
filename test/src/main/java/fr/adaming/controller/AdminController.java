package fr.adaming.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	 * get ou post ou formméthodes 
	 */
	// Methode pour soummettre le formulaire d'ajout et lui attribuer le modele
//	@RequestMapping(value = "/soumettreFormAjout", method = RequestMethod.POST)
//	public String soumettreFormAjout(Model model, @Valid @ModelAttribute("adminForm") Admin admin,BindingResult resultaValidation ) {
//		if(resultaValidation.hasErrors()){
//			return "ajouter";
//		}
//		if(admin.getId()==0){
//		// appel de la methode ajouter du service
//		adminService.addAdmin(admin);
//		}else{
//			adminService.updateAdmin(admin);
//		}
//		// raffraissiment de la liste
//		List<Admin> listeEmp = adminService.getAllAdmin();
//
//		model.addAttribute("adminListe", listeAdmin);
//
//		return "afichListe";
//	}
	
}
