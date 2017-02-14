package util;

import java.util.Scanner;

public class SSN {
	public String calcSsn(String ssn) {
		String gender = "";
		switch(ssn.charAt(7)){
		case '1':case '3':
			gender = "남자";
			break;
		case '2':case '4':
			gender = "여자";
			break;
		case '5':case '6':
			gender = "외국인";
			break;
		default:
			gender="잘못된 값";
		}
		return gender;
	}
}
