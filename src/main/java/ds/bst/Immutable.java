package ds.bst;

/**
 * Created by sherlekar on 3/23/17.
 */
public final  class Immutable {
    private final String string;
    private final Integer i;

    public Immutable(String string, Integer i) {
        this.string = string;
        this.i = i;
    }

    private String getString() {
        return this.string;
    }

    private Integer getI() {
        return this.i;
    }

}
