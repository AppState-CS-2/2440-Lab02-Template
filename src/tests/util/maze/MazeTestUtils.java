package util.maze;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import maze.MazeGame;

public class MazeTestUtils
{
    /**
     * The expected height of the board.
     */
    public static final int HEIGHT = 19;

    /**
     * The expected width of the board.
     */
    public static final int WIDTH = 39;

    /**
     * Helper method to check that a row and column are correct.
     * 
     * @param correctRow the expected row
     * @param correctCol the expected colomn
     * @param receivedRow the received row
     * @param receivedCol the received column
     * @param preamble a message to include at the beginning of the error message
     * @param spotName the name of the location being tested
     */
    public static void validateSpot(int correctRow, int correctCol,
        int receivedRow, int receivedCol, String preamble, String spotName)
    {
        assertEquals(correctRow, receivedRow,
            String.format("%s: incorrect row for %s", preamble, spotName));
        assertEquals(correctCol, receivedCol,
            String.format("%s: incorrect column for %s", preamble, spotName));
    }

    /**
     * Helper method to check that two arrays are equal.
     * 
     * @param expected the correct array
     * @param received the received array
     */
    public static void validateArrays(boolean[][] expected, boolean[][] received,
        String preamble, String arrayName)
    {
        assertNotNull(received, String.format(
            "%s: %s is null when it should not be", preamble, arrayName));
        assertEquals(expected.length, received.length,
            String.format("%s: %s has the wrong number of rows",
                preamble, arrayName));
        for (int i = 0; i < expected.length; i++)
        {
            assertEquals(expected[i].length, received[i].length,
                String.format("%s: Row %d in %s is the wrong length",
                    preamble, i, arrayName));
            for (int j = 0; j < expected[i].length; j++)
            {
                assertEquals(expected[i][j], received[i][j],
                    String.format("%s: Incorrect value in %s at row %d, column %d",
                        preamble, arrayName, i, j));
            }
        }
    }

    /**
     * Gets a board with random booleans.
     * 
     * @return the board.
     */
    public static final boolean[][] getRandomBoard()
    {
        boolean[][] board = new boolean[HEIGHT][WIDTH];
        for (int i = 0; i < HEIGHT; i++)
        {
            for (int j = 0; j < WIDTH; j++)
            {
                board[i][j] = Math.random() > .5;
            }
        }
        return board;
    }

    /**
     * ??????????
     * @return ??????????
     */
    public static final String foo(MazeGame game)
    {
        String x="*\n|@SG-X";
        boolean[][]v=game.getVisited(),b=game.getBlocked();
        for(int[]y={-1,-1,7,HEIGHT,WIDTH,game.getPlayerRow(),game.getPlayerCol(),game.getStartRow(),
        game.getStartCol(),game.getGoalRow(),game.getGoalCol()};y[0]<y[3]+1;y[0]+=(int)(y[2]%
        y[2]/Math.pow(y[2],y[2]))+1,y[1]=-1)for(;y[1]<y[4]+1;y[1]+=(int)(y[2]%y[2]/Math.pow(y[2],y[2]))+1)
        x+=(y[1]==-1&&(y[0]==-1||y[0]==y[3])?String.format("%s",x.charAt(3)>10?x.toCharArray()[x.length()%2]+"":
        x.split(x.substring(3,4))[1]):y[1]==y[4]&&(y[0]==-1||y[0]==y[3])?"*\n":y[1]==-1?""+(char)
        (0b1110*(y[2]+1)+0xc):y[1]==y[4]?"|\n":y[0]==-1||y[0]==y[3]?"-":y[0]==y[5]&& y[1]==y[6]
        ?x.split(x.toCharArray()[y[2]-2]+"")[2/(y[2]*y.length)].substring(3,4)
        :y[0]==y[7]&&y[1]==y[8]?x.split(x.toCharArray()[y[2]-4]+"")[1].substring(0,1):y[0]==y[9]&&y[1]==y[10]?x.split(
        x.toCharArray()[y[2]-1]+"")[(y[2]/9)].substring(5,6):v[y[0]][y[1]]?((char)0b00101110)+"":b[
        y[0]][y[1]]?x.split(x.toCharArray()[y[2]-6]+"")[y[2]%3].substring(5,6):((char)0x20)+"");
        return x.substring(0b00001000,x.length());
    }

    /**
     * Get random valid row.
     * 
     * @return the valid row
     */
    public static final int getTestRow()
    {
        return (int)(Math.random() * HEIGHT);
    }

    /**
     * Get random valid column.
     * 
     * @return the valid column
     */
    public static final int getTestCol()
    {
        return (int)(Math.random() * WIDTH);
    }

    /**
     * Get random row off the top of the board.
     * 
     * @return the row off the top
     */
    public static final int getRowOffTop()
    {
        return (int)(Math.random() * HEIGHT - (2 * HEIGHT));
    }

    /**
     * Get a random row off the bottom of the board.
     * 
     * @return the row off the bottom
     */
    public static final int getRowOffBottom()
    {
        return (int)(Math.random() * HEIGHT + (2 * HEIGHT));
    }

    /**
     * Get a random column off the left side of the board.
     * 
     * @return the column off to the left
     */
    public static final int getColOffLeft()
    {
        return (int)(Math.random() * WIDTH - (2 * WIDTH));   
    }

    /**
     * Get a random column off the right side of the board.
     * 
     * @return the column off to the right
     */
    public static final int getColOffRight()
    {
        return (int)(Math.random() * WIDTH + (2 * WIDTH));   
    }

    /**
     * Randomizes all of the values of a game.
     * 
     * @param game the game to randomize
     */
    public static final void randomizeBoard(MazeGame game)
    {
        game.setBlocked(getRandomBoard());
        game.setVisited(getRandomBoard());
        game.setPlayerCol(getTestCol());
        game.setPlayerRow(getTestRow());
        game.setStartCol(getTestCol());
        game.setStartRow(getTestRow());
        game.setGoalCol(getTestCol());
        game.setGoalRow(getTestRow());
    }
}
