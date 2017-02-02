/**
 * Packages https://docs.oracle.com/javase/tutorial/java/package/index.html
 * A package is a grouping of related types providing access protection and name
 * space management. 
 * 
 * NOTE: types refers to classes, interfaces, enumerations, and annotation types.
 * Enumerations and annotation types are special kinds of classes and interfaces.
 * 
 * You cannot use "-" (hyphens) within a package name, instead use "_" (underscore.)
 */
package com.cmclinnovations.codepalette.basic_concepts.java_semantics;

/**
 * Importing https://docs.oracle.com/javase/tutorial/java/package/usepkgs.html
 * Allows the use of other classes/types in your code. Every import
 * statement is a dependency where the code being used is taken from another 
 * location. These sometimes have to be downloaded using Maven look at pom.xml to
 * see what version of a package you are currently using.
 * 
 * when an import statement is used the class or interface can be refereed to by
 * its simple name. 
 * To import all the types contained in a particular package, use the import 
 * statement with the asterisk (*) wildcard character.
 * 
 * Name ambiguities can occur if a member in one package shares its name with a 
 * member in another package and both packages are imported, you must refer to 
 * each member by its qualified name. See the Logger objects below for example.
 */
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class demonstrates examples of general Java language semantics.
 * You can find out more by reading the related Oracle tutorials.
 * https://docs.oracle.com/javase/tutorial/java/javaOO/index.html
 * 
 * Topics covered:
 * -Packages and importing a package member
 * -Importing libraries and declaring objects

* -Static variables and methods
 * -Initialisation blocks (Within a Class and Instance) 
 * -Arbitrary number of arguments (also known as varargs) 
 * -Using the "this" keyword (Within an instance method or a constructor)
 * -CHECK: What is the proper name for this. Multiple Constructor methods with same name.
 * -TODO: Annotations
 * -TODO: Enums (enumerations)
 * 
 * @author Christopher Stavrou <cstavrou@cmclinnovations.com>
 */
public class Names {
    
    /**
     * Logger 
     * TODO: Write description for Logger. What is it?
     * TODO: Find out how to use and compare the native Java and SL4J Logger
     */
    private static final java.util.logging.Logger JAVA_LOGGER = java.util.logging.Logger.getLogger(Names.class.getName());
    private static final org.slf4j.Logger SL4FJ_LOGGER = org.slf4j.LoggerFactory.getLogger(Names.class.getName());
    
    /**
     * NOTE: The modifier static in their declaration are called static fields or
     * class variables. They are associated with the class, rather than with any
     * object. Anything using this modifier will be common to all objects.
     * 
     * static variables follow different naming conventions 
     */
    private static final ArrayList<String> ALL_CLASS_NAMES;
    
    
    /**
     * TODO: Describe the use and benefits of normal non static 
     */
    private static ArrayList<String> allInstanceNames;

    /**
     * Static initialisation block: Runs once (when the class is initialised)
     */
    static {
        /**
         * NOTE: Static variables only need be used once because it is shared
         * among all other instances. No real point in putting them in the
         * constructor to initialise them again on creation of a new instance.
         * This is often the reason static fields are final.
         */
        System.out.println("Static initalization.");
        ALL_CLASS_NAMES = new ArrayList<>();

        //TODO: Create strings and add them to the static ArrayList allClassNames
        for (int i = 0; i < 10; i++) {
            String name = null;
            ALL_CLASS_NAMES.add(name);
        }
    }

    /**
     * Instance initialisation block: Runs each time you instantiate an object
     */
    {
        System.out.println("Instance initialization.");
        allInstanceNames = new ArrayList<>();
    }

    /**
     * Constructor with no arguments. It uses the operator this keyword to
     * explicitly invocate a constructor in the same class.
     *
     * NOTE: Other than being used for explicit constructor invocation. The most
     * common reason for using the this keyword is because a field is shadowed
     * by a method or constructor parameter.
     */
    public Names() {
        //TODO Set the explicit constructor invocation.
        this("");
    }

    /**
     * Constructor takes an arbitrary number of String arguments
     *
     * NOTE: Constructors are invoked every time a new instance is created and
     * only ever once.
     *
     * @param names An arbritrary number of String arguments. Even though one
     * String parameter is declared it can receive any number. new
     * Names("variable_1", "variable_2", "variable_3");
     */
    public Names(String... names) {
        
    }

    /**
     * CHECK: What will happen when you try to make changes to a final var?
     * Although this is valid Java the variable ALL_CLASS_NAMES is final
     * and it will not work.
     */
    public static void someMethod(){
        //TODO: Try and make changes to a final variable
    }
    
    
    /**
     * Add one or many names to an ArrayList
     * @param arrayList 
     * @param names pass an arbritrary amount of Strings
     */
    public static void addNames(ArrayList<String> arrayList,String... names) {
        arrayList.addAll(Arrays.asList(names));
    }

    /**
     * Get the entire ArrayList of Names from the Class
     * @return ArrayList<String> ALL_CLASS_NAMES
     */
    public static ArrayList<String> getAllClassNames() {
        return ALL_CLASS_NAMES;
    }
    
    /**
     * Get a single name from the ArrayList based on index
     * @param index
     * @return
     */
    public static String getClassName(int index) {
        return ALL_CLASS_NAMES.get(index);
    }
}
