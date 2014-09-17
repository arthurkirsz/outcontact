package fr.esiea.outcontact.model;

public class AddressModel {
	
	private String m_addressNumber;
	private String m_addressStreet;
	private String m_adressZipCode;
	private String m_adressCity;

	public AddressModel() {
	}

	public AddressModel(String m_addressNumber, String m_addressStreet,
			String m_adressZipCode, String m_adressCity) {
		this.m_addressNumber = m_addressNumber;
		this.m_addressStreet = m_addressStreet;
		this.m_adressZipCode = m_adressZipCode;
		this.m_adressCity = m_adressCity;
	}

	public String getM_addressNumber() {
		return m_addressNumber;
	}

	public void setM_addressNumber(String m_addressNumber) {
		this.m_addressNumber = m_addressNumber;
	}

	public String getM_addressStreet() {
		return m_addressStreet;
	}

	public void setM_addressStreet(String m_addressStreet) {
		this.m_addressStreet = m_addressStreet;
	}

	public String getM_adressZipCode() {
		return m_adressZipCode;
	}

	public void setM_adressZipCode(String m_adressZipCode) {
		this.m_adressZipCode = m_adressZipCode;
	}

	public String getM_adressCity() {
		return m_adressCity;
	}

	public void setM_adressCity(String m_adressCity) {
		this.m_adressCity = m_adressCity;
	}

}
