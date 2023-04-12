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
		String[] passwords = new String[13];
		boolean hasNumber;
		boolean hasLetter;
		boolean hasSpecialChar;
		boolean hasInvalidChar;

		BufferedReader br = new BufferedReader(new FileReader(file));

		for (int i = 0; i < 13; i++) {
			passwords[i] = br.readLine();

		}
		br.close();

		for (String password : passwords) {
			System.out.println(password);

			for (int k = 0; k < password.length(); k++) {
				if ("0123456789".contains(password.substring(k, k + 1))) {
					System.out.println("Position " + (k+1) + " contains number.");
				} else if ("abcdefghijklmnopqrstuvwxyz".contains(password.substring(k, k + 1))) {
					System.out.println("Position " + (k+1) + " contains letter.");
				} else if ("()!@#$%".contains(password.substring(k, k + 1))) {
					System.out.println("Position " + (k+1) + " contains special character.");
				} else {
					System.out.println("Position " + (k+1) + " contains invalid character.");
				}
			}
		}
	}

}