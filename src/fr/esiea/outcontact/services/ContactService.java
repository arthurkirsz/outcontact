package fr.esiea.outcontact.services;

import java.util.ArrayList;
import java.util.Collection;

import fr.esiea.outcontact.dao.ContactDAO;
import fr.esiea.outcontact.model.ContactModel;

public class ContactService {
	
	public static ContactModel getContactById(Integer id) {
		//Return null if user selects an id which is not in hash map 
		if (ContactDAO.getM_contactsMap().containsKey(id)) {
			return ContactDAO.getM_contactsMap().get(id).getM_contactActive() ? ContactDAO.getM_contactsMap().get(id) : null;
		}
		return null;
	}
	
	/**
	 * Return the collection of ContactModel which are active
	 * @return list of active contacts
	 */
	public static Collection<ContactModel> contactList() {
		Collection<ContactModel> activeContacts = new ArrayList<ContactModel>();
		for (ContactModel contact : ContactDAO.getM_contactsMap().values()) {
			if (contact.getM_contactActive()) {
				activeContacts.add(contact);
			}
		}
		
		return activeContacts;
	}
    
    public static void createContact(ContactModel contact) {
    	contact.setM_contactActive(true);
    	ContactDAO.addContact(contact); 
    }
}
