import java.awt.Point;
import java.util.Formatter;
//import java.util.Scanner;

public abstract class Game{
	protected Player player1;
	protected Player player2;
	protected GameBoard gameboard;
	protected GameLogic gameLogic = new GameLogic(this);
	protected int gameboardSize;
	//Cell[][] tempCells;
	protected int turnCounter = 0;
	
	// custom size board constructor
	public Game(int gameboardSize){
		this.gameboardSize = gameboardSize;
		gameboard = new GameBoard(gameboardSize);
		//tempCells = new Cell[gameboardSize][gameboardSize];
	}
	
	public void initialise(){
		System.out.println("Default starting pieces loaded to gameboard");
		gameboard.initialise();
	}
	
	public boolean makeMove(Point playerMove){
		if (gameLogic.isValidMove(getNextPlayer(), playerMove)){
			gameLogic.ConvertPieces(getNextPlayer(), playerMove);	
			updateScores();
			turnCounter = turnCounter + 1;
			return true;
		}
		return false;
	}
	
	public abstract boolean takeTurn(Point playerMove);
//	public void MakeTwoPlayerGame(){
//		player1 = new HumanPlayer("Player1",Cell.GamePiece.Red);
//		player2 = new HumanPlayer("Player2",Cell.GamePiece.Black);
//		gameboard.initialise();
//	}
//	
//	public void MakeSinglePlayerGame(){
//		player1 = new HumanPlayer("Player1", Cell.GamePiece.Red);
//		player2 = new ComputerPlayer("Computer",Cell.GamePiece.Black);
		//this is not great i.e a double up of the above, 
		//the initialise was originally done in Gameboard constructor, but may interfere with Resume/Load game
		//may have to find a better way to do this at some point
	//}
//	
//	public void playGame(){
//		gameboard.initialise();
//		
//	}
	
	public void updateScores() {
		// TODO Auto-generated method stub
		int blackCount = 0;
		int redCount = 0;
		for (int x = 0; x<gameboard.size; x++)
			for (int y = 0; y<gameboard.size; y++){
				if (gameboard.GetCell(x,y).getValue() == Cell.GamePiece.BLACK)
					blackCount = blackCount + 1;
				else if (gameboard.GetCell(x,y).getValue() == Cell.GamePiece.RED)
					redCount = redCount + 1;
			}
			System.out.println("player 1 score = " + blackCount);
			player1.SetScore(blackCount);
			System.out.println("player 2 score = " + redCount);
			player2.SetScore(redCount);
	}
	
	protected Player getNextPlayer(){
		if (turnCounter % 2 == 0)
			return player1;
		else
			return player2;
	}
	
//	public abstract boolean nextMove(Point playerMove);
	
	public boolean Exit(){
		System.out.println("Exiting Game");
		//not exactly sure what needs implementing here...
		//may not need a return, boolean for now
		return true;
	}
	
	//don't like this much, used by ConsoleGameView.ShowGameBoard which needs some work probably
	public GameBoard GetGameBoard(){
		return gameboard;
	}

	public int GetGameboardSize() {
		return gameboardSize;
	}
	
	public boolean save(){
		System.out.println("Game saved");
	//Below is just stuff copied from SoloLearn, use whatever is applicable
	// Formatter will overwrite an existing file with a blank one? used to create content and write it to files.
//		try {
//	    Formatter f = new Formatter("C:\\sololearn\\test.txt");
//	    f.format("%s %s %s", "1","John", "Smith \r\n");
//	    f.format("%s %s %s", "2","Amy", "Brown"); 
//	    //the format %s %s %s denotes three strings that are separated with spaces.\r\n is the newline symbol in Windows.
//	    f.close();    
//	  } catch (Exception e) {
//	      System.out.println("Error");
//	  }
		return true;
	
	}
	
	public static boolean Load(){
		System.out.println("Load saved game");
		return false;
	}

	public boolean Over() {
		System.out.println("Game is finished.");
		// Tally scores, who is the winner? Ask player1 and player2 for scores
		return false;
	}

}
