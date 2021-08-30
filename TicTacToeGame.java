package com.tictactoe;


import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {
	private char[] board = new char[10];
	private char userOption;
	private char computerOption;
	private int indexNumber;
	Scanner sc = new Scanner(System.in);
	public Random rand = new Random(); // to check if User play's first or Computer using coin tossing
	public char turnToPlay; // to check who is playing - the user or the system
	public int flag = 0; // is used to monitor if the game is starting first time or not
	

	public void createBoard() {

		for (int i = 1; i <board.length ; i++) {
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
	/*
	 * UseCase 5 -  To check for the free space before making the desired move
	 * The'if...else' checks if the particular index is available or not, if it is available,the user input goes there
	 * If not, message is displayed and the user needs to repeat his turn again.
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
	public void userMove()
	{
		if(board[indexNumber] == ' ' && flag == 1) // this is when the user and computer are playing for the first time
			{
				if(turnToPlay == 'P')
				{
					board[indexNumber] = userOption;
					flag = 0;
				}
				else
				{
					board[indexNumber] = computerOption;
					flag = 0;
				}
			}
		else if(board[indexNumber] == ' ')
		{
			board[indexNumber] = userOption;
		}
		else
			{
				System.out.println("Sorry, Enter a different index number, this index number is not available."); 
				userIndexValue();
				userMove();
			}
	 showBoard();
	}
	
	/* UseCase 6 - Asking if the User would like to do a toss to check who plays first.
	 * If the user chooses Heads i.e, 0, and the @param headOrTail gives the result as 1, user plays
	 * Else,computer starts.
	 * @param flag is set to 1 to indicate that the Computer is starting first
	 */
	public void tossMethod()
	{
		System.out.println("Choose Head(0) or Tail(1): ");
		int userChoice=sc.nextInt();							
		int headOrTail = rand.nextInt(2);						
		if(userChoice==headOrTail)
		{
			System.out.println("Player's Turn.");
			turnToPlay='P';

		}
		else
		{
			System.out.println("Computer's turn");
			turnToPlay='C';
			indexNumber = rand.nextInt(10);
			flag = 1;
			userMove();
		}
	}
}
	
	

	