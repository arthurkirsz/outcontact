package fr.esiea.outcontact.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import fr.esiea.outcontact.model.AddressModel;

/**
 * @author david
 * This class manages the validation of the createAddress and newContactAddress form 
 */
public class AddressValidator implements Validator {
	
	private static String zipCodeRegex = "^\\d{5}(?:[-\\s]\\d{4})?$";
	private static String numberRegex = "[0-9]+";

	@Override
	public boolean supports(Class<?> param) {
		return AddressModel.class.equals(param);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		AddressModel address = (AddressModel) obj;
		
		ValidationUtils.rejectIfEmpty(errors, "m_addressNumber", "valid.emptyField");
		ValidationUtils.rejectIfEmpty(errors, "m_addressStreet", "valid.emptyField");
		ValidationUtils.rejectIfEmpty(errors, "m_addressZipCode", "valid.emptyField");
		ValidationUtils.rejectIfEmpty(errors, "m_addressCity", "valid.emptyField");
		
		if (!address.getM_addressNumber().equals("") && !address.getM_addressNumber().matches(numberRegex)) {
			errors.rejectValue("m_addressNumber", "valid.correctNumber");
		}
		
		if (!address.getM_addressZipCode().equals("") && !address.getM_addressZipCode().matches(zipCodeRegex)) {
			errors.rejectValue("m_addressZipCode", "valid.correctZipCode");
		}
	}

}
