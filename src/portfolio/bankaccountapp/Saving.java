package portfolio.bankaccountapp;

import java.util.Random;

public class Saving extends Account {
	// List properties to the specific Saving account
	private int safetyDepositBoxID;
	private int safetyDepositBoxKey;

	// Constructor to initialize Saving account properties
	public Saving(String name, String sSN, double initDeposit) {
		super(name, sSN, initDeposit);
		accountNumber = "1" + accountNumber;
		setSafetyDepositBox();
	}

	@Override
	public void setRate() {
		rate = getBaseRate() - .25;
	}

	// List any methods specific to the Saving account
	private void setSafetyDepositBox() {
		Random rand = new Random();
		safetyDepositBoxID = rand.nextInt(900) + 100;
		safetyDepositBoxKey = rand.nextInt(9000) + 1000;
	}

	public void showInfo() {
		super.showInfo();
		System.out.println("Your Saving Account features: " + "\n  Safety Deposit Box ID: " + safetyDepositBoxID
				+ "\n  Safety Deposit Box Key: " + safetyDepositBoxKey);
	}

}
