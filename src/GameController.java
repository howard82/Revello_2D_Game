import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

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
	}
	
	public void newTwoPlayerGame(int boardSize, String player1Name, String player2Name) {
		System.out.println("TWO PLAYER GAME");
		game = new TwoPlayerGame(boardSize, player1Name, player2Name);
	}
	 
	public void loadNewGame(){
		game.GetGameBoard().initialise();
	}
	
	public int loadExistingGame(){
		File file = new File("RevelloSaveGame.txt");
		Scanner scanner;
		try {
			scanner = new Scanner(file);
			int turnCount = scanner.nextInt();
			int boardSize = scanner.nextInt();
			int gameType = scanner.nextInt();
			scanner.nextLine();
			Cell[][] cells = new Cell[boardSize][boardSize];
			
			String gameboardRow = null;
			String[] gameboardCells = new String[boardSize];

			while (scanner.hasNextLine()){				
				for (int x=0; x<gameboardCells.length; x++){
					gameboardRow = scanner.nextLine();
					gameboardCells = gameboardRow.split(",");
					for (int y=0; y<gameboardCells.length; y++){
						cells[x][y] = new Cell();
						if (gameboardCells[y].equals("BLACK"))
							cells[x][y].setBlack();
						if (gameboardCells[y].equals("RED"))
							cells[x][y].setRed();
					}
				}
				
				if (gameType == 1)
					game = new SinglePlayerGame(boardSize, "Player O", "Player X", turnCount, cells);
				if (gameType == 2)
					game = new TwoPlayerGame(boardSize, "Player O", "Player X", turnCount, cells);
			}
			scanner.close();
			return gameType;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
		
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
