package multithreading.deadlock;

public class Transaction {

    public static void main(String[] args) {

        Transaction transaction = new Transaction();

        Account alice = new Account(1, 100);
        Account bob = new Account(2, 500);

        /*Scenario 0*/

        //Say, Alice is sending $10 to Bob
        Thread aliceThread = new Thread() {
            public void run() {
                transaction.transferMoney(alice, bob, 10);
            }
        };

        //At the same time Bob decides to send Alice $100
        Thread bobThread = new Thread() {
            public void run() {
                transaction.transferMoney(bob, alice, 100);
            }
        };

        //Consider both transaction requests are submitted at the same time
        aliceThread.start();
        bobThread.start();


        /*Scenario 2*/
        Account alice1 = new Account(1, 100);
        Account bob1 = new Account(2, 500);

        /*Scenario 1*/

        //Say, Alice is sending $10 to Bob
        Thread aliceThread1 = new Thread() {
            public void run() {
                transaction.transferMoney(alice1, bob1, 10);
            }
        };

        Account alice2 = new Account(1, 100);
        Account bob2 = new Account(2, 500);
        //At the same time Bob decides to send Alice $100
        Thread bobThread1 = new Thread() {
            public void run() {
                transaction.transferMoney(bob2, alice1, 100);
            }
        };
    }

    /*
    * 1. aliceThread gets alice lock, bobThread gets bob lock
    * 2. aliceThread waits to get bob lock, bobThread waits to get alice lock
    * 3. Two threads try to acquire locks in same order and we go into deadlock
    * 4. Solution - Introduce ordering in lock acquiring
    * */
    public void transferMoney(Account from, Account to, long amount) {
        synchronized (from) {
            synchronized (to) {
                //Assumption - from account has enough balance
                from.debit(amount);
                to.credit(amount);
            }
        }
    }

    /*
    * 1.
    *
    * */
    public void transferMoney2(Account from, Account to, long amount) {
        from.debit(amount);
        to.credit(amount);
    }

}
