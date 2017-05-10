import java.awt.Point;
import java.io.File;

public class Program {
	//private static Menu menu = new Menu();
	//private static ConsoleGameView gameView = new ConsoleGameView();
	//private static Game game;
	private static GameController GC = GameController.getInstance();
	private static int menuOption;
	
	public static void main(String[] args) {
		do{
			menuOption = Menu.MainMenu();
			switch (menuOption)
			{
				case 1:
					ShowInstructions();
					break;
				case 2:
					TwoPlayerGame();
					break;
				case 3:
					SinglePlayerGame();
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
		// TODO Auto-generated method stub
		Menu.InstructionsMenu();
	}
	
	private static void TwoPlayerGame() 
	{
		// TODO Auto-generated method stub
		Point moveXY = null;
		boolean userExit = false;
		String userInput;
		GC.newTwoPlayerGame(Menu.GameBoardSizeMenu(), "Player O", "Player X");
		do{
			ConsoleGameView.ShowGameBoard(GC.getGameBoardCells(),GC.getGameBoardSize(), GC.getPlayerScores(), GC.getPossibleMoves());
			userInput = ConsoleGameView.GetMoveInput(GC.getCurrentPlayer());
			if (!userInput.toUpperCase().equals("X")){
				moveXY = ConsoleGameView.ConvertToXY(userInput);
				if (!GC.takeTurn(moveXY))
					System.out.println("This was not a valid move. Please try again.");
			}
			else
				userExit = GC.ExitGame();
		}while (!userExit && !GC.gameOver());
	}
	
	private static void SinglePlayerGame() {
		GC.newSinglePlayerGame(Menu.GameBoardSizeMenu());
		System.out.println("Program: No implementation available yet in game/game controller class\n");
	}
	
	private static void LoadGame() {
		// Retrieve the users default save directory
		StringBuilder saveFileDirectory = new StringBuilder(System.getProperty("user.dir"));
		// Append the save file name to the directory
		StringBuilder saveFile = saveFileDirectory.append("\\RevelloSaveGame.sav");
		String fullSaveFileDirectory = saveFile.toString();
		File saveFileAsTypeFile = new File(fullSaveFileDirectory);
		
		// Check to see if the file exists
		if(saveFileAsTypeFile.exists() && !saveFileAsTypeFile.isDirectory()) { 
			Game.Load("RevelloSaveGame.sav");
		}
	    else {
	    	System.out.println("\nYou have no saved game\n");
	    }
	}
	
	private static void ExitProgram() {
	// TODO Auto-generated method stub
	Menu.ExitMenu();
}
}
