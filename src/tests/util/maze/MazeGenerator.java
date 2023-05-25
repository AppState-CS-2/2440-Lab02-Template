package util.maze;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Creates random mazes and writes them to files.
 * 
 * @author Willow Sapphire
 * @version 04/27/2023
 */
public class MazeGenerator
{
    /**
     * The height of the maze.
     */
    private int height;

    /**
     * The width of the maze.
     */
    private int width;

    /**
     * The filename to which to write generated mazes.
     */
    private String filename;

    /**
     * Stores the moves that will win the game.
     */
    private String winningInput;

    /**
     * The maze itself.
     */
    private String[][] maze;

    /**
     * The [row][col] of the starting location
     */
    private int[] start;

    /**
     * The [row][col] of the goal location
     */
    private int[] goal;

    /**
     * Creates a new MazeGenerator.
     * 
     * @param filename the file to which the random maze(s) should be written
     * @param height the height of the mazes to generate
     * @param width the width of the mazes to generate
     */
    public MazeGenerator(String filename, int height, int width)
    {
        this.height = height;
        this.width = width;
        this.filename = filename;
        File mazeFile = new File(filename);
        if (!mazeFile.exists())
        {
            try {
                mazeFile.createNewFile();
            } catch (IOException e) {
                System.out.println("Could not create file at: " + filename);
                e.printStackTrace();
            }
        }
    }

    /**
     * Generates a random maze specified by the fields of this object.
     * 
     * @return true if the file was created. false if it failed.
     */
    public boolean generateRandomMazeFile()
    {
        winningInput = "";
        maze = new String[height][width];
        start = getUnusedCell();
        maze[start[0]][start[1]] = "S";
        goal =  getUnusedCell();
        maze[goal[0]][goal[1]] = "G";
        createPathToGoal();
        fillEmptyWithOnes();
        try {
            printMazeToFile();
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("Could not find the file: " + filename);
            return false;
        }
    }

    /**
     * Gets the string of moves to win the maze.
     * Should only be run after generating a maze.
     * 
     * @return the string of winning moves as they would be input by a player.
     */
    public String getWinningInput()
    {
        return winningInput;
    }

    /**
     * Getter for the maze's width.
     * 
     * @return width
     */
    public int getWidth()
    {
        return this.width;
    }

    /**
     * Getter for the maze's height.
     * 
     * @return height
     */
    public int getHeight()
    {
        return this.height;
    }

    /**
     * Getter for the filename to which mazes will be written.
     * 
     * @return filename
     */
    public String getFilename()
    {
        return this.filename;
    }

    /**
     * Setter for the maze's width.
     * 
     * @param width the new maze width
     */
    public void setWidth(int width)
    {
        this.width = width;
    }

    /**
     * Setter for the maze's height.
     * 
     * @param height the new maze height
     */
    public void setHeight(int height)
    {
        this.height = height;
    }

    /**
     * Setter for the filename to which to write mazes.
     * 
     * @param filename the new filename
     */
    public void setFilename(String filename)
    {
        this.filename = filename;
    }

    /**
     * Creates a path of zeros from the start to the goal.
     * The path will follow a straight line to either the goal row or column,
     * then follow a straight line to the goal.
     */
    private void createPathToGoal()
    {
        int[] playerLoc = {start[0], start[1]};
        boolean rowFirst = Math.random() < .5;
        moveToGoal(playerLoc, rowFirst);
        moveToGoal(playerLoc, !rowFirst);
    }

    /**
     * Moves the player in a straight line to the column containing the goal.
     * Puts zeros in every spot inbetween.
     * 
     * @param playerLoc the current location of the player
     * @param moveToRow true to move to the goal row, false to move to the goal column.
     */
    private void moveToGoal(int[] playerLoc, boolean moveToRow)
    {
        int index = moveToRow ? 0 : 1;
        while (playerLoc[index] != goal[index])
        {
            if ( goal[index] > playerLoc[index])
            {
                winningInput += moveToRow ? "down\n" : "right\n";
                playerLoc[index]++;
            }
            else
            {
                winningInput += moveToRow ? "up\n" : "left\n";
                playerLoc[index]--;
            }
            // do not overwrite the goal when it is reached.
            if (maze[playerLoc[0]][playerLoc[1]] != "G")
            {
                maze[playerLoc[0]][playerLoc[1]] = "0";
            }
        }
    }

    /**
     * Prints the current maze to the current filename.
     * 
     * @throws FileNotFoundException if the file does not exit
     */
    private void printMazeToFile() throws FileNotFoundException
    {
        PrintWriter pw = new PrintWriter(filename);
        for (String[] row : maze)
        {
            for (String cell : row)
            {
                pw.print(cell + " ");
            }
            pw.println();
        }
        pw.close();
    }

    /**
     * Gets a location in the maze array that has no value yet.
     * 
     * @return an array of the indices to the maze array such that
     *      maze[returnVal[0]][returnVal[1]] is an empty spot in the array.
     *      Returns null if the array is full.
     */
    private int[] getUnusedCell()
    {
        if (isFull()) return null;
        int[] cell = {getValidRow(), getValidCol()};
        while (maze[cell[0]][cell[1]] != null)
        {
            int emptyColInRow = getRandomEmptySpotInRow(cell[0]);
            int emptyRowInCol = getRandomEmptySpotInCol(cell[0]);
            if (emptyColInRow != -1)
            {
                cell[1] = emptyColInRow;
            }
            else if (emptyRowInCol != -1)
            {
                cell[0] = emptyRowInCol;
            }
            else
            {
                cell[0] = getValidRow();
                cell[1] = getValidCol();
            }
        }
        return cell;
    }

    /**
     * Gets a random row within the bounds of the board.
     * 
     * @return the random row
     */
    private int getValidRow()
    {
        return (int) (Math.random() * height);
    }

    /**
     * Gets a random column within the bounds of the board.
     * 
     * @return the random column
     */
    private int getValidCol()
    {
        return (int) (Math.random() * width);
    }

    /**
     * Gets a random empty spot in a given row.
     * 
     * @param row the row to search
     * 
     * @return the empty spot or -1 if the row is full
     */
    private int getRandomEmptySpotInRow(int row)
    {
        // I just didn't want to use an ArrayList or deal with
        // an incomplete array, so I keep track of spots in a string
        String spots = "";
        for (int i = 0; i < maze[row].length; i++)
        {
            if (maze[row][i] == null)
            {
                spots += i + ",";
            }
        }
        String[] spotArray = spots.split(",");
        return spotArray.length > 0 ?
            Integer.parseInt(spotArray[(int)(Math.random() * spotArray.length)]) : -1;
    }

    /**
     * Gets a random empty spot in a given column.
     * 
     * @param row the column to search
     * 
     * @return the empty spot or -1 if the xolumn is full
     */
    private int getRandomEmptySpotInCol(int col)
    {
        // I just didn't want to use an ArrayList or deal with
        // an incomplete array, so I keep track of spots in a string
        String spots = "";
        for (int i = 0; i < maze.length; i++)
        {
            if (maze[i][col] == null)
            {
                spots += i + ",";
            }
        }
        String[] spotArray = spots.split(",");
        if (spotArray.length > 0)
        {
            return Integer.parseInt(spotArray[(int)(Math.random() * spotArray.length)]);
        }
        else
        {
            return -1;
        }
    }

    /**
     * Checks if there are any empty spots in the maze.
     * 
     * @return true if the maze is full, false otherwise
     */
    private boolean isFull()
    {
        for (String[] row : maze)
        {
            for (String val : row)
            {
                if (val == null)
                {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Fills every empty spot in maze with a "1".
     */
    private void fillEmptyWithOnes()
    {
        for (int i = 0; i < maze.length; i++)
        {
            for (int j = 0; j < maze[i].length; j++)
            {
                if (maze[i][j] == null)
                {
                    maze[i][j] = "1";
                }
            }
        }
    }
}
