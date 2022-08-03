/**
 * Provides for the HeapUtils Class. For example: heapsort, insert, remove
 * 
 * @author Ayan Nath
 * @version 12/10/21
 */
public class HeapUtils 
{
    /**
     * Constructor for objects of class HeapUtils
     */
    public HeapUtils()
    {
    }
    
    /**
     * Given a subtree whose children are heaps, sinks root down to the proper level.
     * 
     * This method heapifies a complete binary tree given in array form.
     * It takes in an array that contains the heap data 
     * and rearranges the elements in a max heap.
     *   
     * This means that any parent node is larger than both of its child nodes. 
     * The heap must also be a complete binary tree in addition to following
     * the max heap property.
     * The Big O analysis for this method is going to be the Big O of the height of the tree 
     * times the Big O of swap. The Big O of the height of the tree is log(n) and
     * the Big O of swap is O(1). Thus, the overall Big O for this method is log(n).
     * @param heap the array that contains the heap data
     * @param index specifies the root of the tree that is being heapified
     * @param heapSize is the size of the heap
     */
    public static void heapify(Comparable[] heap, int index, int heapSize)
    {
        //Trying to find the smallest node between the parent, left and right
        // int smallest = index;
        // //Also makes sure left exists
        // if (2*index+1 < heapSize && heap[smallest].compareTo(heap[2*index + 1])==-1)
        //     smallest = 2*index + 1;
        // //Also makes sure right exists
        // if (2*index+2 < heapSize && heap[smallest].compareTo(heap[2*index + 2])==-1)
        //     smallest = 2*index + 2;

        // //If parent is smallest, heap property is maintained for min heap
        // if (smallest == index)
        //     return;

        // swap(heap, index, smallest);
        // heapify(heap, smallest, heapSize);
        int leftIndex = index * 2;
        int rightIndex = leftIndex + 1;
        int indexMax;
        if (leftIndex > heapSize)
            indexMax = rightIndex;

        else if (rightIndex > heapSize)
            indexMax = leftIndex;
        
        else if (((Integer)heap[leftIndex]).compareTo((Integer)heap[rightIndex]) >= 0)
            indexMax = leftIndex;
        
        else
            indexMax = rightIndex;
        

        if (leftIndex <= heapSize && heap[index].compareTo(heap[indexMax]) < 0)
        {             
            heap = swapValues(heap, index, indexMax);
            heapify(heap, indexMax, heapSize);
        } 
    }

    /**
     * Swaps the value at the index a with the value at index b
     * in the array.
     * @param heap the array that contains the heap data
     * @param a the first index
     * @param b the second index
     */
    private static Comparable[] swapValues(Comparable[] array, int index1, int index2)
    {
        Comparable val1 = array[index1];
        Comparable val2 = array[index2];
        array[index1]=val2;
        array[index2]=val1; 
        return array;
    }

    /**
     * This method heapifies the nonleaf nodes in the complete binary tree, turning the tree into a max Heap. 
     * It begins at the last nonleaf node, which has index n/2 and then heapifies every node before this one.
     * The method is finished when the root of the tree is reached and the method has heapified every 
     * nonleaf node in the tree. Thus, the big O analyisis for this method is log(n)
     * @param heap the input array representing a complete binary tree containing heapSize nodes
     * @param heapSize is the size of the heap
     */
    public static void buildHeap(Comparable[] heap, int heapSize)
    {
        //Comparable[] result = new Comparable[heapSize+1];

        int parent = heapSize / 2 ;
        while(parent>0)
        {
            heapify(heap,parent,heapSize); 
            parent--; 
        }
    }

    /**
     * This method removes the root from the heap and then fixes the heap
     * so that the heap property is met (the root is bigger than its children for a max heap 
     * and is smaller than its children for a min heap).
     * The first step is to swap the root with the bottom right node.
     * The next step is to reduce the size of the heap by one.
     * Then, you restore the heap by recursively heapifying starting at the root.
     * In other words, you are essentially swapping parents and children until the heap
     * is restored.
     * The Big O will be the Big O of heapify plus the Big O for the swap plus the Big O to decrease the size by one.
     * The Big O of heapify is log(n) and the Big (O) for swap and decreasing the size by one is O(1). 
     * Thus the overall Big O for this method is log (n).
     * @param heap the input array representing a complete binary tree containing heapSize nodes
     * @param heapSize is the size of the heap
     * @return the root that was removed
     */
    public static Comparable remove(Comparable[] heap, int heapSize)
    {
        Comparable original = heap[1];
        heap = swapValues(heap, 1, heapSize); 
        heap[heapSize] = null; 
        heapSize = heapSize - 1; 
        heapify(heap,1,heapSize); 
        return original; 
    }

    /**
     * This method adds a node to the heap and then fixes the heap
     * so that the heap property is met (the root is bigger than its children for a max heap 
     * and is smaller than its children for a min heap) by repeatedly heapifying upwards.
     * The first step is to increase the size of the heap by one.
     * The next step is to add a the node to the bottom right of the heap.
     * Then, you restore the heap by recursively heapifying upwards starting at the parent
     * of the node just added.
     * In other words, you are essentially swapping parents and children until the heap
     * is restored.
     * @param heap the input array representing a complete binary tree containing heapSize nodes
     * @param item the new node inserted into the heap
     * @param heapSize heapSize is the size of the heap
     * @return the modified array with the new node added
     */
    public static Comparable[] insert(Comparable[] heap, Comparable item, int heapSize)
    {
        
        if (heapSize + 1 >= heap.length)
        {
            Comparable[] doubledHeap = new Comparable[heap.length * 2];
            for (int i = 1; i < heap.length; i++)
            {
                doubledHeap[i] = heap[i];                
            }
            heap = doubledHeap;
        }
        heap[heapSize + 1] = item;
        int parent = (heapSize + 1) / 2;
        while (parent >= 0 && heap[parent].compareTo(item) < 0)
        {
            heap = swapValues(heap, parent, heapSize + 1);
            parent = (heapSize + 1) / 2;
        }
        return heap;  
    }


    /**
     * Takes an unsorted array and converts it to a heap.
     * Removes elements from the heap to sort the array.
     * @param unsorted the unsorted array
     * @param heapSize is the size of the heap to be created
     */
    public static void heapSort(Comparable[] unsorted, int heapSize)
    {
        buildHeap(unsorted, heapSize); 
        while (heapSize > 1)
        {
            Comparable originalRoot = remove(unsorted, heapSize);
            unsorted[heapSize] = originalRoot;
            heapSize--;            
        }  
    }
}