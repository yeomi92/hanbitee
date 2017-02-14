package util;

import java.util.Scanner;

public class BMI {
	public String getBmi(double weight, double height) {
		double bmi = weight / (height/100 * height/100);
		String result="";
		if (bmi > 30.0) {
			result = "고도비만";
		} else if (bmi > 25.0) {
			result = "비만";
		} else if (bmi > 23.0) {
			result = "과체중";
		} else if (bmi > 18.5) {
			result = "정상";
		} else {
			result = "저체중";
		}
		return result;
	}
}
