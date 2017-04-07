import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class Game {
	//constructors
	
	public Game(){
		Integer defaultGameSize = 8;
		
		int[][] gameBoard;
		for (int i = 0; i < 1; i++)
		{
			
		}
		
		
	
	}
	
	public boolean CreateGameBoard(){
		return false;
	
	}
	
	public boolean saveGame(){

	// Formatter will overwrite an existing file with a blank one? used to create content and write it to files.
		try {
	    Formatter f = new Formatter("C:\\sololearn\\test.txt");
	    f.format("%s %s %s", "1","John", "Smith \r\n");
	    f.format("%s %s %s", "2","Amy", "Brown"); 
	    //the format %s %s %s denotes three strings that are separated with spaces.\r\n is the newline symbol in Windows.
	    f.close();    
	  } catch (Exception e) {
	      System.out.println("Error");
	  }

	    
	    
		
		return false;
	
	}
	
	public boolean loadGame(){
		File x = new File("C:\\sololearn\\test.txt");
	    if(x.exists()) {
	     System.out.println(x.getName() +  "exists!");
	    }
	    else { 
	     System.out.println("The file does not exist");
	    }
	    
	    try {
    	  File f = new File("C:\\sololearn\\test.txt");
    	  Scanner sc = new Scanner(f);      
    	}
    	 catch (FileNotFoundException e) {

    	}
	    
	    try {
	    	  File x = new File("C:\\sololearn\\test.txt");
	    	  Scanner sc = new Scanner(x);
	    	  while(sc.hasNext()) {
	    	    System.out.println(sc.next());
	    	  }
	    	  sc.close();
	    	} catch (FileNotFoundException e) {
	    	  System.out.println("Error");
	    	}
		return false;
	
	}
}
