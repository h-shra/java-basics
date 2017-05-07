package basics.oop.abstraction;

public class MyInterfaceImpl implements MyInterface {
    public static void main(String[] args) {
        MyInterfaceImpl impl = new MyInterfaceImpl();
        //Can't do this
        //impl.VARIABLE - static
        //MyInterface.VARIABLE = 5; - final
    }

    @Override
    public void doThis() {

    }

    //Can't do this
    /*@Override
    default void defaultMethodWithBody() {

    }*/

    @Override
    public int doThat(int withParam) {
        return 0;
    }
}
