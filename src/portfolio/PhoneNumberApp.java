package portfolio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PhoneNumberApp {

	public static void main(String[] args) throws IOException {
		String filename = "numbers.txt";
		File file = new File(filename);

		BufferedReader br = new BufferedReader(new FileReader(file));

		String phoneNumber = br.readLine();
		br.close();

		if (phoneNumber.length() == 12) {
			System.out.println(phoneNumber);
		} else {
			System.out.println("Phone number is not correct: " + phoneNumber);
		}
	}

}
