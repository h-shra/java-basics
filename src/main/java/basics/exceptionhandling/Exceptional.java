package basics.exceptionhandling;

import java.io.File;
import java.io.IOException;
import java.time.DateTimeException;

public class Exceptional {

    public static void main(String[] args) {
        Exceptional exceptional = new Exceptional();
        exceptional.testError();
        try {
            exceptional.testChecked();
        } catch (IOException e) {
            e.printStackTrace();
        }
        exceptional.testUnchecked();
    }

    /**
     * RuntimeException and its subclasses are unchecked exceptions.
     * Unchecked exceptions do not need to be declared in a method or constructor's throws clause
     * They can be thrown by the execution of the method or constructor and usually propagate upwards, if not caught.
     */
    private void testUnchecked() {
        int a = 8;
        int b = 0;
        int result = a / b; //no compile time error to write catch or to add "throws" in method signature

        String test = null;
        test.replace('c', 's');//no compile time error to write catch or to add "throws" in method signature

        throw new DateTimeException("Throwing it intentionally");
        //no compile time error to write catch or to add "throws" in method signature
    }

    /**
     * The class Exception and any subclasses that are not also subclasses of RuntimeException are checked exceptions.
     * Compile-time checking for the presence of exception handlers is mandatory.
     */
    private void testChecked() throws IOException {

        File file = new File("C://Test.txt");

        throw new IOException("Throwing it intentionally");
        // Should either catch or add "throws" in method signature
    }

    /**
     * Most such errors are abnormal conditions that indicate serious problems.
     * A reasonable application should not try to catch Error.
     * Error and its subclasses are regarded as unchecked exceptions for the purposes of compile-time checking of exceptions.
     */
    private void testError() {
        throw new OutOfMemoryError("Throwing it intentionally");
        //no compile time error to write catch or to add "throws" in method signature
    }

}
