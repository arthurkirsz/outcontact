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

import fr.esiea.outcontact.model.AddressFormModel;
import fr.esiea.outcontact.model.AddressModel;
import fr.esiea.outcontact.model.ContactModel;
import fr.esiea.outcontact.services.AddressService;
import fr.esiea.outcontact.services.ContactService;

/**
 * @author david
 * This controller is linked to the existingContactAddress page 
 * which manage the adding of an existing address for a contact
 */
@Controller
public class ExistingContactAddressController {

    /**
     * Return the existingContactAddress page when it calls by GET method
     * Print addresses list and dynamic title
     * @param contactId
     * @param addressType
     * @param addressForm
     * @return ModelAndView
     */
    @RequestMapping(value = "/existingContactAddress", method = RequestMethod.GET)
    public ModelAndView initAddressForm
    (
    	@RequestParam(value="contact", required=true) Integer contactId,
    	@RequestParam(value="type", required=true) String addressType,
    	@ModelAttribute("addressForm") AddressFormModel addressForm
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
    	
    	model.put("addressList", AddressService.listAddresses("street"));
    	
    	return new ModelAndView("existingContactAddress", model);
    }
    
    /**
     * This method is called when the existingContactAddress form is submitted by POST method
     * It allows to add an existing address to this contact and return to the index page
     * @param contactId
     * @param addressType
     * @param addressForm
     * @param result
     * @return ModelAndView
     */
    @RequestMapping(value = "/existingContactAddress", method = RequestMethod.POST)
	public ModelAndView selectExisitngAddress
	(
		@RequestParam(value="contact", required=true) Integer contactId,
		@RequestParam(value="type", required=true) String addressType,
		@ModelAttribute("addressForm") AddressFormModel addressForm,
		BindingResult result
	) 
    {
    	Map<String, Object> model = new HashMap<String, Object>();
		
    	ContactService.addContactAddress(contactId, addressForm.getM_addressKey(), addressType);
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
        
    	String resultJsp = "index";

    	return new ModelAndView(resultJsp, model);
    }
}
