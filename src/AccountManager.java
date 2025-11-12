import java.util.HashMap;

public class AccountManager {
    private HashMap<String, BankAccount> accounts = new HashMap<>();

    public void createAccount(String accNo, String name, double initialBalance) {
        if (!accounts.containsKey(accNo)) {
            accounts.put(accNo, new BankAccount(accNo, name, initialBalance));
            System.out.println(" Account created successfully.");
        } else {
            System.out.println(" Account number already exists.");
        }
    }

    public void viewAccount(String accNo) {
        BankAccount acc = accounts.get(accNo);
        if (acc != null) {
            System.out.println(acc);
        } else {
            System.out.println(" Account not found.");
        }
    }

    public void deposit(String accNo, double amount) {
        BankAccount acc = accounts.get(accNo);
        if (acc != null) {
            acc.deposit(amount);
            System.out.println(" Deposit successful. New Balance: ₹" + acc.getBalance());
        } else {
            System.out.println(" Account not found.");
        }
    }

    public void withdraw(String accNo, double amount) {
        BankAccount acc = accounts.get(accNo);
        if (acc != null) {
            if (acc.withdraw(amount)) {
                System.out.println(" Withdrawal successful. New Balance: ₹" + acc.getBalance());
            } else {
                System.out.println(" Insufficient balance.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    public void deleteAccount(String accNo) {
        if (accounts.remove(accNo) != null) {
            System.out.println(" Account deleted.");
        } else {
            System.out.println(" Account not found.");
        }
    }
}