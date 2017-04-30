import java.awt.Point;

public class HumanPlayer extends Player{
	Point playerMove;
	int score;
	
	public HumanPlayer(String name, Cell.GamePiece color) {
		super(name, color);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Point MakeMove(Point playerMove) {
		this.playerMove = playerMove;
		return playerMove;
	}
}
