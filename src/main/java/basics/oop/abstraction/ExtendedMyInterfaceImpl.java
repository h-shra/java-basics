package basics.oop.abstraction;

public class ExtendedMyInterfaceImpl implements ExtendedMyInterface {

    public static void main(String[] args) {
        MyInterface impl = new ExtendedMyInterfaceImpl();
        impl.defaultMethodWithBody();
        MyInterface.staticMethodWithBody();
    }
/*

    @Override
    public void defaultMethodWithBody() {
        System.out.println("Changed default method to non-default here");
    }
*/

    @Override
    public void doThis() {

    }

    @Override
    public int doThat(int withParam) {
        return 0;
    }

    @Override
    public void doThisAsWell() {

    }
}
