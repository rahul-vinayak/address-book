package addressbook;

import java.text.ParseException;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by rahul on 3/18/15.
 */
public class AddressBook {

    private String name;
    private String sex;
    private Date dob;

    public AddressBook(String name, String sex, String dob) throws ParseException {
        this.name = name;
        this.sex = sex;
        this.dob = Helper.buildDate(dob);
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public Date getDob() {
        return dob;
    }

    @Override
    public String toString() {
        return "AddressBook{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", dob=" + dob +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressBook that = (AddressBook) o;

        if (!dob.equals(that.dob)) return false;
        if (!name.equals(that.name)) return false;
        if (!sex.equals(that.sex)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + sex.hashCode();
        result = 31 * result + dob.hashCode();
        return result;
    }
}
