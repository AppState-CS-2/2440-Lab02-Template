package maze;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import util.maze.MazeGenerator;
import util.maze.MazeTestUtils;

/**
 * Tests the play method of the MazeGame class.
 * 
 * @author Willow Sapphire
 * @version 04/20/2023
 */
public class MazeGamePlayTest
{
    /**
     * Message that should be printed if the user quits.
     */
    public static final String FAIL_MESSAGE = "Goodbye!\n";

    /**
     * Message that should be printed if the user wins.
     */
    public static final String WIN_MESSAGE = "You Won!\n";

    /**
     * The file path to the file that will get random mazes.
     */
    private static final String RANDOM_MAZE_FILE = "src/data/random.txt";

    /**
     * Generator for random mazes.
     */
    private static MazeGenerator mg;
    
     /**
     * MazeGame object used by all tests.
     */
    private static MazeGame game;

    /**
     * Used to catch output printed to System.out.
     */
    private static ByteArrayOutputStream baos;

    /**
     * Stores the original System.out.
     */
    private static PrintStream oldOut;

    /**
     * Stores the original System.in.
     */
    private static InputStream oldIn;

    /**
     * Creates a MazeGenerator to be used by all tests.
     */
    @BeforeAll
    public static void beforeAll()
    {
        mg = new MazeGenerator(RANDOM_MAZE_FILE, MazeTestUtils.HEIGHT, MazeTestUtils.WIDTH);
    }
    /**
     * Sets up the testing environment before each test.
     */
    @BeforeEach
    public void beforeEach()
    {
        oldOut = System.out;
        oldIn = System.in;
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
    }

    /**
     * Cleans up the testing environment after each test.
     */
    @AfterEach
    public void afterEach()
    {
        System.setOut(oldOut);
        System.setIn(oldIn);
    }

    /**
     * Tests moving up, down, left, and right.
     */
    @Test
    public void testSimpleMoves()
    {
        // game objects created in testMove
        int numTrials = 20;
        testMove("up", numTrials);
        testMove("down", numTrials);
        testMove("left", numTrials);
        testMove("right", numTrials);
    }

    @Test
    public void testWin()
    {
        int numTrials = 50;
        for (int i = 0; i < numTrials; i++)
        {
            game = genRandomGame();
            String winningMoves = mg.getWinningInput();
            game.setPlayerInput(new Scanner(new ByteArrayInputStream(winningMoves.getBytes())));
            game.playGame();
            String output = getOutput();
            assertEquals(WIN_MESSAGE, output.substring(
                output.length() - WIN_MESSAGE.length(), output.length()));
        }
    }

    /**
     * Gets the output printed to System.out.
     * Strips return characters.
     * Resets the buffer.
     * 
     * @return the string that was sent to System.out
     */
    private String getOutput()
    {
        System.out.flush();
        String output = baos.toString().replaceAll("\r", "");
        baos.reset();
        return output;
    }
    
    /**
     * Tests moving in a given direction.
     * 
     * @param direction "up", "down", "left", or "right"
     * @param numTrials the number of times to test the move
     */
    private void testMove(String direction, int numTrials)
    {
        for (int i = 0; i < numTrials; i++)
        {
            System.setIn(new ByteArrayInputStream((direction + "\nq\n").getBytes()));
            game = genRandomGame();
            int originalCol = game.getPlayerCol();
            int originalRow = game.getPlayerRow();
            game.playGame();
            validateMove(originalRow, originalCol, direction);
        }
    }

    /**
     * Validates that moving in a particular direction
     * succeeds if it should succeed and fails if it should fail.
     * 
     * @param originalRow the starting row
     * @param originalCol the starting column
     * @param direction the direction in which to move: "up", "down", "left", or "right"
     */
    private void validateMove(int originalRow, int originalCol, String direction)
    {
        int destCol = originalCol;
        int destRow = originalRow;
        String cellState = "blocked";
        switch (direction)
        {
            case "up":
                if (originalRow > 0 && !game.getBlocked()[originalRow - 1][originalCol])
                {
                    cellState = "free";
                    destRow--;
                }
                break;
            case "down":
                if (originalRow < MazeTestUtils.HEIGHT - 1
                    && !game.getBlocked()[originalRow + 1][originalCol]) 
                {
                    cellState = "free";
                    destRow++;
                }
                break;
            case "left":
                if (originalCol > 0 && !game.getBlocked()[originalRow][originalCol - 1]) 
                {
                    cellState = "free";
                    destCol--;
                }
                break;
            case "right":
                if (originalCol < MazeTestUtils.WIDTH - 1
                    && !game.getBlocked()[originalRow][originalCol + 1]) 
                {
                    cellState = "free";
                    destCol++;
                }
                break;
        }
        MazeTestUtils.validateSpot(destRow, destCol, game.getPlayerRow(), game.getPlayerCol(),
            String.format("When moving %s to a %s cell", direction, cellState), "player");
    }

    /**
     * Creates and returns a randomized game.
     * 
     * @return the randomized game or null if the game could not be created.
     */
    private MazeGame genRandomGame()
    {
        if (mg.generateRandomMazeFile())
        {
            return new MazeGame(RANDOM_MAZE_FILE);
        }
        else
        {
            fail("Could not run play tests due to being unable"
                    + " to create a file at " + RANDOM_MAZE_FILE);
            return null;
        }
    }
}
