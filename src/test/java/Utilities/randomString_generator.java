package Utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class randomString_generator {
	public static String randomstring() {
		String generaterandomstring = RandomStringUtils.secure().nextAlphabetic(6);
		return generaterandomstring;
	}
	
	public static String randomnumber() {
		String generaterandomnumber = RandomStringUtils.secure().nextNumeric(10);
		return generaterandomnumber;
	}
	
	public static String randomalphanumeric() {
		String generaterandomstring = RandomStringUtils.secure().nextAlphabetic(3);
		String generaterandomnumber = RandomStringUtils.secure().nextNumeric(3);
		return(generaterandomstring+"@"+generaterandomnumber);
	}
}
