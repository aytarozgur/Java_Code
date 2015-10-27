/*  Student information for assignment:
 *
 *  On my honor, Anna Mengjie Yu, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  Name: Anna Mengjie Yu
 *  email address: annayu2010@gmail.com
 *  UTEID: my3852
 *  Section 5 digit ID: 90130
 *  Grader name: Erik
 *  Number of slip days used on this assignment: 0
 */

// Experiment results. CS314 students, place your experiment
// results here:
/*
		Num Repeats: 100
		Adding at end: ArrayList
		N = 30000, total time:  0.0480
		N = 60000, total time:  0.3399
		N = 120000, total time:  0.2175
		N = 240000, total time:  0.6356
		N = 480000, total time:  3.6374
		
		
		Num Repeats: 100
		Adding at end: LinkedList
		N = 30000, total time:  1.5465
		N = 60000, total time:  2.5316
		N = 120000, total time:  4.5472
		N = 240000, total time:  7.2933
		N = 480000, total time: 11.5755
		
		//For adding at end method, ArrayList is faster than LinkedList
		 * For adding at end Arraylist is O(1), add() in ArrayList is constant time;
		 * For adding at end LinkedList is O(1), we just need to add a node in the end
		 *      and update the last node.
		
		
		Num Repeats: 100
		Adding at front: ArrayList
		N = 2000, total time:  0.0346
		N = 4000, total time:  0.2145
		N = 8000, total time:  0.4990
		N = 16000, total time:  2.0847
		N = 32000, total time:  8.4148
		
		
		Num Repeats: 100
		Adding at front: LinkedList
		N = 10000, total time:  0.0182
		N = 20000, total time:  0.2054
		N = 40000, total time:  0.5324
		N = 80000, total time:  0.6219
		N = 160000, total time:  1.1940
		
		//For Adding at front method, LinkedList is faster than Arraylist
		 * For ArrayList adding at front is O(n), since every element has to shift to right;
		 * For LinkedList adding at front is O(1), just need to add a new node at the beginning.
		
		
		Num Repeats: 100
		Removing from front: ArrayList
		N = 2000, total time:  0.0326
		N = 4000, total time:  0.1209
		N = 8000, total time:  0.4657
		N = 16000, total time:  2.0698
		N = 32000, total time:  8.4816
		
		
		Num Repeats: 100
		removing from front: LinkedList
		N = 5000, total time:  0.0165
		N = 10000, total time:  0.0301
		N = 20000, total time:  0.0705
		N = 40000, total time:  0.1223
		N = 80000, total time:  0.1725
		
		//For removing from front, LinkedList is faster
		 * For ArrayList removing at front is O(n), since every element has to shift to left;
		 * For LinkedList removing at front is O(1), just need to remove a node at the beginning.
		 
		 
		Num Repeats: 100
		Getting random: ArrayList
		N = 10000, total time:  0.0261
		N = 20000, total time:  0.0519
		N = 40000, total time:  0.1112
		N = 80000, total time:  0.2806
		N = 160000, total time:  0.8106
		
		
		Num Repeats: 100
		Getting random: LinkedList
		N = 1000, total time:  0.0965
		N = 2000, total time:  0.3982
		N = 4000, total time:  1.6027
		N = 8000, total time:  6.5479
		N = 16000, total time: 26.8002
		
		//For getting random, ArrayList is faster than LinkedList
		 * For ArrayList getting random is O(1), no need to loop through the list
		 * For LinkedList getting random is O(n), need to loop from the first node
		
		
		Num Repeats: 100
		Getting all using iterator: ArrayList
		N = 50000, total time:  0.0238
		N = 100000, total time:  0.0335
		N = 200000, total time:  0.0969
		N = 400000, total time:  0.1033
		N = 800000, total time:  0.2266
		
		
		Num Repeats: 100
		Getting all using iterator: LinkedList
		N = 50000, total time:  0.0394
		N = 100000, total time:  0.0523
		N = 200000, total time:  0.1062
		N = 400000, total time:  0.2121
		N = 800000, total time:  0.4616
		
		//For getting all using iterator, ArrayList and LinkedList are almost the same fast
		 * For ArrayList getting all using iterator is O(n), each iterator is O(1);
		 * For LinkedList getting all using iterator is O(n), each iterator is O(1);
		
		
		Num Repeats: 100
		Getting all using get method: ArrayList
		N = 100000, total time:  0.0404
		N = 200000, total time:  0.0405
		N = 400000, total time:  0.0940
		N = 800000, total time:  0.1816
		N = 1600000, total time:  0.3422
		
		
		Num Repeats: 100
		Getting all using get method: LinkedList
		N = 1000, total time:  0.0890
		N = 2000, total time:  0.3874
		N = 4000, total time:  1.5593
		N = 8000, total time:  6.3746
		N = 16000, total time: 26.0501
		
		//For getting all using get method, ArrayList is faster than LinkedList
		 * For ArralyList, the get method is O(1);
		 * for LinkedList, the get method is O(n),

*/


        //CS314 students. Add your tests here:

import java.util.Iterator;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

public class LinkedListTester {

    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<String>();
        Object[] actual;
        Object[] expected;

        //test add(item) 1-3
        System.out.println("Testing add(item):");
        list.add("A");
        if( list.toString().equals("[A]")  )
            System.out.println("Passed test add() 1");
        else
            System.out.println("Failed test add() 1");
        
        list.add("B");
        if( list.toString().equals("[A, B]")  )
            System.out.println("Passed test add() 2");
        else
            System.out.println("Failed test add() 2");
        
        list.add("C");
        if( list.toString().equals("[A, B, C]")  )
            System.out.println("Passed test add() 3");
        else
            System.out.println("Failed test add() 3");
     
        //test insert(int pos, E item) 1-3
        System.out.println("\nTesting insert (int pos, E item):");
        list.insert(1, "a");
        if( list.toString().equals("[A, a, B, C]")  )
            System.out.println("Passed test insert(int pos, E item) 1");
        else
            System.out.println("Failed test insert(int pos, E item) 1");
        
        list.insert(3, "b");
        if( list.toString().equals("[A, a, B, b, C]")  )
            System.out.println("Passed test insert(int pos, E item) 2");
        else
            System.out.println("Failed test insert(int pos, E item) 2");
        
        list.insert(5, "c");
        if( list.toString().equals("[A, a, B, b, C, c]")  )
            System.out.println("Passed test insert(int pos, E item) 3");
        else
            System.out.println("Failed test insert(int pos, E item) 3");
        
        //test set(int pos, E item) 1-3
        System.out.println("\nTesting set (int pos, E item):");
        list.set(0, "a");
        if( list.toString().equals("[a, a, B, b, C, c]")) 
            System.out.println("Passed test set(int pos, E item): 1");
        else
            System.out.println("Failed test et(int pos, E item): 1");
        
        list.set(2, "b");
        if( list.toString().equals("[a, a, b, b, C, c]")) 
            System.out.println("Passed test set(int pos, E item): 2");
        else
            System.out.println("Failed test et(int pos, E item): 2");
        
        list.set(4, "c");
        if( list.toString().equals("[a, a, b, b, c, c]")) 
            System.out.println("Passed test set(int pos, E item): 3");
        else
            System.out.println("Failed test et(int pos, E item): 3");
        
        
        //test get(int pos) 1-3
        System.out.println("\nTesting get(int pos):");
        if( list.get(0).equals("a")) 
            System.out.println("Passed test get(int pos) 1");
        else
            System.out.println("Failed test get(int pos) 1");
        
        if( list.get(2).equals("b")) 
            System.out.println("Passed test get(int pos) 2");
        else
            System.out.println("Failed test get(int pos) 2");
        
        if( list.get(3).equals("b")) 
            System.out.println("Passed test get(int pos) 3");
        else
            System.out.println("Failed test get(int pos) 3");
        
        //test remove(int pos) 1-3
        System.out.println("\nTesting remove (int pos):");
        String removed = list.remove(0);
        if(removed.equals("a"))
            System.out.println("Passed test remove(int pos) 1");
        else
            System.out.println("Failed test remove(int pos) 1"); 
        
        String removed2 = list.remove(1);
        if(removed2.equals("b"))
            System.out.println("Passed test remove(int pos) 2");
        else
            System.out.println("Failed test remove(int pos) 2"); 
        
        String removed3 = list.remove(2);
        if(removed3.equals("c"))
            System.out.println("Passed test remove(int pos) 3");
        else
            System.out.println("Failed test remove(int pos) 3"); 
        
        //test size() 1-3
        System.out.println("\nTesting int size():");
        if( list.size() == 3 )
            System.out.println("Passed test size() 1");
        else
            System.out.println("Failed test size () 1");
        
        list.add("AA");
        if( list.size() == 4 )
            System.out.println("Passed test size() 2");
        else
            System.out.println("Failed test size () 2");
        
        list.remove(0);
        if( list.size() == 3 )
            System.out.println("Passed test size() 3");
        else
            System.out.println("Failed test size () 3");
        
    
      //test makeEmpty() 1-3
        System.out.println("\nTesting makeEmpty():");
        list.makeEmpty();
        if( list.size() == 0 )
            System.out.println("Passed test makeEmpty() 1");
        else
            System.out.println("Failed test makeEmpty() 1");
        
        list.add("AA");
        list.makeEmpty();
        if( list.size() == 0 )
            System.out.println("Passed test makeEmpty() 2");
        else
            System.out.println("Failed test makeEmpty() 2");
        
        list.add("BB");
        list.add("CC");
        list.makeEmpty();
        if( list.size() == 0 )
            System.out.println("Passed test makeEmpty() 3");
        else
            System.out.println("Failed test makeEmpty() 3");
        
        //test indexOf(E item) 1-3
        System.out.println("\nTesting int indexOf(E item):");
        list = new LinkedList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        if (list.indexOf("A") == 0)
        	System.out.println("Passed test indexOf(E item) 1");
        else
            System.out.println("Failed test indexOf(E item) 1");
        
        if (list.indexOf("B") == 1)
        	System.out.println("Passed test indexOf(E item) 2");
        else
            System.out.println("Failed test indexOf(E item) 2");
        
        if (list.indexOf("C") == 2)
        	System.out.println("Passed test indexOf(E item) 3");
        else
            System.out.println("Failed test indexOf(E item) 3");
        	
        //test indexOf(E item, int pos)
        System.out.println("\nTesting int indexOf (E item, int pos):");
        list.add("A");
        list.add("B");
        list.add("C");
        if (list.indexOf("A", 2)== 3)
        	System.out.println("Passed test indexOf(E item, int pos) 1");
        else
            System.out.println("Failed test indexOf(E item, int pos) 1");
        
        if (list.indexOf("B", 2)== 4)
        	System.out.println("Passed test indexOf(E item, int pos) 2");
        else
            System.out.println("Failed test indexOf(E item, int pos) 2");
        
        if (list.indexOf("C", 3)== 5)
        	System.out.println("Passed test indexOf(E item, int pos) 3");
        else
            System.out.println("Failed test indexOf(E item, int pos) 3");
        
        //test toString() 1-3
        System.out.println("\nTesting toString():");
        list = new LinkedList<String>();
        list.add("A");
        if( list.toString().equals("[A]")  )
            System.out.println("Passed test toString() 1");
        else
            System.out.println("Failed test toString() 1");
        
        list.add("B");
        if( list.toString().equals("[A, B]")  )
            System.out.println("Passed test toString() 2");
        else
            System.out.println("Failed test toString() 2");
        
        list.add("AC");
        if( list.toString().equals("[A, B, AC]")  )
            System.out.println("Passed test toString() 3");
        else
            System.out.println("Failed test toString() 3");
        
        //test addLast(E item) 1-3
        System.out.println("\nTesting addLast(E item):");
        list = new LinkedList<String>();
        list.addLast("A");
        actual = toArray(list);
        expected = new Object[] {"A"};
        //System.out.println( "Expected result: " + Arrays.toString(expected) );
        //System.out.println( "Actual result: " + Arrays.toString(actual) );  
        if( arraysSame(actual, expected) )
            System.out.println("Passed test addLast(E item) 1");
        else
            System.out.println("Failed test addLast(E item) 1");
        
        list.addLast("B");
        actual = toArray(list);
        expected = new Object[] {"A", "B"};
        //System.out.println( "Expected result: " + Arrays.toString(expected) );
        //System.out.println( "Actual result: " + Arrays.toString(actual) );  
        if( arraysSame(actual, expected) )
            System.out.println("Passed test addLast(E item) 2");
        else
            System.out.println("Failed test addLast(E item) 2");
        
        list.addLast("C");
        actual = toArray(list);
        expected = new Object[] {"A", "B", "C"};
        //System.out.println( "Expected result: " + Arrays.toString(expected) );
        //System.out.println( "Actual result: " + Arrays.toString(actual) );  
        if( arraysSame(actual, expected) )
            System.out.println("Passed test addLast(E item) 3");
        else
            System.out.println("Failed test addLast(E item) 3");
        
        
        //test addFirst(E item)
        System.out.println("\nTesting addFirst(E item):");
        list = new LinkedList<String>();
        list.addFirst("A");
        actual = toArray(list);
        expected = new Object[] {"A"};
        //System.out.println( "Expected result: " + Arrays.toString(expected) );
        //System.out.println( "Actual result: " + Arrays.toString(actual) );  
        if( arraysSame(actual, expected) )
            System.out.println("Passed test addFirst(E item) 1");
        else
            System.out.println("Failed test addFirst(E item) 1");
        
        list.addFirst("B");
        actual = toArray(list);
        expected = new Object[] {"B","A"};
        //System.out.println( "Expected result: " + Arrays.toString(expected) );
        //System.out.println( "Actual result: " + Arrays.toString(actual) );  
        if( arraysSame(actual, expected) )
            System.out.println("Passed test addFirst(E item) 2");
        else
            System.out.println("Failed test addFirst(E item) 2");
        
        list.addFirst("C");
        actual = toArray(list);
        expected = new Object[] {"C","B","A"};
        //System.out.println( "Expected result: " + Arrays.toString(expected) );
        //System.out.println( "Actual result: " + Arrays.toString(actual) );  
        if( arraysSame(actual, expected) )
            System.out.println("Passed test addFirst(E item) 3");
        else
            System.out.println("Failed test addFirst(E item) 3");
        
       //test removeFirst(E item) 1-3
        System.out.println("\nTesting removeFirst(E item):");
        list = new LinkedList<String>();
        list.add("A");
        if (list.removeFirst().equals("A"))
        	System.out.println("Passed test removeFirst() 1");
        else
        	System.out.println("Failed test removeFirst() 1");
        
        list.add("C");
        list.add("B");
        list.add("A");
        if (list.removeFirst().equals("C"))
        	System.out.println("Passed test removeFirst() 2");
        else
        	System.out.println("Failed test removeFirst() 2");
        
        list.addFirst("Hello");
        if (list.removeFirst().equals("Hello"))
        	System.out.println("Passed test removeFirst() 3");
        else
        	System.out.println("Failed test removeFirst() 3");
        
        //test removeLast(E item) 1-3
        System.out.println("\nTesting removeLast(E item):");
        list = new LinkedList<String>();
        list.addLast("A");
        if (list.removeLast().equals("A"))
        	System.out.println("Passed test removeLast() 1");
        else
        	System.out.println("Failed test removeLast() 1");
        
        list.add("A");
        list.add("Hi");
        if (list.removeLast().equals("Hi"))
        	System.out.println("Passed test removeLast() 2");
        else
        	System.out.println("Failed test removeLast() 2");
        
       
        list.add("W");
        list.add("H");
        list.addLast("Hello");
        if (list.removeLast().equals("Hello"))
        	System.out.println("Passed test removeLast() 3");
        else
        	System.out.println("Failed test removeLast() 3");

        //test equals() 1-3
        System.out.println("\nTesing equals()");
        list = new LinkedList<String>();
        if( list.toString().equals("[]") )
            System.out.println("Passed test equals() 1");
        else
            System.out.println("Failed test equals() 1");
        
        list.add("A");
        if( list.toString().equals("[A]") )
            System.out.println("Passed test equals() 2");
        else
            System.out.println("Failed test equals() 2");
        
        list.add("AA");
        list.add("AAA");
        if( list.toString().equals("[A, AA, AAA]") )
            System.out.println("Passed test equals() 3");
        else
            System.out.println("Failed test equals() 3");
        
        //test removeRange(start,stop) 1-3
        System.out.println("\nTesting removeRange(start, stop):");
        list = new LinkedList<String>();
        list.add("A");
        list.removeRange(0, 1);
        if( list.toString().equals("[]")  )
            System.out.println("Passed test removeRange(start, stop) 1");
        else
            System.out.println("Failed test removeRange(start, stop) 1");
        
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.removeRange(1, 3);
        if( list.toString().equals("[A, D]")  )
            System.out.println("Passed test removeRange(start, stop) 2");
        else
            System.out.println("Failed test removeRange(start, stop) 2");
        
        list.insert(1, "B");
        list.insert(2, "C");
        list.removeRange(0, 4);
        if( list.toString().equals("[]")  )
            System.out.println("Passed test removeRange(start, stop) 3");
        else
            System.out.println("Failed test removeRange(start, stop) 3");
        
        
        //test getSublist (int start, int stop) 
        System.out.println("\nTesting IList <E> getSublist (int start, int stop)");
        list = new LinkedList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        
        LinkedList<String> subList1 = (LinkedList<String>) list.getSubList(0, 0);
        if( subList1.toString().equals("[]")  )
            System.out.println("Passed test getSublist (int start, int stop) 1");
        else
            System.out.println("Failed test getSublist (int start, int stop) 1");
        
        LinkedList<String> subList2 = (LinkedList<String>) list.getSubList(1, 5);
        if( subList2.toString().equals("[B, C, D, E]")  )
            System.out.println("Passed test getSublist (int start, int stop) 2");
        else
            System.out.println("Failed test getSublist (int start, int stop) 2");
        
        LinkedList<String> subList3 = (LinkedList<String>) list.getSubList(4, 5);
        if( subList3.toString().equals("[E]")  )
            System.out.println("Passed test getSublist (int start, int stop) 3");
        else
            System.out.println("Failed test getSublist (int start, int stop) 3");      
        
        //test boolean remove (E obj) 1-3
        System.out.println("\nTesting boolean remove (E obj):");
        list = new LinkedList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        boolean boo1 = list.remove("A");
        if(boo1 == true && list.toString().equals("[B, C, D, E]"))
           System.out.println("Passed test remove(E obj) 1");
        else
            System.out.println("Failed test remove(E obj) 1"); 
        
        boolean boo2 = list.remove("B");
        if(boo2 == true && list.toString().equals("[C, D, E]"))
           System.out.println("Passed test remove(E obj) 2");
        else
            System.out.println("Failed test remove(E obj) 2");
        
        boolean boo3 = list.remove("E");
        if(boo3 == true && list.toString().equals("[C, D]"))
           System.out.println("Passed test remove(E obj) 3");
        else
            System.out.println("Failed test remove(E obj) 3");
        
        // CS314 Students:
        // uncomment the following line to run tests comparing
        // your LinkedList class to the java ArrayList class.
        //comparison();
    }

    private static Object[] toArray(LinkedList<String> list) {
        Object[] result = new Object[list.size()];
        Iterator<String> it = list.iterator();
        int index = 0;
        while( it.hasNext() ){
            result[index] = it.next();
            index++;
        }
        return result;
    }

    //pre: none
    private static boolean arraysSame(Object[] one, Object[] two)  {
        boolean same;
        if( one == null || two == null ) {
            same = (one == two);
        }
        else {
            //neither one or two are null
            assert one != null && two != null;
            same = one.length == two.length;
            if( same ) {
                int index = 0;
                while( index < one.length && same ) {
                    same = ( one[index].equals(two[index]) );
                    index++;
                }
            }
        }
        return same;
    }
   
    
    public static final int NUM_DOUBLINGS_OF_N = 5;
    private static final int NUM_REPEATS_OF_TEST = 100;

    // A method to be run to compare the LinkedList you are completing and the Java ArrayList class
    public static void comparison(){
        Stopwatch s = new Stopwatch();
        
        int initialN = 30000;
        addEndArrayList(s, initialN, NUM_DOUBLINGS_OF_N);
        addEndLinkedList(s, initialN, NUM_DOUBLINGS_OF_N);

        initialN = 2000;
        addFrontArrayList(s, initialN, NUM_DOUBLINGS_OF_N);
        initialN = 10000;
        addFrontLinkedList(s, initialN, NUM_DOUBLINGS_OF_N);

        initialN = 2000;
        removeFrontArrayList(s, initialN, NUM_DOUBLINGS_OF_N);
        initialN = 5000;
        removeFrontLinkedList(s, initialN, NUM_DOUBLINGS_OF_N);

        initialN = 10000;
        getRandomArrayList(s, initialN, NUM_DOUBLINGS_OF_N);
        initialN = 1000;
        getRandomLinkedList(s, initialN, NUM_DOUBLINGS_OF_N);

        initialN = 50000;
        getAllArrayListUsingIterator(s, initialN, NUM_DOUBLINGS_OF_N);
        getAllLinkedListUsingIterator(s, initialN, NUM_DOUBLINGS_OF_N);

        initialN = 100000;
        getAllArrayListUsingGetMethod(s, initialN, NUM_DOUBLINGS_OF_N);
        initialN = 1000;
        getAllLinkedListUsingGetMethod(s, initialN, NUM_DOUBLINGS_OF_N);

    }

    // These pairs of method illustarte a failure to use polymorphism
    // If the students had implemented the Java list interface there
    // could be a single method. Also we could use function objects to
    // reduce the awful repitition of code.
    public static void addEndArrayList(Stopwatch s, int initialN, int numTests){

        double[] totalTimes = new double[numTests];        
        for(int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for(int i = 0; i < numTests; i++){
                ArrayList<Integer> javaList = new ArrayList<Integer>();
                s.start();
                for(int j = 0; j < n; j++)
                    javaList.add(j);
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Adding at end: ArrayList", totalTimes, initialN);
    }

    private static void showResults(String title, double[] times, int initialN) {
        System.out.println();
        System.out.println("Num Repeats: " + NUM_REPEATS_OF_TEST);
        System.out.println(title);
        for(double time : times) {
            System.out.print("N = " + initialN + ", total time: ");
            System.out.printf("%7.4f\n", time);
            
            initialN *= 2;
        }
        System.out.println();
    }

    public static void addEndLinkedList(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];        
        for(int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for(int i = 0; i < numTests; i++){
                LinkedList<Integer> studentList = new LinkedList<Integer>();
                s.start();
                for(int j = 0; j < n; j++)
                    studentList.add(j);
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Adding at end: LinkedList", totalTimes, initialN);
    }

    public static void addFrontArrayList(Stopwatch s, int initialN, int numTests){

        double[] totalTimes = new double[numTests];        
        for(int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for(int i = 0; i < numTests; i++){
                ArrayList<Integer> javaList = new ArrayList<Integer>();
                s.start();
                for(int j = 0; j < n; j++)
                    javaList.add(0, j);
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Adding at front: ArrayList", totalTimes, initialN);
    }

    public static void addFrontLinkedList(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];        
        for(int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for(int i = 0; i < numTests; i++){
                LinkedList<Integer> studentList = new LinkedList<Integer>();
                s.start();
                for(int j = 0; j < n; j++)
                    studentList.insert(0, j);
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Adding at front: LinkedList", totalTimes, initialN);
    }

    public static void removeFrontArrayList(Stopwatch s, int initialN, int numTests){     
        double[] totalTimes = new double[numTests];        
        for(int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for(int i = 0; i < numTests; i++){
                ArrayList<String> javaList = new ArrayList<String>();
                for(int j = 0; j < n; j++)
                    javaList.add(j + "");
                s.start();
                while(!javaList.isEmpty())
                    javaList.remove(0);
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Removing from front: ArrayList", totalTimes, initialN);
    }

    public static void removeFrontLinkedList(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];        
        for(int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;    
            for(int i = 0; i < numTests; i++){
                LinkedList<String> studentList = new LinkedList<String>();
                for(int j = 0; j < n; j++)
                    studentList.add(j + "");
                s.start();
                while( studentList.size() != 0 )
                    studentList.removeFirst();
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("removing from front: LinkedList", totalTimes, initialN);
    }

    public static void getRandomArrayList(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];        
        for(int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            int total = 0;
            Random r = new Random();
            for(int i = 0; i < numTests; i++){
                ArrayList<Integer> javaList = new ArrayList<Integer>();
                for(int j = 0; j < n; j++)
                    javaList.add(j);
                s.start();
                for(int j = 0; j < n; j++){
                    total += javaList.get( r.nextInt(javaList.size()) );
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Getting random: ArrayList", totalTimes, initialN);
    }

    public static void getRandomLinkedList(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];        
        for(int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            int total = 0;
            Random r = new Random();
            for(int i = 0; i < numTests; i++){
                LinkedList<Integer> studentList = new LinkedList<Integer>();
                for(int j = 0; j < n; j++)
                    studentList.add(j);
                s.start();
                for(int j = 0; j < n; j++){
                    total += studentList.get( r.nextInt(studentList.size()) );
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Getting random: LinkedList", totalTimes, initialN);
    }

    public static void getAllArrayListUsingIterator(Stopwatch s, int initialN, int numTests){

        double[] totalTimes = new double[numTests];        
        for(int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            int total = 0;
            for(int i = 0; i < numTests; i++){
                ArrayList<Integer> javaList = new ArrayList<Integer>();
                for(int j = 0; j < n; j++)
                    javaList.add(j);
                Iterator<Integer> it = javaList.iterator();
                s.start();
                while( it.hasNext() ){
                    total += it.next();
                }        
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Getting all using iterator: ArrayList", totalTimes, initialN);
    }

    public static void getAllLinkedListUsingIterator(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];        
        for(int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            int total = 0;
            for(int i = 0; i < numTests; i++){
                LinkedList<Integer> studentList = new LinkedList<Integer>();
                for(int j = 0; j < n; j++)
                    studentList.add(j);
                Iterator<Integer> it = studentList.iterator();
                s.start();
                while(it.hasNext()){
                    total += it.next();
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Getting all using iterator: LinkedList", totalTimes, initialN);
    }

    public static void getAllArrayListUsingGetMethod(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];        
        for(int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for(int i = 0; i < numTests; i++){
                ArrayList<Integer> javaList = new ArrayList<Integer>();
                for(int j = 0; j < n; j++)
                    javaList.add(j);

                s.start();
                int x = 0;
                for(int j = 0; j < javaList.size(); j++){
                    x += javaList.get(j);
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Getting all using get method: ArrayList", totalTimes, initialN);
    }

    public static void getAllLinkedListUsingGetMethod(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];        
        for(int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for(int i = 0; i < numTests; i++){
                LinkedList<Integer> studentList = new LinkedList<Integer>();
                for(int j = 0; j < n; j++)
                    studentList.add(j);

                s.start();
                int x = 0;
                for(int j = 0; j < studentList.size(); j++){
                    x += studentList.get(j);
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Getting all using get method: LinkedList", totalTimes, initialN);
    }

    // for future changes
    private static interface ArrayListOp {
        public <E> void op(ArrayList<E> list, E data);
    }
    
    private ArrayListOp addAL = new ArrayListOp() {
        public <E> void op(ArrayList<E> list, E data) {
            list.add(data);
        }
    };
    
    private ArrayListOp addFrontAL = new ArrayListOp() {
        public <E> void op(ArrayList<E> list, E data) {
            list.add(0, data);
        }
    };
    
    private ArrayListOp removeFrontAL = new ArrayListOp() {
        public <E> void op(ArrayList<E> list, E data) {
            list.remove(0);
        }
    };

    private static interface LinkedListOp<E> {
        public void op(LinkedList<E> list);
    }
}
