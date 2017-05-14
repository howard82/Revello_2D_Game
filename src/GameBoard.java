import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class GameBoard
{
    Cell[][] gameBoard;
    private int size;

    GameBoard(int gameBoardSize)
    {
        this.size = gameBoardSize;
        gameBoard = new Cell[size][size];
    }

    public void initialise()
    {
        // set the middle four cells to 2 x black, 2 x red
        for (int x = 0; x <= size - 1; x++)
        {
            for (int y = 0; y <= size - 1; y++)
            {
                gameBoard[x][y] = new Cell();
            }
        }

        for (int x = size / 2 - 1; x <= size / 2; x++)
        {
            for (int y = size / 2 - 1; y <= size / 2; y++)
            {
                if ((x + y) % 2 == 0)
                    gameBoard[x][y].setBlack();
                else
                    gameBoard[x][y].setRed();
            }
        }
    }
    // Data currently being read from the txt file

    public void load()
    {
        String readData = null;
        // Retrieve the users default save directory
        StringBuilder saveFileDirectory = new StringBuilder(
                System.getProperty("user.dir"));
        // Append the save file name to the directory
        StringBuilder saveFile = saveFileDirectory
                .append("\\" + Game.saveFileName);
        String fullSaveFileDirectory = saveFile.toString();
        File saveFileAsTypeFile = new File(fullSaveFileDirectory);
        try
        {
            Scanner fileScanner = new Scanner(
                    new FileReader("RevelloSaveGame.txt"));
            fileScanner.useDelimiter(",");
            readData = fileScanner.next();
            if (saveFileAsTypeFile.exists()
                    && !saveFileAsTypeFile.isDirectory())
            {
                // skipping the game board size value.
                readData = fileScanner.next();

                for (int x = 0; x <= size - 1; x++)
                {
                    for (int y = 0; y <= size - 1; y++)
                    {
                        while (fileScanner.hasNext())
                        {

                            gameBoard[x][y] = new Cell();
                            gameBoard[x][y].loadValue(readData);
                            readData = fileScanner.next();
                        }
                    }
                }

            }
            fileScanner.close();
        } catch (FileNotFoundException e)
        {

        }
    }

    public int GetSize()
    {
        return size;
    }

    public Cell[][] GetCells()
    {
        return gameBoard;
    }

    public Cell GetCell(int row, int column)
    {
        return gameBoard[row][column];
    }

    protected void setGameBoardCellColor(Cell.GamePiece gamePiece, Point cell)
    {
        GetCells()[cell.x][cell.y].setColor(gamePiece);
    }
}
