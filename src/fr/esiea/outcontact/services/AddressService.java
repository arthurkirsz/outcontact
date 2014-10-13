package fr.esiea.outcontact.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import fr.esiea.outcontact.dao.AddressDAO;
import fr.esiea.outcontact.model.AddressModel;

/**
 * @author david
 * This class is the service which manages actions on addresses
 * All controllers which want to perform actions on addresses need to call this class
 */
public class AddressService {

	/**
	 * Return the address object with this id
	 * @param id
	 * @return AddressModel
	 */
	public static AddressModel getAddressById(Integer id) {
		//Return null if user selects an id which is not in hash map 
		if (AddressDAO.getM_addressesMap().containsKey(id)) {
			return AddressDAO.getM_addressesMap().get(id);
		}
		return null;
	}

	/**
	 * Return the collection of AddressModel which are sorted by criteria
	 * @return list of addresses
	 */
	public static List<AddressModel> listAddresses(String criteria) {
		List<AddressModel> addresses = new ArrayList<AddressModel>();
		
		for (AddressModel address : AddressDAO.getM_addressesMap().values()) {
			addresses.add(address);
		}
		//Sorts list by criteria
		sortListByCriteria(addresses, criteria);
		
		return addresses;
	}
	
	/**
	 * This private method allows to sort address list with a specific criteria
	 * @param addresses
	 * @param criteria
	 * @return List<AddressModel>
	 */
	private static List<AddressModel> sortListByCriteria(List<AddressModel> addresses, String criteria) {
		switch (criteria) {
			case "number" : 
				Collections.sort(addresses, new Comparator<AddressModel>() {
					public int compare(AddressModel address1, AddressModel address2) {
						return address1.getM_addressNumber().compareToIgnoreCase(address2.getM_addressNumber());
					}
				});
			break;
			case "street" :
				Collections.sort(addresses, new Comparator<AddressModel>() {
					public int compare(AddressModel address1, AddressModel address2) {
						return address1.getM_addressStreet().compareToIgnoreCase(address2.getM_addressStreet());
					}
				});
			break;
			default : break;
		}
		
		return addresses;
	}
	
	/**
	 * This method allows to create this address 
	 * and links (or not) this address with the contact with this contactId
	 * Return this address id
	 * @param address
	 * @param contactId
	 * @return int
	 */
	public static int createAddress(AddressModel address, Integer contactId, String addressType) {
		Integer addressId = AddressDAO.createAddress(address);
		
		//If user wants to create an address for a contact
		if (contactId != null && addressType != null) {
			ContactService.addContactAddress(contactId, address.getM_addressKey(), addressType);
		}
		
		return addressId;
	}

	/**
	 * Delete the address with this deleteAddressId
	 * @param deleteAddressId
	 */
	public static void deleteAddress(Integer deleteAddressId) {
		AddressDAO.deleteAddress(getAddressById(deleteAddressId));
	}
	
	/**
	 * Replace the address (with this updateAddressId) by this address 
	 * @param updateAddressId
	 * @param address
	 */
	public static void updateAddress(Integer updateAddressId, AddressModel address) {
		AddressModel oldAddress = getAddressById(updateAddressId);
		
		//Update address only if oldAddress is different of newAddress
		if (oldAddress.compareTo(address) != 0) {
			address.setM_addressKey(oldAddress.getM_addressKey());
			AddressDAO.updateAddress(address);
		}
	}
}
