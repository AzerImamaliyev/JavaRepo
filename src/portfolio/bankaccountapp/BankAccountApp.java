package portfolio.bankaccountapp;

import java.util.ArrayList;
import java.util.List;

/* You are a back-end developer and need to create an application to handle new customer bank account requests.
 * 
 * Your application should do the following:
 * 
 * Read a .csv file of names, social security numbers, account type, and initial deposit
 * Use a proper data structure to hold all these accounts
 * Both savings and checking accounts share the following properties:
 * 
 * deposit()
 * withdraw()
 * transfer()
 * showInfo()
 * 
 * 11-Digit Account Number (generated with the following process: 
 * 1 or 2 depending on Savings or Checking, last two digits of SSN, unique 5-digit number, and random 3-digit number)
 * 
 * Savings Account holders are given a Safety Deposit Box, identified by a 3-digit number and accessed with a 4-digit code
 * Checking Account holders are assigned a Debit Card with a 12-digit number and 4-digit PIN
 * Both accounts will use an interface that determines the base interest rate.
 * Savings account will use .25 points less than the base rate
 * Checking accounts will use 15% of the base rate
 * The showInfo() method should reveal relevant account information as well as information specific to the Checking account 
 * or Savings account 
 */
public class BankAccountApp {

	public static void main(String[] args) {

		/*
		 * Checking chkAcc1 = new Checking("Azer Imamaliyev", "123456798", 1500); Saving
		 * svgAcc1 = new Saving("Fateh Imamaliyev", "987654321", 2500);
		 * 
		 * chkAcc1.showInfo(); svgAcc1.showInfo();
		 * 
		 * svgAcc1.compound(); svgAcc1.deposit(5000);
		 * 
		 * svgAcc1.withdraw(200); svgAcc1.transfer("Other account", 3000);
		 */

		// Read a CSV file then create new accounts based on that data
		ArrayList<Account> accounts = new ArrayList<Account>();

		// Read a CSV File, then create new accounts based on that data
		String file = "D:\\Books\\JAVA\\Codes\\PROJECTS\\NewBankAccounts.csv";
		List<String[]> newAccountHolders = CSV.read(file);
		for (String[] accountHolder : newAccountHolders) {
			String name = accountHolder[0];
			String sSN = accountHolder[1];
			String accountType = accountHolder[2];
			double initDeposit = Double.parseDouble(accountHolder[3]);

			// System.out.println(name + " " + sSN + " " + accountType + " " + "$" + initDeposit);

			if (accountType.equals("Savings")) {
				accounts.add(new Saving(name, sSN, initDeposit));
			} else if (accountType.equals("Checking")) {
				accounts.add(new Checking(name, sSN, initDeposit));
			} else {
				System.out.println("EROR READING ACCOUNT TYPE");
			}
		}

		for (Account acc : accounts) {
			acc.showInfo();
		}
	}

}
