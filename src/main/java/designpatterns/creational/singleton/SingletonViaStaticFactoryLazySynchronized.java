package designpatterns.creational.singleton;

import java.io.Serializable;

public class SingletonViaStaticFactoryLazySynchronized implements Serializable {

    private static final long serialVersionUID = -6849794470754667710L;
    private static volatile SingletonViaStaticFactoryLazySynchronized instance;
    //OR use this object for lock
    //private static final Object lock = new Object();
    private String test;

    private SingletonViaStaticFactoryLazySynchronized() {
        test = "This is Singleton with lazy init with synchronized get instance method";
    }

    public static synchronized SingletonViaStaticFactoryLazySynchronized getInstance() {
        if (instance == null) {
            synchronized (SingletonViaStaticFactoryLazySynchronized.class) {
                //check if any other thread created the object while you acquired lock
                if (instance == null) {
                    instance = new SingletonViaStaticFactoryLazySynchronized();
                }
            }
        }
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public SingletonViaStaticFactoryLazySynchronized readResolve() {
        return SingletonViaStaticFactoryLazySynchronized.instance;
    }
}
