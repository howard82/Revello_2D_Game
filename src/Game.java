import java.awt.Point;
import java.io.*;
//import java.util.Scanner;
import java.util.ArrayList;

public abstract class Game{
//	protected Player player1;
// Player player2;
	
	protected Player[] players;
	protected GameBoard gameboard;
	protected GameLogic gameLogic = new GameLogic(this);
	protected int turnCounter = 0;
	public final static String saveFileName = "RevelloSaveGame.txt";
	
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
	
	
	public void save(){
		//save file contents saved in the order: turnCounter, gameBoardSize, single/multiplayer game, gameBoard
		try {
			PrintWriter outputFile = new PrintWriter(new BufferedWriter(new FileWriter(saveFileName)));
			int gameboardSize = GetGameBoard().GetSize();
//			int player1Score = players[0].GetScore();
//			int player2Score = players[1].GetScore();
			Cell[][] gameboardCells = GetGameBoard().GetCells();
			
			outputFile.println(turnCounter + ",");
			outputFile.println(Integer.toString(gameboardSize)+ ",");
			
			//determine if the game is singleplayer or multiplayer
			String className = this.getClass().getSimpleName();
			
			if (className.equals("SinglePlayerGame")) {
				outputFile.println("1" + ",");
			}
			else {
				outputFile.println("2" + ",");
			}
			
		    for (int x = 0; x < gameboardSize; x++) {
		        for (int y = 0; y < gameboardSize; y++){
		        	outputFile.append(gameboardCells[x][y].getValue() + ",");
		        }
		        if (x != gameboardSize -1)
		        	outputFile.println();
		    }
		    outputFile.close();
	        outputFile.flush();
		}
		catch (IOException e) {
			e.printStackTrace();
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

	public boolean isWon() {
		//loop through all gameboard pieces and use the existing isValidMove method to determine if 
		//there are any more moves left on the board
		if (gameLogic.getPossibleMoves().isEmpty()){
			return true;
		}
		return false;
	}
}
