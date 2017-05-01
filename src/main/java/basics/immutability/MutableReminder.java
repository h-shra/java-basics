package basics.immutability;

import java.util.Date;

public final class MutableReminder {
    //Declaring this as private final is not sufficient to make the class immutable.
    public final Date date;

    public MutableReminder(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }
}
