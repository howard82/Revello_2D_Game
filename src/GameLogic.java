import java.awt.Point;

public class GameLogic {
	Cell[][] tempGameCells;
	Cell[][] gameboardCells;
	
	public boolean isValidMove(Player player, Cell[][] gameboardCells, Point playerMove){
		// point is the coordinate x,y thing that Java uses, and holds the location of the gamePiece
		// the player has placed to modify the game board.
		
		return true;
	}
	
	public int movesRemaining(GameBoard gameboard){
		return 1;
	}
	
	public Cell[][] ConvertPieces(){
		return tempGameCells;
		
	}

	public int CalculateScore(Player player) {
		// TODO Auto-generated method stub
		System.out.println("returning player score");
		return 2;
	}
}
