import java.util.ArrayList;

public class Bank {

    private ArrayList<Account> accounts;

    public Bank() {

        accounts = new ArrayList<>();

        accounts.add(new Account("shashi", "1234", "Shashivadhan", 10000));
        accounts.add(new Account("rahul", "1111", "Rahul", 8000));
        accounts.add(new Account("priya", "2222", "Priya", 12000));

    }

    public Account login(String userId, String pin) {

        for (Account account : accounts) {

            if (account.getUserId().equals(userId)
                    && account.getPin().equals(pin)) {

                return account;
            }

        }

        return null;
    }

    public Account findAccount(String userId) {

        for (Account account : accounts) {

            if (account.getUserId().equals(userId)) {

                return account;
            }

        }

        return null;
    }

}
