package com.tictactoe;

public class TicTacToeGame {
	private char[] board = new char[10];

	public void createBoard() {

		for (int i = 1; i <=10; i++) {
			board[i] = ' ';
		}

	}
}
