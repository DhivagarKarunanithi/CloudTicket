package com.train.booking.util;

import java.util.Arrays;

public class Validations {
	
	public static boolean isValidSection(String section) {
		if(Arrays.asList(Constants.SECTIONS).contains(section)) {
			return true;
		}
		return false;
	}

}
