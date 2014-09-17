package fr.esiea.outcontact.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.esiea.outcontact.model.ContactModel;
import fr.esiea.outcontact.services.ContactServiceImpl;
import fr.esiea.outcontact.validator.ContactValidator;

@Controller
public class ContactController {
	
	private ContactServiceImpl contactService;

    @RequestMapping(value = "/")
    public String initIndexForm() 
    {
    	return "index";
    }
    
    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String initContactForm
    (
    	@ModelAttribute("contact") ContactModel contact,
    	Model model
    ) 
    {
    	contactService = new ContactServiceImpl();
    	model.addAttribute("contact", contact);
    	return "contact";
    }
    
    @RequestMapping(value = "/contact", method = RequestMethod.POST)
	public String createContact
	(
		Model model, 
		@ModelAttribute("contact") ContactModel contact,
		BindingResult result
	) 
    {
    	ContactValidator validator = new ContactValidator();
    	validator.validate(contact, result);
    	
    	String resultJsp = "index";
    	
    	if (result.hasErrors()) {
    		resultJsp = "contact";
    	} else {
    		//Add contact in the HashMap
    		contactService.createContact(contact); 
    	}
    	return resultJsp;
    }
}