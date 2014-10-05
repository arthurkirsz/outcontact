package fr.esiea.outcontact.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import fr.esiea.outcontact.model.AddressModel;
import fr.esiea.outcontact.services.AddressService;
import fr.esiea.outcontact.validator.AddressValidator;

/**
 * @author david
 * This controller is linked to the createAddress page which manage the address creation
 */
@Controller
public class CreateAddressController {
    
    /**
     * Return the createAddress page when it calls by GET method
     * @param address
     * @return String
     */
    @RequestMapping(value = "/createAddress", method = RequestMethod.GET)
    public String initAddressForm
    (
    	@ModelAttribute("addressModel") AddressModel address
    ) 
    {    	
    	return "createAddress";
    }
    
    /**
     * This method is called when the form is submitted by POST method
     * It allows to create an address and return to the index page
     * @param address
     * @param result
     * @return ModelAndView
     */
    @RequestMapping(value = "/createAddress", method = RequestMethod.POST)
	public ModelAndView createAddress
	(
		@ModelAttribute("addressModel") AddressModel address,
		BindingResult result
	) 
    {
    	Map<String, Object> model = new HashMap<String, Object>();
    	
    	AddressValidator validator = new AddressValidator();
    	validator.validate(address, result);
    	
    	String resultJsp = "index";
    	
    	if (result.hasErrors()) {
    		resultJsp = "createAddress";
    	} 
    	else {
    		AddressService.createAddress(address, null, null);    	
    		model.put("addressList", AddressService.listAddresses("street"));	
    	}
    	return new ModelAndView(resultJsp, model);
    }
}
