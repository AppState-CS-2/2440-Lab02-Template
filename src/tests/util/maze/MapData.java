package util.maze;

/**
 * Data used for testing the maze game.
 * 
 * @author Willow Sapphire
 * @version 04/27/2023
 */
public class MapData
{
    public static final String EASY_MAP = "src/data/easy.txt";
    public static final String EASY_MAP_OUTPUT = "src/data/easy_output.txt";
    public static final String EASY_WIN_CRUMBS = "src/data/easy_win_crumbs.txt";
    public static final String EASY_LOSE_CRUMBS = "src/data/easy_lose_crumbs.txt";
    public static final String MAP_1 = "src/data/hard.txt";
    public static final String MAP_1_OUTPUT = "src/data/hard_output.txt";
    public static final int HEIGHT = 19;
    public static final int WIDTH = 39;
    public static final int[] EASY_MAP_START = {0, 0};
    public static final int[] EASY_MAP_GOAL = {10, 38};
    public static final int ROW = 0;
    public static final int COL = 1;

    public static final boolean[][] EASY_MAP_DATA = {
        {
            false, true, false, false, false, false, false, false, false, 
            false, false, false, false, true, false, false, false, false, 
            false, true, false, false, false, false, false, false, false, 
            false, false, true, false, false, false, false, false, false, 
            false, false, false
        }, {
            false, true, true, true, false, true, true, true, false, 
            true, true, true, false, true, false, true, true, true, 
            false, true, false, true, true, true, true, true, true, 
            true, false, true, false, true, true, true, true, true, 
            false, true, false
        }, {
            false, false, false, true, false, false, false, true, false, 
            true, false, true, false, true, false, true, false, true, 
            false, true, false, false, false, true, false, false, false, 
            true, false, true, false, true, false, false, false, false, 
            false, true, false
        }, {
            true, true, false, true, true, true, true, true, false, 
            true, false, true, false, true, false, true, false, true, 
            false, true, true, true, false, true, false, true, false, 
            true, false, true, false, true, false, true, true, true, 
            true, true, false
        }, {
            false, true, false, false, false, true, false, false, false, 
            true, false, true, false, false, false, true, false, true, 
            false, false, false, false, false, true, false, true, false, 
            false, false, true, false, true, false, true, false, false, 
            false, true, false
        }, {
            false, true, true, true, false, true, false, true, true, 
            true, false, true, true, true, true, true, false, true, 
            true, true, true, true, true, true, false, true, true, 
            true, true, true, true, true, false, true, false, true, 
            true, true, false
        }, {
            false, false, false, true, false, true, false, false, false, 
            true, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, true, false, false, false, 
            false, false, true, false, false, false, true, false, false, 
            false, false, false
        }, {
            true, true, false, true, false, true, false, true, false, 
            true, false, true, false, true, true, true, true, true, 
            true, true, true, true, false, true, true, true, true, 
            true, false, true, false, true, true, true, false, true, 
            true, true, true
        }, {
            false, false, false, true, false, true, false, true, false, 
            true, false, true, false, false, false, false, false, true, 
            false, false, false, false, false, true, false, false, false, 
            true, false, true, false, true, false, false, false, false, 
            false, false, false
        }, {
            false, true, true, true, false, true, true, true, false, 
            true, true, true, false, true, true, true, false, true, 
            true, true, true, true, false, true, true, true, false, 
            true, false, true, false, true, true, true, true, true, 
            true, true, false
        }, {
            false, false, false, true, false, false, false, true, false, 
            false, false, true, false, false, false, true, false, false, 
            false, false, false, true, false, false, false, false, false, 
            true, false, true, false, false, false, true, false, false, 
            false, true, false
        }, {
            false, true, false, true, true, true, false, true, true, 
            true, false, true, true, true, false, true, true, true, 
            true, true, false, true, true, true, false, true, true, 
            true, false, true, false, true, false, true, false, true, 
            false, true, true
        }, {
            false, true, false, true, false, false, false, true, false, 
            false, false, true, false, false, false, true, false, false, 
            false, true, false, true, false, true, false, true, false, 
            false, false, true, false, true, false, false, false, true, 
            false, false, false
        }, {
            false, true, false, true, false, true, true, true, false, 
            true, true, true, false, true, true, true, true, true, 
            false, true, false, true, false, true, false, true, false, 
            true, true, true, true, true, true, true, true, true, 
            true, true, false
        }, {
            false, true, false, false, false, true, false, false, false, 
            true, false, true, false, false, false, false, false, false, 
            false, true, false, true, false, false, false, true, false, 
            true, false, false, false, true, false, false, false, false, 
            false, true, false
        }, {
            false, true, true, true, true, true, false, true, true, 
            true, false, true, true, true, true, true, true, true, 
            false, true, false, true, true, true, false, true, false, 
            true, false, true, false, true, false, true, true, true, 
            false, true, false
        }, {
            false, false, false, false, false, true, false, false, false, 
            true, false, false, false, false, false, true, false, false, 
            false, true, false, false, false, true, false, true, false, 
            false, false, true, false, true, false, false, false, true, 
            false, false, false
        }, {
            true, true, true, true, false, true, true, true, false, 
            true, false, true, true, true, false, true, false, true, 
            true, true, true, true, false, true, true, true, true, 
            true, true, true, false, true, true, true, false, true, 
            true, true, false
        }, {
            false, false, false, false, false, false, false, false, false, 
            true, false, false, false, true, false, false, false, false, 
            false, false, false, true, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, true, 
            false, false, false
        }
    };

    public static final boolean[][] ALL_FALSE_MAP = {
        {
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false
        }, {
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false
        }, {
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false
        }, {
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false
        }, {
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false
        }, {
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false
        }, {
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false
        }, {
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false
        }, {
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false
        }, {
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false
        }, {
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false
        }, {
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false
        }, {
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false
        }, {
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false
        }, {
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false
        }, {
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false
        }, {
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false
        }, {
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false
        }, {
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, 
            false, false, false
        }
    };

    public static final String MOVE_INPUT = "down\ndown\nright\nright\ndown\n"
        + "down\nright\nright\ndown\ndown\ndown\ndown\ndown\ndown\nright\n"
        + "right\ndown\ndown\nleft\nleft\ndown\ndown\nleft\nleft\nup\nup\nup\n"
        + "up\nleft\nleft\ndown\ndown\ndown\ndown\ndown\ndown\nright\nright\n"
        + "right\nright\ndown\ndown\nright\nright\nright\nright\nup\nup\n"
        + "left\nleft\nup\nup\nright\nright\nup\nup\nright\nright\nup\nup\n"
        + "left\nleft\nup\nup\nup\nup\nleft\nleft\nup\nup\nright\nright\nup\n"
        + "up\nup\nup\nright\nright\nright\nright\ndown\ndown\ndown\ndown\n"
        + "right\nright\nup\nup\nup\nup\nright\nright\nright\nright\ndown\n"
        + "down\ndown\ndown\nright\nright\nright\nright\nup\nup\nleft\nleft\n"
        + "up\nup\nright\nright\nright\nright\nright\nright\nright\nright\n"
        + "down\ndown\ndown\ndown\nleft\nleft\nup\nup\nleft\nleft\ndown\ndown"
        + "\ndown\ndown\nright\nright\nright\nright\ndown\ndown\ndown\ndown\n"
        + "down\ndown\nleft\nleft\ndown\ndown\ndown\ndown\nright\nright\nup\n"
        + "up\nright\nright\ndown\ndown\ndown\ndown\nright\nright\nright\n"
        + "right\nup\nup\nleft\nleft\nup\nup\nright\nright\nright\nright\n"
        + "down\ndown\nright\nright\nup\nup\nup\nup\nleft\nleft\nup\nup\n"
        + "left\nleft\ndown\ndown\nleft\nleft\nup\nup\nleft\nleft\nup\nup\n"
        + "up\nup\nright\nright\nup\nup\nup\nup\nright\nright\nright\nright\n"
        + "up\nup\nright\nright\ndown\ndown\ndown\ndown\ndown\ndown\nleft\n"
        + "left\nleft\nleft\ndown\ndown\nright\nright\nright\nright\ndown\n"
        + "down\n";

    public static final String LOSE_INPUT = "down\ndown\nright\nright\ndown\n"
        + "down\nright\nright\ndown\ndown\ndown\ndown\ndown\ndown\nright\n"
        + "right\ndown\ndown\nleft\nleft\ndown\ndown\nleft\nleft\nup\nup\nup\n"
        + "up\nleft\nleft\nup\nup\nright\nright\nup\nup\nleft\nleft\nup\nup\n"
        + "quit\n";
}
