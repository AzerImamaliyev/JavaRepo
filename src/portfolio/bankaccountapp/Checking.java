package portfolio.bankaccountapp;

import java.util.Random;

public class Checking extends Account {
	// List properties to the specific Checking account
	private long debitCardNumber;
	private int debitCardPIN;

	// Constructor to initialize Checking account properties
	public Checking(String name, String sSN, double initDeposit) {
		super(name, sSN, initDeposit);
		accountNumber = "2" + accountNumber;

		setDebitCard();
	}

	@Override
	public void setRate() {
		rate = getBaseRate() * 0.15;
	}

	private void setDebitCard() {
		Random rand = new Random();
		debitCardNumber = (long) (Math.random() * Math.pow(10, 12));
		debitCardPIN = rand.nextInt(9000) + 1000;
	};

	// List any methods specific to the Checking account

	public void showInfo() {
		super.showInfo();
		System.out.println("Your Checking Account features: " + "\n  Debit Card Number: " + debitCardNumber
				+ "\n  Debit Card Pin: " + debitCardPIN);
	}

}
