package util.specs;

import java.lang.reflect.Member;

/**
 * Specifications to describe a class.
 * Used to define what particular classes should look like
 * and test against their actual implementation.
 * 
 * @author Willow Sapphire
 * @version 04/27/2023
 */
public class ClassSpec extends Spec
{
    /**
     * Creates a new ClassSpec object.
     * isSynchronized, isInterface are always false since they are invalid for fields.
     * paramTypes is always null since fields do not have parameters.
     * dataType is used as the returnType.
     * 
     * @param name the class' name
     * @param accessModifier the class' access modifier
     * @param isFinal whether or not the class is final
     * @param isAbstract whether or not the class is abstract
     * @param isInterface whether or not the class is an interface
     */
    public ClassSpec(String name, String accessModifier,
        boolean isFinal,boolean isAbstract,  boolean isInterface)
    {
        super("class", name, accessModifier, false, isFinal, 
            isAbstract, false, isInterface, null, null);
    }

    /**
     * A class spec matches a class if they have the same name.
     * 
     * @param m the member to match to
     * @return true if the member has the same name as the spec
     */
    @Override
    public boolean matches(Member m)
    {
        return this.name.equals(m.getName());
    }
}
