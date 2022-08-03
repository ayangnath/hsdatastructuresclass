/**
 * Static methods for operating on binary search trees
 * @author Ayan Nath
 * @version 12/1/2021
 */

public abstract class BSTUtilities
{
	/**
	 * checks if a tree contains a certain value
	 * @param t the TreeNode to check
	 * @param x the value to search for
	 * @param display the TreeDisplay where the tree will be displayed
	 * @return true if t contains the value; otherwise
	 * 			false
	 */
	//precondition:  t is a binary search tree in ascending order
	//postcondition: returns true if t contains the value x;
	//               otherwise, returns false
	public static boolean contains(TreeNode t, Comparable x, TreeDisplay display)
	{
		if (t == null)
        {
            return false;
        }
        else
        {
            display.visit(t);
            Comparable value = (Comparable) t.getValue();
            if (x.compareTo(value) < 0)
            {               
                return contains(t.getLeft(), x, display);
            }
            else if (x.compareTo(value) > 0)
            {               
                return contains(t.getRight(), x, display);
            }
            else
            {
                return true;
            }         
        }
	}

	/**
	 * inserts value into binary search
	 * @param t the TreeNode to insert to
	 * @param x the value being inserted
	 * @param display the TreeDisplay where the tree will be displayed
	 * @return the TreeNode with the added value
	 */
	//precondition:  t is a binary search tree in ascending order
	//postcondition: if t is empty, returns a new tree containing x;
	//               otherwise, returns t, with x having been inserted
	//               at the appropriate position to maintain the binary
	//               search tree property; x is ignored if it is a
	//               duplicate of an element already in t; only one new
	//               TreeNode is created in the course of the traversal
	public static TreeNode insert(TreeNode t, Comparable x, TreeDisplay display)
	{
		if (t == null)
            return new TreeNode(x);
        
        else
        {
            Comparable val = (Comparable) t.getValue();
            if (x.compareTo(val) < 0)
            {               
                t.setLeft(insert(t.getLeft(), x, display));
            }
            else if (x.compareTo(val) > 0)
            {               
                t.setRight(insert(t.getRight(), x, display));
            }          
            return t;           
        }
	}

	//precondition:  t is a binary search tree in ascending order
	//postcondition: returns a pointer to a binary search tree,
	//               in which the value at node t has been deleted
	//               (and no new TreeNodes have been created)
	/**
	 * Deletes a node in a binary search tree.
	 * @param t the binary search tree
	 * @param display the TreeDisplay where the tree will be displayed
	 * @return the pointer to a BST, in which the value at node t has been deleted
	 */
	private static TreeNode deleteNode(TreeNode t, TreeDisplay display)
	{
		if (t.getRight()==null && t.getLeft()==null)
			return null;

		if (t.getLeft()==null)
			return t.getRight();

		else if (t.getRight()==null)
			return t.getLeft();

		else
		{
			Object a = TreeUtil.leftmost(t.getRight());
			t.setValue(a);
			Comparable a2 = (Comparable)a;
			t.setRight(delete(t.getRight(), a2, display));
			return t;
		}

	}


	//precondition:  t is a binary search tree in ascending order
	//postcondition: returns a pointer to a binary search tree,
	//               in which the value x has been deleted (if present)
	//               (and no new TreeNodes have been created)
	/**
	 * returns a pointer to a binary search tree, in which the value x has been deleted (if present) 
	 * and no new TreeNodes have been created)
	 * @param t the binary search tree
	 * @param x the value to be deleted
	 * @param display the TreeDisplay where the tree will be displayed
	 * @return a pointer to a binary search tree, in which the value x has been deleted
	 */
	public static TreeNode delete(TreeNode t, Comparable x, TreeDisplay display)
	{
		if ( x.compareTo( (Comparable) t.getValue()) == 0)
        {
            return deleteNode(t, display);            
        }
        else
        {
            if (x.compareTo( (Comparable) t.getValue()) < 0)
            {
                t.setLeft( delete(t.getLeft(), x, display));
            }
            else if (x.compareTo( (Comparable) t.getValue()) > 0)
            {
                t.setRight( delete(t.getRight(), x, display));
            }
            return t;
        }
	}
}