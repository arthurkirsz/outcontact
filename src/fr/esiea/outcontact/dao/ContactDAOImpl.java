package fr.esiea.outcontact.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import fr.esiea.outcontact.model.ContactModel;

public class ContactDAOImpl implements ContactDAO {

	private static HashMap<Integer, ContactModel> m_contactsMap = new HashMap<Integer, ContactModel>();
	private static Integer m_contactKey = 3;
	
	static {
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date1 = new Date();
		Date date2 = new Date();
		try {
			date1 = formatter.parse("20/02/1988");
			date2 = formatter.parse("02/10/1992");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		m_contactsMap.put(1, new ContactModel("Dupont","Jean", "j.dupont@wanadoo.fr", date1, true, 1));
		m_contactsMap.put(2, new ContactModel("Dupont","Marine", "m.dupont@gmail.com", date2, true, 2));	
	}
	
	@Override
	public void addContact(ContactModel contact) {
		contact.setM_contactKey(m_contactKey++);
		m_contactsMap.put(contact.getM_contactKey(), contact);
	}
	
	@Override
	public boolean deleteContact(ContactModel contact) {
		if (m_contactsMap.containsValue(contact)) {
			m_contactsMap.remove(contact.getM_contactKey());
		}
		else {
			return false;
		}
		return true;
	}
	
	@Override
	public boolean updateContact(ContactModel contact) {
		if (m_contactsMap.containsValue(contact)) {
			m_contactsMap.remove(contact.getM_contactKey());
			m_contactsMap.put(contact.getM_contactKey(), contact);
		}
		else {
			return false;
		}
		return true;
	}

	@Override
	public HashMap<String, String> mapConverter() {
		HashMap<String, String> convertedMap = new HashMap<String, String>();
	    Iterator<Entry<Integer, ContactModel>> itMap = m_contactsMap.entrySet().iterator();
	    while (itMap.hasNext()) {
	    	Map.Entry<Integer, ContactModel> pairs = (Map.Entry<Integer, ContactModel>)itMap.next();
	    	convertedMap.put(pairs.getKey().toString(), pairs.getValue().toString());
	    }
		
		return convertedMap;
	}
}
