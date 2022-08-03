import java.util.Stack;

/**
 * @author Anu Datar
 * @author Ayan Nath with assitance from friends in class
 * @version 10/30/2021
 */

public class Expressions
{
    // parenthesis matching : An expression is said to be balanced if
    // every opener has a corresponding closer, in the right order
    // {, [ or ( are the only types of brackets allowed
    // @param   expression containing operands operators 
    //          and any of the 3 supportedbrackets
    // @return  true is the parenthesis are balanced         
    //          false otherwise
    public static boolean matchParenthesis(String expression)
    {
        Stack<String> s = new Stack<String>(); 
        String[] ex = expression.split(" ");
        for (int i = 0; i < ex.length; i++)
        {
            switch(ex[i])
            {
                case "(": 
                case "{":
                case "[": 
                s.push(ex[i]);
                break; 
                case ")":
                if (s.isEmpty() || !(s.pop().equals("("))) 
                    return false;
                break; 
                case "}":
                if (s.isEmpty() || !(s.pop().equals("{")))
                    return false;
                break;
                case "]":
                if (s.isEmpty() || !(s.pop().equals("]")))
                    return false;
                break;    
            }
        }
        return true; 
    }

    // returns a string in postfix form 
    // if given an expression in infix form as a parameter
    // does this conversion using a Stack
    // @param expr valid expression in infix form
    // @return equivalent expression in postfix form
    public static String infixToPostfix(String expr)
    {
        Stack<String> postFix = new Stack<String>();
        String strPostfix = "";

        for (int i = 0; i < expr.length(); i++)
        {
            String current = expr.substring(i, i+1);
            if (current.compareTo("0") >= 0  && current.compareTo("9") <= 0)
            {
                if (i+1 < expr.length() && expr.substring(i+1, i+2).compareTo("0") >= 0 && 
                    expr.substring(i+1, i+2).compareTo("9") <= 0)
                {
                    strPostfix += current;
                }
                else
                {
                    strPostfix += current + " ";
                }
            }
            else if ((postFix.isEmpty() || postFix.peek().equals("(")) 
                && (! current.equals(" ")) && (! current.equals(")")))
            {
                postFix.push(current);
            }
            else if (current.equals("("))
            {
                postFix.push(current);
            }
            else if (current.equals(")"))
            {
                while (!(postFix.peek().equals("(")))
                {
                    strPostfix += postFix.pop() + " ";
                }
            }
            else if ((current.equals("%") || current.equals("*") || current.equals("/")) 
                && (postFix.peek().equals("+") || postFix.peek().equals("-")))
            {
                postFix.push(current);
            }
            else if ((current.equals("%") || current.equals("*") ||  current.equals("/")) 
                && (postFix.peek().equals("%") || postFix.peek().equals("*") 
                || postFix.peek().equals("/")))
            {
                strPostfix += postFix.pop() + " ";
                postFix.push(current);
            }
            else if ((current.equals("+") || current.equals("-")) 
                && (postFix.peek().equals("+") || postFix.peek().equals("-")))
            {
                strPostfix += postFix.pop() + " ";
                postFix.push(current);
            }
            else if ((current.equals("+") || current.equals("-")) 
                && (postFix.peek().equals("*") || postFix.peek().equals("%") 
                || postFix.peek().equals("/")))
            {
                while ( (!(postFix.isEmpty()) && (!(postFix.peek().equals("+") 
                    || postFix.peek().equals("-")))))
                {
                    strPostfix += postFix.pop() + " ";
                }
                i--;
            }
        }
        while (! postFix.isEmpty())
        {
            strPostfix += postFix.pop() + " ";
        }        
        return strPostfix;
    }

    // returns the value of an expression in postfix form
    // does this computation using a Stack
    // @param expr valid expression in postfix form
    // @return value of the expression
    // @precondition postfix expression  
    //               contains numbers and operators + - * / and %
    //               and that operands and operators are separated by spaces
    public static double evalPostfix(String expr)
    {
        Stack<Double> postfixOperands = new Stack<Double>();
        String[] arr = expr.split(" ");
        
        for (String str : arr)
        {
            switch (str)
            {
                case "+":
                    if (!postfixOperands.empty())
                    {
                        Double last = postfixOperands.pop();
                        if (!postfixOperands.empty())
                            postfixOperands.push(postfixOperands.pop()+last);
                    }
                break;              
                case "-":
                    if (!postfixOperands.isEmpty())
                    {
                        Double last = postfixOperands.pop();
                        if (!postfixOperands.empty())
                            postfixOperands.push(postfixOperands.pop()-last);
                    }
                break;                
                case "*":
                    if (!postfixOperands.isEmpty())
                    {
                        Double last = postfixOperands.pop();
                        if (!postfixOperands.empty())
                            postfixOperands.push(postfixOperands.pop()*last);
                    }
                break;                
                case "/":
                    if (!postfixOperands.isEmpty())
                    {
                        Double last = postfixOperands.pop();
                        if (!postfixOperands.empty())
                            postfixOperands.push(postfixOperands.pop()/last);
                    }
                break;                
                case "%":
                    if (!postfixOperands.isEmpty())
                    {
                        Double last = postfixOperands.pop();
                        if (!postfixOperands.empty())
                            postfixOperands.push(postfixOperands.pop()%last);
                    }
                break;
                
                default:
                    postfixOperands.push(Double.parseDouble(str));
            }
        }
        
        return postfixOperands.peek();
    }


    // Tester to check if infix to postfix and evaluate postfix work well
    public static void main(String[] args)
    {
        String exp = "2 + 3 * 4";
        test(exp, 14);

        exp = "8 * 12 / 2";
        test(exp, 48);

        exp = "5 % 2 + 3 * 2 - 4 / 2";
        test(exp, 5);   

        // test balanced expressions
        testBalanced("{ 2 + 3 } * ( 4 + 3 )", true);
        testBalanced("} 4 + 4 { * ( 4 + 3 )", false);
        testBalanced("[ [ [ ] ]", false);
        testBalanced("{ ( } )", false);
        testBalanced("( ( ( ) ) )", true);
    }

    public static void test(String expr, double expect)
    {
        String post = infixToPostfix(expr);        
        double val = evalPostfix(post);

        System.out.println("Infix: " + expr);
        System.out.println("Postfix: " + post);
        System.out.println("Value: " + val);
        if (val == expect)
        {
            System.out.print("** Success! Great Job **");
        }
        else
        {
            System.out.print("** Oops! Something went wrong. ");
            System.out.println("Check your postfix and eval methods **");
        }
    }

    public static void testBalanced(String ex, boolean expected)
    {
        boolean act = matchParenthesis(ex);
        if (act == expected)
            System.out.println("** Success!: matchParenthesis(" + ex + ") returned " + act);
        else
        {
            System.out.print("** Oops! Something went wrong check : matchParen(" + ex + ")");
            System.out.println(" returned " + act + " but should have returned " + expected);
        }
    }
}
