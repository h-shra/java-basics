package questions;

/*
    Don't allow subclasses to override methods. The simplest way to do this is to declare the class as final.
    A more sophisticated approach is to make the constructor private and construct instances in factory methods.
 */
public final class Immutable implements Cloneable {

    private final int value;
    private OtherImmutable otherImmutable;

    public Immutable(int value, OtherImmutable otherImmutable) {
        this.value = value;
        this.otherImmutable = otherImmutable;
    }

    public OtherImmutable getOtherImmutable() {
        return otherImmutable;
    }

    public int getValue() {
        return value;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        final Immutable clonedImmutable = (Immutable) super.clone();
        clonedImmutable.otherImmutable = (OtherImmutable) super.clone();
        return clonedImmutable;
    }
}
