import java.awt.Point;
import java.util.ArrayList;

public class GameController {
	Game game;
	
	private static GameController instance = null;
	protected GameController() {
      // not public to prevent instantiation, need to use getInstance.
	}
	
	public static GameController getInstance() {
		if(instance == null) {
			instance = new GameController();
      }
      return instance;
	}
	
	public void newSinglePlayerGame(int boardSize, String player1Name, String player2Name) {
		System.out.println("SINGLE PLAYER GAME");
		game = new SinglePlayerGame(boardSize, player1Name, player2Name);
		//return game;
	}
	
	public void newTwoPlayerGame(int boardSize, String player1Name, String player2Name) {
		System.out.println("TWO PLAYER GAME");
		game = new TwoPlayerGame(boardSize, player1Name, player2Name);
		//return game;
		// TODO Auto-generated method stub
	}
	 
	public void loadNewGame(){
		game.GetGameBoard().initialise();
	}
	
	public Player getCurrentPlayer(){
		return game.getCurrentPlayer();
	}
	
	public Cell[][] getGameBoardCells(){
		return game.GetGameBoard().GetCells();
	}
	
	public Cell getGameBoardCell(int x, int y){
		return game.GetGameBoard().GetCell(x,y);
	}
	
	public int getGameBoardSize(){
		return game.GetGameBoard().GetSize();
	}
	
	public boolean ExitGame(){
		if (!game.isWon());
			game.save();
		return true;
	}
	
	public ArrayList<Point> getPossibleMoves(){
		return game.gameLogic.getPossibleMoves();
	}
	
	public boolean gameOver() {
		if (game.isWon())
			return true;
			return false;
	}
	
	public boolean takeTurn(Point playerMove) {
		return game.takeTurn(playerMove);
	}

	public int[] getPlayerScores() {
		// returns both player scores at once
		int[] playerScores = {0,0};
		int i = 0;
		for (Player player : game.getPlayers()){
			playerScores[i] = player.GetScore();
			i++;
		}
		return playerScores;
	}
}
