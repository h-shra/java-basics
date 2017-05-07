package basics.oop.abstraction;

public interface ExtendedMyInterface extends MyInterface {

    int VARIABLE = 0;

    @Override
    default void defaultMethodWithBody() {
        //Override it to do something else
        System.out.println("ExtendedMyInterface.defaultMethodWithBody - Overrode it to do something else");
    }

    //OR I can do this so the behaviour of default method can be changed by my subclass
    //which means it is no longer a default method
    // void defaultMethodWithBody();

    void doThisAsWell();
}
