package com.tictactoe;


import java.util.Scanner;

public class TicTacToeGame {
	private char[] board = new char[10];
	private char userOption;
	private char computerOption;
	Scanner sc = new Scanner(System.in);

	public void createBoard() {

		for (int i = 0; i <9 ; i++) {
			board[i] = ' ';
		}

	}

	/*
	 * UseCase 2 - To allow a player to choose X or O
	 * 
	 * userOption is allows the user to choose if he wants to play as X and O.
	 * 
	 * @ computerOption automatically allows it to choose the other team opposite to
	 * what user has selected. the 'if...else' condition automatically allocates
	 * computer option
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
	
	}

//Method to display the board
	public void showBoard()
	{
		for(int i = 1 ; i<10 ; i+=3)
		{
			System.out.println("| " + board[i] + " | " + board[i+1] + " | " + board[i+2] );
			System.out.println("------------- ");
		}
		
	}
	/*
	 * UseCase 4 - The user to make desired location in the board
	 * In this method the user is asked to input as to where he wants to place his X or O
	 * indexNumber is used for the user to enter his input number.
	 * The 'if' condition checks for a valid index number.
	 */
	public void userIndexValue()
	{
		int indexNumber;
		System.out.println("Enter an index number where you want to place your input: ");
		indexNumber = sc.nextInt(); 
		if(indexNumber < 1 || indexNumber > 9)
		{
			System.out.println("Please enter a valid index number from 1-9. ");
		}
	

	}
	
}
