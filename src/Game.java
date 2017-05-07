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
	// This string is fine unless I add functionality for multiple save games, in which case it will need to append numbers to the end of the save file names
	static String saveFileName = "RevelloSaveGame.sav";
	
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

		int[] array = new int[GetGameboardSize()];
		int player1Score = player1.GetScore();
		int player2Score = player2.GetScore();
		SaveGame(turnCounter, player1Score, player2Score, array);
		System.out.println("\nGame saved\n");
		return true;
	}

	public void SaveGame(int turnCounter, int player1Score, int player2Score, int[] gameBoard) {

		try {
			FileOutputStream saveFile=new FileOutputStream(saveFileName);
			ObjectOutputStream save = new ObjectOutputStream(saveFile);

			save.writeObject(turnCounter);
			save.writeObject(player1Score);
			save.writeObject(player2Score);
			save.writeObject(gameBoard);

			save.flush();
			save.close();
			}

		catch(Exception exc) {
			exc.printStackTrace();
		}
	}		

	public static boolean Load(String saveFileName){
		System.out.println("Loading saved game");
		int  turnCounterFromSave = 0;
		int player1ScoreFromSave = 0;
		int player2ScoreFromSave = 0;
		int[] gameBoardFromSave = null;
		
		try {
			FileInputStream saveFile = new FileInputStream(saveFileName);
			ObjectInputStream RevelloSaveGame = new ObjectInputStream(saveFile);

			turnCounterFromSave = (int) RevelloSaveGame.readObject();
			player1ScoreFromSave = (int) RevelloSaveGame.readObject();
			player2ScoreFromSave = (int) RevelloSaveGame.readObject();
			gameBoardFromSave = (int[]) RevelloSaveGame.readObject();
			
			RevelloSaveGame.close();
		}

		catch(Exception exc) {
			exc.printStackTrace();
		}
		
		return false;
	}

	public boolean Over() {
		System.out.println("Game is finished.");
		// Tally scores, who is the winner? Ask player1 and player2 for scores
		return false;
	}

}
