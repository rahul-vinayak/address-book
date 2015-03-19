package addressbook;

import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.util.List;

import static org.junit.Assert.*;

public class ParserTest {

    private Parser parser;

    @Before
    public void setUp() throws Exception {
        parser = new Parser("AddressBook.txt");
    }

    @Test
    public void shouldReadFileIntoListOfObjects() {
        List<AddressBook> addresses = parser.listAddresses();
        assertNotNull(addresses);
        assertFalse(addresses.isEmpty());
        assertEquals(5, addresses.size());
    }

    @Test
    public void shouldReturnNumberOfMales() {
        int count = parser.getGenderCount("Male");
        assertEquals(3, count);
    }

    @Test
    public void shouldReturnNumberOfFemales() {
        int count = parser.getGenderCount("Female");
        assertEquals(2, count);
    }

    @Test
    public void shouldReturnTheOldestPerson() {
        String oldestPerson = parser.getOldestPerson();
        assertNotNull(oldestPerson);
        assertEquals("Wes Jackson", oldestPerson);
    }

    @Test
    public void shouldReturn_DOB_DifferenceInDays(){
        long days = parser.getAgeDifference("Bill McKnight","Paul Robinson");
        assertFalse(days == 0);
        assertEquals(2862, days);
    }

}