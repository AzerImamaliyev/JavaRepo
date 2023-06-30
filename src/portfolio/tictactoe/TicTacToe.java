package portfolio.tictactoe;

import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {

		char[] pos = new char[9]; // Array creation with 9 elements
		char turn = 'X'; // Game start with 'X'
		int input; // Arrays elements' position
		int currentTurn = 1; // Laps count
		Scanner keyboard = new Scanner(System.in); // Scanner object

		while (true) {
			do {
				System.out.print("Enter a position: ");
				input = keyboard.nextInt();
			} while (pos[input - 1] == 'X' || pos[input - 1] == 'O');
			pos[input - 1] = turn;
			System.out.println("+---+---+---+");
			System.out.println("| " + pos[0] + " | " + pos[1] + " | " + pos[2] + " |");
			System.out.println("+---+---+---+");
			System.out.println("| " + pos[3] + " | " + pos[4] + " | " + pos[5] + " |");
			System.out.println("+---+---+---+");
			System.out.println("| " + pos[6] + " | " + pos[7] + " | " + pos[8] + " |");
			System.out.println("+---+---+---+");

			if ((pos[0] == turn && pos[1] == turn && pos[2] == turn) // checking the first row
					|| (pos[3] == turn && pos[4] == turn && pos[5] == turn) // checking the second row
					|| (pos[6] == turn && pos[7] == turn && pos[8] == turn) // checking the third row
					|| (pos[0] == turn && pos[3] == turn && pos[6] == turn) // checking the first column
					|| (pos[1] == turn && pos[4] == turn && pos[7] == turn) // checking the second column
					|| (pos[2] == turn && pos[5] == turn && pos[8] == turn) // checking the third column
					|| (pos[0] == turn && pos[4] == turn && pos[8] == turn) // checking the first diagonal
					|| (pos[2] == turn && pos[4] == turn && pos[6] == turn)) // checking the second column
			{
				System.out.println("***" + turn + " is the WINNER***");
				break; // End the game
			}

			if (turn == 'X') {
				turn = 'O';
			} else if (turn == 'O') {
				turn = 'X';
			}

			currentTurn++;

			if (currentTurn > 9) {
				System.out.println("*** DRAW ***");
				break; // End the game
			}
		}
	}

}
