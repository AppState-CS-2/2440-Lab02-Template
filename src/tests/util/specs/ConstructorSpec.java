package util.specs;

import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.util.Arrays;

/**
 * Specifications to describe a constructor.
 * Used to define what particular constructors should look like
 * and test against their actual implementation.
 * 
 * @author Willow Sapphire
 * @version 04/27/2023
 */
public class ConstructorSpec extends Spec
{
    /**
     * Creates a new ConstructorSpec object.
     * isStatic, isFinal, isAbstract, isSynchronized, isInterface
     * are always false since they are invalid for constructors.
     * returnType is always null since constructors do not have a return type.
     * 
     * @param name the constructor's name
     * @param accessModifier the constructor's access modifier
     * @param parameterTypes the types of the constructor's parameters
     */
    public ConstructorSpec(String name, String accessModifier, String[] parameterTypes)
    {
        super("constructor", name, accessModifier, false, 
            false, false, false, false, parameterTypes, null);
    }

    /**
     * Describes the ConstructorSpec object as:
     *  "constructor with parameters: <constructorParameters>"
     * 
     * @return the string describing this spec object.
     */
    @Override
    public String toString()
    {
        return String.format("constructor: %s with parameters: %s", name, Arrays.toString(paramTypes));
    }

    /**
     * A constructor spec matches a constructor if
     * they have the same name and parameter types.
     * 
     * @param m the constructor to compare to.
     * @return true if they match
     */
    @Override
    @SuppressWarnings("rawtypes")
    public boolean matches(Member m)
    {
        if (m instanceof Constructor && m.getName().equals(this.name))
        {
            Class[] params = ((Constructor) m).getParameterTypes();
            if (params.length != this.paramTypes.length)
            {
                return false;
            }
            for (int i = 0; i < this.paramTypes.length; i++)
            {
                if (!(params[i].getName().equals(this.paramTypes[i])))
                {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
