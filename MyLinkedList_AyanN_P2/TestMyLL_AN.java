
/**
 * Demonstrates execution of each and every method within MyLinkedList.  
 * 
 * @author Marina Peregrino  
 * @version 12 19, 2019     
 *          Created Skeleton to outline some basic tests for students to create.  
 * 
 * @author Ayan Nath
 * @version October 12, 2021
 */
public class TestMyLL_AN
{

    /**
     * Tests each of the methods for the MyLinkedList: 
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
                System.out.println("Adding at index: " + i);
                nums1.add(i,i);
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
        else{
            /* */
            System.out.println ("List:\n" + nums2);
            System.out.println ("#3 Testing: iterator:  ");
            String s ="";
            MyArrayList<String> myAl = new MyArrayList<String>();
            for (int num : nums2){ 
               s += num + ", ";
           }
            /*
             * get an iterator 
             * loop through and get values from the iterator 
             * append the values to a String 
            /* 
            while()
            {
                int val = ; 
                s += val + ", ";
            
            }
            */ 

            System.out.println(" yields:");
            System.out.println(s);

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
         * 
         * append,
         * insert
         * remove
         */
        boolean test4 = true; 
        if (!test4){
            System.out.println ("Skipping Test #4"); 
        }
        else{
            System.out.println("\n Other tests:");
            System.out.println ("#4 Testing: append, remove, insert: ");
            MyArrayList<String> myAl = new MyArrayList<String>();
            for (int i=0; i<5; i++)
            {
                myAl.add("a" + i);
            }
            System.out.println(myAl);
            
            myAl.add(0,"b"); // [b, a0, a1, a2, a3, a4]
            System.out.println(myAl);

            myAl.add(myAl.size()/2,"c"); // [b, a0, a1, c, a2, a3, a4]
            System.out.println(myAl);

            myAl.add(myAl.size(),"d"); // [b, a0, c, a1, a2, a3, a4, d]
            System.out.println(myAl);

            myAl.remove(myAl.size()-1); // [b, a0, c, a1, a2, a3, a4]
            System.out.println(myAl);

            myAl.remove(myAl.size()/2); // [b, a0, a1, a2, a3, a4]
            System.out.println(myAl);

            myAl.remove(0); // [a0, a1, a2, a3, a4]
            System.out.println(myAl);
        }

        /**
         * test5:  Tests for each of the following: 
         * 
         * get,
         * set
         * 
         */
        boolean test5 = true; 
        if (!test5){
            System.out.println ("Skipping Test #5"); 
        }
        else{
            System.out.println("\n More tests:");
            System.out.println ("#5 Testing: get, set: ");

            MyArrayList<String> myAl = new MyArrayList<String>();
            for (int i=0; i<5; i++)
            {
                myAl.add("a" + i);
            }
            System.out.println(myAl);

            myAl.set(0,"b1");
            System.out.println(myAl.get(0)); // b1

            myAl.set(myAl.size()/2,"b2");
            System.out.println(myAl.get(myAl.size()/2)); // b2

            myAl.set(myAl.size()-1,"b3");
            System.out.println(myAl.get(myAl.size()-1)); // b3
        }

        /**
         * test6:  Tests exception for index out of bounds 
         * tests each of the methods that use index, 
         * add, remove, set, get
         * Tests when underlying array does have such and index and when it does not.   
         */
        boolean test6 = true; 
        if (!test6){
            System.out.println ("Skipping Test #9"); 
        }
        else{
            System.out.println("\n Test index out of bounds exception:");

            MyArrayList<String> myAl = new MyArrayList<String>();
            for (int i=0; i<5; i++)
            {
                myAl.add("a");
            }
            System.out.println(myAl);
            
            try 
            {
                myAl.add(-1,"b");
            } 
            catch (IndexOutOfBoundsException e) 
            {
                System.out.println("" +  e );
                System.out.println("");
            }
            try 
            {
                myAl.add(myAl.size(),"b");
            } 
            catch (IndexOutOfBoundsException e) 
            {
                System.out.println("" +  e );
                System.out.println("");
            }
            try 
            {
                myAl.remove(-1);
            } 
            catch (IndexOutOfBoundsException e) 
            {
                System.out.println("" +  e );
                System.out.println("");
            }
            try 
            {
                myAl.remove(myAl.size());
            } 
            catch (IndexOutOfBoundsException e) 
            {
                System.out.println("" +  e );
                System.out.println("");
            }
            try 
            {
                myAl.set(-1,"b");
            } 
            catch (IndexOutOfBoundsException e) 
            {
                System.out.println("" +  e );
                System.out.println("");
            }
            try 
            {
                myAl.set(myAl.size(),"b");
            } 
            catch (IndexOutOfBoundsException e) 
            {
                System.out.println("" +  e );
                System.out.println("");
            }
        }

        System.out.println("Test passed!");
    }
}
