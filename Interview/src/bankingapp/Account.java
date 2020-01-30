package bankingapp;

public abstract class Account implements IRate {

    private String name;
    private String SSN;
    protected String accountNumber;
    private double balance;
    protected double rate;
    private static int index = 10000;

    public Account(String name, String SSN, double initDeposit){
        this.name = name;
        this.SSN = SSN;
        this.balance = initDeposit;
        this.accountNumber = setAccountNumber();
        index++;
        setRate();
    }

    public abstract void setRate();

    private String setAccountNumber() {
        String lastTwoOfSSN = SSN.substring(SSN.length() - 2);
        int uniqueID = index;
        int randomNum = (int) (Math.random() * 1000);
        return lastTwoOfSSN + uniqueID + randomNum;
    }

    public String showInfo(){
        return "Name: " + name + "\nAccount number: " + accountNumber + "\nBalance: " + balance + "\nRate: " + rate +"%\n";
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("You deposited: $" +amount);
        printBalance();
    }

    public void withdraw(double amount) {
        balance -= amount;
        System.out.println("You withdrawn: $" + amount);
        printBalance();
    }

    public void transfer(String toWhere, double amount) {
        balance -= amount;
        System.out.println("Transfering $" + amount + " to " + toWhere);
        printBalance();
    }

    public void printBalance(){
        System.out.println("Your balance is: $" + balance);
    }

    public void compound() {
        double accruedInterest = balance * (rate / 100);
        balance += accruedInterest;
        System.out.println("Accrued interest: $" +accruedInterest);
    }



}
