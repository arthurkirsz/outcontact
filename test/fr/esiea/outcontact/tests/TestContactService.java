package fr.esiea.outcontact.tests;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fr.esiea.outcontact.model.AddressModel;
import fr.esiea.outcontact.model.ContactModel;
import fr.esiea.outcontact.services.ContactService;

public class TestContactService {
	
	ContactModel contact;
	
	@Before
	public void init() {
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date1 = new Date();
		try {
			date1 = formatter.parse("20/02/1988");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		contact = new ContactModel("Dupont","Nicole", "n.dupont@wanadoo.fr", date1, true, 3);
	}

	@Test
	public void testGetContactById() {
		ContactModel contact = ContactService.getContactById(1);
		assertTrue(contact.getM_contactKey().equals(1));
	}
	
	@Test
	public void testCreateContact() {
		ContactService.createContact(contact);
		assertTrue(ContactService.getContactById(3).getM_contactFirstName().equals(contact.getM_contactFirstName()));
	}
	
	@Test
	public void testDeleteContact() {
		ContactService.deleteContact(2);
		assertNull(ContactService.getContactById(2));
	}
	
	@Test
	public void testUpdateContactInformations() {
		ContactService.updateContactInformations(1, contact);
		assertTrue(ContactService.getContactById(1).getM_contactFirstName().equals(contact.getM_contactFirstName()));
	}
	
	@Test
	public void testListContacts() {
		List<ContactModel> lstContact = ContactService.listContacts("firstName");
		assertFalse(lstContact.isEmpty());
	}
	
	@Test 
	public void testListAddresses() {
		ContactModel thisContact = ContactService.getContactById(1);
		List<AddressModel> lstAddress = ContactService.listAddresses(thisContact, "delivery");
		assertFalse(lstAddress.isEmpty());
	}
	
	@Test
	public void testAddContactAddress() {
		ContactService.addContactAddress(1, 1, "billing");
		assertTrue(ContactService.getContactById(1).getM_contactBillingAddress().equals(1));
	}
	
	@Test
	public void testDeleteContactAddress() {
		ContactService.deleteContactAddress(1, 1, "delivery");
		assertFalse(ContactService.getContactById(1).getM_contactDeliveryAdressList().contains(1));
	}
	
	@Test
	public void testGetContactBirthDate() {
		String birthDate = ContactService.getContactBirthDate(1);
		assertTrue(birthDate.equals("1988-02-20"));
	}

}
