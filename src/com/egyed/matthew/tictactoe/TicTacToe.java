package com.egyed.matthew.tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class TicTacToe {

	public static Scanner input;
	public static void main(String[] args) {

		System.out.println("Welcome to Tic Tac Toe. Good Luck!");
		System.out.println("Would you like to go first or second?");

		String first = "Second";
		Boolean isFirst = false;

		input = new Scanner(System.in);


		try{

			first = input.nextLine();

		}
		catch(InputMismatchException e){
			System.out.println("That's not an option, try again");
			first = input.nextLine();
		}


		char[][] board = new char[3][3];

		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				board[i][j] = '+';	
			}
		}



		if(first.equalsIgnoreCase("first")){
			isFirst = true;
			System.out.println("OK, you will go first");


		}else{
			isFirst = false;
			System.out.println("OK, you will go second");
		}


		/*	
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				System.out.print(board[i][j]);	
			}
			System.out.println("");
		}
		 */

		int nextMove = 0;
		boolean isPlayer = isFirst;
		boolean spaceFree = false;

		Random randomGenerator = new Random();
		int random = 0;

		if (!isFirst){

			random= randomGenerator.nextInt(4)+1;

			switch(random){
			case 1:
				nextMove = 1;
				break;
			case 2:
				nextMove = 3;
				break;
			case 3:
				nextMove = 7;
				break;
			case 4:
				nextMove = 9;
				break;
			}
			int cpuMove = nextMove;
			isPlayer = false;


			spaceFree = placeAvailable(cpuMove,board);

			if(spaceFree){
				board = boardChanger(board,cpuMove,isPlayer);
			}
		}






		System.out.println("The plus represents an empty space");
		System.out.println("To place an O, type the number 1-9");
		System.out.println("The spaces are numbered as shown:");
		System.out.println("147");
		System.out.println("258");
		System.out.println("369");
		System.out.println("");

		//TODO FIX THE NUMBERS!!!
		boardPrint(board);


		int playerMove = 0;
		isPlayer = true;


		playerMove = spaceInput(playerMove, board);

		board = boardChanger(board,playerMove, isPlayer);

		boardPrint(board);


		boolean gameOver = false;
		boolean playerWon = false;


		while (!gameOver){
			isPlayer = false;








			switch(movePlanner(board)){
			case 1:
				nextMove = 1;
				break;
			case 2:
				nextMove = 2;
				break;
			case 3:
				nextMove = 3;
				break;
			case 4:
				nextMove = 4;
				break;
			case 5:
				nextMove = 5;
				break;
			case 6:
				nextMove = 6;
				break;
			case 7:
				nextMove = 7;
				break;
			case 8:
				nextMove = 8;
				break;
			case 9:
				nextMove = 9;
				break;
			}

			int cpuMove = nextMove;

			System.out.println("");


			spaceFree = placeAvailable(cpuMove,board);
			
			if(spaceFree){
				board = boardChanger(board,cpuMove,isPlayer);
			}
			while (!spaceFree){
				spaceFree = placeAvailable(cpuMove,board);
			if(spaceFree){
				board = boardChanger(board,cpuMove,isPlayer);
			}
			cpuMove++;
			}





			boardPrint(board);

			if (winChecker(board) == 1){
				playerWon = true;
				break;
			}else if (winChecker(board) == 2){
				break;
			}else if (tieChecker(board) == 0){
				break;
			}


			isPlayer = true;

			playerMove = spaceInput(playerMove, board);

			board = boardChanger(board,playerMove, isPlayer);

			boardPrint(board);


			
			if (winChecker(board) == 1){
				playerWon = true;
				break;
			}else if (winChecker(board) == 2){
				break;
			}else if (tieChecker(board) == 0){
				break;
			}


		}
		if(playerWon)
		{
			System.out.println("HOW DID YOU WIN???");
		}else System.out.println("Good game!");

		input.close();

	}



	public static Boolean placeAvailable(int move, char board[][]){

		int i = 0;
		int j = 0;


		if (move == 1){
			i=0;
			j=0;
		}else if (move == 2){
			i=1;
			j=0;
		}else if (move == 3){
			i=2;
			j=0;
		}else if (move == 4){
			i=0;
			j=1;
		}else if (move == 5){
			i=1;
			j=1;
		}else if (move == 6){
			i=2;
			j=1;
		}else if (move == 7){
			i=0;
			j=2;
		}else if (move == 8){
			i=1;
			j=2;
		}else {
			i=2;
			j=2;
		}


		/*
		if (board[i][j] == '+'){
			return true;
		}else return false;
		*/

		return (board[i][j] == '+');
	}


	public static void boardPrint(char board [][]){

		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				System.out.print(board[i][j]);	
			}
			System.out.println("");
		}

	}


	public static int spaceInput(int playerMove, char board [][]){

		for(boolean spaceAvailable = false;!spaceAvailable;){


			try{

				playerMove = input.nextInt();

			}
			catch(InputMismatchException e){
				System.out.println("That's not an option");
				playerMove = input.nextInt();
			}


			if(placeAvailable(playerMove, board)){
				spaceAvailable = true;
				break;
			}else System.out.println("That Place is not avaliable");

		}
		return playerMove;


	}


	public static char[][] boardChanger (char board [][], int move, boolean isPlayer){

		int i = 0;
		int j = 0;
		if (move == 1){
			i=0;
			j=0;
		}else if (move == 2){
			i=1;
			j=0;
		}else if (move == 3){
			i=2;
			j=0;
		}else if (move == 4){
			i=0;
			j=1;
		}else if (move == 5){
			i=1;
			j=1;
		}else if (move == 6){
			i=2;
			j=1;
		}else if (move == 7){
			i=0;
			j=2;
		}else if (move == 8){
			i=1;
			j=2;
		}else {
			i=2;
			j=2;
		}

		if (isPlayer){
			board[i][j] = 'O';
		}else board[i][j] = 'X';

		return board;
	}

	public static int tieChecker (char board [][]){
		int tie = 0;
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				if (board[i][j] == '+'){
					tie ++;
				}
			}
		}

		return tie;

	}


	public static int winChecker(char board [][]){
		int[] oneDimBoard = new int[9] ;
		int counter = 0;

		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){

				if (board[i][j] == 'O'){
					oneDimBoard [counter] = 1;
				}else if (board[i][j] == 'X'){
					oneDimBoard [counter] = 2;	
				}
				counter++;
			}
		}
		int winnerTeam = 0;



		if (oneDimBoard[0] == 1 && oneDimBoard[1] == 1 && oneDimBoard[2] == 1){
			winnerTeam = 1;
		}else if (oneDimBoard[3] == 1 && oneDimBoard[4] == 1 && oneDimBoard[5] == 1){
			winnerTeam = 1;
		}else if (oneDimBoard[6] == 1 && oneDimBoard[7] == 1 && oneDimBoard[8] == 1){
			winnerTeam = 1;
		}else if (oneDimBoard[0] == 1 && oneDimBoard[4] == 1 && oneDimBoard[8] == 1){
			winnerTeam = 1;
		}else if (oneDimBoard[2] == 1 && oneDimBoard[4] == 1 && oneDimBoard[6] == 1){
			winnerTeam = 1;
		}else if (oneDimBoard[2] == 1 && oneDimBoard[5] == 1 && oneDimBoard[8] == 1){
			winnerTeam = 1;
		}else if (oneDimBoard[1] == 1 && oneDimBoard[4] == 1 && oneDimBoard[7] == 1){
			winnerTeam = 1;
		}else if (oneDimBoard[0] == 1 && oneDimBoard[3] == 1 && oneDimBoard[6] == 1){
			winnerTeam = 1;
		}


		if (oneDimBoard[0] == 2 && oneDimBoard[1] == 2 && oneDimBoard[2] == 2){
			winnerTeam = 2;
		}else if (oneDimBoard[3] == 2 && oneDimBoard[4] == 2 && oneDimBoard[5] == 2){
			winnerTeam = 2;
		}else if (oneDimBoard[6] == 2 && oneDimBoard[7] == 2 && oneDimBoard[8] == 2){
			winnerTeam = 2;
		}else if (oneDimBoard[0] == 2 && oneDimBoard[4] == 2 && oneDimBoard[8] == 2){
			winnerTeam = 2;
		}else if (oneDimBoard[2] == 2 && oneDimBoard[4] == 2 && oneDimBoard[6] == 2){
			winnerTeam = 2;
		}else if (oneDimBoard[2] == 2 && oneDimBoard[5] == 2 && oneDimBoard[8] == 2){
			winnerTeam = 2;
		}else if (oneDimBoard[1] == 2 && oneDimBoard[4] == 2 && oneDimBoard[7] == 2){
			winnerTeam = 2;
		}else if (oneDimBoard[0] == 2 && oneDimBoard[3] == 2 && oneDimBoard[6] == 2){
			winnerTeam = 2;
		}


		return winnerTeam;
	}


	public static int movePlanner(char board [][]){
		int plannedMove = 1;
		int[] oneDimBoard = new int[9] ;
		int[] boardRotation = oneDimBoard;
		int counter = 0;

		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){

				if (board[i][j] == 'O'){
					oneDimBoard [counter] = -2;
				}else if (board[i][j] == 'X'){
					oneDimBoard [counter] = 1;	
				}else oneDimBoard [counter] = 0;
				counter++;
			}
		}

		int rotation = 0;
		// 0 = normal, 1 = 90 clockwise, 2 = 180, 3 = 90 counter-clockwise


		while(rotation <4){

			if (boardRotation[0] + boardRotation[1] + boardRotation[2] == 2){
				if (boardRotation[0] == 0){
					plannedMove = 1;
					break;
				}else if (boardRotation[1] == 0){
					plannedMove = 4;
					break;
				}else if (boardRotation[2] == 0){
					plannedMove = 7;
					break;
				}
			}else if (boardRotation[3] + boardRotation[4] + boardRotation[5] == 2){
				if (boardRotation[3] == 0){
					plannedMove = 2;
					break;
				}else if (boardRotation[4] == 0){
					plannedMove = 5;
					break;
				}else if (boardRotation[5] == 0){
					plannedMove = 8;
					break;
				}
			}else if (boardRotation[6] + boardRotation[7] + boardRotation[8] == 2){
				if (boardRotation[6] == 0){
					plannedMove = 3;
					break;
				}else if (boardRotation[7] == 0){
					plannedMove = 6;
					break;
				}else if (boardRotation[8] == 0){
					plannedMove = 9;
					break;
				}
			}else if (boardRotation[0] + boardRotation[4] + boardRotation[8] == 2){
				if (boardRotation[0] == 0){
					plannedMove = 1;
					break;
				}else if (boardRotation[4] == 0){
					plannedMove = 5;
					break;
				}else if (boardRotation[8] == 0){
					plannedMove = 9;
					break;
				}
			}
				if (boardRotation[0] + boardRotation[1] + boardRotation[2] == -4){
					if (boardRotation[0] == 0){
						plannedMove = 1;
						break;
					}else if (boardRotation[1] == 0){
						plannedMove = 4;
						break;
					}else if (boardRotation[2] == 0){
						plannedMove = 7;
						break;
					}
				}else if (boardRotation[3] + boardRotation[4] + boardRotation[5] == -4){
					if (boardRotation[3] == 0){
						plannedMove = 2;
						break;
					}else if (boardRotation[4] == 0){
						plannedMove = 5;
						break;
					}else if (boardRotation[5] == 0){
						plannedMove = 8;
						break;
					}
				}else if (boardRotation[6] + boardRotation[7] + boardRotation[8] == -4){
					if (boardRotation[6] == 0){
						plannedMove = 3;
						break;
					}else if (boardRotation[7] == 0){
						plannedMove = 6;
						break;
					}else if (boardRotation[8] == 0){
						plannedMove = 9;
						break;
					}
				}else if (boardRotation[0] + boardRotation[4] + boardRotation[8] == -4){
					if (boardRotation[0] == 0){
						plannedMove = 1;
						break;
					}else if (boardRotation[4] == 0){
						plannedMove = 5;
						break;
					}else if (boardRotation[8] == 0){
						plannedMove = 9;
						break;
					}
				}



			
			//temporary locations for rotation
			//p stands for position
			int p1 = 0;
			int p2 = 0;
			int p3 = 0;
			int p4 = 0;
			int p5 = 0;
			int p6 = 0;
			int p7 = 0;
			int p8 = 0;
			int p9 = 0;

			for(int i=0; i<9;i++){
				if(i == 0){
					if(rotation == 0){
						p1 = oneDimBoard[i];
					}else if(rotation == 1){
						p7 = oneDimBoard[i];
					}else if(rotation == 2){
						p9 = oneDimBoard[i];
					}else if(rotation == 1){
						p3 = oneDimBoard[i];
					}
				}else if(i == 1){
					if(rotation == 0){
						p4 = oneDimBoard[i];
					}else if(rotation == 1){
						p8 = oneDimBoard[i];
					}else if(rotation == 2){
						p6 = oneDimBoard[i];
					}else if(rotation == 1){
						p2 = oneDimBoard[i];
					}
				}else if(i == 2){
					if(rotation == 0){
						p7 = oneDimBoard[i];
					}else if(rotation == 1){
						p9 = oneDimBoard[i];
					}else if(rotation == 2){
						p3 = oneDimBoard[i];
					}else if(rotation == 1){
						p1 = oneDimBoard[i];
					}
				}else if(i == 3){
					if(rotation == 0){
						p2 = oneDimBoard[i];
					}else if(rotation == 1){
						p4 = oneDimBoard[i];
					}else if(rotation == 2){
						p8 = oneDimBoard[i];
					}else if(rotation == 1){
						p6 = oneDimBoard[i];
					}
				}else if(i == 4){
					p5 = oneDimBoard[i];
				}else if(i == 5){
					if(rotation == 0){
						p8 = oneDimBoard[i];
					}else if(rotation == 1){
						p6 = oneDimBoard[i];
					}else if(rotation == 2){
						p2 = oneDimBoard[i];
					}else if(rotation == 1){
						p4 = oneDimBoard[i];
					}
				}else if(i == 6){
					if(rotation == 0){
						p3 = oneDimBoard[i];
					}else if(rotation == 1){
						p1 = oneDimBoard[i];
					}else if(rotation == 2){
						p7 = oneDimBoard[i];
					}else if(rotation == 1){
						p9 = oneDimBoard[i];
					}
				}else if(i == 7){
					if(rotation == 0){
						p6 = oneDimBoard[i];
					}else if(rotation == 1){
						p2 = oneDimBoard[i];
					}else if(rotation == 2){
						p4 = oneDimBoard[i];
					}else if(rotation == 1){
						p8 = oneDimBoard[i];
					}
				}else if(i == 8){
					if(rotation == 0){
						p9 = oneDimBoard[i];
					}else if(rotation == 1){
						p3 = oneDimBoard[i];
					}else if(rotation == 2){
						p1 = oneDimBoard[i];
					}else if(rotation == 1){
						p7 = oneDimBoard[i];
					}
				}

			}


			boardRotation[0] = p1;		
			boardRotation[1] = p2;	
			boardRotation[2] = p3;	
			boardRotation[3] = p4;	
			boardRotation[4] = p5;	
			boardRotation[5] = p6;	
			boardRotation[6] = p7;	
			boardRotation[7] = p8;	
			boardRotation[8] = p9;	


			rotation++;
		}

		if(rotation == 3){
			if(plannedMove == 1)plannedMove = 7;
			if(plannedMove == 2)plannedMove = 4;
			if(plannedMove == 3)plannedMove = 1;
			if(plannedMove == 4)plannedMove = 8;
			if(plannedMove == 5)plannedMove = 5;
			if(plannedMove == 6)plannedMove = 2;
			if(plannedMove == 7)plannedMove = 9;
			if(plannedMove == 8)plannedMove = 6;
			if(plannedMove == 9)plannedMove = 3;
		}else if(rotation == 2){
			if(plannedMove == 1)plannedMove = 9;
			if(plannedMove == 2)plannedMove = 8;
			if(plannedMove == 3)plannedMove = 7;
			if(plannedMove == 4)plannedMove = 6;
			if(plannedMove == 5)plannedMove = 5;
			if(plannedMove == 6)plannedMove = 4;
			if(plannedMove == 7)plannedMove = 3;
			if(plannedMove == 8)plannedMove = 2;
			if(plannedMove == 9)plannedMove = 1;
		}else if(rotation == 1){
			if(plannedMove == 1)plannedMove = 3;
			if(plannedMove == 2)plannedMove = 6;
			if(plannedMove == 3)plannedMove = 9;
			if(plannedMove == 4)plannedMove = 2;
			if(plannedMove == 5)plannedMove = 5;
			if(plannedMove == 6)plannedMove = 8;
			if(plannedMove == 7)plannedMove = 1;
			if(plannedMove == 8)plannedMove = 4;
			if(plannedMove == 9)plannedMove = 7;
		} 

		return plannedMove;

	}

}
