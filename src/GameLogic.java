import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

public class GameLogic
{
	private Game game;
	
	public GameLogic(Game game){
		this.game = game;
	}

    protected ArrayList<Point> getValidMoves(Player player, Point playerMove){
    	int moveX = playerMove.x;
        int moveY = playerMove.y;
        Cell moveCell = game.GetGameBoard().GetCell(moveX, moveY);
        ArrayList<Point> cellsToConvert = new ArrayList<Point>();
        
		//Test to see if move is being made to an empty cell.
		if (moveCell.getValue() == Cell.GamePiece.EMPTY){
			
			//Cycle through surrounding cells and make sure at least one has an opponent gamePiece in it
			for (int x = -1; x <=1; x++){
				for (int y = -1; y <=1; y++){
					// if (!(x==0 && y==0))
					// if there's an opponent piece in a particular direction...
	    			if (hasAdjacentOpponentPiece(player, moveX, moveY, x, y)){
	    				//search in that direction for one of the current players gamepieces and convert any inbetween
	    				ArrayList<Point> convertPieces = getConvertPieces(player, moveX, moveY, x, y, cellsToConvert);
	    				if (convertPieces !=null)
	    					cellsToConvert.addAll(convertPieces);
	    			}
	    		}
			}
			
		}
		//will return a null if no valid piece conversions are found
		return cellsToConvert;
    }
    
    protected boolean hasAdjacentOpponentPiece(Player player, int moveX, int moveY, int xDir, int yDir){
    	Cell.GamePiece checkCell;
    	int adjacentCellX = moveX + xDir;
    	int adjacentCellY = moveY + yDir;
		if (adjacentCellX<game.GetGameBoard().GetSize() && adjacentCellY<game.GetGameBoard().GetSize() && adjacentCellX>=0 && adjacentCellY>=0){
			checkCell = game.gameboard.GetCell(adjacentCellX, adjacentCellY).getValue();
			if (checkCell != player.GetColor()){
				return true;
			}
		}
    	//System.out.println("Doesn't have a valid cell nearby");
    	return false;
    	
    }
    
    private ArrayList<Point> getConvertPieces(Player player, int moveX, int moveY, int xDir, int yDir, ArrayList<Point> cellsToConvert){
    	int x = moveX;
    	int y = moveY;
    	Cell.GamePiece cellValue = null;
    	boolean foundPiece = false;
    	
    	do {
			//move in specified x/y direction away from placed piece
    		x = x + xDir;
			y = y + yDir;
			
			//if this sends the search out of bounds of the game board, or finds an empty cell then don't bother with it
			if (x>=game.GetGameBoard().GetSize() || y>=game.GetGameBoard().GetSize() || x<0 || y<=0 
					|| cellValue == Cell.GamePiece.EMPTY)
				return null;
			
			// if you find one of the players game pieces 
			cellValue = game.gameboard.GetCell(x, y).getValue();
			if (cellValue == player.GetColor()){
				foundPiece = true;
				//move a step back towards placed piece
				x = x - xDir;
				y = y - yDir;
				do{
					cellsToConvert.add(new Point(x,y));
					x = x - xDir;
					y = y - yDir;
					//game.GetGameBoard().GetCells()[x][y].setColor(player.GetColor());
				} while (x !=moveX || y!=moveY);
			}
				
    	} while(!foundPiece);
    	return cellsToConvert;
    }
    
    
	protected void convertOpponentPieces(Cell[][] gameboard, Cell.GamePiece color, ArrayList<Point> cellsToConvert) {
		Point piece;
		Iterator<Point> iter = cellsToConvert.iterator();
		while (iter.hasNext()) {
		    piece = iter.next();
			gameboard[piece.x][piece.y].setColor(color);
			iter.remove();
	    }
	}

	protected void updateScores() {
		// TODO Auto-generated method stub
		int blackCount = 0;
		int redCount = 0;
		for (int x = 0; x<game.GetGameBoard().GetSize(); x++)
			for (int y = 0; y<game.GetGameBoard().GetSize(); y++){
				if (game.GetGameBoard().GetCell(x,y).getValue() == Cell.GamePiece.BLACK)
					blackCount = blackCount + 1;
				else if (game.GetGameBoard().GetCell(x,y).getValue() == Cell.GamePiece.RED)
					redCount = redCount + 1;
			}
			System.out.println("player 1 score = " + blackCount);
			game.players[0].SetScore(blackCount);
			System.out.println("player 2 score = " + redCount);
			game.players[1].SetScore(redCount);
	}

	//Needs to take an empty gameboard cell as an input from 
    protected Point getBestMove(Player player)//(Cell cell)
    {
    	Point bestMove = new Point(null);
    	Point nextPotentialMove = new Point(null);
    	int noOfConversions = 0, mostConversions = 0;
    	ArrayList<Point> possibleMoves = new ArrayList<Point>();
    	possibleMoves = getPossibleMoves();
		
    	if (!possibleMoves.isEmpty()){
    		Iterator<Point> iter = possibleMoves.iterator();
    		
    		while (iter.hasNext()) {
    			nextPotentialMove = iter.next();
    			noOfConversions = getValidMoves(player, nextPotentialMove).size();
    			if (noOfConversions > mostConversions)
    				bestMove.setLocation(nextPotentialMove.getX(), nextPotentialMove.getY());
    		}
    	}
		return bestMove;
    }
    
    protected ArrayList<Point> getPossibleMoves()//(Cell cell)
    {
    	Player player = game.getCurrentPlayer();
    	ArrayList<Point> movesLeftArray = new ArrayList<Point>();
    	ArrayList<Point> tempPointArray = new ArrayList<Point>();
    	Point testXY = new Point();
    	for (int x = 0; x<game.GetGameBoard().GetSize(); x++)
    		for (int y = 0; y<game.GetGameBoard().GetSize(); y++)
    			if (game.GetGameBoard().GetCell(x, y).getValue() == Cell.GamePiece.EMPTY){
    				testXY.setLocation(x, y);
    				tempPointArray = getValidMoves(player, testXY);
    				if(!tempPointArray.isEmpty()){
    					Point point = new Point();
    					point.setLocation(testXY.x, testXY.y);
    					movesLeftArray.add(point);
    					tempPointArray.clear();
    				}
    			}
    	System.out.println("movesRemaining = " + movesLeftArray.size());
    	return movesLeftArray;
    }
}
