package fr.esiea.outcontact.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author david
 * This class represents the contact model
 */
public class ContactModel implements Comparable<ContactModel> {
	
	private String m_contactLastName;
	private String m_contactFirstName;
	private String m_contactMail;
	private Date m_contactBirthDate;
	private Boolean m_contactActive;
	//Integer key of this contact in the contact map
	private Integer m_contactKey;
	
	private Integer m_contactBillingAddress;
	private List<Integer> m_contactDeliveryAdressList = new ArrayList<Integer>();
	private static SimpleDateFormat formater = new SimpleDateFormat("yyy-MM-dd");

	public ContactModel() {
	}

	public ContactModel(String m_contactLastName, String m_contactFirstName,
			String m_contactMail, Date m_contactBirthDate,
			Boolean m_contactActive, Integer m_contactKey) {
		this.m_contactLastName = m_contactLastName;
		this.m_contactFirstName = m_contactFirstName;
		this.m_contactMail = m_contactMail;
		this.m_contactBirthDate = m_contactBirthDate;
		this.m_contactActive = m_contactActive;
		this.m_contactKey = m_contactKey;
		this.m_contactDeliveryAdressList = new ArrayList<Integer>();
	}
	
	@Override
	public int compareTo(ContactModel contact) {
		if (m_contactLastName.equals(contact.getM_contactLastName())
				&& m_contactFirstName.equals(contact.getM_contactFirstName())
				&& m_contactMail.equals(contact.getM_contactMail())) {
			return 0;
		}
		else {
			return m_contactFirstName.compareTo(contact.getM_contactFirstName());
		}
	}

	public String toString() {		
		return  "firstName:" + m_contactFirstName
				+ "lastName:" + m_contactLastName
				+ "mail:" + m_contactMail
				+ "birthDate:" + formater.format(m_contactBirthDate);
	}
	
	/**
	 * Return string birth date 
	 * @return String
	 */
	public String strBirthDate() {
		return formater.format(m_contactBirthDate);
	}

	//Getters and Setters
	public String getM_contactLastName() {
		return m_contactLastName;
	}

	public void setM_contactLastName(String m_contactLastName) {
		this.m_contactLastName = m_contactLastName;
	}

	public String getM_contactFirstName() {
		return m_contactFirstName;
	}

	public void setM_contactFirstName(String m_contactFirstName) {
		this.m_contactFirstName = m_contactFirstName;
	}

	public String getM_contactMail() {
		return m_contactMail;
	}

	public void setM_contactMail(String m_contactMail) {
		this.m_contactMail = m_contactMail;
	}

	public Date getM_contactBirthDate() {
		return m_contactBirthDate;
	}

	public void setM_contactBirthDate(Date m_contactBirthDate) {
		this.m_contactBirthDate = m_contactBirthDate;
	}

	public Boolean getM_contactActive() {
		return m_contactActive;
	}

	public void setM_contactActive(Boolean m_contactActive) {
		this.m_contactActive = m_contactActive;
	}

	public Integer getM_contactKey() {
		return m_contactKey;
	}

	public void setM_contactKey(Integer m_contactKey) {
		this.m_contactKey = m_contactKey;
	}

	public Integer getM_contactBillingAddress() {
		return m_contactBillingAddress;
	}

	public void setM_contactBillingAddress(Integer m_contactBillingAddress) {
		this.m_contactBillingAddress = m_contactBillingAddress;
	}

	public List<Integer> getM_contactDeliveryAdressList() {
		return m_contactDeliveryAdressList;
	}

	public void setM_contactDeliveryAdressList(
			List<Integer> m_contactDeliveryAdressList) {
		this.m_contactDeliveryAdressList = m_contactDeliveryAdressList;
	}
	
}
