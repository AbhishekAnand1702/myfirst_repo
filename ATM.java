import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int accountNumber = 123456;
        int pin = 1702;
        double balance = 5000;

        int userAcc, userPin;
        int tries = 0;
        boolean isLoggedIn = false;

        System.out.println("Welcome to Simple ATM!");

        // Login check
        while (tries < 3) {
            System.out.print("Enter Account Number: ");
            userAcc = sc.nextInt();

            System.out.print("Enter PIN: ");
            userPin = sc.nextInt();

            if (userAcc == accountNumber && userPin == pin) {
                isLoggedIn = true;
                break;
            } else {
                System.out.println("Wrong details! Try again.");
                tries++;
            }
        }

        if (!isLoggedIn) {
            System.out.println("Too many attempts. Exiting...");
            return;
        }

        int choice;
        do {
            System.out.println("\n---- ATM Menu ----");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your balance is: Rs. " + balance);
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: Rs. ");
                    double deposit = sc.nextDouble();
                    if (deposit > 0) {
                        balance = balance + deposit;
                        System.out.println("Money deposited successfully!");
                    } else {
                        System.out.println("Invalid amount.");
                    }
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: Rs. ");
                    double withdraw = sc.nextDouble();
                    if (withdraw > 0 && withdraw <= balance) {
                        balance = balance - withdraw;
                        System.out.println("Please collect your cash.");
                    } else {
                        System.out.println("Not enough balance or wrong amount.");
                    }
                    break;

                case 4:
                    System.out.println("Thank you! Visit again.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 4);

        sc.close();
    }
}
