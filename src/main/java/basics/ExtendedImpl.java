package basics;

public class ExtendedImpl implements ExtendedMyInterface {

    public static void main(String[] args) {
        MyInterface impl = new ExtendedImpl();
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
