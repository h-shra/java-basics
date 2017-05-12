package designpatterns.singleton;

public class SingletonViaStaticFactory {

    private static final SingletonViaStaticFactory INSTANCE = new SingletonViaStaticFactory();
    private String test;

    private SingletonViaStaticFactory() {
        test = "This is Singleton eager init";
    }

    public static SingletonViaStaticFactory getInstance() {
        return INSTANCE;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
