package com.example.leadmanagement.util;

import java.util.regex.Pattern;

public class CommonUtil {

	public static boolean isValidField(String field) {
		boolean bValid = true;
		if (null == field || field.isBlank() || field.isEmpty()) {
			bValid = false;
		}
		return bValid;
	}

	public static boolean isValidLong(Long lValue) {
		boolean bValid = true;
		if (null == lValue || lValue.longValue() == 0) {
			bValid = false;
		}
		return bValid;
	}

	public static boolean validateLetters(String txt) {
		String regex = "[a-zA-Z]+";
		return Pattern.matches(regex, txt);
	}

	public static boolean validateEmailFormat(String email) {
		String regex = "^(.+)@(.+)$";
		return Pattern.matches(regex, email);
	}

}
