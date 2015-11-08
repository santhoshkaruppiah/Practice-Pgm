package com.san.debug;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateToStringConverter {

	public static String formateDate(String dateString) {
		String dateFormatted=null;
		try {
			
			// dateString to long
			long timeInMillis = Long.valueOf(dateString);
			Calendar cal1 = Calendar.getInstance();
			cal1.setTimeInMillis(timeInMillis);
			SimpleDateFormat dateFormat = new SimpleDateFormat(
			                                "dd/MM/yyyy hh:mm:ss a");
			dateFormatted = dateFormat.format(cal1.getTime());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dateFormatted;
	}
	
	//SAP PromoSvc date check logic , modified param to take long(time in millis) instead of date
	private boolean checkDate(long date, long startDate, long endDate) {
	        long time = (date != 0 ? date : System.currentTimeMillis());
	        // Allow for campaign start and/or endDate not set, which means open in that direction.
	        // Exclude endDate == time because date would normally be reset to beginning of day (12am).
	        return (startDate == 0 || startDate <= time) && (endDate == 0 || endDate > time);
	 }

	public static void main(String[] args) {
		System.out.println(formateDate("1388563200000"));
		System.out.println(formateDate("1416816000000"));
	}
}
