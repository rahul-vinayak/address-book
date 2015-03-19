package addressbook;

import org.junit.Test;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class HelperTest {

    @Test
    public void shouldBuildDateFromString_year77() throws Exception {
        Date date = Helper.buildDate("16/03/77");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        assertEquals(16, cal.get(Calendar.DAY_OF_MONTH));
        assertEquals(Calendar.MARCH, cal.get(Calendar.MONTH));
        assertEquals(1977, cal.get(Calendar.YEAR));
    }

    @Test
    public void shouldBuildDateFromString_year08() throws Exception {
        Date date = Helper.buildDate("16/03/08");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        assertEquals(16, cal.get(Calendar.DAY_OF_MONTH));
        assertEquals(Calendar.MARCH, cal.get(Calendar.MONTH));
        assertEquals(2008, cal.get(Calendar.YEAR));
    }

    @Test
    public void shouldBuildDateFromString_year1977() throws Exception {
        Date date = Helper.buildDate("16/03/1977");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        assertEquals(16, cal.get(Calendar.DAY_OF_MONTH));
        assertEquals(Calendar.MARCH, cal.get(Calendar.MONTH));
        assertEquals(1977, cal.get(Calendar.YEAR));
    }

    @Test
    public void shouldGetDifferenceInDays() throws ParseException {
        Date date_1 = Helper.buildDate("1/03/1977");
        Date date_2 = Helper.buildDate("11/03/1977");
        long differenceInDays = Helper.getDifferenceInDays(date_1, date_2);
        assertFalse(differenceInDays == 0);
        assertEquals(10, differenceInDays);

    }
}