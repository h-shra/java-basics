package designpatterns.creational.singleton;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonViaEnumTest {


    @Test
    public void test() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<?>[] constructors = SingletonViaEnum.class.getDeclaredConstructors();
        for (Constructor c : constructors) {
            c.setAccessible(true);
            SingletonViaEnum singletonViaEnum1 = (SingletonViaEnum) c.newInstance();
            System.out.println(singletonViaEnum1.hashCode());
        }
        SingletonViaEnum one = SingletonViaEnum.INSTANCE_ONE;
        System.out.println(one.hashCode());
    }

}