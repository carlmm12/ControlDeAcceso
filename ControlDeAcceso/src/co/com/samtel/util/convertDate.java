package co.com.samtel.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class convertDate {

	/*
	 * METODO PARA CONVERTIR UN STRING A UNA FECHA
	 */

	public static Date convertToDate(String date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date converDate;
		try {
			converDate =  formatter.parse(date);
			return converDate;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static LocalDate converToDat(String date) {

		DateTimeFormatter f = DateTimeFormatter.ofPattern( "yyyy-MM-dd" ) ;
		LocalDate ldt = LocalDate.parse( date , f ) ;
		System.out.println(ldt.getMonthValue());
       return ldt;
	}

}
