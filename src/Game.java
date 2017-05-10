import java.awt.Point;
import java.io.*;
import java.util.ArrayList;
import java.util.Formatter;
//import java.util.Scanner;

public abstract class Game{
//	protected Player player1;
// Player player2;
	protected Player[] players;
	protected GameBoard gameboard;
	protected GameLogic gameLogic = new GameLogic(this);
	protected int turnCounter = 0;
	
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

	public abstract boolean takeTurn(Point playerMove);

	
	public boolean save(){
		int[] array = new int[GetGameBoard().GetSize()];
		int player1Score = players[0].GetScore();
		int player2Score = players[1].GetScore();
		SaveGame(turnCounter, player1Score, player2Score, array);
		System.out.println("\nGame saved\n");
		return true;
	}

	public void SaveGame(int turnCounter, int player1Score, int player2Score, int[] gameBoard) {

		try {
			String saveFileName = "savedGame";
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
		
		try {
			FileInputStream saveFile = new FileInputStream(saveFileName);
			ObjectInputStream RevelloSaveGame = new ObjectInputStream(saveFile);

			int turnCounterFromSave = (int) RevelloSaveGame.readObject();
			int player1ScoreFromSave = (int) RevelloSaveGame.readObject();
			int player2ScoreFromSave = (int) RevelloSaveGame.readObject();
			int[] gameBoardFromSave = (int[]) RevelloSaveGame.readObject();
			
			RevelloSaveGame.close();
		}

		catch(Exception exc) {
			exc.printStackTrace();
		}
		
		return false;
	}

	public boolean isWon() {
		//loop through all gameboard pieces and use the existing isValidMove method to determine if 
		//there are any more moves left on the board
		if (gameLogic.getPossibleMoves().isEmpty()){
			System.out.println("Game is not finished.");
		}

		// Tally scores, who is the winner? Ask player1 and player2 for scores
		return false;
	}
}
