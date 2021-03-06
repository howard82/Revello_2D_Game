import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class Program {
	//private static Menu menu = new Menu();
	//private static ConsoleGameView gameView = new ConsoleGameView();
	//private static Game game;
	private static GameController GC = GameController.getInstance();
	private static int menuOption;
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) {
		System.out.println("                                                                ");
        System.out.println(" R|rrrrr  E|eeeeee V     vv  Eeeeeee L|       L|        oOOOo   ");
        System.out.println(" R|    rr E|       V     vv E|       L|       L|       O     O  ");
        System.out.println(" R|  rrr  E|eeeee  V     vv E|eeeee  L|       L|       O     O  ");
        System.out.println(" R|rrr    E|        V   vv  E|       L|       L|       O     O  ");
        System.out.println(" R|   rr  E|         V vv   E|       L|       L|       O     O  ");
        System.out.println(" R|    rr E|eeeeee    V     E|eeeeee L|llllll L|llllll  OoooO   ");
        System.out.println("");
        System.out.println("");
		do{
			menuOption = Menu.MainMenu();
			switch (menuOption)
			{
				case 1:
					ShowInstructions();
					break;
				case 2:
					SinglePlayerGame();
					break;
				case 3:
					TwoPlayerGame();
					break;	
				case 4:
					LoadGame();
					break;
				case 5:
					ExitProgram();
			}
		}while (menuOption !=5);
	}
	
	private static void ShowInstructions() {
		Menu.showInstructionsMenu();
	}
	
	private static void TwoPlayerGame() 
	{
		int gameboardSize = Menu.GameBoardSizeMenu();
		if (gameboardSize !=0){
			GC.newTwoPlayerGame(gameboardSize, "Player O", "Player X");
			playTwoPlayerGame();
		}
	}

	private static void SinglePlayerGame() {
		int gameboardSize = Menu.GameBoardSizeMenu();
		if (gameboardSize !=0){
			GC.newSinglePlayerGame(gameboardSize, "Player O", "Player X");
			playSingleGame();
		}
	}
	
	private static void playTwoPlayerGame(){
		Point moveXY = null;
		boolean userExit = false;
		String userInput;
		do{
			ConsoleGameView.ShowGameBoard(GC);
			userInput = ConsoleGameView.GetMoveInput(GC.getCurrentPlayer());
			if (!userInput.toUpperCase().equals("X")){
				moveXY = ConsoleGameView.ConvertToXY(userInput);
				if (!GC.takeTurn(moveXY))
					System.out.println("This was not a valid move. Please try again.");
			}
			else
				userExit = GC.ExitGame();
		}while (!userExit && !GC.gameOver());
		gameOver();
	}
	
	private static void playSingleGame(){
		Point moveXY = null;
		boolean userExit = false;
		String userInput;
		do{
			ConsoleGameView.ShowGameBoard(GC);
			userInput = ConsoleGameView.GetMoveInput(GC.getCurrentPlayer());
			if (!userInput.toUpperCase().equals("X")){
				moveXY = ConsoleGameView.ConvertToXY(userInput);
				if (!GC.takeTurn(moveXY))
					System.out.println("This was not a valid move. Please try again.");
				else
				{
					ConsoleGameView.ShowGameBoard(GC);
					System.out.println("\nPress enter for computer player to take turn...");
					try {
						reader.readLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
					GC.game.gameLogic.doComputerMove();
					System.out.println("Computer has taken its turn");
				}
			}
			else
				userExit = GC.ExitGame();
		}while (!userExit && !GC.gameOver());
		gameOver();
	}
	
	private static void gameOver(){
		if (GC.gameOver()){
			Player[] players = GC.game.getPlayers();
			ConsoleGameView.ShowGameBoard(GC);
			System.out.println("\nGame is finished.\n");
			for (Player player : players)
				System.out.println("Player " + player.getName() + " final score " + player.GetScore());
			System.out.println("\nPress enter to return to Main Menu...");
			try {
				System.in.read();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}

	private static void LoadGame() {
		int gameType = 0;
		gameType = GC.loadExistingGame();
		if (gameType == 1)
			playSingleGame();
		if (gameType == 2)
			playTwoPlayerGame();
	}
	
	private static void ExitProgram() {
	Menu.ExitMenu();
	}
}
