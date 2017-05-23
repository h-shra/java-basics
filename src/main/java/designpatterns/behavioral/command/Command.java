package designpatterns.behavioral.command;

import basics.exceptionhandling.WrappedException;

public interface Command {

    void execute(String param) throws WrappedException;
}
