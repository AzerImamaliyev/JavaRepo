package portfolio.primenumbers;

public class PrimeNumbers {

	public static void main(String[] args) {
		checkIfPrime(27);
	}
	
	// Method for checking if the number is prime
	private static void checkIfPrime(int num) {
		int reminderCounter = 0;
		String message = " is a prime number";
		for (int i = 1; i <= num; i++) {

			if (num % i == 0) {
				reminderCounter++;
			}

			if (reminderCounter > 2) {
				message = " is not a prime number";
				break;
			}

		}

		System.out.println(num + "" + message);

	}

}
