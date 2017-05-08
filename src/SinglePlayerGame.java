import java.awt.Point;

public class SinglePlayerGame extends Game {

	public SinglePlayerGame(int gameboardSize) {
		// TODO Auto-generated constructor stub
		super(gameboardSize);
		player1 = new HumanPlayer("Player1", Cell.GamePiece.RED);
		player2 = new ComputerPlayer("Computer",Cell.GamePiece.BLACK);
	}

	@Override
	public boolean takeTurn(Point PlayerMove) {
		// TODO Auto-generated method stub
		return false;
	}

//	@Override
//	public boolean tryMove() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean nextMove(Point playerMove) {
//		// TODO Auto-generated method stub
//		return false;
//	}

}
