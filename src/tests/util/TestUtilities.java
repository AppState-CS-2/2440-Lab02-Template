package util;

import java.io.ByteArrayOutputStream;

/**
 * Library of useful functions for unit testing.
 * 
 * @author Willow Sapphire
 * @version 04/20/2023
 */
public class TestUtilities
{
    /**
     * Gets output that was printed to the screen,
     * Strips return characters.
     * Resets the output stream.
     * 
     * @return the string printed to System.out
     */
    public static final String getOutput(ByteArrayOutputStream baos)
    {
        System.out.flush();
        String output = baos.toString().replaceAll("\r", "");
        baos.reset();
        return output;
    }
}
