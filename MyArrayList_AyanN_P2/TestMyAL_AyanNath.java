/**
 * Demonstrates execution of each and every method within MyArrayList.  
 * 
 * @author Marina Peregrino  
 * @version 12 19, 2019     
 *          Created Skeleton to outline some basic tests for students to create.  
 * 
 * @author Ayan Nath 
 * @version January 12 2022
 */
public class TestMyAL_AyanNath
{

    /**
     * Tests each of the methods for the MyArrayList: 
     * 
     * toString
     * size()
     * add(n)
     * add(i, n)
     * 
     * remove
     * set
     * get
     * 
     */
    public static void main (String [] args){ 
        /*
         * Things to consider:
         * What would be different for a Linked List?  
         */

        String studentName = "Ayan Nath"; //Insert your name here.  
        System.out.println("Tests MyAL for "+ studentName); 
        
        // Test that MyArrayList implements the interface
        MyList<Integer> nums1 = new MyArrayList<Integer>();

        /**
         * test1:  Tests for each of the following: 
         * add(i, n) to an empty list,
         * add(i, n) to an existing list,
         * size,
         * toString 
         */
        boolean test1 = true; 
        if (!test1){
            System.out.println ("Skipping Test #1"); 
        }
        else{
            System.out.println ("#1 Testing: add at last index");
            for (int i=0; i < 5; i++){
                /**
                 * use add(i, number)
                 * print the resulting list after each pass
                 */
                nums1.add(i, 5);
                System.out.println ("" + nums1 + ", size: " + nums1.size());

                
            }
        }
        nums1= null;   //release unused data 
        //////////////////////////////////////////////////////////////////////

        /**
         * test2:  Tests for each of the following: 
         * add(n) to an empty list,
         * add(n) to an existing list,
         * size,
         * toString 
         */
        MyList<Integer> nums2 = new MyArrayList<Integer>();
        boolean test2 = true; 
        if (!test2){
            System.out.println ("Skipping Test #2"); 
        }
        else{
            System.out.println ("#2 Testing: add (appending)");
            for (int i=0; i < 5; i++){
                /**
                 * use add(number)
                 * print the resulting list after each pass
                 */
                nums2.add(i);
                System.out.println ("" + nums2 + ", size: " + nums2.size());

            }
        }

        /**
         * test3:  Tests for each of the following: 
         * iterator,
         * hasNext,
         * next,
         */
        boolean test3 = true; 
        if (!test3){
            System.out.println ("Skipping Test #3"); 
        }
        else
        {
            System.out.println ("List:\n" + nums2);
            System.out.println ("#3 Testing: iterator:  ");
            String s ="";
            MyArrayList<String> myAl = new MyArrayList<String>();
            for (int num : nums2)
            { 
                myAl.add(num + ""); 
            }
            /*
             * gets an iterator 
             * and loop through it
             * also gets values from the iterator 
             * append the values to a String 
            /* */ 
            MyIterator<String> iterator = myAl.iterator();
            while(iterator.hasNext())
            {
                String val = iterator.next(); 
                s += val + ", ";
            }
            System.out.println(" yields:");
            System.out.println(s);   
            System.out.println(nums2);  
        }

        nums2= null;  //release unused data 
        //////////////////////////////////////////////////////////////////////


        /**
         * Previous tests were Integer list subsequent tests are String list
         * 
         * Add tests for the methods 
         * append,              
         * insert, 
         * remove, 
         * set, 
         * get
         * 
         * from begin, middle and end of list
         * 
         * test index out of bounds
         */
        MyArrayList<String> list = new MyArrayList<String>();

        /**
         * test4:  Tests for each of the following: 
         * Adding to beginning and end of list 
         * 
         * 
         * 
         */
        boolean test4 = true; 
        if (!test4)
        {
            System.out.println ("Skipping Test #4"); 
        }
        else
        {
            System.out.println("\n Other tests: adding to beginning, end, and middle of a list");
            nums2 = new MyArrayList<Integer>(); 
            for (int i = 1; i < 10; i++)
            {
                nums2.add(i); 
            }
            
            nums2.add(0, 0);
            System.out.println(nums2 + ", 0 added to beginning of list?");
            
            nums2.add(10, 10); 
            System.out.println(nums2 + ", 10 added to end of list?");
            
            nums2.add(5, 5);
            System.out.println(nums2 + ", 5 added to middle of list?" + 
                                       "; size = " + nums2.size()); 

        }

        /**
         * test5:  Tests for each of the following: 
         * Removing from beginning and end of list, as well as getting and setting 
         * 
         * 
         */
        boolean test5 = true; 
        if (!test5)
        {
            System.out.println ("Skipping Test #5"); 
        }
        else
        {
            System.out.println("\n More tests: removing, setting, and getting");
            
            nums2.remove(0); 
            System.out.println(nums2 + ", 0 should be removed from the list"); 
            nums2.remove(10); 
            System.out.println(nums2 + ", 10 should be removed from the list" + 
                               "; size = " + nums2.size()); 
            
            int num = nums2.get(0);
            System.out.println("get(0) = " + num + ", 1 should have been retrieved from the list"); 
            
            int num3 = nums2.set(0, 314); 
            System.out.println(num3 + ": 1 should be returned");  
            System.out.println(nums2 + ", first element should have been set to 314"); 
        }

        /**
         * test6:  Tests exception for index out of bounds 
         * tests each of the methods that use index, 
         * add, remove, set, get
         * Tests when underlying array does have such and index and when it does not.   
         */
        boolean test6 = true; 
        if (!test6)
        {
            System.out.println ("Skipping Test #6"); 
        }
        else
        {
            nums1 = new MyArrayList<Integer>();
            for (int i = 0; i < 5; i ++)
            {
                nums1.add(i);
            }

            nums1.remove(2);
            nums1.remove(2);
            System.out.println("\n Test index out of bounds exception:");
            
            try 
            {
                // nums1.add(nums1.size()+1, 0);
                nums1.add(nums1.size()+2, 0);
            } 
            catch (IndexOutOfBoundsException e) 
            {
                System.out.println("" +  e );
                System.out.println("");
            }
            try 
            {
                
                nums1.remove(nums1.size()+5); 
            } 
            catch (IndexOutOfBoundsException e) 
            {
                System.out.println("" +  e );
                System.out.println("");
            }
            try 
            {
                
                nums1.set(nums1.size()+8, 0); 
            } 
            catch (IndexOutOfBoundsException e) 
            {
                System.out.println("" +  e );
                System.out.println("");
            }
            try 
            {
                
                nums1.get(nums1.size()+10);
            } 
            catch (IndexOutOfBoundsException e) 
            {
                System.out.println("" +  e );
                System.out.println("");
            }
            
        }
    }

}

