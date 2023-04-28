package portfolio;

import java.util.Scanner;

import oracle.jrockit.jfr.tools.ConCatRepository;

public class Guests {

	static String[] guests = new String[10];
	static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {

		insertTestNames();

		do {
			displayGuests();

			displayMenu();

			int option = getOption();

			if (option == 1) {

				addGuest();

			} else if (option == 2) {

				insertGuest();

			} else if (option == 3) {

				renameGuest();

			} else if (option == 4) {

				removeGuest();

			} else if (option == 5) {
				System.out.println("Thank you for choosing our app.");
				break;
			}
			System.out.println();
		} while (true);

	}

	static void displayGuests() {
		System.out.println("-----------------------\n       - Guests -");
		System.out.println("-----------------------");

		boolean isEmpty = true;

		for (int i = 0; i < guests.length; i++) {
			// System.out.println((i + 1) + ". " + (guests[i] == null ? "--" : guests[i]));
			if (guests[i] != null) {
				System.out.println((i + 1) + ". " + guests[i]);
				isEmpty = false;
			}
		}

		if (isEmpty) {
			System.out.println("Guest list is empty");
		}
	}

	static void displayMenu() {
		System.out.println("-----------------------\n        - Menu -");
		System.out.println("-----------------------");
		System.out.println("1 - Add guest");
		System.out.println("2 - Insert guest");
		System.out.println("3 - Rename guest");
		System.out.println("4 - Remove guest");
		System.out.println("5 - Exit");
		System.out.println("-----------------------\n");
	}

	static int getOption() {
		System.out.print("Option: ");
		int option = keyboard.nextInt(); // num\n
		keyboard.nextLine();
		System.out.println();
		return option;
	}

	static void addGuest() {
		for (int i = 0; i < guests.length; i++) {
			if (guests[i] == null) {
				System.out.print("Name: ");
				String name = keyboard.nextLine();
				guests[i] = name;
				break;
			}

		}
	}

	static void insertGuest() {

		System.out.print("Number: ");
		int num = keyboard.nextInt();
		keyboard.nextLine();

		if (num >= 1 && num <= guests.length && guests[num - 1] != null) {

			System.out.print("Name: ");
			String newName = keyboard.nextLine();

			for (int i = guests.length - 1; i > num - 1; i--) {
				guests[i] = guests[i - 1];
			}
			guests[num - 1] = newName;

		} else {
			System.out.println("\nError: There is no guest with that number.");
		}
	}

	static void renameGuest() {
		System.out.print("Number: ");
		int num = keyboard.nextInt();
		keyboard.nextLine();
		System.out.println();

		if (num >= 1 && num <= guests.length && guests[num - 1] != null) {

			System.out.print("Name: ");
			String newName = keyboard.nextLine();

			guests[num - 1] = newName;

		} else {
			System.out.println("\nError: There is no guest with that number.");
		}
	}

	static void removeGuest() {
		/*
		 * System.out.print("Name: "); String name = keyboard.next(); for (int i = 0; i
		 * < guests.length; i++) {
		 * 
		 * if (guests[i] != null && guests[i].equalsIgnoreCase(name)) { guests[i] =
		 * null; break; } }
		 */

		System.out.print("Number: ");
		int num = keyboard.nextInt();

		if (num >= 1 && num <= guests.length && guests[num - 1] != null) {
			guests[num - 1] = null;

			String[] tempGuests = new String[guests.length];
			int tempIndex = 0;

			for (int i = 0; i < guests.length; i++) {
				if (guests[i] != null) {
					tempGuests[tempIndex] = guests[i];
					tempIndex++;
				}
			}
			guests = tempGuests;
		} else {
			System.out.println("\nError: There is no guest with that number.");

		}
	}

	static void insertTestNames() {
		guests[0] = "Jacob Hughes";
		guests[1] = "Edward Jones";
		guests[2] = "Frank Morgan";
	}
}