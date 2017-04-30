package basics.singleton;

import java.io.Serializable;

public class SingletonViaStaticFactoryLazy implements Serializable {

    private static final long serialVersionUID = -6849794470754667710L;
    private static SingletonViaStaticFactoryLazy instance;
    private String test;

    private SingletonViaStaticFactoryLazy() {
        test = "This is Singleton with lazy init";
    }

    public static SingletonViaStaticFactoryLazy getInstance() {
        if (instance == null) {
            instance = new SingletonViaStaticFactoryLazy();
        }
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public SingletonViaStaticFactoryLazy readResolve() {
        return SingletonViaStaticFactoryLazy.instance;
    }
}
