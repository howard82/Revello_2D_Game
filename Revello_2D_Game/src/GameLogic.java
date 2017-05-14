import java.awt.Point;

public class GameLogic
{
    Cell[][] tempGameCells;
    Cell[][] gameboardCells;
    // Integers for running the nested loops
    int x, y;
    //The  X and Y coordinates of the playerMove
    double moveX, moveY;
    //Integer conversions of the above doubles
    int moveIntX, moveIntY;
    //The Enum cell that the player is trying to make a move too and the adjacent cells
    Cell moveCell, topLeft, topMiddle, topRight, middleLeft, middleRight, bottomLeft,
    bottomMiddle, bottomRight;
    //The current state of the Cell.
    Cell.GamePiece moveCellState, pColor;

    public boolean isValidMove(Player player, Cell[][] gameboardCells, Point playerMove){
	    moveX = playerMove.getX();
	    moveY = playerMove.getY();
	    moveIntX = (int) moveX;
	    moveIntY = (int) moveY;
	    topLeft = gameboardCells[moveIntX - 1][moveIntY - 1];
	    topMiddle =  gameboardCells[moveIntX][moveIntY - 1];
	    topRight =  gameboardCells[moveIntX + 1][moveIntY - 1];
	    middleLeft =  gameboardCells[moveIntX - 1][moveIntY];
	    middleRight = gameboardCells[moveIntX + 1][moveIntY];
	    bottomLeft = gameboardCells[moveIntX - 1][moveIntY + 1];
	    bottomMiddle = gameboardCells[moveIntX][moveIntY + 1];
	    bottomLeft = gameboardCells[moveIntX + 1][moveIntY + 1];
	    moveCell = gameboardCells[moveIntX][moveIntY];
	    moveCellState = moveCell.getValue();
	    pColor = player.GetColor();
		for (x = 0; x < gameboardCells.length; x++)
		{
		    for (y = 0; y < gameboardCells.length; y++)
		    {        
		    //Test to see if move is within the game board.
		        if (moveCell != null)
		        {
		    //Test to see if move is being made to an empty cell.
		            if (moveCell.getValue() == Cell.GamePiece.EMPTY)
		            {
		    //Test to see if adjacent top cells match color.
		             if (topLeft.getValue() == pColor || topMiddle.getValue() == pColor || topRight.getValue() == pColor)
		             {
		                 return true;
		             }
		    //Test to see if adjacent cells match color
		             else if (middleLeft.getValue() == pColor || middleRight.getValue() == pColor)
		             {
		                 return true;
		             }
		    //Test to see if bottom cells match color.
		             else if (bottomLeft.getValue() == pColor || bottomMiddle.getValue() == pColor || bottomRight.getValue() == pColor)
		             {
		                 return true;
		             }
		         }
		            else
		            {
		                return false;
		            }
		        }
		        else
		        {
		            return false;
		        }
		    }
		}
	return false;	
	}

    public int movesRemaining(GameBoard gameboard)
    {
        int remaining = 0;
        for (x = 0; x < gameboardCells.length; x++)
        {
            for (y = 0; y < gameboardCells.length; y++)
            {
                if (gameboardCells[x][y].getValue() == Cell.GamePiece.EMPTY)
                {
                    remaining++;
                }
            }
        }
        return remaining;
    }

    public Cell[][] ConvertPieces(Point playerMove, Player player)
    {
        moveX = playerMove.getX();
        moveY = playerMove.getY();
        moveIntX = (int) moveX;
        moveIntY = (int) moveY;
        topLeft = gameboardCells[moveIntX - 1][moveIntY - 1];
        topMiddle =  gameboardCells[moveIntX][moveIntY - 1];
        topRight =  gameboardCells[moveIntX + 1][moveIntY - 1];
        middleLeft =  gameboardCells[moveIntX - 1][moveIntY];
        middleRight = gameboardCells[moveIntX + 1][moveIntY];
        bottomLeft = gameboardCells[moveIntX - 1][moveIntY + 1];
        bottomMiddle = gameboardCells[moveIntX][moveIntY + 1];
        bottomLeft = gameboardCells[moveIntX + 1][moveIntY + 1];
        moveCell = gameboardCells[moveIntX][moveIntY];
        Cell.GamePiece cellState, otherCellState;
        cellState = moveCell.getValue();
        if (cellState == Cell.GamePiece.BLACK)
        {
            otherCellState = Cell.GamePiece.RED;
        }
        else
        {
            otherCellState = Cell.GamePiece.BLACK;
        }
        pColor = player.GetColor();
        for (x = 0; x < gameboardCells.length; x++)
        {
            for(y = 0; y < gameboardCells.length; y++)
            {
                tempGameCells[x][y] = gameboardCells[x][y];
            }
        }
        
        return tempGameCells;
    }

    public int CalculateScore(Player player)
    {
        pColor = player.GetColor();
        System.out.println("returning player score");
        int score = 0;
        for (x = 0; x < gameboardCells.length; x++)
        {
            for (y = 0; y < gameboardCells.length; y++)
            {
                if (gameboardCells[x][y].getValue() == pColor)
                {
                    score++;
                }
            }
        }
        return score;
    }
}
