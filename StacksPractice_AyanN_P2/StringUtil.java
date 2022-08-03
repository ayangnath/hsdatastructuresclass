import java.util.Stack;

/**
 * @author Anu Datar
 * @author Ayan Nath
 * @version 10/29/2021
 */
public class StringUtil
{
    /**
     * reverses a string using stacks
     * @param str the string to reverse
     * @return a String that is reversed
     */
    public static String reverseString(String str)
    {
        Stack<String> s = new Stack<String>();
        String rev = "";
        // Write me by replacing the line below
        String[] arr = str.split("");

        for (int i = 0; i < arr.length; i++)
        {
            s.push(arr[i]);
        }

        for (int i = 0; i < arr.length; i++)
        {
            rev+=s.pop();
        }
        return rev;
    }

    /**
     * determines if a string is the same as its reverse
     * @param s the strick to check if its a palindrome
     * @return true if palindrome; otherwise
     *          false
     */
    public static boolean isPalindrome(String s)
    {
        String reverse = reverseString(s);
        return (s.equals(reverse));
    }

    // The tester for checking that reverse and isPalindrome work well.
    public static void main(String[] args)
    {
        String test =  "racecar";
        String test2 = "notapalindrome";

        if ( !("".equalsIgnoreCase(reverseString(""))) )
            System.out.println("** Oops Something went wrong. Check your reverse method **");

        if ( !("a".equalsIgnoreCase(reverseString("a"))) )
            System.out.println("** Oops Something went wrong. Check your reverse method **");

        if (!test.equalsIgnoreCase(reverseString(test)))
            System.out.println("** Oops Something went wrong. Check your reverse method **");
        else
            System.out.println("Success " + test + " matched " + reverseString(test));
            
        if (test2.equalsIgnoreCase(reverseString(test2)))
            System.out.println("** Oops Something went wrong. Check your reverse method **");

    }
}
