package fr.esiea.outcontact.services;

import fr.esiea.outcontact.dao.AddressDAO;
import fr.esiea.outcontact.model.AddressModel;

public class AddressService {

	public static void createAddress(AddressModel address) {
		AddressDAO.addAddress(address);
	}

}
