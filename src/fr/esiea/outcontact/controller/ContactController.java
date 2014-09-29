package fr.esiea.outcontact.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.esiea.outcontact.model.ContactModel;
import fr.esiea.outcontact.services.ContactService;
import fr.esiea.outcontact.validator.ContactValidator;

@Controller
public class ContactController {
	
	@InitBinder
	public void initBinder(WebDataBinder binder) 
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
    
    @RequestMapping(value = "/createContact", method = RequestMethod.GET)
    public String initContactForm
    (
    	@ModelAttribute("contact") ContactModel contact,
    	Model model
    ) 
    {
    	model.addAttribute("contact", contact);
    	return "createContact";
    }
    
    @RequestMapping(value = "/createContact", method = RequestMethod.POST)
	public ModelAndView createContact
	(
		Model model, 
		@ModelAttribute("contact") ContactModel contact,
		BindingResult result
	) 
    {
    	Map<String, Object> resultModel = new HashMap<String, Object>();
    	
    	ContactValidator validator = new ContactValidator();
    	validator.validate(contact, result);
        
    	String resultJsp = "index";
    	
    	if (result.hasErrors()) {
    		resultJsp = "createContact";
    	} else {
    		ContactService.createContact(contact);
    		resultModel.put("contactList", ContactService.contactList());
    	}
    	return new ModelAndView(resultJsp, resultModel);
    }
}