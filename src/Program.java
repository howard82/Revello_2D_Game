import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

public class Program {

	public static void main(String[] args) {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("David wrote this.");
		System.out.println("Brenden wrote this.");
		System.out.println("David wrote this too.");
		System.out.println("Jason wrote this also.");

	    System.out.print("Please enter your name? ");
	    String name;
		try {
			name = reader.readLine();
			System.out.println("Your name is: " + name);
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		Game game = new Game();
		game.CreateGameBoard();
	    
		
	}

}
