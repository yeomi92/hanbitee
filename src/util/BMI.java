package util;

import java.util.Scanner;

public class BMI {
	public String getBmi(double weight, double height) {
		double bmi = weight / (height/100 * height/100);
		String result="";
		if (bmi > 30.0) {
			result = "����";
		} else if (bmi > 25.0) {
			result = "��";
		} else if (bmi > 23.0) {
			result = "��ü��";
		} else if (bmi > 18.5) {
			result = "����";
		} else {
			result = "��ü��";
		}
		return result;
	}
}
