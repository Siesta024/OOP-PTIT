class BankAccount {
    public int acc_num;
    public String acc_name;
    public int balance;

    public BankAccount(int num, String s, int bal) {
        this.acc_num = num;
        this.acc_name = s;
        this.balance = bal;
    }

    void deposit(int n) {
        balance += n;
    }
    void withdraw(int n) {
        if (balance <= n) {
            System.out.println("Not enough money");
        }
        else {
            balance -= n;
        }
    }
    void transfer(BankAccount target, int n) {
        if (this.balance >= n) {
            this.balance -= n;
            target.balance += n;
            System.out.println("Done");
        }
        else {
            System.out.println("Not enough money");
        }
    }
    void display() {
        System.out.printf("acc number: %d \nName: %s \nBalance: %d \n", this.acc_num, this.acc_name, this.balance);
    }
}

public class Bank {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount(101, "Alice", 5000);
        BankAccount acc2 = new BankAccount(102, "Bob", 3000);
        
        acc1.deposit(1000);
        acc1.withdraw(2000);
        acc1.transfer(acc2, 1500);

        acc1.display();
        acc2.display();
    }
}
