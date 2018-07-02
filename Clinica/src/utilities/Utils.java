package utilities;

import java.util.Date;
import java.util.Calendar;

public class Utils {

	public static Calendar toCalendar(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}
}
