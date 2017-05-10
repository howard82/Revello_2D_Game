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
 
	@Override
	public boolean takeTurn(Point playerMove){
		Player player =  getCurrentPlayer();
		ArrayList<Point> piecesToConvert = gameLogic.getValidMoves(player, playerMove) ;
		if (!piecesToConvert.isEmpty()){
			gameboard.GetCells()[playerMove.x][playerMove.y].setColor(player.GetColor());
			gameLogic.convertOpponentPieces(gameboard.GetCells(), player.GetColor(), piecesToConvert);
			gameLogic.updateScores();
			turnCounter = turnCounter + 1;
			
			//Computer player turn logic
			//should go somewhere else...
			
			//checks for every possible move and picks the one that converts the most pieces
			gameLogic.getBestMove(getCurrentPlayer()); //this requires implementation
			//do all of them until you 
			
			return true;
		}
		return false;
	}
}