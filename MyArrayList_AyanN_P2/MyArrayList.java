import java.util.NoSuchElementException;

/*
 * Some things to consider for this lab:
 * 
 * Use the updated checkstyle.  
 * 
 * Java doesn't let us instantiate an array of type E so some casting will be needed
 * 
 * Some new tags and annotations you may like to use:
 * @param  <E> describes the specific type of data stored in the list.  
 * 
 * When casting carefully, you may not need Java's warning regarding unsafe or unchecked operations 
 * you may like to use the annotation @SuppressWarnings("unchecked")
 * Use this judiciously.  
 * 
 * In Javadocs use the tags either {@code text} or {@literal}.
 * to avoid html interpretations for example {@code 0 <= index <= size}
 * or use {@literal 0 <= index <= size}
 */
/**
 * MyArrayList stores values into specified positions of the array
 * and can remove, return, or set these values to other values. 
 * The capacity of the array can be returned and modified.
 * 
 * @author Ayan Nath
 * @author Marina Peregrino
 * @version December 19, 2019
 * @version October 6, 2021
 */
public class MyArrayList<E> implements MyList<E>,  Iterable<E>
{
    private int size;
    private Object[] values;


    /**
     * Creates an instance of the MyArrayList class
     */
    public MyArrayList()
    {
        size = 0;
        values = new Object[1];
    }

    /**
     * Returns the size of this MyArrayList
     * @return the size
     */
    public int size()
    {
        return size;
    }

    /**
     * Adds an object to the end of the MyArrayList and then returns true
     * @param obj the object being added to the end of the list
     * @return true if can add
     */
    public boolean add(E obj)
    {
        // // if values is already full, call doubleCapacity before adding
        if (size==values.length)
            doubleCapacity();
        E newObj = (E)obj;
        values[size] = newObj;
        size++;
        return true;
    }
    /*
     * precondition
     * {@code 0 <= index <= size}
     * 
     * inserts obj at position index,
     * moving elements at position index and higher
     * to the right (adds 1 to their indices) 
     * and adjusts size
     */
    /**
     * Adds an object to the list at a specific index
     * All elements after the index are pushed back by one
     * @precondition 0 <= index <= size
     * @precondition obj is a valid element
     * @param index the index where the new object will be placed
     * @param obj the new object
     */
    public void add(int index, E obj)
    {
        if (index > size || index < 0)
        {
            throw new IndexOutOfBoundsException("index is not valid");
        }
        if (size == values.length)
        {
            doubleCapacity();
        }

        for (int i = size; i > index; i--)
        {
            values[i]=values[i-1];
        }
        values[index]=obj;
        size++;
    }

    /**
     * Doubles the length of the array
     * @postcondition postcondition
     * replaces the array with one that is
     * twice as long, and copies all of the
     * old elements into it
     */
    private void doubleCapacity()
    {
        Object[] temporary = new Object[size*2];
        for (int i = 0; i < size; i ++)
        {
            temporary[i] = values[i];
        }
        values = temporary;

    }

    /**
     * Gets the element at a specified index
     * @precondition index is a valid index
     * @return the element at the index
     */
    public E get(int index)
    {
        return (E) values[index];
    }

    /**
     * returns the length of the array
     * @return the length of the array
     */
    public int getCapacity()
    {
        return values.length;
    }

    /**
     * Removes the object from the position index,
     * moving elements at position index + 1 and higher 
     * to the left (subtracts 1 from their indices) 
     * and adjusts size
     * returns the element formerly at the specified position
     * @param index the index of the element being removed
     * @return the element that was removed
     */
    public E remove(int index)
    {
        E previous = (E) values[index];
        for (int i = index; i < size -1; i++)
        {
            values[i] = values[i+1];
        }
        values[size-1]=null;
        size--;
        return previous;
    }

    /*
     * replaces the element at position index with obj
     * returns the element formerly at the specified position
     */
    /**
     * replaces the element at position idex with obj and
     * returns the element formerly at that specified position
     * @param index the index with the new element being set
     * @param obj the new elemebt to replace the old one
     * @return the element replaced
     */
    public E set(int index, E obj)
    {
        E replaced = (E) values[index];
        values[index] = obj;
        return replaced;
    }

    /**
     * Returns an Iterator for the list
     * @return an Iterator;
     */
    public MyIterator<E> iterator()
    {
        return new MyArrayListIterator();
    }

    /**
     * Retruns a ListIterator for the list
     * @return a ListIterator
     */
    public MyListIterator<E> listIterator()
    {
        return new MyArrayListIterator();
    }

    /**
     * Returns a String containing the data inside the list
     * @return the string of data
     */
    public String toString()
    {

        if (size == 0)
            return "[]";

        String s = "[";
        for (int i = 0; i < size - 1; i++)
            s += values[i] + ", ";
        return s + values[size - 1] + "]";

    }

    /**
     * Iterator for MyArrayList. Goes through MyArrayList left to right, 
     * and checks if there is a next object.
     * 
     * @author Ayan Nath 
     * @version October 10 2021
     */
    private class MyArrayListIterator implements MyIterator<E>, MyListIterator<E>
    {
        // //the index of the value that will be returned by next() 
        private int nextIndex;

        /**
         * Creates an instance of this MyArrayListIterator.
         */
        public MyArrayListIterator()
        {
            nextIndex = 0;
        }

        /**
         * Determines if this Iterator still has more elements in the list
         * @return true if there are still elements to be found; otherwise,
         *         false
         */
        public boolean hasNext()
        {
            return nextIndex < MyArrayList.this.size;
        }

        /**
         * Returns the next element of the list
         * @return the next element
         */
        public E next()
        {
            if (!hasNext())
            {
                throw new NoSuchElementException();
            }
            nextIndex++;
            return (E) MyArrayList.this.get(nextIndex-1);
        }

        /*
         * Removes the last element that was returned by next
         */

        public void remove()
        {
            if (nextIndex != 0)
            {
                size--;
                MyArrayList.this.remove(nextIndex - 1);
            }
        }
    }
}
