package mainFrame;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class SystemDateTime
{
	public static String now(String dateFormat, String gmt)
	{
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		sdf.setTimeZone(TimeZone.getTimeZone(gmt));
		return sdf.format(cal.getTime());
	}
}
