package com.tictactoe;

import java.util.Scanner;

public class MainT {
	public static void main(String[] args) {
		System.out.println("Welcome to the game of Tic Tac Toe");
		
	TicTacToeGame ticTacToeGame = new TicTacToeGame();
//	ticTacToeGame.createBoard();
//	ticTacToeGame.chooseOption();
//	ticTacToeGame.showBoard();
//    ticTacToeGame.userIndexValue();
//    ticTacToeGame.userMove();
//    ticTacToeGame.tossMethod();
//    ticTacToeGame.statistics();
//    ticTacToeGame.computerMove();
//    ticTacToeGame.getWinner();
//    ticTacToeGame.identifyWinner();
    ticTacToeGame.gameFlow();
  //Asking the user if wants to play another game - UC13
  		System.out.println("Want to start a new game?(Y/N) ");
  		Scanner sc = new Scanner(System.in);
		char newGame = sc .next().charAt(0); 
  		if(newGame=='Y' || newGame=='y')
  		{
  			int winnerStatus = 0;
  			ticTacToeGame.gameFlow();
  		}
  		else 
  			System.out.println("Thank you for playing the game");
  		
	}
}


	