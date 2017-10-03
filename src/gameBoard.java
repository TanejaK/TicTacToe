import java.util.Arrays;
import java.util.Scanner;

public class gameBoard {
	private char[][] board;
	
	/*This is a constructor for initializing the board
	 * Initializing it with spaces because if not initialized it will point to null.
	 * And that will become hard to test.
	 * */
	public gameBoard() {
		board = new char[3][3];
		for(int row = 0; row < board.length; row++) {
			Arrays.fill(board[row], ' ');
		}
	} // End of the constructor.
	
	
	/* This is method to display the board.
	 * */
	public void displayBoard() {
		for(int row = 0; row < board.length; row++) {
			for(int col = 0; col < board[0].length; col++) {
				System.out.print(board[row][col]);
				if( col==0 || col==1 )
					System.out.print("\t|");
			}
			if(row!=2)
				System.out.println("\n------------------------");
		}
		System.out.println("\n");
	}// End of displayBoard method.
	
	/*Method for checking if the move is valid or not.If yes update the board
	 * Move is invalid if:
	 *     1. the position of cell mention is out of the grid. Ex. board[3][3] is invalid.
	 *     2. That position is already taken by another player.
	 * */
	
	public boolean checkMove(char player, int row, int col) {
		if(row >= 0  && row<3 && col>=0 && col<3) {
			if(board[row][col]!=' ')
				return false;
			else {
				board[row][col]= player;
				return true;
			}
		}
		else
			return false;
	}// End of checkMove method.
	
	/*Checking if my game is still active or not. If there is a winner it will
	 *  return false. 
	 * */
	public boolean stillActive() {
		//checking for rows.
		for(int row=0; row<board.length; row++) {
			if(board[row][0]==board[row][1] && board[row][1]==board[row][2]&& board[row][0]!= ' ') {
				System.out.println("Winner is: "+ board[row][0]);
				return false;
			}
		}
		//checking for cols.
		for(int col=0; col<board[0].length; col++) {
			if(board[0][col]==board[1][col] && board[1][col]==board[2][col] && board[0][col]!= ' '){
				System.out.println("Winner is: "+ board[0][col]);
				return false;
			}
		}
		// checking diagonally
		if(board[0][0]==board[1][1] && board[1][1]==board[2][2] && board[0][0]!=' '){
			System.out.println("Winner is: "+ board[0][0]);
			return false;
		}
		if(board[0][2]==board[1][1] && board[1][1]==board[2][0] && board[0][0]!=' '){
			System.out.println("Winner is: "+ board[0][2]);
			return false;
		}
		return true;
	}
	
	/*Checking if the selected position is valid or not.
	 * This function will return true only if that position is valid.
	 * */
	public boolean notValid(int row, int col) {
		if( row>2 || row<0 || col>2 || col<0) {
			System.out.println("Plaese enter a valid position");
			return true;
		}
		if(board[row][col]!=' ') {
			System.out.println("Already taken!! Please enter a valid move.");
			return true;
		}
		return false;
	}// End of notValid move.
	
	/*Asking a player to select row and col for their next move and checking if 
	 * that move is valid or not. If not keep going on. If valid then will 
	 * update our board.
	 * */
	public void askPlayer(char player) {
		Scanner sc = new Scanner(System.in);
		int row,col;
		do {
			System.out.printf("Player %s please enter a row number between 0-2",player);
			row = sc.nextInt();
			System.out.printf("Player %s please enter a col number between 0-2",player);
			col = sc.nextInt();
		}while(notValid(row, col));
	
		board[row][col]=player;
		displayBoard();
		
	}// End of askPlayer method.
	
}
