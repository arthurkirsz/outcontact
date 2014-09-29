package fr.esiea.outcontact.dao;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import fr.esiea.outcontact.model.AddressModel;
import fr.esiea.outcontact.model.ContactModel;

public class AddressDAO {
	
	private static HashMap<Integer, AddressModel> m_addressesMap = new HashMap<Integer, AddressModel>();
	private static Integer m_addressKey = 3;
	
	static {
		m_addressesMap.put(1, new AddressModel("1","avenue la ronde", "75010", "Paris", 1));
		m_addressesMap.put(2, new AddressModel("256","rue du général leclerc", "75014", "Paris", 2));	
	}

	public static void addAddress(AddressModel address) {
		address.setM_addressKey(m_addressKey++);
		m_addressesMap.put(address.getM_addressKey(), address);
	}

	public static boolean deleteAddress(AddressModel address) {
		if (m_addressesMap.containsValue(address)) {
			//Remove address element in the address map
			m_addressesMap.remove(address.getM_addressKey());
			//Remove address element in each contact's address list
			for (ContactModel contact : ContactDAO.getM_contactsMap().values()) {
				if (contact.getM_contactAdressList().contains(address)) {
					contact.getM_contactAdressList().remove(address);
				}
			}
		}
		else {
			return false;
		}
		return true;
	}

	public static boolean updateAddress(AddressModel address) {
		if (m_addressesMap.containsValue(address)) {
			m_addressesMap.remove(address.getM_addressKey());
			m_addressesMap.put(address.getM_addressKey(), address);
		}
		else {
			return false;
		}
		return true;
	}

	public static HashMap<String, String> mapConverter() {
		HashMap<String, String> convertedMap = new HashMap<String, String>();
	    Iterator<Entry<Integer, AddressModel>> itMap = m_addressesMap.entrySet().iterator();
	    while (itMap.hasNext()) {
	    	Map.Entry<Integer, AddressModel> pairs = (Map.Entry<Integer, AddressModel>)itMap.next();
	    	convertedMap.put(pairs.getKey().toString(), pairs.getValue().toString());
	    }
		
		return convertedMap;
	}

	public static HashMap<Integer, AddressModel> getM_addressesMap() {
		return m_addressesMap;
	}
	
}
