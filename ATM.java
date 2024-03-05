import java.util.Scanner;

public class ATM extends TransactionManager {
    private Scanner scanner;

    public ATM() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to Lesedi Bank ATM");
        System.out.print("Enter user ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();
        if (verify(userId, pin)) {
            showOptions();
        } else {
            System.out.println("Invalid credentials. Exiting/User not registered...");
        }
    }

    private void showOptions() {
        while (true) {
            System.out.println("Please select an option:");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");

            int option = scanner.nextInt();
            scanner.nextLine();
            performTransaction(option);
        }
    }
}
