package Com.sc;
import java.awt.*;
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
            System.out.println("\tD) Add Deposit.");
            System.out.println("\tP) Make Payment.");
            System.out.println("\tL) Ledger");
            System.out.println("\tX) Exit.");
            System.out.println("Command");

            input = scanner.nextLine();

            switch (input) {
                case "D":
                    addDeposit();
                    break;
                case "P":
                    makePayment();
                    break;
                case "L":
                    displayLedgerScreen();
                    break;
                case "X":
                    System.out.println("Exiting");
                default:
                    System.out.print("Invalid input");
                    break;
            }

        } while();
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

        System.out.println();
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
        String subInput;
        do {
            System.out.println("Please choose a command:");
            System.out.println("\tA) Display all entries.");
            System.out.println("\tD) Display deposits only.");
            System.out.println("\tP) Display payments only.");
            System.out.println("\tR) Search by other options");
            System.out.println("\tH) Home menu.");

            subInput = scanner.nextLine();

            switch (subInput.toUpperCase()) {
                case "A":
                    displayAllDEntries();
                    System.out.println("All entries:");
                    break;
                case "D":
                    addDeposit();
                    System.out.println("All deposits:");
                    break;
                case "P":
                    makePayment();
                    System.out.println("All payments:");
                    break;
                case "R":
                    cascadingMenu();
                    break;
                case "H":
                    System.out.println("Exiting to home screen.");
                    break;
                default:
                    System.out.print("Invalid input");
                    break;

            }

        } while ();
    }
    public static void cascadingMenu() {
        String cascadeInput;
        do {
            System.out.print("Search reports by: ");
            System.out.print("\t1) Month to Date.");
            System.out.print("\t2) Previous Month.");
            System.out.print("\t3) Year To Date.");
            System.out.print("\t4) Previous Year.");
            System.out.print("\t5) Vendor.");
            System.out.print("\t0) Back to Report screen");

            cascadeInput = scanner.nextLine();
            switch(cascadeInput) {
                case "1":
                    monthToDate();
                    System.out.print("All transaction month to date");
                    break;
                case "2":
                    previousMonth();
                    System.out.print("Transaction report by previous month:");
                    break;
                case "3":
                    yearToDate();
                    System.out.println("Transactions year to date");
                    break;
                case "4":
                    previousYear();
                    System.out.println("Transactions from previous year.");
                    break;
                case "5":
                    vendor();
                    System.out.println("Transactions by vendor.");
                    break;
                case "0":
                    System.out.println("Back to Report Screen");
                default:
                    System.out.println("Invalid input.");
                    break;
            }
        }while(cascadeInput.equalsIgnoreCase("5"));

    }
    public static void displayAllDEntries() {}


}


