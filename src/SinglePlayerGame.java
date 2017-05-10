import java.awt.Point;
import java.util.ArrayList;

public class SinglePlayerGame extends Game {

	public SinglePlayerGame(int gameboardSize) {
		super(gameboardSize);
		players = new Player[2];
		players[0] = new HumanPlayer("Player1", Cell.GamePiece.RED);
		players[1] = new ComputerPlayer("Computer",Cell.GamePiece.BLACK);
		GetGameBoard().initialise();
	}
	
	public void doComputerMove(){
		takeTurn(gameLogic.getBestMove(getCurrentPlayer()));
	}
	
}