package bankingapp;

public class Checking extends Account {

    private int debitCardNumber;
    private int debitCardPin;

    public Checking(String name, String SSN, double initDeposit) {
        super(name, SSN, initDeposit);
        accountNumber = "2" + accountNumber;
        setDebitCard();
    }

    @Override
    public void setRate() {
        rate = getBaseRate() * 0.15;
    }

    private void setDebitCard() {
        debitCardNumber = (int) (Math.random() * Math.pow(10, 12));
        debitCardPin = (int) (Math.random() * Math.pow(10, 4));
    }

    public String showInfo(){
        return "Account type: CHECKING\n" + "Debit Card number: " + debitCardNumber + "\nDebit Card PIN: " + debitCardPin + "\n" + super.showInfo();
    }
}
