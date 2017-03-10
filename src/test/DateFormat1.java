package test;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat1 {

	public static void main(String[] args) throws ParseException {
		/*SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(format.format(format.parse("2016/11/11 11:11:11")));*/
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SZ");
		System.out.println(df.format(new Date(1484728484418l)));
		
	}

}
