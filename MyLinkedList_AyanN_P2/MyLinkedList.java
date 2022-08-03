import java.util.Iterator;
import java.util.ListIterator;

/**
 * Describes the methods of LinkedLists, which
 * are doubly linked lists of DoubleNodes.
 */
public class MyLinkedList<E> implements MyList<E>, Iterable<E>
{
    private DoubleNode first;
    private DoubleNode last;
    private int size;

    /**
	 * Constructs the LinkedList.
     * Initializes the first and last nodes to null and the size to 0.
	 */
    public MyLinkedList()
    {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * Converts the elements in LinkedList to String.
     */
    public String toString()
    {
        DoubleNode node = first;
        if (node == null)
            return "[]";
        String s = "[";
        while (node.getNext() != null)
        {
            s += node.getValue() + ", ";
            node = node.getNext();
        }
        return s + node.getValue() + "]";
    }

    /** 
     * @precondition  0 <= index <= size / 2
     * starting from first, returns the node with given index (where index 0 returns first)
     * 
     * @param    index   the index of the node that is being found 
     * @return   the node with given index 
     */               
    private DoubleNode getNodeFromFirst(int index)
    {
        int i = 0;
        DoubleNode nodefromfirst = first; 
        while (i < index)
        {
            nodefromfirst = nodefromfirst.getNext(); 
            i++; 
        }
        return nodefromfirst; 
    }

    /** 
     * @precondition  size / 2 <= index < size 
     * starting from last, returns the node 
     * with given index (where index size-1 returns last)
     * 
     * @param    index   the index of the node that is being found 
     * @return   the node with given index           
     */               
    private DoubleNode getNodeFromLast(int index)
    {
        int i = size - 1; 
        DoubleNode nodefromlast = last; 
        while (i > index)
        {
            nodefromlast = nodefromlast.getPrevious();
            i--; 
        }
        return nodefromlast; 
    }

    /** 
     * @precondition  0 <= index < size
     * starting from first or last (whichever is closer) and
     * returns the node with given index using getNodeFromFirst if the index 
     * is in the first half and using getNodeFromLast if in the second half
     * 
     * @param    index   the index of the node that is being found 
     * @return   the node with given index   
     */              
    private DoubleNode getNode(int index)
    {
        if(index <= size/2)
        {
            return this.getNodeFromFirst(index); 
        }
        return this.getNodeFromLast(index); 
    }

    /**
     * returns size of LinkedList
     * @return  size of LinkedList
     */
    public int size()
    {
        return size; 
    }

    /**
     * returns the node located at the given index 
     * @param    index   the index of the node that is being requested to find 
     * @return   the node with given index  
     */ 
    public E get(int index)
    {
        DoubleNode temp = this.getNode(index); 
        return (E)temp.getValue(); 
    }

    /** 
     * replaces the element at position index with obj
     * returns the element formerly at the specified position
     * 
     * @param   index   the index where the elment is being replaced 
     * @param   obj     the thing that is replacing the element formerly at index
     * @return the previous element at given index           
     */
    public E set(int index, E obj)
    {
        E temp = this.get(index);
        this.getNode(index).setValue(obj); 
        return temp; 
    }

    /**
     * Appends obj to end of list; returns true
     * @param  obj  object added to end of the list 
     * @return true 
     */
    public boolean add(E obj)
    {
        add(size,obj);
        return true;
    }

    /** 
     * removes element from position index, moving elements
     * at position index + 1 and higher to the left
     * (subtracts 1 from their indices) and adjusts size
     * 
     * @param  index  index where the element to be removed is located 
     * @return element element that was previously located at index
     */
    public E remove(int index)
    {
        if (index >= size || index<0)
        {
            throw new IndexOutOfBoundsException();
        }
        DoubleNode removed = this.getNode(index); 

        if (size == 1)
        {
            first = null;
            last = null;
        }
        else if (index == 0)
        {
            first=this.getNode(1); 
            first.setPrevious(null);
        }
        else if (index == size-1)
        {
            last=this.getNode(size-2); 
            last.setNext(null);
        }
        else
        {
            DoubleNode before = this.getNode(index-1); 
            DoubleNode after = this.getNode(index+1); 
            before.setNext(after); 
            after.setPrevious(before); 
        }
        size--; 
        return (E)removed.getValue(); 
    }

    /** 
     * @precondition  0 <= index <= size
     * inserts obj at position index, moving elements at position index and higher
     * to the right (adds 1 to their indices) and adjusts size
     * 
     * @param index index in the list where obj is added
     * @param obj   element that is inserted into the list at index 
     */
    public void add(int index, E obj)
    {
        DoubleNode toAdd = new DoubleNode(obj);
        if (size == 0)
        {
            first = toAdd;
            last = first;
            size++;
        }
        else if (index == size)
        {
            toAdd.setPrevious(last); 
            last.setNext(toAdd);
            last = toAdd; 
            size++;
        }
        else if (index == 0)
        {
            toAdd.setNext(first);
            first.setPrevious(toAdd);
            first=toAdd;
            size++;
        }

        else if (index>=0 && index<size)
        {
            DoubleNode temp = getNode(index);
            temp.getPrevious().setNext(toAdd);
            toAdd.setPrevious(temp.getPrevious());
            toAdd.setNext(temp);
            temp.setPrevious(toAdd);
            size++;
        }
        else 
        {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Adds a DoubleNode to the front of the LinkedList.
	 * 
	 * @param obj the node to be added to the front of the list.
	 */ 
    public void addFirst(E obj)
    {
        DoubleNode newfirst = new DoubleNode(obj); 
        if(first == null)
        {
            first = newfirst; 
            last = newfirst;
            first.setNext(null); 
        }
        else
        {
            newfirst.setNext(first); 
            first.setPrevious(newfirst); 
            first=newfirst; 
        }
        size++; 
    }

    /**
     * Adds a DoubleNode to the end of the LinkedList.
	 * 
	 * @param obj the node to be added to the end of the list.
     * @param  element to store at the new node 
     */
    public void addLast(E obj)
    {
        DoubleNode newlast = new DoubleNode(obj); 
        newlast.setPrevious(last); 
        last.setNext(newlast); 
        last=newlast; 
        size++; 
    }

    /**
     * returns the element stored at the first node 
     * 
     * @return  value of first node 
     */
    public E getFirst()
    {
        return (E)first.getValue();
    }

    /**
     * returns the element stored at the last node 
     * 
     * @return  value of the last node
     */
    public E getLast()
    {
        return (E)last.getValue(); 
    }

    /**
     * Removes the first node of the LinkedList.
	 * 
	 * @return the element that was previously at the first node.
     */
    public E removeFirst()
    {
        DoubleNode oldfirst = first; 
        first=this.getNode(1); 
        first.setPrevious(null);
        size--;
        return (E) oldfirst.getValue();
    }

    /**
     * Removes the last node of the LinkedList.
	 * 
	 * @return the element that was previously at the last node.
     */
    public E removeLast()
    {
        DoubleNode oldlast = last; 
        last=this.getNode(size-2); 
        last.setNext(null); 
        size--;
        return (E) oldlast.getValue(); 
    }

    public MyIterator<E> iterator()
    {
        return new MyLinkedListIterator();
    }

    public MyListIterator<E> listIterator()
    {
        return new MyLinkedListIterator();
    }

    private class MyLinkedListIterator implements MyListIterator<E>
    {
        private DoubleNode nextNode;
        private int nextIndex; 

        /**
         * Creates a new MyLinkedListIterator object that starts at node located at index 0 
         */
        public MyLinkedListIterator()
        {
            nextNode = first; 
            nextIndex = 0; 
        }

        /**
         * Checks if the iterator is pointing to the last element.
         * 
         * @return true if there are more nodes after index; 
         *         otherwise false
         */
        public boolean hasNext()
        {
            return nextNode!= null;
            //if (nextNode == null)
            //    return false;

            //if (nextNode != null)
            //{
            //    return true; 
            //}
            //return false; 
        }

        /**
         * Points the Iterator to the next element (if exists).
         * 
         * @return   next element
         */
        public E next()
        {
            if (!hasNext())
            {
                throw new IllegalStateException();
            }
            E temp =  (E)nextNode.getValue(); 
            nextNode = nextNode.getNext();
            nextIndex++; 
            return temp;
        }

        /**
         * removes the last element that was returned by next
         */
        public void remove()
        {
            nextIndex--;
            MyLinkedList.this.remove(nextIndex); 
            //DoubleNode temp = nextNode.getPrevious().getPrevious();
            //if(temp == null) 
            //{
            //first = nextNode;
            //first.setPrevious(null);
            //} 
            //else 
            //{
            //temp.setNext(nextNode);
            //nextNode.setPrevious(temp);
            //}
            //size --;
        }

        /*
         * Adds obj before the element returned by next
         * 
         * @param obj the object to be added to the ArrayList
         * 
        */
        public void add(E obj)
        {
            MyLinkedList.this.add(nextIndex, obj);
            nextIndex++;
        }

        /**
         * Sets the last element returned by next with the 
         * parameter obj
         */
        public void set(E obj)
        {
            if (nextIndex == 0)
            {
                throw new IllegalStateException("Next was not called."); 
            }
            MyLinkedList.this.set(nextIndex-1, obj);
        }
    }
}