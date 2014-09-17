package fr.esiea.outcontact.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ContactModel {
	
	private String m_contactLastName;
	private String m_contactFirstName;
	private String m_contactMail;
	private Date m_contactBirthDate;
	private Boolean m_contactActive;
	//Integer key of this contact in the contact map
	private Integer m_contactKey;
	
	private List<AddressModel> m_contactAdressList;
	private static SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
	
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
	}
	
	public String toString() {		
		return  "firstName:" + m_contactFirstName;
	}

	/*public String toString() {		
		return  "firstName:" + m_contactFirstName
				+ "lastName:" + m_contactLastName
				+ "mail:" + m_contactMail + "\n"
				+ "birthDate:" + formater.format(m_contactBirthDate)
				+ "active:" + (m_contactActive ? "true" : "false");
	}*/

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

	public List<AddressModel> getM_contactAdressList() {
		return m_contactAdressList;
	}

	public void setM_contactAdressList(List<AddressModel> m_contactAdressList) {
		this.m_contactAdressList = m_contactAdressList;
	}
	
}
