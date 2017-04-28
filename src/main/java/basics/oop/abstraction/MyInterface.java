package basics.oop.abstraction;

public interface MyInterface {

    final int VARIABLE = 0;

    static void staticMethodWithBody() {
        System.out.println("from MyInterface.staticMethodWithBody - Aha!");
    }

    default void defaultMethodWithBody() {
        System.out.println("Aha aha!");
    }

    void doThis();

    int doThat(int withParam);

}
