package basics.multithreading;// Lazily initialized, cached hashCode

public class Volatile {
    private volatile int hashCode; // (See Item 71)
    private int areaCode;
    private int prefix;
    private int lineNumber;

    public Volatile(int areaCode, int prefix, int lineNumber) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNumber = lineNumber;
    }

    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = 17;
            result = 31 * result + areaCode;
            result = 31 * result + prefix;
            result = 31 * result + lineNumber;
            hashCode = result;
        }
        return result;
    }

}