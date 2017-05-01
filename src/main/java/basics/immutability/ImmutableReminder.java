package basics.immutability;

import java.util.Date;

/**
 * Don't allow subclasses to override methods. Declare the class as final.
 * Ensure mutable class members are final and return its copy via getters.
 * Override clone method to create new instances.
 * A more sophisticated approach is to make the constructor private and
 * construct instances in factory methods.
 */
public final class ImmutableReminder {

    private int unusedInt;
    private Date date;
    private OtherMutable otherMutable;

    public ImmutableReminder(final int unusedInt, final Date date, final OtherMutable otherMutable) {
        this.unusedInt = unusedInt;
        this.date = (Date) date.clone();
        this.otherMutable = otherMutable;
    }

    public int getUnusedInt() {
        return unusedInt;
    }

    public Date getDate() {
        return (Date) date.clone();
    }

    public OtherMutable getOtherMutable() {
        return otherMutable;
    }
}
