package util;

import java.util.Scanner;

public class SSN {
	public String calcSsn(String ssn) {
		String gender = "";
		switch(ssn.charAt(7)){
		case '1':case '3':
			gender = "����";
			break;
		case '2':case '4':
			gender = "����";
			break;
		case '5':case '6':
			gender = "�ܱ���";
			break;
		default:
			gender="�߸��� ��";
		}
		return gender;
	}
}
