package com.tictactoe;

public class MainT {
	public static void main(String[] args) {
		System.out.println("Welcome to the game of Tic Tac Toe");
		
	TicTacToeGame ticTacToeGame = new TicTacToeGame();
	ticTacToeGame.createBoard();
	ticTacToeGame.chooseOption();
	ticTacToeGame.showBoard();
    ticTacToeGame.userIndexValue();
	}
}

	