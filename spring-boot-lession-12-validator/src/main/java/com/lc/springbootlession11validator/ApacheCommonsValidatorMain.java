package com.lc.springbootlession11validator;

import org.apache.commons.validator.routines.IntegerValidator;

public class ApacheCommonsValidatorMain {

	public static void main(String[] args) {
		IntegerValidator integerValidator = IntegerValidator.getInstance();
		Integer value = integerValidator.validate("10");
		System.out.println(value);
		value = integerValidator.validate("a");
		System.out.println(value);
	}
}
