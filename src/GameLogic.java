import java.awt.Point;

public class GameLogic {
	//Cell[][] tempGameCells;
	Cell[][] gameboardCells;
	private Game game;
	
	public GameLogic(Game game){
		this.game = game;
//		Cell[][] tempGameCells = game.gameboard.GetCells();
	}
	
	public boolean isValidMove(Player player, Point playerMove){
		// point is the coordinate x,y thing that Java uses, and holds the location of the gamePiece
		// the player has placed to modify the game board.
		return true;
	}
	
	public int movesRemaining(GameBoard gameboard){
		return 1;
	}
	
	public void ConvertPieces(Player player, Point playerMove){
		if (player.GetColor() != Cell.GamePiece.BLACK)
			game.GetGameBoard().GetCell(playerMove.x, playerMove.y).setBlack();
		else
			game.GetGameBoard().GetCell(playerMove.x, playerMove.y).setRed();
	}

	public int CalculateScore(Player player) {
		// TODO Auto-generated method stub
		System.out.println("returning player score");
		return 2;
	}

	
}
