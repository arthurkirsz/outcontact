package fr.esiea.outcontact.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.esiea.outcontact.model.AddressModel;
import fr.esiea.outcontact.model.ContactModel;
import fr.esiea.outcontact.services.AddressService;
import fr.esiea.outcontact.services.ContactService;
import fr.esiea.outcontact.validator.AddressValidator;

/**
 * @author david
 * This controller is linked to the newContactAddress page 
 * which manage the adding of a new address for a contact
 */
@Controller
public class NewContactAddressController {
	
    /**
     * Return the same page when it calls by GET method
     * This method is mapped with the createAddress page
     * @param contactId
     * @param addressType
     * @param address
     * @return ModelAndView
     */
    @RequestMapping(value = "/newContactAddress", method = RequestMethod.GET)
    public ModelAndView initAddressForm
    (
    	@RequestParam(value="contact", required=true) Integer contactId,
    	@RequestParam(value="type", required=true) String addressType,
    	@ModelAttribute("addressModel") AddressModel address
    ) 
    {
    	Map<String, Object> model = new HashMap<String, Object>();
    	
    	model.put("contactId", contactId);
    	model.put("addressType", addressType);
    	
    	switch (addressType) {
    		case "billing" : model.put("strTitle", "contactAddressForm.billingAddressTitle"); break;
    		case "delivery" : model.put("strTitle", "contactAddressForm.deliveryAddressTitle"); break;
    		default : break;
    	}
    	
    	return new ModelAndView("newContactAddress", model);
    }
    
    /**
     * This method is called when the form is submitted by POST method
     * It allows to create a new address for this contact
     * @param contactId
     * @param addressType
     * @param address
     * @param result
     * @return ModelAndView
     */
    @RequestMapping(value = "/newContactAddress", method = RequestMethod.POST)
	public ModelAndView createAddress
	(
		@RequestParam(value="contact", required=true) Integer contactId,
		@RequestParam(value="type", required=true) String addressType,
		@ModelAttribute("addressModel") AddressModel address,
		BindingResult result
	) 
    {
    	Map<String, Object> model = new HashMap<String, Object>();
    	
    	model.put("contactId", contactId);
    	model.put("addressType", addressType);
    	
    	switch (addressType) {
    		case "billing" : model.put("strTitle", "contactAddressForm.billingAddressTitle"); break;
    		case "delivery" : model.put("strTitle", "contactAddressForm.deliveryAddressTitle"); break;
    		default : break;
    	}
    	
    	AddressValidator validator = new AddressValidator();
    	validator.validate(address, result);
    	
    	String resultJsp = "index";
    	
    	if (result.hasErrors()) {
    		resultJsp = "newContactAddress";
    	} 
    	else {
    		AddressService.createAddress(address, contactId, addressType);    	
    		model.put("contactList", ContactService.listContacts("firstName"));
        		
            ContactModel thisContact = ContactService.getContactById(contactId);
                	
            if (thisContact != null) {
            	model.put("selectedContact", thisContact);
            	List<AddressModel> contactBillingAddressList = ContactService.listAddresses(thisContact, "billing");
            	if (!contactBillingAddressList.isEmpty() && !contactBillingAddressList.contains(null)) {
            		//Don't show the addBillingAddress button if the user had a billing address 
            		model.put("billingAddressContact", contactBillingAddressList);
            		model.put("btnAddBillingAddressVisible", "visibility: hidden");
            	}
                model.put("deliveryAddressListContact", ContactService.listAddresses(thisContact, "delivery"));
            }
    	}
    	return new ModelAndView(resultJsp, model);
    }
}
