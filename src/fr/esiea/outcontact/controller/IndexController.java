package fr.esiea.outcontact.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.esiea.outcontact.model.AddressModel;
import fr.esiea.outcontact.model.ContactModel;
import fr.esiea.outcontact.services.AddressService;
import fr.esiea.outcontact.services.ContactService;

/**
 * @author david
 * This controller is linked to the index page
 */
@Controller
@RequestMapping(value = "/")
public class IndexController {

    /**
     * Return the index page when it calls by GET method
     * If a contact/address is selected, return the index page with the contact/address informations
     * @param contactId
     * @param deleteContact
     * @param addressId
     * @param deleteAddress
     * @param addressType
     * @param printedList
     * @return ModelAndView
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView initIndexForm
    (
    	@RequestParam(value="contact", required=false) Integer contactId,
    	@RequestParam(value="deleteContact", required=false) Integer deleteContact,
    	@RequestParam(value="address", required=false) Integer addressId,
    	@RequestParam(value="deleteAddress", required=false) Integer deleteAddress,
    	@RequestParam(value="type", required=false) String addressType,
    	@RequestParam(value="list", required=false) String printedList
    ) 
    {
    	Map<String, Object> model = new HashMap<String, Object>();
    	
		// If user wants to delete an address for this contact
		if (contactId != null && deleteAddress != null && addressType != null) {
			ContactService.deleteContactAddress(contactId, deleteAddress, addressType);
		}
		
		if (contactId != null) {
			ContactModel thisContact = ContactService.getContactById(contactId);

			if (thisContact != null) {
				model.put("selectedContact", thisContact);
				List<AddressModel> contactBillingAddressList = ContactService.listAddresses(thisContact, "billing");
				if (!contactBillingAddressList.isEmpty() && !contactBillingAddressList.contains(null)) {
					// Don't show the addBillingAddress button if the user had a
					// billing address
					model.put("billingAddressContact", contactBillingAddressList);
					model.put("btnAddBillingAddressVisible", "visibility: hidden");
				}
				model.put("deliveryAddressListContact", ContactService.listAddresses(thisContact, "delivery"));
			}
		}
		// If user wants to delete selected contact
		else if (deleteContact != null) {
			ContactService.deleteContact(deleteContact);
		}
		// If user selects an address
		else if (addressId != null) {
			AddressModel thisAddress = AddressService.getAddressById(addressId);

			if (thisAddress != null) {
				model.put("selectedAddress", thisAddress);
			}
			// Just to print address list
			printedList = "address";
		}
		// If user wants to delete selected address
		else if (deleteAddress != null) {
			AddressService.deleteAddress(deleteAddress);
			// Just to print address list
			printedList = "address";
		}
        
        //Print list items
        if (printedList != null) {
            if (printedList.equals("address")) {
            	model.put("addressList", AddressService.listAddresses("street"));
            }
        }
        else {
        	model.put("contactList", ContactService.listContacts("firstName"));
        }
        
    	return new ModelAndView("index", model);
    }
}
