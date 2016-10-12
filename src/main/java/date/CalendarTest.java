package date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarTest {
	public static final String SF_DATETIME_FORMAT = "YYYY-MM-dd'T'hh:mm:ss.S'Z'";

	public static void main(String[] args) {
//		getQuarterEnd();
		testSDF();
	}

	private static void testSDF() {
		SimpleDateFormat sdf = new SimpleDateFormat(SF_DATETIME_FORMAT);
		GregorianCalendar cal = new GregorianCalendar();
		System.out.println(sdf.format(cal.getTime()));
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		System.out.println(sdf.format(cal.getTime()));
	}

	private static final void doCalOperation() {
		System.out.println(new Date().getTime());
		GregorianCalendar calendar = new GregorianCalendar();
		System.out.println(calendar.getTime());
		int i = 6;
		calendar.add(Calendar.MONTH, -i);
		System.out.println(calendar.getTime());
	}

    private static void getQuarterEnd() {
        Calendar cal = new GregorianCalendar();
//        cal.set(Calendar.MONTH, 12);
        System.out.println(cal);
        int prevQuarter = cal.get(Calendar.MONTH);
        switch(prevQuarter) {
            case 1 :
            case 2 :
            case 3 : {
            	System.out.println("2016-12-31");
            	break;
            }
                // return September 30
            case 4 :
            case 5 :
            case 6 :
            	System.out.println("2016-09-30");
            	break;
                // return June 30
            case 7 :
            	System.out.println("2016-06-30");
            	break;
                // return March 31
            case 0 : default :
            	System.out.println("2016-03-31");
                // return December 31
        }

    }
}
