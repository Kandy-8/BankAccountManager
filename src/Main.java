import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AccountManager manager = new AccountManager();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Bank Account Manager ---");
            System.out.println("1. Create Account");
            System.out.println("2. View Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Delete Account");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Account No: ");
                    String accNo = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double bal = sc.nextDouble();
                    manager.createAccount(accNo, name, bal);
                    break;
                case 2:
                    System.out.print("Enter Account No: ");
                    manager.viewAccount(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Enter Account No: ");
                    accNo = sc.nextLine();
                    System.out.print("Enter Amount to Deposit: ");
                    double dep = sc.nextDouble();
                    manager.deposit(accNo, dep);
                    break;
                case 4:
                    System.out.print("Enter Account No: ");
                    accNo = sc.nextLine();
                    System.out.print("Enter Amount to Withdraw: ");
                    double wd = sc.nextDouble();
                    manager.withdraw(accNo, wd);
                    break;
                case 5:
                    System.out.print("Enter Account No: ");
                    manager.deleteAccount(sc.nextLine());
                    break;
                case 0:
                    System.out.println("👋 Exiting. Thank you!");
                    break;
                default:
                    System.out.println("❓ Invalid choice.");
            }
        } while (choice != 0);

        sc.close();
    }
}