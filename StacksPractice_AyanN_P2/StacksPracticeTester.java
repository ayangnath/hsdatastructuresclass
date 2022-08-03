
/**
 * Tests for the StacksPractice exercies 
 * 
 * @author Anu Datar
 * @author Marina Peregrino 
 * @version 10/27/2017
 * @version 11-11-17 updated docs, added tester, slight mods to testers
 * @version 10-27-2021  separated out the testers.
 * 
 */
public class StacksPracticeTester 
{

    static final double ACCURACY = java.lang.Float.MIN_NORMAL; 
    /**
     * Tests evalPostfix; prints results to console.
     * 
     * @param   expr    the valid infix arithmetic expression.  
     * @param   expect  the expected result.  
     */
    public static void testEval(String expr, double expect)
    {       
        double val = Expressions.evalPostfix(expr);
        System.out.println("Postfix: " + expr);
        System.out.println("Expected Value: " + expect + " Calculated: "+val);

        if (Math.abs(val - expect) < ACCURACY)
        {
            System.out.println("** Success! Great Job **");
        }
        else
        {
            System.out.print("** Oops! Something went wrong. ");
            System.out.println("Check your postfix and eval methods **");
        }
    }

    /**
     * Tests infixToPostfix and evalPostfix; prints results to console.
     * 
     * @param   expr    the valid infix arithmetic expression.  
     * @param   expect  the expected result.  
     */
    public static void test(String expr, double expect)
    {
        String post = Expressions.infixToPostfix(expr);        
        double val = Expressions.evalPostfix(post);

        System.out.println("Infix: " + expr);
        System.out.println("Postfix: " + post);
        System.out.println("Expected Value: " + expect + " Calculated: "+val);
        if (Math.abs(val - expect) < ACCURACY)
        {
            System.out.println("** Success! Great Job **");
        }
        else
        {
            System.out.print("** Oops! Something went wrong. ");
            System.out.println("Check your postfix and eval methods **");
        }
    }

    /**
     * Tests matchParenthesis; prints results to console. 
     * 
     * @param   ex          The expression to be evaluated
     * @param   expected    true if ex is balanced, false if not.  
     */
    public static void testBalanced(String ex, boolean expected)
    {
        boolean act = Expressions.matchParenthesis(ex);
        if (act == expected)
            System.out.println("** Success!: matchParenthesis(" + ex + ") returned " + act);
        else
        {
            System.out.print("** Oops! Something went wrong check : matchParen(" + ex + ")");
            System.out.println(" returned " + act + " but should have returned " + expected);
        }
    }

    /**
     * Tester to check if infix to postfix and evaluate postfix work well
     * @param args  arguments from the command line.  
     */
    public static void main(String[] args)
    {
        /**/
        // test postfix evaluation 
        testEval ("3 2 +", 5);
        testEval ("3 2 -", 1);
        testEval ("3 2 *", 6);
        testEval ("3 2 /", 3.0/2.0); 
        testEval ("3 2 + 1 * 2 2 * +", 9); 
        /**/

        /**
        // test infix to postfix and postfix evaluation.  
        String exp = "2 + 3 * 4";
        test(exp, 14);

        exp = "8 * 12 / 2";
        test(exp, 48);

        exp = "5 % 2 + 3 * 2 - 4 / 2";
        test(exp, 5);   

        exp = "3 % 2 + 5 * 2 - 6 / 3";
        test(exp, 9);   

        /**/

        /**/
        // test balanced expressions
        testBalanced("{ 2 + 3 } * ( 4 + 3 )", true);
        testBalanced("} 4 + 4 { * ( 4 + 3 )", false);
        testBalanced("[ [ [ ] ]", false);
        testBalanced("{ ( } )", false);
        testBalanced("( ( ( ) ) )", true);
        /**/
    }
}

