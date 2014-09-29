package fr.esiea.outcontact.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.esiea.outcontact.model.AddressModel;
import fr.esiea.outcontact.services.AddressService;
import fr.esiea.outcontact.services.ContactService;
import fr.esiea.outcontact.validator.AddressValidator;

@Controller
public class AddressController {
    
    @RequestMapping(value = "/createAddress", method = RequestMethod.GET)
    public String initAddressForm
    (
    	@ModelAttribute("address") AddressModel address,
    	Model model
    ) 
    {
    	model.addAttribute("address", address);
    	return "createAddress";
    }
    
    @RequestMapping(value = "/createAddress", method = RequestMethod.POST)
	public ModelAndView createAddress
	(
		Model model, 
		@ModelAttribute("address") AddressModel address,
		BindingResult result
	) 
    {
    	Map<String, Object> resultModel = new HashMap<String, Object>();
    	
    	AddressValidator validator = new AddressValidator();
    	validator.validate(address, result);
    	
    	String resultJsp = "index";
    	
    	if (result.hasErrors()) {
    		resultJsp = "createAddress";
    	} else {
    		AddressService.createAddress(address); 
    		resultModel.put("contactList", ContactService.contactList());
    	}
    	return new ModelAndView(resultJsp, resultModel);
    }
}
