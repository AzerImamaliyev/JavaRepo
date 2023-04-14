package datastructures;

public class Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] alphabet = { "a", "b", "c", "d", "e", "f" };
		int size = alphabet.length;

		for (int i = 0; i < size; i++) {
			System.out.print(alphabet[i] + " ");
		}

		System.out.println("\n\n***********\n");

		for (String letter : alphabet) {
			System.out.print(letter + " ");
		}

		System.out.println("\n\nMulti-dimension Array");
		String[][] users = { { "Azer", "Imamaliyev", "azerim@java.com", "654564654" },
				{ "Leyla", "Imamaliyeva", "layla@java.com", "231321231" },
				{ "Fateh", "Imamaliyev", "fateh@java.com", "987987987" } };

		int numOfUsers = users.length;
		int numOfFields = users[0].length;

		System.out.println("Number of users: " + numOfUsers);
		System.out.println("Number of fields: " + numOfFields);

		for (int i = 0; i < numOfUsers; i++) {
			String firstName = users[i][0];
			String lastName = users[i][1];
			String mail = users[i][2];
			String phone = users[i][3];
			System.out.println(
					"First name: " + firstName + "  Last name: " + lastName + "  Mail: " + mail + "  Phone: " + phone);

		}

		System.out.println("\n**********************************************\n");

		for (String[] user : users) {
			System.out.print("[ ");
			for (String field : user) {
				System.out.print(field + " ");
			}
			System.out.println("]");
		}

		System.out.println("\n**********************************************\n");

		for (int i = 0; i < numOfUsers; i++) {
			for (int j = 0; j < numOfFields; j++) {
				System.out.print(users[i][j] + " ");
			}
			System.out.println("\n");
		}

		String[][] matrix = { { "a", "b", "c" }, { "e", "f", "g" }, { "h", "i", "j" } };

		for (String[] list : matrix) {
			for (int i = list.length - 1; i >= 0; i--) {
				System.out.print(list[i]); // cbagfejih
			}
		}

	}

}
