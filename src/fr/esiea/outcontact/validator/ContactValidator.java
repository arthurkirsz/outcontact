package fr.esiea.outcontact.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import fr.esiea.outcontact.model.ContactModel;

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
		
		if (!contact.getM_contactMail().equals("") && !contact.getM_contactMail().matches(mailRegex)) {
			errors.rejectValue("m_contactMail", "valid.correctMail");
		}
	}

}
