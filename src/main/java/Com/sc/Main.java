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
                    diplaysLedgerScreen();
                    break;
                case "4":
                    System.out.println("Exiting");
            }
        } while(!input.equalsIgnoreCase("4"));
}
    public static void homeScreen(){

    }
    public static void addDeposit(){

    }
}


