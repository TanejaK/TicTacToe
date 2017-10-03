
public class TicTacToe {

	public static void main(String[] args) {
		gameBoard myGame = new gameBoard();
		myGame.displayBoard();
		System.out.println("\n\n");
		int counter = 0;
		while(myGame.stillActive()) {
			if(counter%2==0)
				myGame.askPlayer('O');
			else
				myGame.askPlayer('X');
			
			counter++;
			//System.out.println(counter);
			if(counter==9) {
				System.out.println("Its a tie");
				 break;
			}
		}
	}

}
