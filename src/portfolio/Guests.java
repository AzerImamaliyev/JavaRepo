package portfolio;

import java.util.Scanner;

public class Guests {

	public static void main(String[] args) {

		String[] guests = new String[10];
		Scanner keyboard = new Scanner(System.in);

		guests[0] = "Jacob";
		guests[1] = "Edward";
		guests[2] = "Frank";

		do {
			System.out.println("1 - Display all guests");
			System.out.println("2 - Add guest");
			System.out.println("3 - Remove guest");
			System.out.println("4 - Exit");
			System.out.print("Option: ");
			int option = keyboard.nextInt();
			System.out.println();

			if (option == 1) {
				for (String guest : guests) {
					System.out.println(guest);
				}
			} else if (option == 2) {
				for (int i = 0; i < guests.length; i++) {
					if (guests[i] == null) {
						System.out.print("Name: ");
						String name = keyboard.next();
						guests[i] = name;
						break;

					}
				}

			} else if (option == 3) {
				System.out.print("Name: ");
				String name = keyboard.next();
				for (int i = 0; i < guests.length; i++) {

					if (guests[i] != null && guests[i].equals(name)) {
						guests[i] = null;
					}

				}

			} else if (option == 4) {
				System.out.println("Thank you for choosing our app.");
				break;
			}
			System.out.println();
		} while (true);

	}

}
