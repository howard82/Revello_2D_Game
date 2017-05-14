import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Menu {

	public static int MainMenu(){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int userInt = 0;
		
		System.out.println("1. Instructions");
		System.out.println("2. Two Player Game");
		System.out.println("3. Single Player Game");
		System.out.println("4. Resume Game");
		System.out.println("5. Exit Program");
		System.out.println("");
		System.out.print("Please select an option 1-5: ");
		
		do
		{
			try {
				userInt = Integer.parseInt(reader.readLine());
				return userInt;
			}
			catch (Exception e) 
			{
				System.out.println("Incorrect input");
			}
			
			}while(userInt != 5);
			
			return userInt;
		}

	public static int GameBoardSizeMenu() {
		// TODO Auto-generated method stub
		System.out.println("\nDisplay game board size menu, input 8x8\n");
		return 8;
	}

	public static void ExitMenu() {
		// TODO Auto-generated method stub
		System.out.println("Goodbye");
	}

	public static void LoadGameMenu() {
		// TODO Auto-generated method stub
		System.out.println("\nMVP for this is to load the one saved game automatically. \n"
				+ "Extended feature would display load menu for multiple games and allow user to choose\n");
		//return 
	}

	public static void InstructionsMenu() {
		// TODO Auto-generated method stub
		System.out.println("\nDisplay instructions menu, which will require additional methods for each area \n"
				+ " e.g Overview, Gameplay, Strategy, or for MVP use one monolithic instruction\n "
				+ "Have the user hit any key to return to the Instructions/Main Menu\n");
	}
}
