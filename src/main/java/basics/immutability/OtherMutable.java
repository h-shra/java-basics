package basics.immutability;

public final class OtherMutable implements Cloneable {

    private final long longValue;
    private final String string;

    public OtherMutable(long longValue, String string) {
        this.longValue = longValue;
        this.string = string;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
