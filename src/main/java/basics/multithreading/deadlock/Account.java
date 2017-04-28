package basics.multithreading.deadlock;

public class Account {

    int accountNumber;
    long balance = 0L;

    public Account(int accountNumber, long balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public synchronized void credit(long amount) {
        balance = balance + amount;
    }

    public synchronized void debit(long amount) {
        //validate has enough balance
        balance = balance - amount;
    }

    public synchronized long checkBalance() {
        return this.balance;
    }
}
