package com.github.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.github.dtos.LoginDto;

public class LoginFormValidator implements Validator{
	private Pattern pattern;  
	private Matcher matcher;  
	
	private static final String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public boolean supports(Class<?> cls) {
		return LoginDto.class.isAssignableFrom(cls);
	}

	public void validate(Object cmd, Errors be) {
		LoginDto loginDto = (LoginDto) cmd;
		if ((loginDto.getEmail() == null) || (loginDto.getEmail().isEmpty())) {
			ValidationUtils.rejectIfEmptyOrWhitespace(be, "email","required.email", "Field name is required.");
		} else {
			pattern = Pattern.compile(EMAIL_PATTERN);
			matcher = pattern.matcher(loginDto.getEmail());
			if (!matcher.matches()) {  
				be.rejectValue("email", "email.incorrect","Enter a correct email");
			}
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(be, "password","required.password", "Field name is required.");
	}
}