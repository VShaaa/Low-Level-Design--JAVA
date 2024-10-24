package bankSys;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class BankAcc {
    private String ano;
    private String aholdername;
    private double balance;

    public BankAcc(String ano, String aholdername, double balance) {
        this.ano = ano;
        this.aholdername = aholdername;
        this.balance = balance;
    }

    public String getAno() {
        return ano;
    }

    public String getAholdername() {
        return aholdername;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        System.out.println("Enter amount to deposit: " + amount);
        if (amount > 0) {
            balance += amount;
            System.out.printf("Amount %.2f is deposited successfully. Current Balance is: %.2f%n", amount, balance);
        } else {
            System.out.println("Provided amount of deposit is invalid!");
        }
    }

    public void withdraw(double amount) {
        System.out.println("Enter the amount to withdraw: " + amount);
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("Amount %.2f is withdrawn successfully. Current Balance is: %.2f%n", amount, balance);
        } else {
            System.out.println("Withdraw does not process due to the invalid amount");
        }
    }
}

public class BankSystem {
    private static Map<String, BankAcc> accounts = new HashMap<>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("\nWelcome to online Banking!");
            System.out.println("1. Create Account");
            System.out.println("2. Already have account? Login");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Balance check");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = s.nextInt();
            s.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createAcc(s);
                    break;
                case 2:
                    login(s);
                    break;
                case 3:
                    deposit(s);
                    break;
                case 4:
                    withdraw(s);
                    break;
                case 5:
                    cBal(s);
                    break;
                case 6:
                    System.out.println("Thank you for using the online Banking!");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again");
            }
        }
    }

    private static void createAcc(Scanner s) {
        System.out.print("Enter Account Number: ");
        String ano = s.nextLine();
        System.out.print("Enter Account holder name: ");
        String aholdername = s.nextLine();
        System.out.print("Enter initial balance: ");
        double initbal = s.nextDouble();
        s.nextLine(); // Consume newline

        if (!accounts.containsKey(ano)) {
            BankAcc newAcc = new BankAcc(ano, aholdername, initbal);
            accounts.put(ano, newAcc);
            System.out.println("Account created successfully");
        } else {
            System.out.println("Account already exists.");
        }
    }

    private static void login(Scanner s) {
        System.out.print("Enter your account number to login: ");
        String ano = s.nextLine();
        if (accounts.containsKey(ano)) {
            System.out.println("Successfully logged in");
        } else {
            System.out.println("Account does not exist. Create account.");
        }
    }

    private static void deposit(Scanner s) {
        System.out.print("Enter Account number: ");
        String ano = s.nextLine();
        if (accounts.containsKey(ano)) {
            BankAcc acc = accounts.get(ano);
            System.out.print("Enter the deposit amount: ");
            double amount = s.nextDouble();
            s.nextLine(); // Consume newline
            acc.deposit(amount);
        } else {
            System.out.println("Account not found");
        }
    }

    private static void withdraw(Scanner s) {
        System.out.print("Enter Account number: ");
        String ano = s.nextLine();
        if (accounts.containsKey(ano)) {
            BankAcc acc = accounts.get(ano);
            System.out.print("Enter amount to withdraw: ");
            double amount = s.nextDouble();
            s.nextLine(); // Consume newline
            acc.withdraw(amount);
        } else {
            System.out.println("Account not found");
        }
    }

    private static void cBal(Scanner s) {
        System.out.print("Enter account number: ");
        String ano = s.nextLine();
        if (accounts.containsKey(ano)) {
            BankAcc acc = accounts.get(ano);
            System.out.println("Holder name: " + acc.getAholdername());
            System.out.printf("Current Balance: %.2f%n", acc.getBalance());
        } else {
            System.out.println("Account not found");
        }
    }
}
