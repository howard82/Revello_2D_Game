
public class GameBoard {
	Cell[][] gameBoard;
	int size;
	
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
}
