package questions;

public final class OtherImmutable implements Cloneable {

    final long longValue;
    final String string;

    public OtherImmutable(long longValue, String string) {
        this.longValue = longValue;
        this.string = string;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
