public class SinglePlayerGame extends Game {

	public SinglePlayerGame(int gameboardSize, String player1Name, String player2Name) {
		super(gameboardSize);
		players = new Player[2];
		players[0] = new HumanPlayer(player1Name, Cell.GamePiece.RED);
		players[1] = new ComputerPlayer(player2Name,Cell.GamePiece.BLACK);
		GetGameBoard().initialise();
	}
}