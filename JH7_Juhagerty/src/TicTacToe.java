

import java.util.*;

class TicTacToe {
	char ttt[][] = new char[3][3];
	static final char player1 = 'O';
	static final char player2 = 'X';
	Scanner scan = new Scanner(System.in);

	String playerID(char player) {
		// Prints the identity of the player
		// For example:
		// player2: X

		if (player == player1)
			return "player1: " + player;
		else
			return "player2: " + player;
	}

	void getPlayerInput(char player) {
		int row = 0, col = 0;
		boolean lockObject = true;
		// ******* Details to fill in ************
		// Prompt the user for a cell input. Make sure its a legal
		// cell designator. Also make sure the cell doesn't already
		// have a player in it. Prompt the user again in the case
		// of any problem. Once a valid spot has been found,
		// you will issue a statement like:
		String charPlaceHolder;
		while(lockObject == true){
			System.out.println("What cell would you like to place a marker at?");
			charPlaceHolder = scan.nextLine();
			charPlaceHolder.toLowerCase();
			if(charPlaceHolder.length() > 1 && charPlaceHolder.matches(".*[a-i].*")){
				while(charPlaceHolder.length() > 1){
				System.out.println("Your input should be a-i");
				System.out.println("What cell would you like to place a marker at?");
				charPlaceHolder = scan.nextLine();
				}
			}
			charPlaceHolder.toLowerCase();
			switch(charPlaceHolder){
				case "a": row = 0; col = 0; break;
				case "b": row = 0; col = 1; break;
				case "c": row = 0; col = 2; break;
				case "d": row = 1; col = 0; break;
				case "e": row = 1; col = 1; break;
				case "f": row = 1; col = 2; break;
				case "g": row = 2; col = 0; break;
				case "h": row = 2; col = 1; break;
				case "i": row = 2; col = 2; break;
				default:{System.out.println("Your information was incorrect");
				break; 
				}
			}
			if(!(ttt[row][col] == ' ')){
				System.out.println("Please Pick a cell which has no place marker in it!");
			}else{
				lockObject = false;
			}
		}
		ttt[row][col] = player;

	}

	boolean gameIsDraw() {
		boolean lockObject = false; 
		boolean returnObject = false;
		// ******* Details to fill in ************
		// If all ttt entries have been taken return true
		// otherwise return false
		for(char[] c : this.ttt){
			for (char e : c){
				if(e == ' '){
					lockObject = true; 
				}else{
					
				}
			}
		}
		if(lockObject == true){
				returnObject = false;
			}else{
				returnObject = true;
			}
		return returnObject; 
	}

	boolean winner(char player) {
		boolean returnObject = false;
		for(int i = 0; i < 3; i++){
			if(this.ttt[i][0] == player && this.ttt[i][1] == player && this.ttt[i][2] == player){returnObject = true;}
		}
		for(int i = 0; i < 3; i++){
			if(this.ttt[0][i] == player && this.ttt[1][i] == player && this.ttt[2][i] == player){returnObject = true;}
		}
			if(this.ttt[0][0] == player && this.ttt[1][1] == player && this.ttt[2][2] == player){returnObject = true;}
			if(this.ttt[0][2] == player && this.ttt[1][1] == player && this.ttt[2][0] == player){returnObject = true;}
			
	return returnObject;
	}

	void displayBoard() {
		System.out.println("********************************");
		System.out.println(" --a---b---c---");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == 0)
					System.out.print(" | ");
				System.out.print(ttt[i][j]);
				if (j < 2)
					System.out.print(" | ");
				if (j == 2)
					System.out.print(" |");
			}
			System.out.println();
			switch (i) {
			case 0:
				System.out.println(" --d---e---f---");
				break;
			case 1:
				System.out.println(" --g---h---i---");
				break;
			case 2:
				System.out.println(" ---------------------");
				break;
			}
		}
	}

	void newgame() {
		char currPlayer = player1;
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				ttt[i][j] = ' ';

		boolean continueFlag = true;
		while (continueFlag) {
			displayBoard();
			if (gameIsDraw()) {
				System.out.println("Game Ends in Draw");
				continueFlag = false;
			} else {
				getPlayerInput(currPlayer);
				if (winner(currPlayer)) {
					System.out.println("We have a winner: " + playerID(currPlayer));
					displayBoard();
					continueFlag = false;
				} else {
					if (currPlayer == player1)
						currPlayer = player2;
					else
						currPlayer = player1;
				}
			}
		}

	}

	public static void main(String[] args) {
		TicTacToe game = new TicTacToe();
		String str;
		do {
			game.newgame();

			System.out.println("Do you want to play Tic-Tac-Toe (y/n)?");
			str = game.scan.next();
		} while ("y".equals(str));

		System.out.println("Bye");
	}
}