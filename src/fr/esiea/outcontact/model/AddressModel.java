package fr.esiea.outcontact.model;

import java.util.Comparator;

public class AddressModel {
	
	private String m_addressNumber;
	private String m_addressStreet;
	private String m_addressZipCode;
	private String m_addressCity;
	//Integer key of this address in the address map
	private Integer m_addressKey;

	public AddressModel() {
	}

	public AddressModel(String m_addressNumber, String m_addressStreet,
			String m_addressZipCode, String m_addressCity, Integer addressKey) {
		this.m_addressNumber = m_addressNumber;
		this.m_addressStreet = m_addressStreet;
		this.m_addressZipCode = m_addressZipCode;
		this.m_addressCity = m_addressCity;
		this.m_addressKey = addressKey;
	}

	class NumberComparator implements Comparator<AddressModel> {

		@Override
		public int compare(AddressModel address1, AddressModel address2) {
			return address1.getM_addressNumber().compareToIgnoreCase(address2.getM_addressNumber());
		}
		
	}
	
	class StreetComparator implements Comparator<AddressModel> {

		@Override
		public int compare(AddressModel address1, AddressModel address2) {
			return address1.getM_addressStreet().compareToIgnoreCase(address2.getM_addressStreet());
		}
		
	}

	public String toString() {
		return m_addressNumber + " " + m_addressStreet + " " + m_addressZipCode + " " + m_addressCity;
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

	public String getM_addressZipCode() {
		return m_addressZipCode;
	}

	public void setM_addressZipCode(String m_addressZipCode) {
		this.m_addressZipCode = m_addressZipCode;
	}

	public String getM_addressCity() {
		return m_addressCity;
	}

	public void setM_addressCity(String m_addressCity) {
		this.m_addressCity = m_addressCity;
	}

	public Integer getM_addressKey() {
		return m_addressKey;
	}

	public void setM_addressKey(Integer m_addressKey) {
		this.m_addressKey = m_addressKey;
	}

}
