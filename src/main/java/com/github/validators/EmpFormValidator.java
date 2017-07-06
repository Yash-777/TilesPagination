package com.github.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.github.dtos.EmpDto;

public class EmpFormValidator implements Validator {

	public boolean supports(Class<?> cls) {
		return EmpDto.class.isAssignableFrom(cls);
	}

	public void validate(Object cmd, Errors be) {
		ValidationUtils.rejectIfEmptyOrWhitespace(be, "name","name.firstName", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(be, "age","age.firstName", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(be, "salary","salary.firstName", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(be, "address","address.firstName", "Field name is required.");
	}
}