package fr.esiea.outcontact.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.esiea.outcontact.model.ContactModel;
import fr.esiea.outcontact.services.ContactService;

@Controller
@RequestMapping(value = "/")
public class IndexController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView initIndexForm(@RequestParam(value="id", required=false) Integer id) 
    {
    	Map<String, Object> model = new HashMap<String, Object>();
        model.put("contactList", ContactService.contactList());
    	
        if (id != null) {
        	ContactModel thisContact = ContactService.getContactById(id);
        	model.put("selectedContact", (thisContact != null ? thisContact : new ContactModel()));
    	}
    	return new ModelAndView("index", model);
    }
}
