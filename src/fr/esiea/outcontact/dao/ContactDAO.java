package fr.esiea.outcontact.dao;

import java.util.HashMap;
import fr.esiea.outcontact.model.ContactModel;

public interface ContactDAO {

	void addContact(ContactModel contact);
	boolean deleteContact(ContactModel contact);
	boolean updateContact(ContactModel contact);
	HashMap<String, String> mapConverter();
	
}
