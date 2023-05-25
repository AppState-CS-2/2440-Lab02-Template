package util.specs;

import java.lang.reflect.Member;

/**
 * Specifications for Java structures.
 * Depending on the type of structure, some fields may not be needed.
 * 
 * @author Willow Sapphire
 * @version 04/27/2023
 */
public abstract class Spec
{
    /**
     * The name of the structure.
     */
    protected String name;

    /**
     * The access modifier of the structure.
     */
    protected String accessModifier;

    /**
     * True if the structure is static.
     */
    protected boolean isStatic;

    /**
     * True if the structure is final.
     */
    protected boolean isFinal;

    /**
     * True if the structure is abstract.
     */
    protected boolean isAbstract;

    /**
     * True if the structure is synchronized.
     */
    protected boolean isSynchronized;

    /**
     * True if the structure is an interface.
     */
    protected boolean isInterface;

    /**
     * The types of parameters for the structure.
     */
    protected String[] paramTypes;

    /**
     * The return type of the structure.
     */
    protected String returnType;

    /**
     * The specification type.
     */
    protected String specType;

    /**
     * Creates a new Spec object.
     * 
     * @param specType the type of specification
     * @param name the structure's name
     * @param accessModifier the structure's access modifier
     * @param isStatic whether or not the structure is static
     * @param isFinal whether or not the structure is final
     * @param isAbstract whether or not the structure is abstract
     * @param isSynchronized whether or not the structure is synchronized
     * @param isInterface whether or not the structure is an interface
     * @param parameterTypes the types of the structure's parameters
     * @param returnType the structure's return type
     */
    public Spec(String specType, String name, String accessModifier, boolean isStatic,
        boolean isFinal, boolean isAbstract, boolean isSynchronized, boolean isInterface,
        String[] parameterTypes, String returnType)
    {
        this.specType = specType;
        this.name = name;
        this.accessModifier = accessModifier;
        this.isStatic = isStatic;
        this.isFinal = isFinal;
        this.isAbstract = isAbstract;
        this.isSynchronized = isSynchronized;
        this.isInterface = isInterface;
        this.paramTypes = parameterTypes;
        this.returnType = returnType;
    }

    /**
     * Getter for the type of specification.
     * 
     * @return specType
     */
    public String getSpecType()
    {
        return specType;
    }
    /**
     * Getter for the structure's name.
     * 
     * @return name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Getter for the structure's access modifier.
     * 
     * @return accessModifier
     */
    public String getAccessModifier()
    {
        return accessModifier;
    }

    /**
     * Getter for if the structure is static.
     * 
     * @return isStatic
     */
    public boolean getIsStatic()
    {
        return isStatic;
    }

    /**
     * Getter for if the structure is final.
     * 
     * @return isFinal
     */
    public boolean getIsFinal()
    {
        return isFinal;
    }

    /**
     * Getter for if the structure is abstract.
     * 
     * @return isAbstract
     */
    public boolean getIsAbstract()
    {
        return isAbstract;
    }

    /**
     * Getter for if the structure is synchronized.
     * 
     * @return isSynchronized
     */
    public boolean getIsSynchronized()
    {
        return isSynchronized;
    }

    /**
     * Getter for if the structure is an interface.
     * 
     * @return isInterface
     */
    public boolean getIsInterface()
    {
        return isInterface;
    }

    /**
     * Getter for the types of the structure's parameters.
     * 
     * @return paramTypes
     */
    public String[] getParamTypes()
    {
        return paramTypes;
    }

    /**
     * Getter for the structure's return type.
     * 
     * @return returnType
     */
    public String getReturnType()
    {
        return returnType;
    }

    @Override
    public String toString()
    {
        return String.format("%s: %s", specType, name);
    }

    /**
     * Checks if the specifications match a real member object.
     * 
     * @param o the member to compare to.
     * @return true if the specs match the object, false otherwise
     */
    public abstract boolean matches(Member m);
}
