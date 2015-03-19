package addressbook;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by rahul on 3/18/15.
 */
public class Helper {


    public static Date buildDate(String s) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        Date date = sdf.parse(s);
        return date;
    }

    public static long getDifferenceInDays(Date dob1, Date dob2) {
        long diffInMillis = Math.abs(dob1.getTime() - dob2.getTime());
        return diffInMillis/(1000*60*60*24);
    }
}
