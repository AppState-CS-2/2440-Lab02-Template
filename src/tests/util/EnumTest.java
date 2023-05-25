package util;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Generic unit tests for enumerated types.
 * 
 * @author Willow Sapphire
 * @version 04/06/2023
 */
public abstract class EnumTest
{
    private String name;
    private String accessModifier;
    private String[] values;

    /**
     * The enumerated type being tested.
     */
    @SuppressWarnings("rawtypes")
    private Class e;

    public EnumTest(String name, String accessModifier, String[] values)
    {
        this.name = name;
        this.accessModifier = accessModifier;
        this.values = values;
    }

    /**
     * Creates a new test enumerated type for each test.
     * Fails the test if the class could not be found.
     */
    @BeforeEach
    public void beforeEach()
    {
        try {
            e = Class.forName(name);
        } catch (ClassNotFoundException e) {
            fail(String.format("Could not find enum: %s", name));
        }
    }

    /**
     * Tests the modifiers of the enumerated type.
     */
    @Test
    public void testModifiers()
    {
        assertTrue(e.isEnum(), String.format("Class: %s should be an enumerated type", name));
        ClassTests.checkModifiers(e.getModifiers(), name, accessModifier,
        false,true, false, false, false);
    }

    /**
     * Tests the values of the enumerated type.
     */
    @Test
    public void testValues()
    {
        try {
            @SuppressWarnings("unchecked")
            Object[] actualValues = (Object[]) (e.getMethod("values").invoke(null));
            assertEquals(values.length, actualValues.length);
            for (int i = 0; i < values.length; i++)
            {
                assertEquals(values[i].toString(), actualValues[i].toString(),
                    String.format("Incorrect value \"%s\" for value %d of %s",
                    actualValues[i].toString(), i, name));
            }
        } catch (IllegalAccessException | IllegalArgumentException
            | InvocationTargetException | NoSuchMethodException |SecurityException e) {
            fail(String.format("Error testing %s.\n%s", name, e.toString()));
        }
    }
}