package yaku.string;

import yaku.logic.Lock;

/**
 * @author Elijah Bare
 * <p>
 * The `StringUtils` class provides utility methods for manipulating strings.
 */
public class StringUtils {

    /**
     * Generates a string consisting of a specified number of newline characters.
     *
     * @param n the number of newlines to generate.
     * @return a string with the specified number of newlines.
     */
    public static String newLineGen(int n){
        return "\n".repeat(n);
    }

    /**
     * Prints a specified number of newlines to the console.
     *
     * @param n the number of newlines to print.
     */
    public static void printNewlines(int n){
        System.out.println(newLineGen(n));
    }

    /**
     * Prints the given string and waits for the specified duration.
     *
     * @param toPrint  The string to be printed.
     * @param toWait   The duration in milliseconds to wait.
     */
    public static void printWait(String toPrint, int toWait) {
        System.out.println(toPrint);
        Lock lock = new Lock(false);
        lock.lock(toWait);
        lock.waitHere();
    }



}

