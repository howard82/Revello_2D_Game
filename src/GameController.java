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
	
	public void newSinglePlayerGame(int boardSize) {
		System.out.println("GC creates a new Single Player game");
		game = new SinglePlayerGame(boardSize);
		//return game;
	}
	
	public void newTwoPlayerGame(int boardSize, String player1Name, String player2Name) {
		System.out.println("GC creates a new TwoPlayer game");
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
		System.out.println("User has hit X to Exit. Save (if game not finished) and Exit methods in game class");
		//implementation in game required
		if (!game.isWon());
			game.save();
		return true;
	}
	
	public ArrayList<Point> getPossibleMoves(){
		return game.gameLogic.getPossibleMoves();
	}
	
//	public void setPossibleMoves(){
//    	ArrayList<Point> possibleMoves = getPossibleMoves();
//		//Iterator<Point> iter = possibleMoves.iterator();
//    	if (!getPossibleMoves().isEmpty()){
//	    	for (Point move : possibleMoves)
//	    		game.GetGameBoard().GetCell(move.x, move.y).setColor(Cell.GamePiece.MOVE);;
//    	}
//    }
	
	public boolean gameOver() {
		if (game.isWon())
			return true;
			return false;
	}
	
	public boolean loadGame(){
		System.out.println("GC calls the load method in game");
		//		File x = new File("C:\\sololearn\\test.txt");
//	    if(x.exists()) {
//	     System.out.println(x.getName() +  "exists!");
//	    }
//	    else { 
//	     System.out.println("The file does not exist");
//	    }
//	    
//	    try {
//    	  File f = new File("C:\\sololearn\\test.txt");
//    	  Scanner sc = new Scanner(f);
//    	  sc.close();
//    	}
//    	 catch (Exception e) {
//
//    	}
//	    
//	    try {
//	    	  File x2 = new File("C:\\sololearn\\test.txt");
//	    	  Scanner sc = new Scanner(x2);
//	    	  while(sc.hasNext()) {
//	    	    System.out.println(sc.next());
//	    	  }
//	    	  sc.close();
//	    	} catch (FileNotFoundException e) {
//	    	  System.out.println("Error");
//	    	}
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
