package util.specs;

import java.lang.reflect.Field;
import java.lang.reflect.Member;

/**
 * Specifications to describe a field.
 * Used to define what particular fields should look like
 * and test against their actual implementation.
 * 
 * @author Willow Sapphire
 * @version 04/27/2023
 */
public class FieldSpec extends Spec
{
    /**
     * Creates a new FieldSpec object.
     * isSynchronized, isInterface are always false since they are invalid for fields.
     * paramTypes is always null since fields do not have parameters.
     * dataType is used as the returnType.
     * 
     * @param name the field's name
     * @param accessModifier the field's access modifier
     * @param isStatic whether or not the field is static
     * @param isFinal whether or not the field is final
     * @param isAbstract whether or not the field is abstract
     * @param dataType the field's data type
     */
    public FieldSpec(String name, String accessModifier, boolean isStatic,
        boolean isFinal, String dataType)
    {
        super("field", name, accessModifier, isStatic, isFinal, false, 
            false, false, null, dataType);
    }

    /**
     * Describes the FieldSpec object as:
     *  "field: <fieldName> of type: <returnType>"
     * 
     * @return the string describing this spec object.
     */
    @Override
    public String toString()
    {
        return String.format("field: %s of type: %s", name, returnType);
    }

    /**
     * Checks if this field matches the signature of a given field.
     * 
     * @param m the field to compare to
     * @return true if the given object is a field,
     *      has the same name, and has the same types of parameters
     */
    @Override
    public boolean matches(Member m)
    {
        return m instanceof Field
            && name.equals(((Field) m).getName())
            && returnType.equals(((Field) m).getType().getName());
    }

}
