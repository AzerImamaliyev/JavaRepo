package portfolio;

public class BankAccountApp {

	public static void main(String[] args) {
		BankAccount acc1 = new BankAccount("123456789", 1000);
		BankAccount acc2 = new BankAccount("987654321", 2000);
		BankAccount acc3 = new BankAccount("543219876", 3000);

		acc1.setName("Azer");
		System.out.println(acc1.getName());
		acc1.makeDeposit(500);
		acc1.showBalance();
		acc1.makeDeposit(600);
		acc1.showBalance();
		acc1.payBill(1000);
		acc1.showBalance();
		acc1.accrue();
		System.out.println(acc1.toString());
	}

}

class BankAccount implements IInterest {
	// Properties of bank account

	private static int id = 1000; // Internal ID
	private String accountNumber; // ID + random 2-digit number + first 2 of SSN
	private static final String routingNumber = "005400657";
	private String name;
	private String SSN;
	private double balance;

	// Constructors
	public BankAccount(String SSN, double initDeposit) {
		// System.out.println("New account created");
		balance = initDeposit;
		this.SSN = SSN;
		id++;
		// System.out.println(id);
		setAccountNumber();
	}

	private void setAccountNumber() {
		int random = (int) (Math.random() * 100);
		// System.out.println(random);
		accountNumber = id + "" + random + SSN.substring(0, 2);
		System.out.println("Your account number: " + accountNumber);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void payBill(double amount) {
		System.out.println("Paying bill is: " + amount);
		balance = balance - amount;

	}

	public void makeDeposit(double amount) {
		System.out.println("Making deposit: " + amount);
		balance = balance + amount;
	}

	public void showBalance() {
		System.out.println("Your balance is: " + balance);
	}

	// @Override
	public void accrue() {
		balance = balance * (1 + rate / 100);
		showBalance();
	}

	@Override
	public String toString() {
		return "[Name: " + name + "]\n[AccountNumber: " + accountNumber + "]\n[RoutingNumber: " + routingNumber
				+ "]\n[Balance: " + balance + "]";
	}
}