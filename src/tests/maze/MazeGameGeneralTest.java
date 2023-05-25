package maze;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import util.TestUtilities;
import util.maze.MapData;
import util.maze.MazeTestUtils;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Unit tests for the MazeGame class.
 * 
 * @author Willow Sapphire
 * @version 04/17/2023
 */
public class MazeGameGeneralTest
{
    /**
     * Message to use if a row or column is off the board.
     */
    private static final String INVALID_LOCATION_MESSAGE =
        "Location should not change if set beyond the bounds of the board";

    /**
     * Random valid row.
     */
    private static final int TEST_ROW = MazeTestUtils.getTestRow();

    /**
     * Random valid column.
     */
    private static final int TEST_COL = MazeTestUtils.getTestCol();

    /**
     * Random row off the top of the board.
     */
    private static final int ROW_OFF_TOP = MazeTestUtils.getRowOffTop();

    /**
     * Random row off the bottom of the board.
     */
    private static final int ROW_OFF_BOTTOM = MazeTestUtils.getRowOffBottom();

    /**
     * Random column off the left side of the board.
     */
    private static final int COL_OFF_LEFT = MazeTestUtils.getColOffLeft();

    /**
     * Random column off the right side of the board.
     */
    private static final int COL_OFF_RIGHT = MazeTestUtils.getColOffRight();

    /**
     * Board with random booleans.
     */
    private static final boolean[][] TEST_BOARD = MazeTestUtils.getRandomBoard();
    /**
     * Scanner used to test two-arg constructor
     * and to provide input to the maze program.
     */
    private static Scanner testInput;

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
     * Sets up the testing environment before each test.
     */
    @BeforeEach
    public void beforeEach()
    {
        oldOut = System.out;
        oldIn = System.in;
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        game = new MazeGame(MapData.EASY_MAP);
        baos.reset();
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
     * Tests the values of HEIGHT and WIDTH.
     */
    @Test
    public void testConstantValues()
    {
        assertEquals(MazeTestUtils.HEIGHT, MazeGame.HEIGHT,
            "Your HEIGHT constant does not have the correct value.");
        assertEquals(MazeTestUtils.WIDTH, MazeGame.WIDTH,
            "Your WIDTH constant does not have the correct value.");
    }

    /**
     * Checks that the one argument constructor works properly.
     */
    @Test
    public void testOneArgConstructor() throws FileNotFoundException
    {
        final String preamble = "In the one-arg constructor";
        MazeTestUtils.validateArrays(MapData.EASY_MAP_DATA, game.getBlocked(),
            preamble, "blocked");
        MazeTestUtils.validateArrays(MapData.ALL_FALSE_MAP, game.getVisited(),
            preamble, "visited");
        assertNotNull(game.getPlayerInput(),
            "One-arg constructor did not set playerInput");
        MazeTestUtils.validateSpot(MapData.EASY_MAP_START[MapData.ROW],
            MapData.EASY_MAP_START[MapData.COL],
            game.getPlayerRow(), game.getPlayerCol(), preamble, "player");
        MazeTestUtils.validateSpot(MapData.EASY_MAP_START[MapData.ROW],
            MapData.EASY_MAP_START[MapData.COL],
            game.getStartRow(), game.getStartCol(), preamble, "start");
        MazeTestUtils.validateSpot(MapData.EASY_MAP_GOAL[MapData.ROW],
            MapData.EASY_MAP_GOAL[MapData.COL],
            game.getGoalRow(), game.getGoalCol(), preamble, "goal");
    }

    /**
     * Checks that the two argument constructor works properly.
     */
    @Test
    public void testTwoArgConstructor() throws FileNotFoundException
    {
        game = new MazeGame(MapData.EASY_MAP, testInput);
        final String preamble = "In the two-arg constructor";
        MazeTestUtils.validateArrays(MapData.EASY_MAP_DATA, game.getBlocked(),
            preamble, "blocked");
        MazeTestUtils.validateArrays(MapData.ALL_FALSE_MAP, game.getVisited(),
            preamble, "visited");
        assertEquals(game.getPlayerInput(), testInput,
            "The input scanner is not equal to the scanner provided in the constructor");
        MazeTestUtils.validateSpot(MapData.EASY_MAP_START[MapData.ROW],
            MapData.EASY_MAP_START[MapData.COL],
            game.getPlayerRow(), game.getPlayerCol(), preamble, "player");
        MazeTestUtils.validateSpot(MapData.EASY_MAP_START[MapData.ROW],
            MapData.EASY_MAP_START[MapData.COL],
            game.getStartRow(), game.getStartCol(), preamble, "start");
        MazeTestUtils.validateSpot(MapData.EASY_MAP_GOAL[MapData.ROW],
            MapData.EASY_MAP_GOAL[MapData.COL],
            game.getGoalRow(), game.getGoalCol(), preamble, "goal");
    }

    /**
     * Tests the getters and setters for the player.
     */
    @Test
    public void testGetSetPlayer()
    {
        game.setPlayerRow(TEST_ROW);
        game.setPlayerCol(TEST_COL);
        MazeTestUtils.validateSpot(TEST_ROW, TEST_COL, game.getPlayerRow(), game.getPlayerCol(),
            "When using the getters and setters:", "player");
        game.setPlayerRow(ROW_OFF_TOP);
        game.setPlayerRow(COL_OFF_RIGHT);
        MazeTestUtils.validateSpot(TEST_ROW, TEST_COL, game.getPlayerRow(), game.getPlayerCol(),
            INVALID_LOCATION_MESSAGE, "player");
        game.setPlayerRow(ROW_OFF_BOTTOM);
        game.setPlayerRow(COL_OFF_LEFT);
        MazeTestUtils.validateSpot(TEST_ROW, TEST_COL, game.getPlayerRow(), game.getPlayerCol(),
            INVALID_LOCATION_MESSAGE, "player");
    }

    /**
     * Tests the getters and setters for the goal.
     */
    @Test
    public void testGetSetGoal()
    {
        game.setGoalRow(TEST_ROW);
        game.setGoalCol(TEST_COL);
        MazeTestUtils.validateSpot(TEST_ROW, TEST_COL, game.getGoalRow(), game.getGoalCol(),
            "When using the getters and setters:", "goal");
        game.setGoalRow(ROW_OFF_TOP);
        game.setGoalRow(COL_OFF_RIGHT);
        MazeTestUtils.validateSpot(TEST_ROW, TEST_COL, game.getGoalRow(), game.getGoalCol(),
            INVALID_LOCATION_MESSAGE, "goal");
        game.setGoalRow(ROW_OFF_BOTTOM);
        game.setGoalRow(COL_OFF_LEFT);
        MazeTestUtils.validateSpot(TEST_ROW, TEST_COL, game.getGoalRow(), game.getGoalCol(),
            INVALID_LOCATION_MESSAGE, "goal");
    }

    /**
     * Tests the getters and setters for the start.
     */
    @Test
    public void testGetSetStart()
    {
        game.setStartRow(TEST_ROW);
        game.setStartCol(TEST_COL);
        MazeTestUtils.validateSpot(TEST_ROW, TEST_COL, game.getStartRow(), game.getStartCol(),
            "When using the getters and setters:", "start");
        game.setStartRow(ROW_OFF_TOP);
        game.setStartRow(COL_OFF_RIGHT);
        MazeTestUtils.validateSpot(TEST_ROW, TEST_COL, game.getStartRow(), game.getStartCol(),
            INVALID_LOCATION_MESSAGE, "start");
        game.setStartRow(ROW_OFF_BOTTOM);
        game.setStartRow(COL_OFF_LEFT);
        MazeTestUtils.validateSpot(TEST_ROW, TEST_COL, game.getStartRow(), game.getStartCol(),
            INVALID_LOCATION_MESSAGE, "start");
    }

    /**
     * Tests the getters and setters for the blocked array.
     */
    @Test
    public void testGetSetBlocked()
    {
        game.setBlocked(TEST_BOARD);
        assertFalse(TEST_BOARD == game.getBlocked(), 
            "The blocked array setter did not set the array to a copy of the provided array");
            MazeTestUtils.validateArrays(TEST_BOARD, game.getBlocked(), 
            "When using the getters and setters", "blocked");
    }

    /**
     * Tests the getters and setters for the visited array.
     */
    @Test
    public void testGetSetVisited()
    {
        boolean[][] board = MazeTestUtils.getRandomBoard();
        game.setVisited(board);
        assertFalse(board == game.getVisited(), 
            "The visited array setter did not set the array to a copy of the provided array");
            MazeTestUtils.validateArrays(board, game.getVisited(), 
            "When using the getters and setters", "visited");
    }

    /**
     * Tests the getters and setters for the player input.
     */
    @Test
    public void testGetSetPlayerInput()
    {
        Scanner s = new Scanner("TEST");
        game.setPlayerInput(s);
        assertTrue(s == game.getPlayerInput(), 
            "The playerInput setter did not set the playerInput");
    }
    
    /**
     * Tests the printMaze method.
     */
    @Test
    public void testPrintMaze()
    {
        final int NUM_TESTS = 20;
        for (int i = 0; i < NUM_TESTS; i++)
        {
            MazeTestUtils.randomizeBoard(game);
            game.printMaze();
            assertEquals(MazeTestUtils.foo(game), TestUtilities.getOutput(baos),
                "Unexpected print output");
        }
    }
}
