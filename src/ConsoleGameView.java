import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.util.Scanner;

public class ConsoleGameView {
	//this may need work, or to use the Gamecontroller somehow don't like the game.GetGameBoard.GetCell stuff
	public static void ShowGameBoard(Game game){
		char[] columnHead = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q'
				,'R','S','T','U','V','W','X'};
		int[] rowHead = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};
		
		System.out.println("");
		System.out.print("    ");
		for (int x=0; x<game.GetGameboardSize(); x++)
		{
			System.out.print(" " + columnHead[x] + "  ");
		}
		
		System.out.println("");
		for (int x=0; x<game.GetGameboardSize(); x++)
		{
			System.out.print(rowHead[x]);
			if (x<9)
				System.out.print("  |");
			else
				System.out.print(" |");
			for (int y=0; y<game.GetGameboardSize(); y++)
			{
			//	Don't love the amount of levels this has to delve to
				switch(game.GetGameBoard().GetCell(x,y).getValue())
				{
				case EMPTY:
					System.out.print("   |");
					break;
				case BLACK:
					System.out.print(" X |");
					break;
				case RED:
					System.out.print(" O |");
					break;
				}
			}
			//Add appropriate number of horizontal dashes for game board size
			System.out.println("");
			System.out.print("---");
			for (int z=0; z<game.GetGameboardSize(); z++){
				System.out.print("----");
			}
			System.out.println("");
		}
	}
	
	//Requires conversion of letter and number input to a point co-ordinate with top left being 0,0, limit defined by game board size. 
	// for standard-size gameboard.
	public static Point ConvertToXY(String validMoveInput){
			//String validMoveInput = GetUserInput();
			//Convert valid string input to Point type (holds X,Y coordinates)
			System.out.println(validMoveInput + " converted to Point type");
			
			//Type of output needed from the real conversion
			Point playerMove = new Point(1,1);
			return playerMove;
	}

	public static String GetMoveInput(Player player) {
		String userString = null;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//Scanner scanner = new Scanner(System.in);
		do 
		{
			System.out.println("");
			System.out.print(player.name + " please enter move (e.g 5C): ");

			try {
				userString = reader.readLine();
				//userString = scanner.nextLine();
			}
			catch (Exception e) 
			{
				System.out.println("Incorrect input");
			}
			
			
		} while (!userString.toUpperCase().equals("X") & userString.length() != 2);
		//scanner.close();
		return userString;
	}
}
