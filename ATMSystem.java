import java.util.ArrayList;
import java.util.Scanner;

public class ATMSystem {
    private static ArrayList<String> transactionHistory = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    static User activeUser;

    public static void main(String[] args) {
        transactionHistory.add("-200");
        transactionHistory.add("+5000");
        transactionHistory.add("-150");
        transactionHistory.add("+1200");
        transactionHistory.add("-450"); 
        System.out.println("Welcome! Register to get started:");
        registerNewUser();
        System.out.println("Proceed with login:");
        
        if (loginUser()) {
            System.out.println("Login successful!");
            showMenu();
        } else {
            System.out.println("Invalid credentials! Please try again.");
        }
    }

    static void registerNewUser() {
        System.out.print("Enter your full name: ");
        String name = input.nextLine();
        System.out.print("Create a PIN: ");
        String pin = input.nextLine();
        activeUser = new User(name, pin);
    }

    static boolean loginUser() {
        System.out.print("Enter your User ID: ");
        String userId = input.nextLine();
        System.out.print("Enter your PIN: ");
        String userPin = input.nextLine();
        return userId.equals(activeUser.getName()) && userPin.equals(activeUser.getPin());
    }

    private static void withdrawFunds() {
        System.out.print("Enter the amount to withdraw: ");
        int amount = input.nextInt();
        
        if (amount <= activeUser.getBalance()) {
            activeUser.updateBalance(-amount);
            System.out.println("Withdrawal successful. Amount: " + amount);
            System.out.println("New balance: " + activeUser.getBalance());
            transactionHistory.add("-" + amount);
        } else {
            System.out.println("Insufficient funds for this withdrawal.");
        }
    }

    private static void depositFunds() {
        System.out.print("Enter the amount to deposit: ");
        int amount = input.nextInt();
        
        if (amount > 0) {
            activeUser.updateBalance(amount);
            System.out.println("Deposit successful. Amount: " + amount);
            System.out.println("Updated balance: " + activeUser.getBalance());
            transactionHistory.add("+" + amount);
        } else {
            System.out.println("Invalid deposit amount entered.");
        }
    }

    private static void transferFunds() {
        System.out.print("Enter the 12-digit account number for transfer: ");
        String accountNumber = input.next();
        
        if (accountNumber.length() == 12) {
            System.out.print("Enter the amount to transfer: ");
            int amount = input.nextInt();
            
            if (amount > 0 && amount <= activeUser.getBalance()) {
                activeUser.updateBalance(-amount);
                System.out.println("Transfer successful. Amount: " + amount);
                System.out.println("New balance: " + activeUser.getBalance());
                transactionHistory.add("-" + amount);
            } else {
                System.out.println("Insufficient balance or invalid transfer amount.");
            }
        } else {
            System.out.println("Invalid account number.");
        }
    }

    private static void showTransactionHistory() {
        System.out.println("Your transaction history:");
        for (String record : transactionHistory) {
            System.out.println(record);
        }
    }

    static void showMenu() {
        int selection;
        do {
            System.out.println("------- ATM Menu -------");
            System.out.println("1. View Transaction History");
            System.out.println("2. Withdraw Funds");
            System.out.println("3. Deposit Funds");
            System.out.println("4. Transfer Funds");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            selection = input.nextInt();

            switch (selection) {
                case 1:
                    showTransactionHistory();
                    break;
                case 2:
                    withdrawFunds();
                    break;
                case 3:
                    depositFunds();
                    break;
                case 4:
                    transferFunds();
                    break;
                case 5:
                    System.out.println("Thank you for using our ATM services.");
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
                    break;
            }
        } while (selection != 5);
    }
}

class User {
    private String name;
    private String pin;
    private double balance;

    public User(String name, String pin) {
        this.name = name;
        this.pin = pin;
        this.balance = 5000; // Updated initial balance
    }

    public String getName() {
        return name;
    }

    public String getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public void updateBalance(double amount) {
        balance += amount;
    }
}

