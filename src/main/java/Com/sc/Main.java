package Com.sc;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;
//import java.IOException;
import java.util.ArrayList;
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Transaction> transactions = new ArrayList<Transaction>();

    public static void main(String[] args) {

        homeScreen();
        String input;
        do{
            System.out.println("Welcome to the Accounting Ledger. Please choose an option below:");
            System.out.println("\t 1) Add Deposit.");
            System.out.println("\t 2) Make Payment.");
            System.out.println("\t 3) Ledger");
            System.out.println("\t 4) Exit.");
            System.out.println("Command");

            input = scanner.nextLine();

            switch (input) {
                case "1":
                    addDeposit();
                    break;
                case "2":
                    makePayment();
                    break;
                case "3":
                    displayLedgerScreen();
                    break;
                case "4":
                    System.out.println("Exiting");
            }
        } while(!input.equalsIgnoreCase("4"));
}
    public static void homeScreen(){


    }
    public static void addDeposit() {
        System.out.println("Please provide deposit information below:");

        System.out.println("Date of deposit:");
        String date = scanner.nextLine();

        System.out.println("Time of deposit:");
        String time = scanner.nextLine();

        System.out.println("Deposit Description:");
        String description = scanner.nextLine();

        System.out.println("");
        String vendor = scanner.nextLine();

        System.out.println( );
        Double depositAmount = scanner.nextDouble();

        Transaction newTransaction = new Transaction(date, time, description, vendor, depositAmount);

        transactions.add(newTransaction);

        System.out.println("Transaction added.");
    }

    public static void makePayment() {
        System.out.println("Please provide payment information below:");

        System.out.println("Date of payment:");
        String date = scanner.nextLine();

        System.out.println("Time the payment was done:");
        String time = scanner.nextLine();

        System.out.println("payment Description:");
        String description = scanner.nextLine();

        System.out.println("Name of vendor");
        String vendor = scanner.nextLine();

        System.out.println( );
        Double depositAmount = scanner.nextDouble();

        Transaction newTransaction = new Transaction(date, time, description, vendor, depositAmount);

        transactions.add(newTransaction);

        System.out.println("Payment added.");

    }

    public static void displayLedgerScreen() {
        String input;
//        do {
//            System.out.println("Please choose command:");
//            System.out.println("\t1) Display all entries.");
//            System.out.println("\t2) Display deposits only.");
//            System.out.println("\t3) Display payments only.");
//            System.out.println("\t4) Cost");
//        }


    }
}


