package Com.sc;
import java.io.*;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class LedgerSync {
    static ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    static Scanner scanner = new Scanner(System.in);
//    static LocalDateTime today = LocalDateTime.now();




    public static void main(String[] args) {

        loadReports();
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
                    deposit();
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

        } while(!input.equalsIgnoreCase("X"));
}
    public static void loadReports(){}

    public static void deposit() {
        System.out.println("Please provide deposit information below:");

        System.out.println("Date of deposit (mm-dd-yyyy): ");
        String date = scanner.nextLine();

        System.out.println("Time of deposit (HH:mm:ss): ");
        String time = scanner.nextLine();

        System.out.println("Deposit Description: ");
        String description = scanner.nextLine();

        System.out.println("Vendor of name: ");
        String vendor = scanner.nextLine();

        System.out.println("Amount:");
        double depositAmount = scanner.nextDouble();

        Transaction newTransaction = new Transaction(date, time, description, vendor, depositAmount);

        transactions.add(newTransaction);
        try{
            FileWriter fileWriter = new FileWriter("./src/main/java/com/sc/transactions.txt", true );
            fileWriter.write("\n" + date + "|" + time + "|" + description + "|" + vendor + "|" + depositAmount);
            fileWriter.close();
        }catch (IOException e){
            System.out.println("Error: Please try again.");
        }

        System.out.println("Transaction added.");
    }

    public static void makePayment() {
        System.out.println("Please provide payment information below:");

        System.out.println("Date of payment (mm-dd-yyyy): ");
        String date = scanner.nextLine();

        System.out.println("Time of payment (HH:mm:ss): ");
        String time = scanner.nextLine();

        System.out.println("Payment Description: ");
        String description = scanner.nextLine();

        System.out.println("Name of vendor: ");
        String vendor = scanner.nextLine();

        System.out.print("Amount of Payment: " );
        double depositAmount = scanner.nextDouble();
        double negativeDepositAmount = depositAmount * -1;
        System.out.println("Total amount paid: " + negativeDepositAmount);

        Transaction newTransaction = new Transaction(date, time, description, vendor, depositAmount);

        transactions.add(newTransaction);
        try{
            FileWriter fileWriter = new FileWriter("./src/main/java/com/sc/transactions.txt", true );
            fileWriter.write("\nPayment: " + date + "|" + time + "|" + description + "|" + vendor + "|" + negativeDepositAmount);
            fileWriter.close();
        }catch (IOException e){
            System.out.println("Error: Please Try Again");
        }


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
                case "A" -> {
                    displayAllDEntries();
                    System.out.println("All entries:");
                }
                case "D" -> {
                    displayDeposit();
                    System.out.println("All deposits:");
                }
                case "P" -> {
                    displayPayments();
                    System.out.println("All payments:");
                }
                case "R" -> cascadingMenu();
                case "H" -> System.out.println("Exiting to home screen.");
                default -> System.out.print("Invalid input");
            }

        } while(!subInput.equalsIgnoreCase("H"));
    }
    public static void displayAllDEntries() {
        {
            try {
                FileReader transactionFile = new FileReader("./src/main/java/com/sc/transactions.txt");
                BufferedReader bufferedReader = new BufferedReader(transactionFile);

                String input;
                while((input=bufferedReader.readLine()) !=null){
                    System.out.println(input);

                }
                bufferedReader.close();
            } catch (IOException e) {

                e.printStackTrace();
            }

        }
    }
    public static void displayDeposit(){
        {
            try {
                FileReader transactionFile = new FileReader("./src/main/java/com/sc/transactions.txt");
                BufferedReader bufferedReader = new BufferedReader(transactionFile);

                String input;
                while((input=bufferedReader.readLine()) !=null){
                        System.out.println(input);

                }
                bufferedReader.close();
            } catch (IOException e) {

                e.printStackTrace();
            }

        }
    }
    public static void displayPayments(){}

    public static void cascadingMenu() {
        String cascadeInput;
        do {
            System.out.println("Search reports by: ");
            System.out.println("\t1) Month to Date.");
            System.out.println("\t2) Previous Month.");
            System.out.println("\t3) Year To Date.");
            System.out.println("\t4) Previous Year.");
            System.out.println("\t5) Vendor.");
            System.out.println("\t0) Back to Report screen");

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
        }while(!cascadeInput.equalsIgnoreCase("0"));

    }

    public static void monthToDate(){

        FileReader transactionFile = null;
        try {
            transactionFile = new FileReader("./src/main/java/com/xd/transactions.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BufferedReader bufferedReader = new BufferedReader(transactionFile);
        String input;
        try {
            input = bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] splitInput = input.split(Pattern.quote("|"));
        String timeInput = splitInput[0];
        String dateInput = splitInput[1];
        String descriptionInput = splitInput[2];
        String vendorInput = splitInput[3];
        double depositAmountInput = Double.parseDouble(splitInput[4]);
        Transaction currentTransaction = new Transaction(timeInput, dateInput, descriptionInput, vendorInput, depositAmountInput);
        System.out.printf("Transaction: %s, %s, %s, %s, $%.2f\n",
                currentTransaction.getTime(),
                currentTransaction.getDate(),
                currentTransaction.getDescription(),
                currentTransaction.getVendor(),
                currentTransaction.getDeposit()
        );
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dateTime = dateInput + " " + timeInput;
        LocalDateTime transactionDateTime = LocalDateTime.parse(dateTime, dateTimeFormatter);
        LocalDateTime now = LocalDateTime.now();

//        try {
//            FileReader transactionFile = new FileReader("./src/main/java/com/sc/transactions.txt");
//            BufferedReader bufferedReader = new BufferedReader(transactionFile);
//
//            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-DD HH:mm:ss");
//            LocalDateTime transactionDateTime = LocalDateTime.parse(dateTime, dateTimeFormatter);
//
//            LocalDateTime now = LocalDateTime.now();
//            int currentYear = now.getYear();
//            int currentMonth = now.getMonthValue();
//
//            int transactionYear = transactionDateTime.getYear();
//            int transactionMonth = transactionDateTime.getMonthValue();
//
//            if(currentYear == transactionYear && currentMonth == transactionMonth){
//                System.out.println("Magic");
//            }
//
//            bufferedReader.close();
//        }catch (IOException e){
//            e.printStackTrace();
//        }

    }
    public static void previousMonth(){}
    public static void yearToDate(){}
    public static void previousYear(){}
    public static void vendor(){}



}


