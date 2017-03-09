package fr.adaming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Client;

@Controller
@RequestMapping("/client")
public class ClientController {

	// Methode pour afficher le formulaire (son role c'est d'associer le modele
	// au formulaire)

	@RequestMapping(value = "/affichForm", method = RequestMethod.GET)
	public ModelAndView afficherFormulaire() {
		return new ModelAndView("soumettre", "clientForm", new Client());

	}

	// Methode pour soumettre le formulare
	@RequestMapping(value = "/soumettreForm", method = RequestMethod.POST)
	public String soumettreFormulaire(Model model, Client pClient) {

		model.addAttribute("resultNom", pClient.getNom());
		model.addAttribute("resultPrenom", pClient.getPrenom());
		model.addAttribute("resultAge", pClient.getAge());
		model.addAttribute("resultMail", pClient.getMail());

		return "resultat";
	}

}
