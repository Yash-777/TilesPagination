package com.github.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.github.dtos.NewUser;

public class RegestrationFormValidator implements Validator{
	private Pattern pattern;  
	private Matcher matcher;  
	private static final String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public boolean supports(Class<?> cls) {
		return NewUser.class.isAssignableFrom(cls);
	}

	public void validate(Object cmd, Errors be) {
		NewUser userDto = ( NewUser ) cmd;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(be, "firstName","required.firstName", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(be, "lastName","required.lastName", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(be, "password","required.password", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(be, "conformPassword","required.conformPassword", "Field name is required.");
		
		if( !( userDto.getPassword().equals(userDto.getConformPassword()) ) ) {
			be.rejectValue("password", "notmatch.password", "passwords not matched");
		}
		// email validation in spring  email : String
		if ((userDto.getEmail() == null) || (userDto.getEmail().isEmpty())) {  
			ValidationUtils.rejectIfEmptyOrWhitespace(be, "email","required.email", "Field name is required.");
		} else {
			pattern = Pattern.compile(EMAIL_PATTERN);
			matcher = pattern.matcher(userDto.getEmail());
			if (!matcher.matches()) {
				be.rejectValue("email", "email.incorrect","Enter a correct email");
			}
		}
	}
}