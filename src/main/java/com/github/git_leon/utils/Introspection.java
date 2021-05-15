package com.github.git_leon.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @author Chris
 * @purpose - Handle reflection methods
 */
public abstract class Introspection {

    /**
     * @param object     object whose fields to access
     * @param fieldClass type of field to retrieve
     * @return ArrayList of values
     */
    public static <T, E> ArrayList<E> getFieldValues(T object, Class<E> fieldClass) {
        ArrayList<E> fields = new ArrayList<E>();
        for (Field f : object.getClass().getDeclaredFields()) {
            if (f.getType().equals(fieldClass)) {
                try {
                    boolean defaultAccess = f.isAccessible();
                    f.setAccessible(true);
                    E obj = fieldClass.cast(f.get(object));
                    fields.add(obj);
                    f.setAccessible(defaultAccess);
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return fields;
    }

    /**
     * @param obj some object
     * @return object class name concatenated with object hash code
     */
    public static String getId(Object obj) {
        return obj.getClass().getSimpleName() + " - " + obj.hashCode();
    }

    /**
     * @param someObject   the object to retrieve values from
     * @param fieldClass   the type of value to retrieve
     * @param fieldName    the name of the field
     * @param <SomeObject> handling any object
     * @param <SomeType>   handling any field-type
     * @return the value you are seeking
     */
    public static <SomeObject, SomeType> SomeType getPrivateFieldValues(SomeObject someObject, Class<SomeType> fieldClass, String fieldName) {
        SomeType desiredValue = null;
        Class<?> someClass = someObject.getClass();
        Field[] someClassFields = someClass.getDeclaredFields();
        Field[] someSuperClassFields = someClass.getSuperclass().getDeclaredFields();
        Field[] mergedFields = ArrayHandler.concatenate(someClassFields, someSuperClassFields);
        for (Field field : mergedFields) {
            try {
                boolean defaultAccess = field.isAccessible();
                boolean condition1 = field.getType().equals(fieldClass);
                boolean condition2 = field.getName().equalsIgnoreCase(fieldName);
                if (condition1 && condition2) {
                    field.setAccessible(true);
                    desiredValue = fieldClass.cast(field.get(someObject));
                    field.setAccessible(defaultAccess);
                }
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return desiredValue;
    }

    /**
     * @param c the class to retrieve from
     * @return an arraylist of super classes
     */
    public static ArrayList<Class> getSuperClasses(Class<?> c) {
        ArrayList<Class> classes = new ArrayList<Class>();
        do {
            classes.add(c);
            c = c.getSuperclass();
        } while (c != null);
        return classes;
    }

    /**
     * @param object the object whose fields to print
     * @implNote prints all of the fields names and respective value of the specified objcet
     */
    public static void printFields(Object object) {
        Console.println("Printing field values of %s", getId(object));
        for (Field field : object.getClass().getDeclaredFields()) {
            try {
                Console.println("\tName: %s\n\tValue: %s\n", field.getName(), field.get(object));
            } catch (Exception e) {

            }
        }
    }

    /**
     * @param invoker    the object to invoke the method
     * @param methodName the name of the method to be invoked
     */
    public static void runMethod(Object invoker, String methodName) {
        Method methodToFind = null;
        try {
            if (invoker != null) {
                methodToFind = invoker.getClass().getMethod(methodName);
                if (methodToFind != null) {
                    methodToFind.invoke(invoker);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
