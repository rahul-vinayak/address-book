package addressbook;

import java.util.Comparator;

/**
 * Created by rahul on 3/18/15.
 */

public class AgeComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        if (((AddressBook)o1).getDob().after(((AddressBook)o2).getDob())) {
            return 1;
        }
        if (((AddressBook)o1).getDob().before(((AddressBook)o2).getDob())) {
            return -1;
        }
        return 0;
    }
}