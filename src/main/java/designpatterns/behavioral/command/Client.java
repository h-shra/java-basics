package designpatterns.behavioral.command;

public class Client {
    public static void main(String[] args) {
        Invoker.invoke("CREATE", "stuff");
    }
}
