package portfolio.emailapp;

import java.util.Scanner;

/*
 * Email Application
 * 
 * Scenario: You are an IT Support Administrator Specialist and are 
 * charged with the task of creating email accounts for new hires.
 * Your application should do the following:
 * 
 * Generate an email with the following syntax: firstname.lastname@department.company.com
 * Determine the department (sales, development, accounting), if none leave blank
 * Generate a random String for a password
 * Have set methods to change the password, set the mailbox capacity, and define an alternate email address
 * Have get methods to display the name, email, and mailbox capacity
 * 
*/
public class Email {

	private String firstName;
	private String lastName;
	private String password;
	private int defaultPasswordLength = 10;
	private String email;
	private String alternateEMail;
	private int mailboxCapacity = 500;
	private String companySuffix = "java.com";
	private String department;

	// Constructor to receive the first name and the last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;

		// Call a method asking for the department - return the department
		this.department = setDepartment();
		System.out.println("**************************************************");
		System.out.println("Department: " + this.department);

		// Call a method that returns a random password
		this.password = setRandomPassword(defaultPasswordLength);
		System.out.println("Random password: " + this.password);

		// Combine elements to generate an email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
		//System.out.println("Your email is: " + email);
	}

	// Ask for the department
	private String setDepartment() {
		System.out
				.print("***Department codes***\n1.Sales\n2.Development\n3.Accounting\n0.None\nEnter the department: ");
		Scanner keyboard = new Scanner(System.in);

		int deptChoice = keyboard.nextInt();

		if (deptChoice == 1) {
			return "sales";
		} else if (deptChoice == 2) {
			return "dev";
		} else if (deptChoice == 3) {
			return "acct";
		} else {
			return "";
		}
	}

	// Generate a random password
	private String setRandomPassword(int length) {
		String passwordUpperCharSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String passwordLowerCharSet = passwordUpperCharSet.toLowerCase();
		String passwordNumberSet = "0123456789";
		String passwordSpecialCharSet = "!@#$%^&";
		String passwordSet = passwordUpperCharSet + passwordLowerCharSet + passwordNumberSet + passwordSpecialCharSet;
		char[] password = new char[length];

		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}

		return new String(password);
	}

	// Set the mailbox capacity
	public void setMailboxCapacity(int mailboxCapacity) {
		this.mailboxCapacity = mailboxCapacity;
	}

	// Set the alternate email
	public void setAlternateEMail(String alternateEMail) {
		this.alternateEMail = alternateEMail;
	}

	// Change the password
	public void setNewPassword(String newPassword) {
		this.password = newPassword;
	}

	// Retrieving alternate mail address
	public String getAlternateEMail() {
		return this.alternateEMail;
	}

	// Retrieving mailbox capacity
	public int getMailboxCapacity() {
		return this.mailboxCapacity;
	}

	// Retrieving new password
	public String getNewPassword() {
		return this.password;
	}

	public String showInfo() {
		System.out.println("**************************************************");
		return "Dsiplay Name: " + this.firstName + " " + this.lastName + "\nCompany email: " + this.email
				+ "\nMailbox Capacity: " + this.mailboxCapacity + "MB";

	}
}
