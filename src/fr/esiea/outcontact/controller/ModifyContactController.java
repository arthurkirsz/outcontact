package fr.esiea.outcontact.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.esiea.outcontact.model.ContactModel;
import fr.esiea.outcontact.services.ContactService;
import fr.esiea.outcontact.validator.ContactValidator;

/**
 * @author david
 * This controller is linked to the modifyContact page which manage contact modification
 */
@Controller
public class ModifyContactController {
	
	/**
	 * This method allows to format contact birth date information
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) 
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
    
    /**
     * Return the modifyContact page when it calls by GET method
     * @param contact
     * @param contactId
     * @return ModelAndView
     */
    @RequestMapping(value = "/modifyContact", method = RequestMethod.GET)
    public ModelAndView initModifyContactForm
    (
    	@ModelAttribute("contactModel") ContactModel contact,
    	@RequestParam(value="contact", required=true) Integer contactId
    ) 
    {
    	Map<String, Object> model = new HashMap<String, Object>();
    	
    	model.put("selectedContact", ContactService.getContactById(contactId));
    	model.put("selectedContactBirthDate", ContactService.getContactBirthDate(contactId));
    	
    	return new ModelAndView("modifyContact", model);
    }
    
    /**
     * This method is called when the modifyContact form is submitted by POST method
     * It allows to modify an existing contact and return to the index page
     * @param contact
     * @param contactId
     * @param result
     * @return ModelAndView
     */
    @RequestMapping(value = "/modifyContact", method = RequestMethod.POST)
	public ModelAndView modifyContact
	(
		@ModelAttribute("contactModel") ContactModel contact,
		@RequestParam(value="contact", required=true) Integer contactId,
		BindingResult result
	) 
    {
    	Map<String, Object> resultModel = new HashMap<String, Object>();
    	
    	ContactValidator validator = new ContactValidator();
    	validator.validate(contact, result);
        
    	String resultJsp = "index";
    	
    	if (result.hasErrors()) {
    		resultJsp = "modifyContact";
    	} else {
    		if (contactId != null) {
    			ContactService.updateContactInformations(contactId, contact);
    		}
    		
    		resultModel.put("contactList", ContactService.listContacts("firstName"));
    	}
    	return new ModelAndView(resultJsp, resultModel);
    }
}