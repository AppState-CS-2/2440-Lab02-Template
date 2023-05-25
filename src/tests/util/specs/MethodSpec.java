package util.specs;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Specifications to describe a method.
 * Used to define what particular methods should look like
 * and test against their actual implementation.
 * 
 * @author Willow Sapphire
 * @version 04/27/2023
 */
public class MethodSpec extends Spec
{
    /**
     * Creates a new MethodSpec object.
     * isInterface is always false since it is an invalid
     * modifier for methods.
     * 
     * @param name the method's name
     * @param accessModifier the method's access modifier
     * @param isStatic whether or not the method is static
     * @param isFinal whether or not the method is final
     * @param isAbstract whether or not the method is abstract
     * @param isSynchronized whether or not the method is synchronized
     * @param parameterTypes the types of the method's parameters
     * @param returnType the method's return type
     */
    public MethodSpec(String name, String accessModifier, boolean isStatic,
        boolean isFinal, boolean isAbstract, boolean isSynchronized,
        String[] parameterTypes, String returnType)
    {
        super("method", name, accessModifier, isStatic, isFinal, isAbstract,
            isSynchronized, false, parameterTypes, returnType);
    }

    /**
     * Describes the MethodSpec object as:
     *  "method: <methodName> with parameters: <methodParameters>"
     * 
     * @return the string describing this spec object.
     */
    @Override
    public String toString()
    {
        return String.format("method: %s with parameters: %s", name, Arrays.toString(paramTypes));
    }

    /**
     * Checks if this method matches the signature of a given method.
     * 
     * @param o the method to compare to
     * @return true if the given object is a method,
     *      has the same name, and has the same types of parameters
     */
    @Override
    public boolean matches(Member m)
    {
        if (m instanceof Method)
        {
            if (m.getName().equals(this.name))
            {
                @SuppressWarnings("rawtypes")
                Class[] params = ((Method) m).getParameterTypes();
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
        }
        return false;
    }
}
