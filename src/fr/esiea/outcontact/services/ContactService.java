package fr.esiea.outcontact.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import fr.esiea.outcontact.dao.ContactDAO;
import fr.esiea.outcontact.model.AddressModel;
import fr.esiea.outcontact.model.ContactModel;

/**
 * @author david
 * This class is the service which manages actions on contacts
 * All controllers which want to perform actions on contacts need to call this class
 */
public class ContactService {
	
	/**
	 * Return the contact object with this id
	 * @param id
	 * @return ContactModel
	 */
	public static ContactModel getContactById(Integer id) {
		//Return null if user selects an id which is not in hash map 
		if (ContactDAO.getM_contactsMap().containsKey(id)) {
			return ContactDAO.getM_contactsMap().get(id).getM_contactActive() ? ContactDAO.getM_contactsMap().get(id) : null;
		}
		return null;
	}
	
	/**
	 * Create this contact
	 * @param contact
	 */
    public static void createContact(ContactModel contact) {
    	contact.setM_contactActive(true);
    	ContactDAO.addContact(contact); 
    }
    
	/**
	 * Delete the contact with this deleteContactId
	 * @param deleteContactId
	 */
	public static void deleteContact(Integer deleteContactId) {
		ContactDAO.deleteContact(getContactById(deleteContactId));
	}
	
	/**
	 * Update contact informations (with this updateContactId) by this contact informations
	 * @param updateContactId
	 * @param contact
	 */
	public static void updateContactInformations(Integer updateContactId, ContactModel contact) {
		ContactModel oldContact = getContactById(updateContactId);

		//Update contact only if oldContact is different of newContact
		if (oldContact.compareTo(contact) != 0) {
			contact.setM_contactKey(oldContact.getM_contactKey());
			contact.setM_contactActive(oldContact.getM_contactActive());
			contact.setM_contactBillingAddress(oldContact.getM_contactBillingAddress());
			contact.setM_contactDeliveryAdressList(oldContact.getM_contactDeliveryAdressList());
			
			ContactDAO.updateContact(contact);
		}
	}
	
	/**
	 * Return the collection of ContactModel which are active sorted by criteria
	 * @return List<ContactModel>
	 */
	public static List<ContactModel> listContacts(String criteria) {
		List<ContactModel> activeContacts = new ArrayList<ContactModel>();
		
		for (ContactModel contact : ContactDAO.getM_contactsMap().values()) {
			if (contact.getM_contactActive()) {
				activeContacts.add(contact);
			}
		}
		//Sorts list by criteria
		sortListByCriteria(activeContacts, criteria);
		
		return activeContacts;
	}
	
	/**
	 * This private method allows to sort contact list with a specific criteria
	 * @param addresses
	 * @param criteria
	 * @return sorted List<AddressModel>
	 */
	private static List<ContactModel> sortListByCriteria(List<ContactModel> contacts, String criteria) {
		switch (criteria) {
			case "firstName" : 
				Collections.sort(contacts, new Comparator<ContactModel>() {
					public int compare(ContactModel contact1, ContactModel contact2) {
						return contact1.getM_contactFirstName().compareToIgnoreCase(contact2.getM_contactFirstName());
					}
				});
			break;
			case "lastName" :
				Collections.sort(contacts, new Comparator<ContactModel>() {
					public int compare(ContactModel contact1, ContactModel contact2) {
						return contact1.getM_contactLastName().compareToIgnoreCase(contact2.getM_contactLastName());
					}
				});
			break;
			default : break;
		}
		
		return contacts;
	}

	/**
	 * Return the address list of this contact with the specific address type
	 * @param thisContact
	 * @param addressType
	 * @return List<AddressModel>
	 */
	public static List<AddressModel> listAddresses(ContactModel thisContact, String addressType) {
		List<AddressModel> addressList = new ArrayList<AddressModel>();
		
		switch (addressType) {
			case "billing" : 
				AddressModel address = AddressService.getAddressById(thisContact.getM_contactBillingAddress());
				if (address != null) {
					addressList.add(address);
				}
				break;
			case "delivery" : 
				for (Integer addressId : thisContact.getM_contactDeliveryAdressList()) {
					addressList.add(AddressService.getAddressById(addressId));
				}
				break;
			default : break;
		}
		
		return addressList;
	}
	
	/**
	 * Adds the address (with this addressId) in the address list of the contact (with this contactId)
	 * @param contactId
	 * @param addressId
	 * @param addressType
	 */
	public static void addContactAddress(Integer contactId, Integer addressId, String addressType) {
		ContactModel newContact = getContactById(contactId);
		
		switch (addressType) {
			case "billing" : newContact.setM_contactBillingAddress(addressId); break;
			case "delivery" : newContact.getM_contactDeliveryAdressList().add(addressId); break;
			default : break;
		}
		
		ContactDAO.updateContact(newContact);
	}
	
	/**
	 * Deletes the address (with this addressId) in the address list of the contact (with this contactId)
	 * @param contactId
	 * @param addressId
	 * @param addressType
	 */
	public static void deleteContactAddress(Integer contactId, Integer addressId, String type) {
		ContactModel newContact = getContactById(contactId);
		
		if (type.equals("billing") && newContact.getM_contactBillingAddress() == addressId) {
			newContact.setM_contactBillingAddress(null);
		}
		else if (type.equals("delivery") && newContact.getM_contactDeliveryAdressList().contains(addressId)) {
			newContact.getM_contactDeliveryAdressList().remove(addressId);

		}
		
		ContactDAO.updateContact(newContact);
	}
	
	/**
	 * Return the string birth date of this contact
	 * @param contactId
	 * @return String
	 */
	public static String getContactBirthDate(Integer contactId) {
		if (ContactDAO.getM_contactsMap().containsKey(contactId)) {
			return ContactDAO.getM_contactsMap().get(contactId).strBirthDate();
		}
		return null;
	}
}
