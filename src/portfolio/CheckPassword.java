package portfolio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import sun.security.util.Password;

public class CheckPassword {

	public static void main(String[] args) throws IOException {
		String filename = "passwords.txt";
		File file = new File(filename);
		String[] passwords = new String[14];

		BufferedReader br = new BufferedReader(new FileReader(file));

		for (int i = 0; i < 14; i++) {
			passwords[i] = br.readLine();

		}
		br.close();

		for (String password : passwords) {
			System.out.println("*****************\n" + password);

			boolean hasNumber = false;
			boolean hasLetter = false;
			boolean hasSpecialChar = false;
			boolean hasInvalidChar = false;

			for (int k = 0; k < password.length(); k++) {
				if ("0123456789".contains(password.substring(k, k + 1))) {
					hasNumber = true;
					// System.out.println("Position " + (k + 1) + " contains number.");
				} else if ("abcdefghijklmnopqrstuvwxyz".contains(password.substring(k, k + 1).toLowerCase())) {
					hasLetter = true;
					// System.out.println("Position " + (k + 1) + " contains letter.");
				} else if ("!@#$%^&*()-_=+".contains(password.substring(k, k + 1))) {
					hasSpecialChar = true;
					// System.out.println("Position " + (k + 1) + " contains special character.");
				} else {
					hasInvalidChar = true;
					// System.out.println("Position " + (k + 1) + " contains invalid character.");
				}
			}

			if (hasInvalidChar) {
				System.out.println("Invalid character");
			} else if (!hasNumber || !hasLetter || !hasSpecialChar) {
				System.out.println("Missing criteria");
			} else if (hasNumber || !hasLetter || !hasSpecialChar) {
				System.out.println("Valid password");
			}

		}

	}
}