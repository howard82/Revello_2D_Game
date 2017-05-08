public class Cell{
	public enum GamePiece{BLACK, RED, EMPTY};
 	private GamePiece value;
	
	public Cell(){
		value = GamePiece.EMPTY;
	}
	
	public GamePiece getValue(){
		return value;
	}
	
	public void setBlack(){
		value = GamePiece.BLACK;
	}
	
	public void setEmpty(){
		value = GamePiece.EMPTY;
	}
	
	public void setRed(){
		value = GamePiece.RED;
	}
	
	public String toString(){
		return null;
	}
}
