import java.awt.Point;

public class TwoPlayerGame extends Game {
	
	public TwoPlayerGame(int gameboardSize, String player1Name, String player2Name) {
		// TODO Auto-generated constructor stub
		super(gameboardSize);
		player1 = new HumanPlayer(player1Name,Cell.GamePiece.RED);
		player2 = new HumanPlayer(player2Name,Cell.GamePiece.BLACK);
	}
	
	public boolean takeTurn(Point playerMove){
	//	boolean validMove;
		return makeMove(playerMove);
			
//		System.out.println(getNextPlayer().name + " has tried placing a piece at " + playerMove.x + playerMove.y);
//			//if (isValidMove()
//			validMove = player1.TakeTurn()
//			validMove = gameLogic.isValidMove(player1, gameboard.GetCells(), playerMove);
//		}
//		else{
//			System.out.println("Player 2 has taken turn");
//			validMove = gameLogic.isValidMove(player2, gameboard.GetCells(), playerMove);
//		}
//			
//		if (validMove){
//			if (turnCounter % 2 == 0)
//				player1.SetScore(gameLogic.CalculateScore(player1));
//			else
//				player1.SetScore(gameLogic.CalculateScore(player2));
//			
//			gameboard.Update();
//			turnCounter = turnCounter + 1;
//			System.out.println("Total turns so far: " + turnCounter);
//		}
//
//		@Override
//		public Point enterMove() {
//			// TODO Auto-generated method stub
//			return null;
//		}
	}
	
	
}
