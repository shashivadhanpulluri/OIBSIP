public class Account {

    private String userId;
    private String pin;
    private String name;
    private double balance;

    public Account(String userId, String pin, String name, double balance) {
        this.userId = userId;
        this.pin = pin;
        this.name = name;
        this.balance = balance;
    }

    public String getUserId() {
        return userId;
    }

    public String getPin() {
        return pin;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {

        if (balance >= amount) {
            balance -= amount;
            return true;
        }

        return false;
    }
}