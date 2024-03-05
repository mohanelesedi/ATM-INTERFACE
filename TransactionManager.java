import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TransactionManager extends UserManager {
    ArrayList<String> transactionHistory = new ArrayList<>();
    private Scanner scanner= new Scanner(System.in);

    public void performTransaction(int option) {
        int amount = getBankBalance(); // Fetch current balance from the User object
        List<String> recipientList =  new ArrayList<>();
        recipientList.add("Lulu");
        recipientList.add("user2");

        boolean continueTransaction = true;
        while (continueTransaction) {
            switch (option) {
                case 1:
                    // Transaction History
                    System.out.println("Transaction History:");
                    for (String transaction : transactionHistory) {
                        System.out.println(transaction);
                    }
                    break;
                case 2:
                    // Withdraw
                    System.out.println("Available balance: " + amount);
                    System.out.print("How much would you like to withdraw? ");
                    int withdrawAmount = scanner.nextInt();
                    if (withdrawAmount <= amount) {
                        amount -= withdrawAmount;
                        System.out.println("New balance is " + amount);
                        setBankBalance();
                        transactionHistory.add("Withdrew an amount of R"+withdrawAmount);
                    } else {
                        System.out.println("Insufficient funds.");
                    }
                    break;
                case 3:
                    // Deposit
                    System.out.println("How much would you like to deposit?");
                    int depositAmount = scanner.nextInt();
                    amount += depositAmount;
                    System.out.println("New available balance: " + amount);
                    transactionHistory.add("Deposited an amount of R"+depositAmount);
                    setBankBalance();
                    break;
                case 4:
                    // Transfer
                    System.out.println("Select recipient's user ID from the following list:");
                    for (String recipient : recipientList) {
                        System.out.println(recipient);
                    }
                    System.out.print("Enter recipient's user ID: ");
                    String recipientId = scanner.next();
                    if (!recipientList.contains(recipientId)) {
                        System.out.println("Recipient not found.");
                        break;
                    }
                    System.out.print("Enter amount to transfer: ");
                    int transferAmount = scanner.nextInt();
                    if (amount >= transferAmount) {
                        amount -= transferAmount;
                        setBankBalance();
                        System.out.println("Transfer successful. Remaining balance: " + amount);
                        transactionHistory.add("Transferred " + transferAmount + " to " + recipientId);
                    } else {
                        System.out.println("Insufficient balance.");
                    }
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }

            // Ask the user if they want to continue
            System.out.print("Do you want to continue? (yes/no): ");
            String choice = scanner.next();
            if (choice.equalsIgnoreCase("no")) {
                continueTransaction = false;
                System.out.println("Thank you for using Lesedi Bank ATM. Goodbye!");
                System.exit(0);
            } else if (choice.equalsIgnoreCase("yes")) {
                System.out.println("Please select an option:");
                System.out.println("1. Transaction History");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Transfer");
                System.out.println("5. Quit");
                option = scanner.nextInt();
            } else {
                System.out.println("Invalid choice. Exiting...");
                System.exit(0);
            }
        }
    }


}
