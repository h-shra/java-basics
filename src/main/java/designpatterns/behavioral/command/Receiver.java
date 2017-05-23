package designpatterns.behavioral.command;

import java.util.List;

public interface Receiver {

    String create(String param);

    String update();

    List<String> list();

    void delete();

}
