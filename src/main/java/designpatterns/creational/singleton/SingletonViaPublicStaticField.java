package designpatterns.creational.singleton;

public class SingletonViaPublicStaticField {

    public static final SingletonViaPublicStaticField INSTANCE = new SingletonViaPublicStaticField();
    private String test;

    private SingletonViaPublicStaticField() {
        test = "This is Singleton eager init with public field";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
