import java.awt.Point;

public abstract class Player {
	
	 int score;
	 Cell.GamePiece color;
	 String name;
	
	// for loading a new game
	public Player(String name, Cell.GamePiece color){
		this.name = name;
		this.color = color;
		this.score = 2;
	}
	
	// for loading an existing game
	public Player(String name, Cell.GamePiece color, int playerScore) {
		this(name, color);
		SetScore(playerScore);
	}
	
	public abstract Point TakeTurn(Point playerMove);
	public abstract Point TakeTurn();
	
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

	public String getName() {
		return name;
	}
	
}
