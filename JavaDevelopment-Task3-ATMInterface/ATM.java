import java.util.ArrayList;
import java.util.Scanner;

public class ATM {

    private Scanner sc;
    private Bank bank;
    private Account currentAccount;
    private ArrayList<Transaction> history;

    public ATM() {
        sc = new Scanner(System.in);
        bank = new Bank();
        history = new ArrayList<>();
    }

    public void start() {

        int attempts = 0;

        while (attempts < 3) {

            System.out.println("\n========== ATM LOGIN ==========");

            System.out.print("Enter User ID: ");
            String userId = sc.nextLine();

            System.out.print("Enter PIN: ");
            String pin = sc.nextLine();

            currentAccount = bank.login(userId, pin);

            if (currentAccount != null) {
                System.out.println("\nLogin Successful!");
                System.out.println("Welcome " + currentAccount.getName());
                showMenu();
                return;
            }

            attempts++;

            System.out.println("Invalid User ID or PIN.");
            System.out.println("Attempts Left: " + (3 - attempts));
        }

        System.out.println("\nAccess Denied!");
        System.out.println("Too many failed attempts.");
    }

    public void showMenu() {

        int choice;

        do {

            System.out.println("\n========== ATM MENU ==========");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    showHistory();
                    break;

                case 2:
                    withdraw();
                    break;

                case 3:
                    deposit();
                    break;

                case 4:
                    transfer();
                    break;

                case 5:
                    System.out.println("\nThank you for using our ATM!");
                    break;

                default:
                    System.out.println("Invalid Choice!");

            }

        } while (choice != 5);
    }

    public void deposit() {

        System.out.print("Enter amount to deposit: ");

        double amount = sc.nextDouble();
        sc.nextLine();

        if (amount <= 0) {
            System.out.println("Invalid Amount.");
            return;
        }

        currentAccount.deposit(amount);

        history.add(new Transaction(
                "Deposit",
                amount,
                "Cash Deposit"));

        System.out.println("Deposit Successful.");
        System.out.println("Current Balance: Rs." + currentAccount.getBalance());
    }

    public void withdraw() {

        System.out.print("Enter amount to withdraw: ");

        double amount = sc.nextDouble();
        sc.nextLine();

        if (amount <= 0) {
            System.out.println("Invalid Amount.");
            return;
        }

        if (currentAccount.withdraw(amount)) {

            history.add(new Transaction(
                    "Withdraw",
                    amount,
                    "Cash Withdrawal"));

            System.out.println("Withdrawal Successful.");
            System.out.println("Current Balance: Rs." + currentAccount.getBalance());

        } else {

            System.out.println("Insufficient Funds.");

        }
    }

    public void transfer() {

        System.out.print("Enter Recipient User ID: ");
        String receiverId = sc.nextLine();

        Account receiver = bank.findAccount(receiverId);

        if (receiver == null) {
            System.out.println("Recipient Account Not Found.");
            return;
        }

        if (receiver.getUserId().equals(currentAccount.getUserId())) {
            System.out.println("You cannot transfer money to your own account.");
            return;
        }

        System.out.print("Enter Amount to Transfer: ");

        double amount = sc.nextDouble();
        sc.nextLine();

        if (amount <= 0) {
            System.out.println("Invalid Amount.");
            return;
        }

        if (currentAccount.withdraw(amount)) {

            receiver.deposit(amount);

            history.add(new Transaction(
                    "Transfer",
                    amount,
                    "Transferred to " + receiver.getName()));

            System.out.println("Transfer Successful.");
            System.out.println("Current Balance: Rs." + currentAccount.getBalance());

        } else {

            System.out.println("Insufficient Funds.");

        }
    }

    public void showHistory() {

        System.out.println("\n========== TRANSACTION HISTORY ==========");

        if (history.isEmpty()) {

            System.out.println("No Transactions Found.");
            return;

        }

        for (Transaction transaction : history) {

            System.out.println(transaction);

        }

    }

}
