import java.awt.Point;

public abstract class Player {
	
	 int score;
	 Cell.GamePiece color;
	 String name;
	
	public Player(String name, Cell.GamePiece color){
		this.color = color;
		this.score = 2;
	}
	 
	public abstract Point MakeMove(Point playerMove);
	
	public int GetScore() {
		return score;
	}
	public void SetScore(int score) {
		this.score = score;
	}
	
	public Cell.GamePiece GetColor() {
		return color;
	}
	public void SetColor(Cell.GamePiece color) {
		this.color = color;
	}
	
}
