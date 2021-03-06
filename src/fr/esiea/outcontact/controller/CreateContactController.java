package fr.esiea.outcontact.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.esiea.outcontact.model.AddressModel;
import fr.esiea.outcontact.model.ContactModel;
import fr.esiea.outcontact.services.ContactService;
import fr.esiea.outcontact.validator.ContactValidator;

/**
 * @author david
 * This controller is linked to the createContact page which manage contact creation
 */
@Controller
public class CreateContactController {
	
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
     * Return the createContact page when it calls by GET method
     * @param contact
     * @return String
     */
    @RequestMapping(value = "/createContact", method = RequestMethod.GET)
    public String initCreateContactForm
    (
    	@ModelAttribute("contactModel") ContactModel contact
    ) 
    {
    	return "createContact";
    }
    
    /**
     * This method is called when the modifyContact form is submitted by POST method
     * It allows to create a new contact and return to the index page
     * @param contact
     * @param result
     * @return ModelAndView
     */
    @RequestMapping(value = "/createContact", method = RequestMethod.POST)
	public ModelAndView createContact
	(
		@ModelAttribute("contactModel") ContactModel contact,
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
    		Integer contactId = ContactService.createContact(contact);
    		resultModel.put("contactList", ContactService.listContacts("firstName"));
    		
    		ContactModel thisContact = ContactService.getContactById(contactId);
        	
            if (thisContact != null) {
            	resultModel.put("selectedContact", thisContact);
            	List<AddressModel> contactBillingAddressList = ContactService.listAddresses(thisContact, "billing");
            	if (!contactBillingAddressList.isEmpty() && !contactBillingAddressList.contains(null)) {
            		//Don't show the addBillingAddress button if the user had a billing address 
            		resultModel.put("billingAddressContact", contactBillingAddressList);
            		resultModel.put("btnAddBillingAddressVisible", "visibility: hidden");
            	}
            	resultModel.put("deliveryAddressListContact", ContactService.listAddresses(thisContact, "delivery"));
            }
    	}
    	return new ModelAndView(resultJsp, resultModel);
    }
}