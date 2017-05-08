import java.awt.Point;

public class Program {
	//private static Menu menu = new Menu();
	//private static ConsoleGameView gameView = new ConsoleGameView();
	private static GameController GC = new GameController();
	private static Game game;
	private static int menuOption;
	
	//static GameController gameController = new GameController();
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
		
	private static void ExitProgram() {
		// TODO Auto-generated method stub
		Menu.ExitMenu();
	}

	private static void SinglePlayerGame() {
		GC.NewSinglePlayerGame(Menu.GameBoardSizeMenu());
		System.out.println("Program: No implementation available yet in game/game controller class\n");
	}

	private static void LoadGame() {
		// TODO Auto-generated method stub
		Menu.LoadGameMenu();
	}

	private static void TwoPlayerGame() 
	{
		// TODO Auto-generated method stub
		Point moveXY = null;
		boolean userExit = false;
		String userInput;
		game = GC.NewTwoPlayerGame(Menu.GameBoardSizeMenu(), "Player 1", "Player 2");
		do{
			ConsoleGameView.ShowGameBoard(game);
			userInput = ConsoleGameView.GetMoveInput(GC.game.getNextPlayer());
			if (!userInput.toUpperCase().equals("X")){
				moveXY = ConsoleGameView.ConvertToXY(userInput);
				if (!GC.enterMove(moveXY))
					System.out.println("This was not a valid move. Please try again.");
			}
			else
				userExit = GC.ExitGame();
		}while (!userExit);
	}
	
	private static void ShowInstructions() {
		// TODO Auto-generated method stub
		Menu.InstructionsMenu();
	}
}
