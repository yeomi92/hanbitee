package util;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Clock {
	public String now(){
		return new SimpleDateFormat("yyyy/MM/dd a hh:mm:ss").format(new Date());
	}
}
