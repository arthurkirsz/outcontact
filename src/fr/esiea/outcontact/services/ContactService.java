package fr.esiea.outcontact.services;

import com.google.appengine.labs.repackaged.org.json.JSONObject;

import fr.esiea.outcontact.model.ContactModel;

public interface ContactService {

	JSONObject listContact();
	void createContact(ContactModel contact);
}
