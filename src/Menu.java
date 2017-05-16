import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static int userInt = 0;
	public static int MainMenu(){
        System.out.println("MAIN MENU");
        System.out.println("");
        System.out.println("1.Instructions");
        System.out.println("2.Single Player Game");
        System.out.println("3.Two Player Game");
        System.out.println("4.Resume Game");
        System.out.println("5.Exit the program");
        System.out.println("");
		System.out.print("Please select an option from 1-5: ");
		
        return getNumberInput(1,5,5);
	}

	public static int getNumberInput(int min, int max, int exit){
		try {
			userInt = Integer.parseInt(reader.readLine());
			System.out.println("\n--------------------------------\n");
			return userInt;
		}
		catch (Exception e) 
		{
			System.out.println("Incorrect input. Please enter a number between " + min + " and " + max);
		}
		return 0;
	}

	public static void showInstructionsMenu() {
		do{
			System.out.println(" INSTRUCTIONS MENU");
			System.out.println(" 1. Basic rules                   ");
	        System.out.println(" 2. Playing the Game              ");
	        System.out.println(" 3. The Goal                      ");
	        System.out.println(" 4. Game Over			          ");
	        System.out.println(" 5. Exit to Main Menu             ");
	        System.out.println("");
			System.out.print("Please select an option from 1-5: ");
	        userInt = getNumberInput(1,5,5);
	        if (userInt !=5)
	        	showInstructionOption(userInt);
		}while(userInt !=5);
	}
	
	public static void showInstructionOption(int menuOption){
		switch (menuOption)
        {
	        case 1: 
	        	System.out.println("Basic Rules           ");
	        	System.out.println("                                                                 ");
	        	System.out.println("Each reversi piece will have  black side and a red side.    ");
	            System.out.println("On your turn, you place one piece on the board              ");
	            System.out.println("with your color facing up. You must place this piece so     ");
	            System.out.println("that an opponent's piece,or a row of opponent's             ");
	            System.out.println("pieces, is flanked by your pieces. All of the opponent's    ");
	            System.out.println("pieces between your pieces are then turned over to          ");
	            System.out.println("become your color.                                          ");
	            
	            break;
	        case 2:    
	        	System.out.println("Playing the game        ");
	        	System.out.println("                                                            ");
	        	System.out.println("The object of the game is to own more pieces than your      ");
	            System.out.println("opponent when the game has ended. The game is over when     ");
	            System.out.println("neither player has a move. Usually, this means the          ");
	            System.out.println("board is full.                                              ");
	            break;
	        case 3:
	        	System.out.println("The Goal ");
	        	System.out.println("                                                            ");
	        	System.out.println("A move consists of placing one piece on an empty square.    ");
	            System.out.println("");
	            System.out.println("Capture                                                     ");
	            System.out.println("You can capture vertical, horizontal, and diagonal          ");
	            System.out.println("rows of pieces. Also, you can capture more than one         ");
	            System.out.println("row at once.                                                ");
	            break;
	        case 4:
	        	System.out.println("Game Over           ");
	        	System.out.println("                                                            ");
	            System.out.println("The game ends when:                                         ");
	            System.out.println("   - There are no more valid moves left on the board        ");
	            System.out.println("   - A player enters X to exit (game is saved automatically)");
	            break;
        }
		System.out.println("\nPress enter to return to instructions menu...");
		try {
			reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("--------------------------------\n");
	}
	
	public static int GameBoardSizeMenu() {
		do{
	        System.out.println("CHOOSE A GAME BOARD SIZE");
	        System.out.println("");
	        System.out.println("1. Small  (6x6)");
	        System.out.println("2. Normal (8x8)");
	        System.out.println("3. Large (10x10)");
	        System.out.println("4. Huge  (12x12)");
	        System.out.println("5. Return to main menu");
	        System.out.println("");
			System.out.print("Please select an option from 1-5: ");
	        userInt = getNumberInput(1,5,5);
		} while (userInt == 0);
        if (userInt != 5)
        	return getBoardSize(userInt);
		return 0;
	}
	
	public static int getBoardSize(int menuOption){
		switch (menuOption)
        {
	        case 1: return 6;
	        case 2: return 8;
	        case 3: return 10;
	        case 4: return 12;
        }
		return 0;
	}

	public static void LoadGameMenu() {
		// TODO Auto-generated method stub
		System.out.println("\nMVP for this is to load the one saved game automatically. \n"
				+ "Extended feature would display load menu for multiple games and allow user to choose\n");
		//return 
	}

	public static void ExitMenu() {
		// TODO Auto-generated method stub
		// Optional: Create a sub-menu that asks if the user really wants to exit, enter Y or N to return to Main Menu
		System.out.println("Goodbye");
	}
}
