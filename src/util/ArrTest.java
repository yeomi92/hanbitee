package util;

import java.util.*;;

public class ArrTest {
	public static void main(String[] args){
		String[] arr={"a","b","c","d"};
		Set<String> result=new HashSet<String>();
		for(String i : arr){
			result.add(i);
		}
		System.out.println(result.toString());
	}
}
