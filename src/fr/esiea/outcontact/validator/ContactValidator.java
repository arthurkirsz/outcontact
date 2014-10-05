package fr.esiea.outcontact.validator;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import fr.esiea.outcontact.model.ContactModel;

/**
 * @author david
 * This class manages the validation of the createContact form
 */
public class ContactValidator implements Validator {
	
	private static String mailRegex = "^[a-zA-Z][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$"; 

	@Override
	public boolean supports(Class<?> param) {
		return ContactModel.class.equals(param);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ContactModel contact = (ContactModel) obj;
		
		ValidationUtils.rejectIfEmpty(errors, "m_contactFirstName", "valid.emptyField");
		ValidationUtils.rejectIfEmpty(errors, "m_contactLastName", "valid.emptyField");
		ValidationUtils.rejectIfEmpty(errors, "m_contactMail", "valid.emptyField");
		ValidationUtils.rejectIfEmpty(errors, "m_contactBirthDate", "valid.emptyField");
		
		if (contact.getM_contactMail() != null) {
			if (!contact.getM_contactMail().equals("") && !contact.getM_contactMail().matches(mailRegex)) {
				errors.rejectValue("m_contactMail", "valid.correctMail");
			}
		}
		
		if (contact.getM_contactBirthDate() != null) {
			Integer birthDateYear = getCalendar(contact.getM_contactBirthDate()).get(Calendar.YEAR);
			Integer thisYear = getCalendar(new Date()).get(Calendar.YEAR);
			
			//Prints error if the contact birth date is after or equals the current date
			if (contact.getM_contactBirthDate().compareTo(new Date()) > 0 || birthDateYear.equals(thisYear)) {
				errors.rejectValue("m_contactBirthDate", "valid.correctBirthDate");
			}
		}
	}
	
	private static Calendar getCalendar(Date date) {
	    Calendar cal = Calendar.getInstance(Locale.getDefault());
	    cal.setTime(date);
	    return cal;
	}

}
