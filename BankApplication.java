import java.util.Scanner;

public class BankApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=============================================");
        System.out.println("       ENTER BANK ACCOUNT DETAILS           ");
        System.out.println("=============================================");

        System.out.print("Enter Bank Name: ");
        String bankName = scanner.nextLine();

        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // Clear scanner buffer

        System.out.print("Enter User Name: ");
        String userName = scanner.nextLine();

        System.out.print("Enter Account Number: ");
        long accountNumber = scanner.nextLong();
        scanner.nextLine(); // Clear scanner buffer

        System.out.print("Enter Account Type: ");
        String accountType = scanner.nextLine();

        System.out.print("Enter Balance: ");
        double balance = scanner.nextDouble();
        scanner.nextLine(); // Clear scanner buffer

        // Initialize the bank account with user input
        Bank myBank = new Bank(bankName, userId, userName, accountNumber, accountType, balance);

        System.out.println("\n=============================================");
        System.out.println("       WELCOME TO THE BANKING SYSTEM        ");
        System.out.println("=============================================");

        boolean running = true;
        while (running) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Display Bank Details");
            System.out.println("2. Display User Details");
            System.out.println("3. Display Account Details");
            System.out.println("4. View Account Summary");
            System.out.println("5. Check Minimum Balance Status");
            System.out.println("6. Exit");
            System.out.print("Please enter your choice (1-7): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear scanner buffer

            System.out.println();
            switch (choice) {
                case 1:
                    System.out.println("--- Bank Details ---");
                    myBank.displayBankDetails();
                    break;
                case 2:
                    System.out.println("--- User Details ---");
                    myBank.displayUserDetails();
                    break;
                case 3:
                    System.out.println("--- Account Details ---");
                    myBank.displayAccountDetails();
                    break;
                case 4:
                    System.out.println("--- Account Summary ---");
                    System.out.println(myBank.createAccountSummary());
                    break;
                case 5:
                    System.out.print("Enter minimum balance to check: ");
                    double minBal = scanner.nextDouble();
                    scanner.nextLine(); // Clear scanner buffer
                    if (myBank.hasMinimumBalance(minBal)) {
                        System.out.println("Yes, account has minimum balance of " + minBal + ". Current balance: " + myBank.balance);
                    } else {
                        System.out.println("No, account does not have minimum balance of " + minBal + ". Current balance: " + myBank.balance);
                    }
                    break;
                case 6:
                    System.out.println("Thank you for using the Banking System. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please select an option between 1 and 7.");
            }
        }
        scanner.close();
    }
}