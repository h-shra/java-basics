package designpatterns.command;

public class Client {
    public static void main(String[] args) {
        Invoker.invoke("CREATE", "stuff");
    }
}
