package portfolio;
import java.util.Scanner;

public class PaymentApp {

	public static void main(String[] args) {
		double payment = 0;
		boolean positivePayment = true;

		Scanner in = new Scanner(System.in);

		do {
			System.out.print("Enter the payment: ");

			try {
				payment = in.nextDouble();

				if (payment < 0) {
					throw new NegativePaymentException(payment);
				} else {
					positivePayment = true;
				}
			} catch (NegativePaymentException e) {
				System.out.println(e.toString());
				System.out.println("Please try again");
				positivePayment = false;
			}
		} while (!positivePayment);

		System.out.println("Thank you for your payment: $" + payment);
	}

}

class NegativePaymentException extends Exception {
	// Define class variable
	double payment;

	// Constructor that takes the value throw the exception
	// Assign that value to the class variable
	public NegativePaymentException(double payment) {
		this.payment = payment;
	}

	// Override the toString() method
	public String toString() {
		return "Error: Can't take negative number: " + payment;
	}
}