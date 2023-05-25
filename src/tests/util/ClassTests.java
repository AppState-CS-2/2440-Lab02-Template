package util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.Modifier;
import java.lang.reflect.Member;

import util.specs.Spec;

/**
 * Useful test functions when testing class implementations.
 * All functions are static.
 * All functions are void.
 * All functions call junit assertions.
 * 
 * @author Willow Sapphire
 * @version 04/27/2023
 */
public class ClassTests
{
    /**
     * Tests a set of modifiers.
     * Tests that the given modifier matches each of
     * the requirements specified by the other parameters.
     * Provides a specific error message for each modifier.
     * 
     * @param modifier the modifier int containing the "actual" values
     * @param name the name of the structure being tested
     * @param accessModifier the correct access modifier
     * @param isStatic whether or not there should be a static modifier
     * @param isFinal whether or not there should be a final modifier
     * @param isAbstract whether or not there should be an abstract modifier
     * @param isSynchronized whether or not there should be a synchronized modifier
     * @param isInterface whether or not there should be an interface modifier
     */
    public static void checkModifiers(int modifier, String name, String accessModifier,
        boolean isStatic, boolean isFinal, boolean isAbstract, boolean isSynchronized,
        boolean isInterface)
    {
        assertEquals(accessModifier.equals("public") ? true : false, Modifier.isPublic(modifier),
            String.format("%s should %sbe public", name,
                Modifier.isPublic(modifier) ? "not " : ""));

        assertEquals(accessModifier.equals("protected") ? true : false, Modifier.isProtected(modifier),
            String.format("%s should %sbe protected", name,
                Modifier.isProtected(modifier) ? "not " : ""));

        assertEquals(accessModifier.equals("private") ? true : false, Modifier.isPrivate(modifier),
            String.format("%s should %sbe private", name,
                Modifier.isPrivate(modifier) ? "not " : ""));

        assertEquals(isStatic, Modifier.isStatic(modifier),
            String.format("%s should %sbe static", name,
                Modifier.isStatic(modifier) ? "not " : ""));

        assertEquals(isFinal, Modifier.isFinal(modifier),
            String.format("%s should %sbe final", name,
                Modifier.isFinal(modifier) ? "not " : ""));

        assertEquals(isAbstract, Modifier.isAbstract(modifier),
            String.format("%s should %sbe abstract", name,
                Modifier.isAbstract(modifier) ? "not " : ""));

        assertEquals(isSynchronized, Modifier.isSynchronized(modifier),
            String.format("%s should %sbe synchronized", name,
                Modifier.isSynchronized(modifier) ? "not " : ""));

        assertEquals(isInterface, Modifier.isInterface(modifier),
            String.format("%s should %sbe an interface", name,
                Modifier.isInterface(modifier) ? "not " : ""));
    }

    /**
     * Tests that a single specification is present in a the
     * list of members where it ought to be present.
     * 
     * @param spec the specification of the member to find
     * @param actuals the list of members
     */
    public static void testDeclaration(Spec spec, Member[] actuals)
    {
        boolean found = false;
        for (Member actual : actuals)
        {
            if (spec.matches(actual))
            {
                checkModifiers(actual.getModifiers(), spec.getName(),
                    spec.getAccessModifier(), spec.getIsStatic(), spec.getIsFinal(),
                    spec.getIsAbstract(), spec.getIsSynchronized(), spec.getIsInterface());
                found = true;
                break;
            }
        }
        if (!found)
        {
            fail(String.format("Could not find %s", spec));
        }
    }

    /**
     * Tests that a list of specifications are all found in a list of members.
     * 
     * @param specs the member specifications to find
     * @param actuals the list of members
     */
    public static void testDeclarations(Spec[] specs, Member[] actuals)
    {
        if (specs.length > actuals.length)
        {
            fail(String.format("You should have at least %d %ss. Only found %d.",
                specs.length, specs[0].getSpecType(), actuals.length));
        }
        for (Spec spec : specs)
        {
            testDeclaration(spec, actuals);
        }
    }
}
