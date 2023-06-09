package portfolio.emailapp;

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

public class EmailApp {

	public static void main(String[] args) {
		Email email = new Email("Azer", "Imamaliyev");

		// Show User Info
		System.out.println(email.showInfo());
		System.out.println("**************************************************");

		// Setting and getting new password
		email.setNewPassword("Azer2023#");
		System.out.println("New password: " + email.getNewPassword());

		// Setting and getting alternate email
		email.setAlternateEMail("azer.imamaliyev@gmail.com");
		System.out.println("Alternate email: " + email.getAlternateEMail());

		// Setting and getting mailbox capacity
		email.setMailboxCapacity(850);
		System.out.println("Updated mailbox capacity: " + email.getMailboxCapacity() + "MB");

	}

}
