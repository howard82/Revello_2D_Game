import java.awt.Point;

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
	
	public Game NewSinglePlayerGame(int boardSize) {
		System.out.println("GC creates a new Single Player game and returns it to the View");
		game = new SinglePlayerGame(boardSize);
		game.initialise();
		
		//game.MakeSinglePlayerGame();
		return game;
		// TODO Auto-generated method stub
		//game.start();
	}
	
	public Game NewTwoPlayerGame(int boardSize, String player1Name, String player2Name) {
		System.out.println("GC creates a new TwoPlayer game and returns it to the View");
		game = new TwoPlayerGame(boardSize, player1Name, player2Name);
		game.initialise();
		return game;
		// TODO Auto-generated method stub
	}	
	
	public boolean ExitGame(){
		System.out.println("GC calls Game Over, Save (if game not finished) and Exit methods in game class");
		//implementation in game required
		if (!game.Over());
			game.save();
		game.Exit();
		return true;
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
	
	public boolean enterMove(Point playerMove) {
		// I'd like to see if we can tidy what happens between this and the Game.TakeTurn up, so that the player is
		//specified here and the if else loops can be removed from the Game.TakeTurn.
		return game.makeMove(playerMove);
	}




	
}
