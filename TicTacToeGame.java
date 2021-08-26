package com.tictactoe;

public class TicTacToeGame {
	private char[] board = new char[10];
	private char userOption;
	private char computerOption;


	public void createBoard() {

		for (int i = 1; i <=10; i++) {
			board[i] = ' ';
		}

	}

	/*
	 * UseCase 2 - To allow a player to choose X or O
	 * 
	 * userOption is allows the user to choose if he wants to play as X and O.
	 * 
	 *  computerOption automatically allows it to choose the other team opposite to what user has selected
	 */
	public void chooseOption() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter if you want to choose X or O: ");
		userOption = sc.next().charAt(0);
		if (userOption == 'X' || userOption == 'x') {
			userOption = 'X';
			computerOption = 'O';
			System.out.println("Player Team: " + userOption);
			System.out.println("Computer Team: " + computerOption);
		} else {
			userOption = 'O';
			computerOption = 'X';
			System.out.println("Player Team: " + userOption);
			System.out.println("Computer Team: " + computerOption);
		}
		sc.close();
	}
	//Method to display the board
	public void showBoard()
	{
		System.out.println("\n------------- ");
		for(int i = 1 ; i<10 ; i+=3)
		{
			System.out.println("| " + board[i] + " | " + board[i+1] + " | " + board[i+2] + " |");
			System.out.println("------------- ");
		}
		
	}
}


