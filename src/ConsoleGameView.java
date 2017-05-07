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
				case Empty:
					System.out.print("   |");
					break;
				case Black:
					System.out.print(" X |");
					break;
				case Red:
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
		String[] XY = validMoveInput.toUpperCase().split("");
		
		String X = XY[0];
		//Converts string X to integer
		int intX = Integer.parseInt(X);
		intX -= 1;
	
		String Y = XY[1];
		//Converts string Y to char
		char YToChar = Y.charAt(0);
		
		int intY = 0;
		
		//user selection index
		char[] column = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O',
				'P','Q','R','S','T','U','V','W','X','Y','Z'};
		//iterates through index to find users selection
		for (int i = 0; i < column.length; i++)
		{
			if (column[i] == YToChar){
				intY = i;
				}
			
		}
		System.out.println(validMoveInput + " converted to Point type");
			
		//Convert users input to point(x,y)
		Point playerMove = new Point(intX,intY);
		return playerMove;
	}

	public static String GetMoveInput() {
		String userString = null;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//Scanner scanner = new Scanner(System.in);
		do 
		{
			System.out.println("");
			System.out.print("Enter move (e.g 5C): ");

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
