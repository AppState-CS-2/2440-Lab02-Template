package util;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import util.specs.ClassSpec;
import util.specs.ConstructorSpec;
import util.specs.FieldSpec;
import util.specs.MethodSpec;

/**
 * Checks that a class is declared correctly.
 * Checks the modifiers of the class,
 *      the required fields
 *      the required constructors
 *      the required methods
 * 
 * Uses the template method.
 * 
 * Subclasses should override the five abstract methods
 * to make this test specific to a particular class
 * 
 * The methods that are not abstract should not need to be changed.
 * 
 * @author Willow Sapphire
 * @version 04/27/2023
 */
public abstract class StructureTest
{
    @SuppressWarnings("rawtypes")
    private Class testStruct;

    @BeforeEach
    public void beforeEach()
    {
        try {
            testStruct = Class.forName(getClassName());
        } catch (ClassNotFoundException e) {
            fail(String.format("Could not find class: %s", getClassName()));
        }
    }

    /**
     * Checks that the class is declared correctly.
     */
    @Test
    public void testClassDeclaration()
    {
        ClassSpec classSpec = getClassSpec();
        ClassTests.checkModifiers(testStruct.getModifiers(), classSpec.getName(),
            classSpec.getAccessModifier(), false, classSpec.getIsFinal(),
            classSpec.getIsAbstract(), false, classSpec.getIsInterface());
    }

    /**
     * Checks that the fields have been declared correctly.
     */
    @Test
    public void testFieldDeclarations()
    {
        ClassTests.testDeclarations(getFieldSpecs(), testStruct.getDeclaredFields());
    }

    /**
     * Checks that the constructors have Been declared correctly.
     */
    @Test
    public void testConstructorDeclarations()
    {
        ClassTests.testDeclarations(getConstructorSpecs(), testStruct.getDeclaredConstructors());
    }

    /**
     * Checks that the methods have the proper modifiers.
     */
    @Test
    public void testMethodDeclarations()
    {
        ClassTests.testDeclarations(getMethodSpecs(), testStruct.getDeclaredMethods());
    }

    /**
     * Gets the name of the class being tested.
     * 
     * @return the full class name
     */
    protected abstract String getClassName();

    /**
     * Get the specifications for the class being tested.
     * 
     * @return the specifications for the class being tested.
     */
    protected abstract ClassSpec getClassSpec();

    /**
     * Get the specifications for the fields of the class being tested.
     * 
     * @return the specifications for the fields of the class being tested.
     */
    protected abstract FieldSpec[] getFieldSpecs();
    
    /**
     * Get the specifications for the methods of the class being tested.
     * 
     * @return the specifications for the methods of the class being tested.
     */
    protected abstract MethodSpec[] getMethodSpecs();
    
    

    protected abstract ConstructorSpec[] getConstructorSpecs();
}
