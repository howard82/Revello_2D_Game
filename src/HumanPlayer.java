import java.awt.Point;

public class HumanPlayer extends Player{
	Point playerMove;
	
	// for loading new game
	public HumanPlayer(String name, Cell.GamePiece color) {
		super(name, color);
	}
	
	// for loading existing game
	public HumanPlayer(String name, Cell.GamePiece color, int playerScore) {
		super(name,color,playerScore);
	}
	
	@Override
	public Point TakeTurn(Point playerMove) {		
		//this.playerMove = playerMove;
		return playerMove;
	}

	@Override
	public Point TakeTurn() {
		// TODO Auto-generated method stub
		return null;
	}

}
