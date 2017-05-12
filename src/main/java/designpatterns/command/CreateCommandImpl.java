package designpatterns.command;

import basics.exceptionhandling.WrappedException;

public class CreateCommandImpl implements Command {

    public Receiver accessor;

    public CreateCommandImpl() {
        this.accessor = ReceiverImpl.getInstance();
    }

    @Override
    public void execute(String param) throws WrappedException {
        accessor.create(param);
        System.out.println("Created : " + param);
    }
}
