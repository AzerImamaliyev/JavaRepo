package datastructures;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CsvOperation {

	public static void main(String[] args) {
		String fileName = "D:\\Books\\JAVA\\Codes\\PROJECTS\\CreditCard.csv";
		String dataRow;
		ArrayList<String[]> transactions = new ArrayList<String[]>();
		double balance = 0.0;

		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			while ((dataRow = br.readLine()) != null) {
				// parse the data by commas
				String[] line = dataRow.split(",");
				// Add the data to the collection
				transactions.add(line);
			}
			br.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("DATE | TRANSACTION | VENDOR | AMOUNT | BALANCE");

		for (String[] transaction : transactions) {
			String date = transaction[0];
			String type = transaction[1];
			String vendor = transaction[2];
			double amount = Double.parseDouble(transaction[3]);

			System.out.print(date + " | " + type + " | " + vendor + " |$" + amount);

			if (type.equalsIgnoreCase("credit")) {
				// System.out.println("Add to balance.");
				balance += amount;
			} else if (type.equalsIgnoreCase("debit")) {
				// System.out.println("Subtract from balance.");
				balance -= amount;
			} else {
				// System.out.println("Some other transaction");
			}

			System.out.println(" | $" + balance);

		}
		System.out.println("");

		System.out.println("Thanks for your payments.");

		if (balance > 0) {
			double fee = balance * 0.1;
			System.out.println("Your balance is: $" + balance);
			System.out.println("You're charged 10% fee: $" + fee);
			System.out.println("Your new balance is: $" + (balance + fee));
		} else if (balance < 0) {
			System.out.println("You have an overpayment: -$" + Math.abs(balance));
		}

	}

}
