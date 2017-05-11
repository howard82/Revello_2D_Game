import java.awt.Point;
import java.io.*;
//import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class Game {
//	protected Player player1;
// Player player2;
	protected Player[] players;
	protected GameBoard gameboard;
	protected GameLogic gameLogic = new GameLogic(this);
	protected int turnCounter = 0;
	public final static String saveFileName = "RevelloSaveGame.sav";
	
	// custom size board constructor
	public Game(int gameboardSize){
		gameboard = new GameBoard(gameboardSize);
	}
	
	//don't like this much, used by ConsoleGameView.ShowGameBoard which needs some work probably
	public GameBoard GetGameBoard(){
		return gameboard;
	}
	
	protected Player[] getPlayers(){
		return players;
	}
	
	protected Player getCurrentPlayer(){
		if (turnCounter % 2 == 0)
			return players[0];
		else
			return players[1];
	}

	//public abstract boolean takeTurn(Point playerMove);

	public boolean takeTurn(Point playerMove){
		Player player =  getCurrentPlayer();
		ArrayList<Point> piecesToConvert = gameLogic.getValidMoves(player, playerMove) ;
		if (!piecesToConvert.isEmpty()){
			gameboard.GetCells()[playerMove.x][playerMove.y].setColor(player.GetColor());
			gameLogic.convertOpponentPieces(gameboard.GetCells(), player.GetColor(), piecesToConvert);
			gameLogic.updateScores();
			turnCounter = turnCounter + 1;
			return true;
		}
		return false;
	}

	public boolean save() {
		
		// This is temporary, till i find how to import current game state
		int[][] gameBoardCurrentState = new int[GetGameBoard().GetSize()] [GetGameBoard().GetSize()];
		for(int i=0; i<GetGameBoard().GetSize(); i++) {
			for(int j=0; j<GetGameBoard().GetSize(); j++) {
				gameBoardCurrentState[i][j] = i;
			}
		}
			
//		THIS DOES NOT WORK - though i believe its a good start
//		Cell[][] gameBoardCurrentState = new Cell[GetGameBoard().GetSize()] [GetGameBoard().GetSize()];
//		
//		GameController GC = GameController.getInstance();
//		
//		for(int i=0; i<GetGameBoard().GetSize(); i++) {
//			for(int j=0; j<GetGameBoard().GetSize(); j++) {
//				Cell boardCell= GC.getGameBoardCell(i,i);
//				gameBoardCurrentState[i][i] = boardCell;
//			}
//		}
		
		int player1Score = players[0].GetScore();
		int player2Score = players[1].GetScore();
		SaveGame(turnCounter, player1Score, player2Score, gameBoardCurrentState);
		System.out.println("\nGame saved\n");
		
		return true;
	}
	
	// the third parameter here is INT, while i believe it will need to be changed to CELL
	public void SaveGame(int turnCounter, int player1Score, int player2Score, int[][] gameBoardCurrentState) {

		try {
			FileOutputStream saveFile=new FileOutputStream(saveFileName);
			ObjectOutputStream save = new ObjectOutputStream(saveFile);

			save.writeObject(turnCounter);
			save.writeObject(player1Score);
			save.writeObject(player2Score);
			save.writeObject(gameBoardCurrentState);

			save.flush();
			save.close();
			
			}

		catch(Exception exc) {
			exc.printStackTrace();
		}
	}

	public static boolean Load(String saveFileName){
		int  turnCounterFromSave = 0;
		int player1ScoreFromSave = 0;
		int player2ScoreFromSave = 0;
		int[] [] gameBoardFromSave = null;
		
		try {
			FileInputStream saveFile = new FileInputStream(saveFileName);
			ObjectInputStream RevelloSaveGame = new ObjectInputStream(saveFile);

			turnCounterFromSave = (int) RevelloSaveGame.readObject();
			player1ScoreFromSave = (int) RevelloSaveGame.readObject();
			player2ScoreFromSave = (int) RevelloSaveGame.readObject();
			gameBoardFromSave = (int[] []) RevelloSaveGame.readObject();
			RevelloSaveGame.close();
		}

		catch(Exception exc) {
			exc.printStackTrace();
		}
		
		// for testing purposes. remove before submitting
		System.out.println(turnCounterFromSave);
		System.out.println(player1ScoreFromSave);
		System.out.println(player2ScoreFromSave);
		System.out.println(Arrays.deepToString(gameBoardFromSave));
		
		return false;
	}

	public boolean isWon() {
		//loop through all gameboard pieces and use the existing isValidMove method to determine if 
		//there are any more moves left on the board
		if (gameLogic.getPossibleMoves().isEmpty()){
			System.out.println("Game is not finished.");
		}
		return false;
	}
}
