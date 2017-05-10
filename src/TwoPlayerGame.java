import java.awt.Point;
import java.util.ArrayList;

public class TwoPlayerGame extends Game {
	
	// for loading a new game
	public TwoPlayerGame(int gameBoardSize, String player1Name, String player2Name) {
		super(gameBoardSize);
		players = new HumanPlayer[2];
		players[0] = new HumanPlayer(player1Name,Cell.GamePiece.RED);
		players[1] = new HumanPlayer(player2Name,Cell.GamePiece.BLACK);
		GetGameBoard().initialise();
	}
	 
	// for loading an existing game
	public TwoPlayerGame(int gameBoardSize, String player1Name, String player2Name, int player1Score, int player2Score) {
		super(gameBoardSize);
		players[0] = new HumanPlayer(player1Name,Cell.GamePiece.RED, player1Score);
		players[1] = new HumanPlayer(player2Name,Cell.GamePiece.BLACK, player2Score);
	}
	
	//
	public boolean takeTurn(Point playerMove){
		Player player =  getCurrentPlayer();
		ArrayList<Point> piecesToConvert = gameLogic.getValidMoves(player, playerMove);
		
		if (!piecesToConvert.isEmpty()){
			GetGameBoard().setGameBoardCellColor(player.color, playerMove);
			gameboard.GetCells()[playerMove.x][playerMove.y].setColor(player.GetColor());
			gameLogic.convertOpponentPieces(gameboard.GetCells(), player.GetColor(), piecesToConvert);
			gameLogic.updateScores();
			turnCounter = turnCounter + 1;
			//requires implementation
			return true;
		}
		return false;
	}	
}


