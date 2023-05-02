package Com.sc;

public class Transaction {
    private String date;
    private String time;
    private String description;
    private String vendor;
    private double depositAmount;
    public Transaction(String date, String time, String description, String vendor, double addDepositAmount) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.depositAmount = addDepositAmount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getAddDepositAmount() {
        return depositAmount;
    }


    public void setAddDepositAmount(double addDepositAmount) {
        this.depositAmount = addDepositAmount;


    }
    @Override
    public String toString() {
        return "Transaction{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", description='" + description + '\'' +
                ", vendor='" + vendor + '\'' +
                ", addDepositAmount=" + depositAmount +
                '}';
    }
}
