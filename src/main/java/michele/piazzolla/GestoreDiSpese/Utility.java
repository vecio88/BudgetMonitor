package michele.piazzolla.GestoreDiSpese;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;


public class Utility {

	static DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	static DateTimeFormatter formatWithTime = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	
	public static ZonedDateTime stringToZoneDateTime(String dateString) {
		return stringToLocalDateTime(dateString).atZone(ZoneId.of("Europe/Rome"));
	}
	
	public static LocalDateTime stringToLocalDateTime(String dateString) {
		return LocalDateTime.parse(dateString, formatWithTime);
	}
	
	public static LocalDate stringToLocalDate(String dateString) {
		return LocalDate.parse(dateString, format);
	}
	
	public static String localDateToString(LocalDate localDate) {
		return localDate.format(format).toString();
	}

	public static boolean checkDataFormat(String dataDaControllare) {
		
		String pattern = "^[0-3][0-9]/([0][0-9]|[1][0-2])/[0-9]{4}$";
		
        return Pattern.matches(pattern, dataDaControllare);

	}
	
	public static boolean checkDataTimeFormat(String dataDaControllare) {
		
		String pattern = "^[0-3][0-9]/([0][0-9]|[1][0-2])/[0-9]{4} ([01][0-9]|2[0-4]):([0-5][0-9]):([0-5][0-9])$";
		
        return Pattern.matches(pattern, dataDaControllare);

	}
	
	public static void main (String[] args) {
		
		Utility u = new Utility();
		
		LocalDate dataLocale = u.stringToLocalDate("04/11/2020");
		
		System.out.println(dataLocale.format(format).toString());
		
		
	}
}
