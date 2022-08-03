import java.util.*;
/**
 * Basic Tests for Tree util 
 * 
 * @author -- .- .-. .. -. .-   .--. . .-. . --. .-. .. -. ---
 * @version 2013 
 * 
 * @version Nov 2019  consolidated changes 
 */
public class TestTreeUtilMMP extends Debug
{
    TreeDisplay display = new TreeDisplay();
    TreeNode tree = TreeUtil.createRandom(3);

    public static void main(String[] args)
    {
        TreeNode tree = TreeUtil.createRandom(3);
        TreeDisplay display = new TreeDisplay();

        display.displayTree(tree);

        boolean test = false;
        // if while (test)
        {
        }

        boolean testLeftMost = true;
        if (testLeftMost)
        {
            debugPause("test left and right most");
            for (int i = 3; i < 6; i ++) 
            {
                tree = TreeUtil.createRandom(i);
                if (tree == null) continue;
                display.displayTree(tree);
                System.out.println ("LeftMost = "+ (TreeUtil.leftmost(tree)));
                System.out.println ("RightMost = "+ (TreeUtil.rightmost(tree)));
                System.out.println ("CountLeaves = " + TreeUtil.countLeaves(tree));
                System.out.println ("MaxDepth = " + TreeUtil.maxDepth(tree));
                System.out.println ("CountNodes = " + TreeUtil.countNodes(tree));

                getUserInput();
            }
            testLeftMost = false;
        }

        boolean testMorse = false;
        if (testMorse)
        {
            TreeNode decoder = TreeUtil.createDecodingTree(display);
            //System.out.println(TreeUtil.decodeMorse (decoder, ".-", display)); 
            System.out.println("\". .- -\" says \"" + TreeUtil.decodeMorse (decoder, ". .- -", display)+"\" in Morse code");
            String haveANiceDay = ".... .- ...- . .- -. .. -.-. . -.. .- -.--";
            System.out.println("\""+haveANiceDay+ "\"\n\t says \"" + TreeUtil.decodeMorse (decoder, haveANiceDay, display)+"\" in Morse code"); 
       
        }

        boolean testCopyAndShape = true; 
        if (testCopyAndShape){
            debugPause("test copy and sameShape, 3 displays");
            TreeDisplay displayCopy = new TreeDisplay("copy");
            TreeDisplay displayRandom = new TreeDisplay("random");

            int size = 4; 
            tree = TreeUtil.createRandom(size);
            display.displayTree(tree);
            TreeUtil.preOrder(tree, display);

            TreeNode copyCat = TreeUtil.copy(tree);
            displayCopy.displayTree(copyCat);
            TreeNode randomTree = TreeUtil.createRandom(size);
            displayRandom.displayTree(randomTree);

            System.out.println ("copy  is same shape?  " + TreeUtil.sameShape(tree, copyCat));
            System.out.println ("random  is same shape?  " + TreeUtil.sameShape(tree, randomTree));
            //TreeUtil.getUserInput();
        }

        boolean testSaveTree = true ;
        if (testSaveTree){
            debugPause("test save and load trees");
            TreeUtil.saveTree("Lorax", tree);
            //ArrayList<String> ListFromTree = new ArrayList<String>();
            //TreeUtil.fillList(tree, ListFromTree);
            getUserInput("the tree was saved, hit enter");

            tree = TreeUtil.createRandom(0);
            display.displayTree(tree);
            getUserInput("hit enter to see the saved tree");
            tree = TreeUtil.loadTree("Lorax"); 
            display.displayTree(tree);
        }

        boolean testTreeTraversal = true; 
        if (testTreeTraversal){
            System.out.println ("test tree traversal");

            display.displayTree(null);
            display.displayTree(tree);
            debugPause("In Order tree traversal:");
            TreeUtil.inOrder(tree, display);

            display.displayTree(null);
            display.displayTree(tree);
            debugPause("Post Order tree traversal:");
            TreeUtil.postOrder(tree, display);
            //while(true)
            {
                //tree = TreeUtil.createRandom(3);
                display.displayTree(tree);
                debugPause("Pre Order tree traversal:");
                TreeUtil.preOrder(tree, display);
            }
        }
        debugPrint("all tests done");
    }

}
