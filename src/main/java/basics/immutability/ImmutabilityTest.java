package basics.immutability;

import java.util.Date;

public class ImmutabilityTest {
    public static void main(String[] args) throws InterruptedException {
        ImmutabilityTest test = new ImmutabilityTest();
        test.testMutableReminder();
        test.immutableReminder();
    }

    private void immutableReminder() throws InterruptedException {

        OtherMutable otherMutable = new OtherMutable(10L, "mutable");
        final Date currentDate = new Date();
        int unusedInt = 9;
        ImmutableReminder reminder = new ImmutableReminder(unusedInt, currentDate, otherMutable);
        System.out.println(currentDate);
        System.out.println(reminder.getDate());
        Thread.sleep(10000);
        // changed current date to 10s later date, hence changing the value of reminder
        currentDate.setTime(new Date().getTime());
        System.out.println(currentDate);
        System.out.println(reminder.getDate());

    }

    private void testMutableReminder() throws InterruptedException {
        final Date currentDate = new Date();
        MutableReminder reminder = new MutableReminder(currentDate);
        System.out.println(currentDate);
        System.out.println(reminder.getDate());
        Thread.sleep(10000);
        // changed current date to 10s later date, hence changing the value of reminder
        currentDate.setTime(new Date().getTime());
        System.out.println(currentDate);
        System.out.println(reminder.getDate());
    }
}
