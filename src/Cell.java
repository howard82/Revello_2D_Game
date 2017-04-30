public class Cell{
	public enum GamePiece{Black, Red, Empty};
 	private GamePiece value;
	
	public Cell(){
		value = GamePiece.Empty;
	}
	
	public GamePiece getValue(){
		return value;
	}
	
	public void setBlack(){
		value = GamePiece.Black;
	}
	
	public void setEmpty(){
		value = GamePiece.Empty;
	}
	
	public void setRed(){
		value = GamePiece.Red;
	}
	
	public String toString(){
		return null;
		
	}
	
}
