package addressbook;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

/**
 * Created by rahul on 3/18/15.
 */
public class Parser {

    private List<AddressBook> addresses = new ArrayList<AddressBook>();
    private File file;

    public Parser(String fileName) throws ParseException, IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        file = new File(classLoader.getResource(fileName).getFile());
        addresses = readFile();
    }

    private List<AddressBook> readFile() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = br.readLine();

        while (line!=null) {
            String[] split = line.split(",");
            addresses.add(new AddressBook(split[0].trim(), split[1].trim(), split[2].trim()));
            line= br.readLine();
        }
        return addresses;
    }

    public List<AddressBook> listAddresses() {
        return addresses;
    }

    public int getGenderCount(final String gender) {
        Predicate<AddressBook> predicate = new Predicate<AddressBook>() {
            @Override
            public boolean apply(AddressBook address) {
                return address.getSex().equalsIgnoreCase(gender);
            }
        };

        Collection<AddressBook> result = Collections2.filter(addresses, predicate);
        return result.size();
    }

    public String getOldestPerson() {
        Collections.sort(addresses, new AgeComparator());
        return addresses.get(0).getName();
    }

    public long getAgeDifference(String person1, String person2) {
        Date dob1 = new Date();
        Date dob2 = new Date();

        for (AddressBook address: addresses) {
            if (address.getName().equalsIgnoreCase(person1)) dob1 = address.getDob();
            if (address.getName().equalsIgnoreCase(person2)) dob2 = address.getDob();
        }
        return Helper.getDifferenceInDays(dob1, dob2);
    }

}
