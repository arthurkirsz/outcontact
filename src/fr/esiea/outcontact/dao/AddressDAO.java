package fr.esiea.outcontact.dao;
import java.util.HashMap;

import fr.esiea.outcontact.model.AddressModel;
import fr.esiea.outcontact.model.ContactModel;

/**
 * @author david
 * This class manages accessing addresses data
 */
public class AddressDAO {
	
	private static HashMap<Integer, AddressModel> m_addressesMap = new HashMap<Integer, AddressModel>();
	private static Integer m_addressKey = 3;
	
	static {
		m_addressesMap.put(1, new AddressModel("1","avenue la ronde", "75010", "Paris", 1));
		m_addressesMap.put(2, new AddressModel("256","rue du général leclerc", "75014", "Paris", 2));	
	}

	/**
	 * Create this address in the hash map
	 * @param address
	 */
	public static void createAddress(AddressModel address) {
		address.setM_addressKey(m_addressKey++);
		m_addressesMap.put(address.getM_addressKey(), address);
	}

	/**
	 * Delete this address in the hash map and delete all references in contacts' address list
	 * @param address
	 * @return true if deletion is success, else false
	 */
	public static void deleteAddress(AddressModel address) {
		if (m_addressesMap.containsKey(address.getM_addressKey())) {
			//Remove address element in the address map
			m_addressesMap.remove(address.getM_addressKey());
			//Remove address element in each contact's address list
			for (ContactModel contact : ContactDAO.getM_contactsMap().values()) {
				if (contact.getM_contactDeliveryAdressList().contains(address.getM_addressKey())) {
					contact.getM_contactDeliveryAdressList().remove(address.getM_addressKey());
				}
			}
		}
	}

	/**
	 * Update this address in the hash map
	 * @param newAddress
	 */
	public static void updateAddress(AddressModel newAddress) {
		if (m_addressesMap.containsKey(newAddress.getM_addressKey())) {
			m_addressesMap.remove(newAddress.getM_addressKey());
			m_addressesMap.put(newAddress.getM_addressKey(), newAddress);
		}
	}

	/**
	 * Getter on addresses map
	 * @return HashMap<Integer, AddressModel> addresses map
	 */
	public static HashMap<Integer, AddressModel> getM_addressesMap() {
		return m_addressesMap;
	}
	
}
