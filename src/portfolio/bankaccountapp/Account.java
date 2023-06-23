package portfolio.bankaccountapp;

import sun.security.util.Length;
import java.util.Random;

public abstract class Account implements IBaseRate {
	// List common properties for savings and checking accounts
	private String name;
	private String sSN;
	private double balance;
	private static int index = 10000;
	protected String accountNumber;
	protected double rate;

	// Constructor to set base properties and initialize the account
	public Account(String name, String sSN, double initDeposit) {
		this.name = name;
		this.sSN = sSN;
		balance = initDeposit;
		// System.out.println("Name: " + name + "; " + "SSN: " + sSN + "; " + "Balance:
		// " + initDeposit + ";");

		// Setting Account number
		index++;
		this.accountNumber = setAccountNumber();
		setRate();
	}

	public abstract void setRate();

	// Set Account number
	private String setAccountNumber() {
		String lastTwoOfSSN = sSN.substring(sSN.length() - 2, sSN.length());
		int uniqueID = index;

		// Generating random 3-digit number
		Random rand = new Random();
		int randomNumber = rand.nextInt(900) + 100;

		return lastTwoOfSSN + uniqueID + randomNumber;
	}

	public void compound() {
		double accuredInterest = balance * (rate / 100);
		balance += accuredInterest;
		System.out.println("Accrued Interest: $" + accuredInterest);
		printBalance();
	}

	// List common methods

	public void deposit(double amount) {
		balance += amount;
		System.out.println("Depositing $" + amount);
		printBalance();
	}

	public void withdraw(double amount) {

		balance -= amount;
		System.out.println("Withdrawing $" + amount);
		printBalance();
	}

	public void transfer(String toWhere, double amount) {
		balance -= amount;
		System.out.println("Transferring $" + amount + " to " + toWhere);
		printBalance();
	}

	public void printBalance() {
		System.out.println("Your balance is now: $" + balance);
	}

	public void showInfo() {
		System.out.println("***********************************");
		System.out.println(
				"Name: " + name + "\nAccount number: " + accountNumber + "\nBalance: " + balance + "\nRate: " + rate);

	}

}
