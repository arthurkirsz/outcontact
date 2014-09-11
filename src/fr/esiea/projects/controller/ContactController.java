package fr.esiea.projects.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
@RequestMapping("/contact")
public class ContactController {
 
	//DI via Spring
	//String message;
 
	//@RequestMapping(value="/{name}", method = RequestMethod.GET)
	@RequestMapping(method = RequestMethod.GET)
	//public String getContact(@PathVariable String name, ModelMap model) {
	public String getContact(ModelMap model) {
		//model.addAttribute("contact", name);
		//model.addAttribute("message", this.message);
 
		//return to jsp page, configured in mvc-dispatcher-servlet.xml, view resolver
		return "contact";
 
	}
 
	//public void setMessage(String message) {
	//	this.message = message;
	//}
 
}