package fr.esiea.outcontact.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import fr.esiea.outcontact.model.ContactModel;

/**
 * @author david
 * This class manages accessing contacts data
 */
public class ContactDAO {

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
		
		ContactModel contact1 = new ContactModel("Dupont","Jean", "j.dupont@wanadoo.fr", date1, true, 1);
		contact1.getM_contactDeliveryAdressList().add(1);
		
		m_contactsMap.put(1, contact1);
		m_contactsMap.put(2, new ContactModel("Ambroise","Marine", "m.ambroise@gmail.com", date2, true, 2));	
	}
	
	/**
	 * Add this contact in the contacts map
	 * @param contact
	 */
	public static void addContact(ContactModel contact) {
		contact.setM_contactKey(m_contactKey++);
		m_contactsMap.put(contact.getM_contactKey(), contact);
	}
	
	/**
	 * Delete this contact in the contacts map
	 * @param contact
	 */
	public static void deleteContact(ContactModel contact) {
		if (m_contactsMap.containsKey(contact.getM_contactKey())) {
			m_contactsMap.remove(contact.getM_contactKey());
			contact.setM_contactActive(false);
			m_contactsMap.put(contact.getM_contactKey(), contact);
		}
	}
	
	/**
	 * Update this contact in contacts map 
	 * @param oldContact
	 * @param newContact
	 */
	public static void updateContact(ContactModel newContact) {
		if (m_contactsMap.containsKey(newContact.getM_contactKey())) {
			m_contactsMap.remove(newContact.getM_contactKey());
			m_contactsMap.put(newContact.getM_contactKey(), newContact);
		}
	}

	/**
	 * Getter on contacts hash map
	 * @return HashMap<Integer, ContactModel> contacts map
	 */
	public static HashMap<Integer, ContactModel> getM_contactsMap() {
		return m_contactsMap;
	}
	
}
