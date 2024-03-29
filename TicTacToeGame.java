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
	public  int winnerStatus = 0 ;
	//public  int tie = 0 ;
	public  int changeUserTurn = 0 ;
	public  int count = 0;
	public int tossWinner = 0 ;
	public int[] arrCorners = {1,3,7,9};
	public int[] arrSides = { 2,4,6,8 };
	
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
		
		
		System.out.println("Enter if you want to choose X or O: ");
		Scanner sc = new Scanner(System.in);
		userOption = sc.next().charAt(0);
		
		if (userOption == 'X' || userOption == 'x') {
			userOption = 'X';
			computerOption = 'O';
			System.out.println("Player Team: " + userOption);
			System.out.println("Computer Team: " + computerOption);
		} 
		else {
			userOption = 'O';
			computerOption = 'X';
			System.out.println("Player Team: " + userOption);
			System.out.println("Computer Team: " + computerOption);
		}
	
	}

//Method to display the board
	public void showBoard()
	{
		System.out.println("\n-----------------");
		for(int i = 1 ; i<board.length ; i+=3)
		{
			System.out.println("| " + board[i] + " | " + board[i+1] + " | " + board[i+2] );
			System.out.println("----------- ");
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
	 * flag is set to 1 to indicate that the Computer is starting first
	 */
	public void tossMethod()
	{
		System.out.println("Choose Head(0) or Tail(1): ");
		int userChoice=sc.nextInt();							
		int headOrTail = rand.nextInt(2);						
		if(userChoice==headOrTail)
		{
			System.out.println("Player's Turn.");
			tossWinner = 1;
			turnToPlay='P';

		}
		else
		{
			System.out.println("Computer's turn");
			tossWinner = 0;
			turnToPlay='C';
			flag = 1;
			
		}
	}
	
	/* UseCase 7 - As player would expect the Tic Tac Toe App to determine after every move the winner or the tie or change the turn
	 * This method prints the Game statistics like the Winner, Tie or not and it helps in Changing the turn 
	 * Swapping is done in order to change the user turns.
	 */
	
public void statistics()
{
	System.out.println("Do you want to change turns? (Y/N):  ");
	char newUserOption = sc.next().charAt(0); 
	if(newUserOption == 'y' || newUserOption == 'Y')
	{
		if(turnToPlay=='C')
		
        {
			turnToPlay='P';
			System.out.println("Player's turn to play");
			userIndexValue();
			userMove();
		}
		else
		{
			turnToPlay='C';
			System.out.println("Computer's turn to play");
			computerMove();
            }
	}
}	
/* UseCase 8 - On Computer getting its turn would like the computer to play like me
 * 
 */

public void computerMove()
{
	if(((board[1]==' ')&&(board[2]==board[3] && board[2]==computerOption)||(board[4]==board[7] && board[4]==computerOption)||(board[5]==board[9] && board[5]==computerOption)) ||
		    (board[1]==' ')&&((board[2]==board[3]&&board[2]==userOption)||(board[4]==board[7]&&board[4]==userOption)||(board[5]==board[9]&&board[5]==userOption)))
		{
			board[1] = computerOption;
			
		}
		else if(((board[2]==' ')&&(board[1]==board[3] && board[1]==computerOption)||(board[5]==board[8] && board[8]==computerOption)) ||
				 (board[2]==' ')&&((board[1]==board[3]&&board[3]==userOption)||(board[5]==board[8]&&board[8]==userOption)))
		{
			board[2] = computerOption;
		}
		else if(((board[3]==' ')&&(board[2]==board[1] && board[2]==computerOption)||(board[5]==board[7] && board[5]==computerOption)||(board[6]==board[9] && board[6]==computerOption)) ||
				 (board[3]==' ')&&((board[1]==board[2]&&board[2]==userOption)||(board[6]==board[9]&&board[9]==userOption)||(board[5]==board[7]&&board[7]==userOption)))
		{
			board[3] = computerOption;		
		}
		else if(((board[4]==' ')&&(board[1]==board[7] && board[1]==computerOption)||(board[5]==board[6] && board[5]==computerOption)) ||
				 (board[4]==' ')&&((board[1]==board[7]&&board[7]==userOption)||(board[5]==board[6]&&board[6]==userOption)))
		{
			board[4] = computerOption;	
		}
		else if(((board[5]==' ')&&(board[2]==board[8] && board[2]==computerOption)||(board[4]==board[6] && board[4]==computerOption)||(board[1]==board[9] && board[9]==computerOption)||(board[7]==board[3] && board[3]==computerOption)) ||
				 (board[5]==' ')&&((board[1]==board[9]&&board[1]==userOption)||(board[7]==board[3]&&board[7]==userOption)||(board[2]==board[8]&&board[8]==userOption)||(board[4]==board[6]&&board[6]==userOption)))
				
		{
			board[5] = computerOption;	
		}
		else if(((board[6]==' ')&&(board[9]==board[3] && board[3]==computerOption)||(board[4]==board[5] && board[4]==computerOption)) ||
				 (board[6]==' ')&&((board[9]==board[3]&&board[3]==userOption)||(board[5]==board[4]&&board[4]==userOption)))
				
		{
			board[6] = computerOption;	
		}
		else if(((board[7]==' ')&&(board[1]==board[4] && board[1]==computerOption)||(board[5]==board[3] && board[3]==computerOption)||(board[8]==board[9] && board[9]==computerOption)) ||
				 (board[7]==' ')&&((board[1]==board[4]&&board[4]==userOption)||(board[8]==board[9]&&board[9]==userOption)||(board[5]==board[3]&&board[3]==userOption)))
				
		{
			board[7] = computerOption;	
		}
		else if(((board[8]==' ')&&(board[2]==board[5] && board[2]==computerOption)||(board[9]==board[7] && board[7]==computerOption)) ||
				 (board[8]==' ')&&((board[9]==board[7]&&board[7]==userOption)||(board[2]==board[5]&&board[2]==userOption)))
		{
			board[8] = computerOption;	
		}
		else if(((board[9]==' ')&&(board[6]==board[3] && board[3]==computerOption)||(board[8]==board[7] && board[7]==computerOption)||(board[5]==board[1] && board[5]==computerOption)) ||
				 (board[9]==' ')&&((board[1]==board[5]&&board[5]==userOption)||(board[6]==board[3]&&board[3]==userOption)||(board[8]==board[7]&&board[7]==userOption)))
		{
			board[9] = computerOption;	
		}		
		else
		{
	
	int flag1 = 0;
	for(int i=0;i<4;i++)
	{
		if(board[arrCorners[i]]==' ')
			{
			board[arrCorners[i]]=computerOption;
			flag1=1;
			break;
			}
	}
 
//checking for center and remaining values usecase11
if(flag1==0 )
	{
	if(board[5]==' ')
		board[5]=computerOption;
	else
	{
		
		for(int i=0;i<4;i++)
		{
			if(board[arrSides[i]]==' ')
				{
				board[arrSides[i]]=computerOption;
				break;
				}
		     }
		  }
	  }
	}
}	

/* This method defines the conditions for a win
 * The first 'for loop' is defined to check if there is an winning situation and if there is, it returns a character X or O
 * The second 'for loop' is to check for a tie,if the match ends in a tie, the method returns character 't' or 'n'.
 */
	public char getWinner() {
		String line = null;
		
        for (int a = 1; a < 10; a++) 
        {
           
            switch (a) {
            case 1:
                line = ""+board[1] + board[2] + board[3];
                break;
            case 2:
                line = ""+board[4] + board[5] + board[6];
                break;
            case 3:
                line = ""+board[7] + board[8] + board[9];
                break;
            case 4:
                line = ""+board[1] + board[4] + board[7];
                break;
            case 5:
                line = ""+board[2] + board[5] + board[8];
                break;
            case 6:
                line = ""+board[3] + board[6] + board[9];
                break;
            case 7:
                line = ""+board[1] + board[5] + board[9];
                break;
            case 8:
                line = ""+board[3] + board[5] + board[7];
                break;
            }
        //For X winner
        if (line.equals("XXX")) {
            return 'X';
        }
          
        // For O winner
        else if (line.equals("OOO")) {
            return  'O';
        }
        }
        int check1;	
        for (check1 = 1; check1 < 10; check1++) 
        {
	            if (board[check1]==' ') {
	               break;
	            }
        } 
        if(check1==10)
	            return 't';
        	else
        		return 'n';
	}
	
	//This is a method created to Identify and display winner
	public void identifyWinner()
	    {
	    	
	    	
	       char win=getWinner();
	        if(win==userOption)
	        {
	        	System.out.println("\n Congratulations, You win!");
	        	winnerStatus=1;
	        }
	        else if(win==computerOption)
	        	{
	        		System.out.println("\n Computer wins!");
	        		winnerStatus=1;
	        	}
	        else if(win=='t')
	        {
	        	System.out.println("TIE.");
	        	winnerStatus=1;
	        }
	    }
	
public void gameFlow() {
	createBoard();	
	chooseOption();
	showBoard();
	tossMethod();
	
	while(winnerStatus==0)
	{
		
		if(turnToPlay=='C')
		{
			computerMove();
			showBoard();
			identifyWinner();
			turnToPlay='P';
		}
		else if(turnToPlay=='P') 
		{
			userIndexValue();
			userMove();
			identifyWinner();
			turnToPlay='C';
			
		}
	}
}

}





    




	
	
	

	