public class test {
    static class BankAccount {
        public int balance;

        public BankAccount(int b) {
            balance = b;
        }

        public synchronized void withdraw(int amount) {
            String name = Thread.currentThread().getName();
            System.out.println(name + " withdraw: " + amount);

            if (balance >= amount) {
                System.out.println(name + " waiting...");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                balance -= amount;

                System.out.println(name + " withdraw success: " + amount + ", remain balance: " + balance);
            } else {
                System.out.println(name + " withdraw unsuccess, remain: " + balance);
            }
        }
    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount(1000);

        Thread thread1 = new Thread(() -> {
            acc.withdraw(700);
        }, "Nguoi A");

        Thread thread2 = new Thread(() -> {
            acc.withdraw(700);
        }, "Nguoi B");

        thread1.start();
        thread2.start();
    }
}