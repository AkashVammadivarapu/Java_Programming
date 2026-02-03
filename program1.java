class BankAccount {
    private int balance = 10000;

    synchronized void withdraw(int amount) {
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " withdrawing " + amount);
            balance -= amount;
            System.out.println("Balance left: " + balance);
        } else {
            System.out.println("Insufficient balance for " + Thread.currentThread().getName());
        }
    }
}

class Customer extends Thread {
    BankAccount acc;
    Customer(BankAccount acc, String name) {
        super(name);
        this.acc = acc;
    }
    public void run() {
        acc.withdraw(7000);
    }
}

public class BankApp {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount();
        new Customer(acc, "User-1").start();
        new Customer(acc, "User-2").start();
    }
}
