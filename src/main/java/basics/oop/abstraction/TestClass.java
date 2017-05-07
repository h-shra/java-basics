package basics.oop.abstraction;

public class TestClass {
    public void myMethod() {
        MyInterface myInterface = new MyInterfaceImpl();
        MyInterface myInterface1 = new ExtendedMyInterfaceImpl();
    }
}
