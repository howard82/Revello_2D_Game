import java.awt.Point;

public class GameBoard {
	Cell[][] gameBoard;
	private int size;
	private int movesRemaining = 1; //requires getter and setter will be set by gameLogic
	
	GameBoard(int gameBoardSize){
		this.size = gameBoardSize;
		gameBoard = new Cell[size][size];
	}
	
	public void initialise(){
		//set the middle four cells to 2 x black, 2 x red
		for (int x = 0;x <= size-1; x++)
		{
			for (int y = 0; y <= size-1; y++)
			{
				gameBoard[x][y] = new Cell();
			}
		}
		
		for (int x = size/2-1;x <= size/2; x++)
		{
			for (int y = size/2-1; y <= size/2; y++)
			{
				if ((x + y) % 2 == 0)
					gameBoard[x][y].setBlack();
				else
					gameBoard[x][y].setRed();
			}
		}
	}
	
	public int GetSize(){
		return size;
	}
	
	public Cell[][] GetCells(){
		return gameBoard;
	}
	
	public Cell GetCell(int row, int column){
		return gameBoard[row][column];
	}

	public void Update() {
		// TODO Auto-generated method stub
		
	}
	
	protected void setGameBoardCellColor(Cell.GamePiece gamePiece, Point cell){
    	GetCells()[cell.x][cell.y].setColor(gamePiece);
    }

	public void setMovesRemaining(int movesRemaining) {
		// TODO Auto-generated method stub
		this.movesRemaining = movesRemaining;
	}
}
