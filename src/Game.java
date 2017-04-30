import java.awt.Point;
import java.util.Formatter;
//import java.util.Scanner;

public class Game{
	private Player player1;
	Player player2;
	private GameBoard gameboard;
	private GameLogic gameLogic;
	private int gameboardSize;
	Cell[][] tempCells;
	int turnCounter = 0;
	
//	// default 8x8 board constructor (not used at this point)
//	public Game(){
//		gameboardSize = 8;
//		Initialise();
//	}
	
	// custom size board constructor
	public Game(int gameboardSize){
		this.gameboardSize = gameboardSize;
		gameboard = new GameBoard(gameboardSize);
		gameLogic = new GameLogic();
		tempCells = new Cell[gameboardSize][gameboardSize];
	}
	
	public void MakeTwoPlayerGame(){
		player1 = new HumanPlayer("Player1",Cell.GamePiece.Red);
		player2 = new HumanPlayer("Player2",Cell.GamePiece.Black);
		gameboard.initialise();
	}
	
	public void MakeSinglePlayerGame(){
		player1 = new HumanPlayer("Player1", Cell.GamePiece.Red);
		player2 = new ComputerPlayer("Computer",Cell.GamePiece.Black);
		//this is not great i.e a double up of the above, 
		//the initialise was originally done in Gameboard constructor, but may interfere with Resume/Load game
		//may have to find a better way to do this at some point
		gameboard.initialise();
	}
	
	public boolean TakeTurn(Point playerMove) {
		//would be better to make a looping array of the two players...
		//there's probably a better way to do this...
		//it may be better to implement from the GameController passing in the player as a variable
		//hopefully works well enough for now
		boolean validMove;
		if (turnCounter % 2 == 0){
			System.out.println("Player 1 has taken turn");
			validMove = gameLogic.isValidMove(player1, gameboard.GetCells(), playerMove);
		}
		else{
			System.out.println("Player 2 has taken turn");
			validMove = gameLogic.isValidMove(player2, gameboard.GetCells(), playerMove);
		}
			
		if (validMove){
			if (turnCounter % 2 == 0)
				player1.SetScore(gameLogic.CalculateScore(player1));
			else
				player1.SetScore(gameLogic.CalculateScore(player2));
			
			gameboard.Update();
			turnCounter = turnCounter + 1;
			System.out.println("Total turns so far: " + turnCounter);
			return true;
		}
			return false;
	}	
	
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
