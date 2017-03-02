package util;

import javax.servlet.http.HttpServletRequest;

public class ParamMap {
	public static String getValues(HttpServletRequest request,String name){
		String[] values=(String[])request.getParameterMap().get(name);
		String rs="";
		for(String s:values){
			rs+=s+",";
		}
		rs=rs.substring(0,rs.length()-1);
		return rs;
	}
}
