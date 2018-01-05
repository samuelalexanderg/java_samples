package date;

import java.util.Date;
import java.util.TimeZone;

/**
 * Created by sam on 5/6/17.
 */
public class TimeZoneTest {
    public static void main (String[] args) {
        System.out.println(TimeZone.getTimeZone("in"));
        System.out.println(TimeZone.getTimeZone("America/Los_Angeles"));
        System.out.println(TimeZone.getTimeZone("America/Los_Angeles").getOffset(new Date().getTime()) / 1000 / 60);
    }
}
