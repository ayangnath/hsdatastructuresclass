/**
 * Creates a TreeSet where values are stored
 * on a binary search tree
 * 
 * @author Ayan Nath
 * @version 12/1/21
 */
public class MyTreeSet<E>
{
	private TreeNode root;
	private int size;
	private TreeDisplay display;

	/**
	 * defualt constructor for the TreeSet class
	 * and makes the set and the display
	 */
	public MyTreeSet()
	{
		root = null;
		size = 0;
		display = new TreeDisplay();

		//wait 1 millisecond when visiting a node
		display.setDelay(1);
	}

	/**
	 * determines size of the root
	 * @return the size of the root
	 */
	public int size()
	{
		return size;
	}

	/**
	 * determines if the root contains an object
	 * @param obj the object to check if it is contained
	 * @return true if the root contains the object
	 */
	public boolean contains(Object obj)
	{
		return BSTUtilities.contains(root, (Comparable) obj, display);
	}

	// if obj is not present in this set, adds obj and
	// returns true; otherwise returns false
	// @param obj the object being added
	public boolean add(E obj)
	{
		boolean exists = contains(obj);
        if (exists)
            return false;
		
        root = BSTUtilities.insert(root, (Comparable) obj, display);
        size++;
        return true;
	}

	// if obj is present in this set, removes obj and
	// returns true; otherwise returns false}
	// @param obj the object being removed
	public boolean remove(Object obj)
	{
		boolean exists = contains(obj);
        if (exists)
        {
            root = BSTUtilities.delete(root, (Comparable) obj, display);
            size--;
            return true;
        }
        return false;
	}

	/**
	 * Converts properties to String
	 * @return contents of MyTreeSet in a String.
	 */
	public String toString()
	{
		return toString(root);
	}

	/**
	 * Converts properties to String
	 * @param t the Treenode
	 * @return contents of MyTreeSet in a String.
	 */
	private String toString(TreeNode t)
	{
		if (t == null)
			return " ";
		return toString(t.getLeft()) + t.getValue() + toString(t.getRight());
	}
}