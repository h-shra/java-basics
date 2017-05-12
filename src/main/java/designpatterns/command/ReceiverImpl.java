package designpatterns.command;

import java.util.ArrayList;
import java.util.List;

public final class ReceiverImpl implements Receiver {

    public static volatile ReceiverImpl instance;
    public static volatile List<String> stuff;

    private ReceiverImpl() {
    }

    public static ReceiverImpl getInstance() {
        if (instance == null) {
            synchronized (ReceiverImpl.class) {
                if (instance == null) {
                    instance = new ReceiverImpl();
                    stuff = new ArrayList<>();
                }
            }
        }
        return instance;
    }

    @Override
    public String create(String param) {
        stuff.add(param);
        return null;
    }

    @Override
    public String update() {
        return null;
    }

    @Override
    public List<String> list() {
        return null;
    }

    @Override
    public void delete() {

    }
}
