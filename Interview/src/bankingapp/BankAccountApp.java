package bankingapp;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {

    public static void main(String[] args) {
        /*Checking chkacc1 = new Checking("Paul Newman", "12463466", 1500);

        Savings svacc1 = new Savings("Kanye West", "844392234", 2400);

        System.out.println(chkacc1.showInfo());
        System.out.println(svacc1.showInfo());

        Checking chkacc2 = new Checking("Kyle Someone", "56432344", 6000);
        Checking chkacc3 = new Checking("Kylie Chino", "94859938", 500);

        System.out.println(chkacc2.showInfo());
        System.out.println(chkacc3.showInfo());

        svacc1.compound();
        svacc1.printBalance();
        */
        List<Account> accountList = new LinkedList<Account>();
        String file = "NewBankAccounts.csv";
        List<String[]> newAccounts = utilities.CSV.read(file);

        for (String[] accounts : newAccounts) {
            String name = accounts[0];
            String SSN = accounts[1];
            String accountType = accounts[2];
            double initDeposit = Double.parseDouble(accounts[3]);
            System.out.println("NEW ACCOUNT: " + name + "\nSocial Security Number: " + SSN + "\nAccount type: " + accountType + "\nAmount: " + initDeposit + "\n");

            if (accountType.equals("Savings")) {
                accountList.add(new Savings(name, SSN, initDeposit));
                System.out.println("Open a savings account");
            } else if (accountType.equals("Checking")) {
                accountList.add(new Checking(name, SSN, initDeposit));
                System.out.println("Open a checking account");
            } else {
                System.out.println("Error reading account type");
            }
        }

        for (Account acc : accountList) {
            System.out.println(acc.showInfo());
        }

    }
}
