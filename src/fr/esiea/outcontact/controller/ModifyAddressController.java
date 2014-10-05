package fr.esiea.outcontact.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.esiea.outcontact.model.AddressModel;
import fr.esiea.outcontact.services.AddressService;
import fr.esiea.outcontact.validator.AddressValidator;

/**
 * @author david
 * This controller is linked to the modifyAddress page which manage address modification
 */
@Controller
public class ModifyAddressController {

	/**
     * Return the modifyAddress page when it calls by GET method
     * @param address
     * @param addressId
     * @return ModelAndView
     */
    @RequestMapping(value = "/modifyAddress", method = RequestMethod.GET)
    public ModelAndView initModifyAddressForm
    (
    	@ModelAttribute("addressModel") AddressModel address,
    	@RequestParam(value="address", required=true) Integer addressId
    ) 
    {
    	Map<String, Object> model = new HashMap<String, Object>();
    	
    	model.put("selectedAddress", AddressService.getAddressById(addressId));
    	
    	return new ModelAndView("modifyAddress", model);
    }
    
    /**
     * This method is called when the modifyAddress form is submitted by POST method
     * It allows to modify an existing address and return to the index page
     * @param address
     * @param addressId
     * @param result
     * @return ModelAndView
     */
    @RequestMapping(value = "/modifyAddress", method = RequestMethod.POST)
	public ModelAndView modifyContact
	(
		@ModelAttribute("addressModel") AddressModel adress,
		@RequestParam(value="address", required=true) Integer addressId,
		BindingResult result
	) 
    {
    	Map<String, Object> model = new HashMap<String, Object>();
    	
    	AddressValidator validator = new AddressValidator();
    	validator.validate(adress, result);
        
    	String resultJsp = "index";
    	
    	if (result.hasErrors()) {
    		resultJsp = "modifyAddress";
    	} else {
    		if (addressId != null) {
    			AddressService.updateAddress(addressId, adress);
    		}
    		
    		model.put("addressList", AddressService.listAddresses("street"));
    	}
    	return new ModelAndView(resultJsp, model);
    }
}
