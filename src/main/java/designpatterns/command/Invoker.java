package designpatterns.command;

import basics.exceptionhandling.WrappedException;

public enum Invoker {

    CREATE("create", new CreateCommandImpl()),
    UPDATE("create", new CreateCommandImpl()),
    LIST("create", new CreateCommandImpl()),
    DELETE("create", new CreateCommandImpl());

    private final Command command;
    private final String operation;

    Invoker(String op, Command command) {
        this.operation = op;
        this.command = command;
    }

    public static Invoker lookup(String command) throws WrappedException {
        try {
            return Invoker.valueOf(command);
        } catch (IllegalArgumentException e) {
            throw new WrappedException("Command " + command + "not supported.");
        }
    }

    public static void invoke(String command, String param) {
        Invoker lookedUpCommand;
        //validate input command
        try {
            lookedUpCommand = Invoker.lookup(command);
            lookedUpCommand.command.execute(param);
        } catch (WrappedException e) {
            e.printStackTrace();
        }
    }
}
