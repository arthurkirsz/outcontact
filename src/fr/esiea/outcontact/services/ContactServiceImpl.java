package fr.esiea.outcontact.services;

import java.util.HashMap;

import com.google.appengine.labs.repackaged.org.json.JSONObject;

import fr.esiea.outcontact.dao.ContactDAOImpl;
import fr.esiea.outcontact.dao.JsonManager;
import fr.esiea.outcontact.model.ContactModel;

public class ContactServiceImpl implements ContactService {

	private ContactDAOImpl contactDao;
	
    public ContactServiceImpl() {
		contactDao = new ContactDAOImpl();
	}

	public JSONObject listContact() {
    	JSONObject contactList = null;
    	
    	HashMap<String, String> convertedMap = contactDao.mapConverter();
    	if (!convertedMap.isEmpty()) {
    		contactList = JsonManager.hashMapToJson(convertedMap);
    	}
    	
    	return contactList;
    }
    
    public void createContact(ContactModel contact) {
    	contact.setM_contactActive(true);
    	contactDao.addContact(contact); 
    }
}
