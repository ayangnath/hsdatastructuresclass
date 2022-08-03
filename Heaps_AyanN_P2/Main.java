/**
 * Tests all the methods in HeapUtils
 * Got some help making this tester from members in class
 * @author Ayan Nath
 * @version January 10 2022
 */
public class Main {
    public static void main(String[] args)
    {
        Integer[] arr = new Integer[12];
        for (int i = 1; i < arr.length; i++)
        {
            arr[i] = (int)(Math.random()*100) + 1;
        }


        HeapDisplay hdisplay = new HeapDisplay(); 
        HeapDisplay hdisplay2 = new HeapDisplay(); 
        HeapDisplay hdisplay3 = new HeapDisplay(); 
        System.out.println("random order");
        System.out.println(java.util.Arrays.toString(arr)); 
        hdisplay.displayHeap(arr, arr.length-1);
        System.out.println("heap order");
        HeapUtils.buildHeap(arr, arr.length-1); 
        System.out.println(java.util.Arrays.toString(arr)); 
        hdisplay2.displayHeap(arr, arr.length-1);
      
        System.out.println("testing insert ");
        HeapUtils.heapSort(arr, arr.length-1); 
        hdisplay3.displayHeap(arr, arr.length-1);
        System.out.println(java.util.Arrays.toString(arr)); 

        insert(Comparable[] heap, Comparable item, int heapSize)
    
    }
}
