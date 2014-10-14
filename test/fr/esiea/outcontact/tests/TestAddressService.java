package fr.esiea.outcontact.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fr.esiea.outcontact.model.AddressModel;
import fr.esiea.outcontact.services.AddressService;
import fr.esiea.outcontact.services.ContactService;

public class TestAddressService {

	AddressModel address;
	
	@Before
	public void init() {
		address = new AddressModel("1","avenue des rondes", "75010", "Paris", 3);
	}
	
	@Test
	public void testGetAddressById() {
		AddressModel address = AddressService.getAddressById(1);
		assertTrue(address.getM_addressKey().equals(1));
	}
	
	@Test
	public void testListAddresses() {
		List<AddressModel> lstAddress = AddressService.listAddresses("street");
		assertFalse(lstAddress.isEmpty());
	}
	
	@Test
	public void testCreateAddress() {
		AddressService.createAddress(address, 1, "billing");
		assertTrue(ContactService.getContactById(1).getM_contactBillingAddress().equals(address.getM_addressKey()));
	}
	
	@Test
	public void testDeleteAddress() {
		AddressService.deleteAddress(2);	
		assertNull(AddressService.getAddressById(2));
	}
	
	@Test 
	public void testUpdateAddress() {
		AddressService.updateAddress(1, address);
		assertTrue(AddressService.getAddressById(1).getM_addressStreet().equals(address.getM_addressStreet()));
	}

}
