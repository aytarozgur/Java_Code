/*  Student information for assignment:
 *
 *  Number of slip days used:0
 *
 *  Student 1: Chang Chih Chi 
 *  UTEID: cc45524
 *  email address: johnnychang6@gmail.com
 *  Grader name: Eric
 *  Section number: 90130
 *  
 *  Student 2: Anna Mengjie Yu
 *  UTEID: my3852
 *  email address: anayu2010@gmail.com
 *  Grader name: Eric
 *  Section number: 90130
 *  
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.UIManager;

import java.util.TreeSet;
import java.util.HashSet;
import java.util.Set;


/*
CS 314 Students, put your results to the experiments and answers to
questions here:


				                                                     								Time			
Total Words	 	  Distinct Words		File Name				Size(kb)	SortedSet		UnsortedSet		HashSet			TreeSet
18341			      5270				Nature.txt				109			0.426558		0.149831		0.021407		0.029792
86552  (4.7X)		15552(3.0X)			TheScarletLetter.txt	525(4.8X)	3.663826(8.6X)	1.360703(9.0X)	0.098687(4.6X)	0.123999(4.2X)
118840 (1.4X)		18784(1.2X)			Walden.txt				667(1.3X)	5.693977(1.6X)	1.84521(1.4X)	0.137865(1.4X)	0.174596(1.4X)
123124 (1.0X)		21011(1.1x)			KnickerBocker.txt		745(1.1X)	7.208474(1.3X)	2.324565(1.3X)	0.176118(1.3X)	0.202053(1.2X)

Q1:
processtextCS314 SortedSet is O(N^2)
processtextCS314 UnsortedSet is  O(N^2)
processtextJavaSets HashSet is O(logN)
processtextJavaSets TreeSet is O(NlogN)

Q2:
Our add methods are O(N) for both sets. HashSet is O(1), TreeSet is O(N).


Q3:
HashSet is faster than TreeSet, TreeSet uses binary search tree method, HashSet is constant 
time for adding method.



1st test: Nature

***** CS314 SortedSet: *****
Time to add the elements in the text to this set: elapsed time: 0.426558 seconds.
Total number of words in text including duplicates: 18341
Number of distinct words in this text 5270

****** CS314 UnsortedSet: *****
Time to add the elements in the text to this set: elapsed time: 0.149831 seconds.
Total number of words in text including duplicates: 18341
Number of distinct words in this text 5270

***** Java HashSet ******
Time to add the elements in the text to this set: elapsed time: 0.021407 seconds.
Total number of words in text including duplicates: 18341
Number of distinct words in this text 5270

***** Java TreeSet ******
Time to add the elements in the text to this set: elapsed time: 0.029792 seconds.
Total number of words in text including duplicates: 18341
Number of distinct words in this text 5270



2nd test: The Scarlet Letter

***** CS314 SortedSet: *****
Time to add the elements in the text to this set: elapsed time: 3.663826 seconds.
Total number of words in text including duplicates: 86522
Number of distinct words in this text 15552

****** CS314 UnsortedSet: *****
Time to add the elements in the text to this set: elapsed time: 1.360703 seconds.
Total number of words in text including duplicates: 86522
Number of distinct words in this text 15552

***** Java HashSet ******
Time to add the elements in the text to this set: elapsed time: 0.098687 seconds.
Total number of words in text including duplicates: 86522
Number of distinct words in this text 15552

***** Java TreeSet ******
Time to add the elements in the text to this set: elapsed time: 0.123999 seconds.
Total number of words in text including duplicates: 86522
Number of distinct words in this text 15552



3rd test: Walden

***** CS314 SortedSet: *****
Time to add the elements in the text to this set: elapsed time: 5.693977 seconds.
Total number of words in text including duplicates: 118840
Number of distinct words in this text 18784

****** CS314 UnsortedSet: *****
Time to add the elements in the text to this set: elapsed time: 1.84521 seconds.
Total number of words in text including duplicates: 118840
Number of distinct words in this text 18784

***** Java HashSet ******
Time to add the elements in the text to this set: elapsed time: 0.137865 seconds.
Total number of words in text including duplicates: 118840
Number of distinct words in this text 18784

***** Java TreeSet ******
Time to add the elements in the text to this set: elapsed time: 0.174596 seconds.
Total number of words in text including duplicates: 118840
Number of distinct words in this text 18784



4th test: KnickerBocker 


***** CS314 SortedSet: *****
Time to add the elements in the text to this set: elapsed time: 7.208474 seconds.
Total number of words in text including duplicates: 123124
Number of distinct words in this text 21011

****** CS314 UnsortedSet: *****
Time to add the elements in the text to this set: elapsed time: 2.324565 seconds.
Total number of words in text including duplicates: 123124
Number of distinct words in this text 21011

***** Java HashSet ******
Time to add the elements in the text to this set: elapsed time: 0.176118 seconds.
Total number of words in text including duplicates: 123124
Number of distinct words in this text 21011

***** Java TreeSet ******
Time to add the elements in the text to this set: elapsed time: 0.202053 seconds.
Total number of words in text including duplicates: 123124
Number of distinct words in this text 21011


CS314 Students, why is it unwise to implement all three of the
intersection, union, and difference methods in the AbstractSet class:

A: Because implement all these three method will leave to mutual recursion,
infinite loop calling each other.


*/


public class SetTester {

	public static void main(String[] args){

		UnsortedSet<Integer> s1 = new UnsortedSet<Integer>();
		for (int i = 1; i <= 10; i++) {
			s1.add(i);
		}

		UnsortedSet<Integer> s2 = new UnsortedSet<Integer>();
		for (int i = 5; i < 15; i++) {
			s2.add(i);
		}

		// Test 1: size method
		System.out.print("Test 1, UnsortedSet  size method: ");
		if(s1.size() == 10)
			System.out.println("passed" );
		else
			System.out.println("failed");

		// Test 2: add method
		System.out.print("Test 2, UnsortedSet  add method: ");
		s1.add(11);
		if (s1.contains(11)) {
			System.out.println("passed");
		} else {
			System.out.println("failed");
		}


		// Test 3: toString method
		System.out.print("Test 3, UnsortedSet toString method: ");
		if(s1.toString().equals("(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)")){
			System.out.println("passed");
		} else {
			System.out.println("failed");
		}

		// Test 4: add all method
		System.out.print("Test 4, UnsortedSet  add all method: ");
		s1.addAll(s2);
		if (s1.toString().equals("(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14)")) {
			System.out.println("passed");
		} else {
			System.out.println("failed");
		}


		// Test 5: remove method
		System.out.print("Test 5, UnsortedSet remove method: ");
		for (int i = 11; i < 15; i++) {
			s1.remove(i);
		}
		if (s1.toString().equals("(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)")) {
			System.out.println("passed");
		} else {
			System.out.println("failed");
		}


		// Test 6: clear method
		System.out.print("Test 6, UnsortedSet clear method: ");
		s1.clear();
		if (s1.size() == 0) {
			System.out.println("passed");
		} else {
			System.out.println("failed");
		}

		for (int i = 1; i <= 10; i++) {
			s1.add(i);
		}

		// Test 7: contains method
		System.out.print("Test 7, UnsortedSet contains method: ");
		if(!s1.contains(999)){
			System.out.println("passed");
		} else {
			System.out.println("failed");
		}

		// Test 8: contains all method
		System.out.print("Test 8, UnsortedSet contains all method: ");
		if(!s1.containsAll(s2))
			System.out.println("passed");
		else 
			System.out.println("failed");



		// Test 9: union method
		System.out.print("Test 9, UnsortedSet union method: ");
		ISet<Integer> s3 = s1.union(s2);
		if(s3.toString().equals("(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14)"))
			System.out.println("passed");
		else
			System.out.println("failed");


		// Test 10: difference method
		System.out.print("Test 10, UnsortedSet difference method: ");
		s3 = s1.difference(s2);
		if(s3.toString().equals("(1, 2, 3, 4)"))
			System.out.println("passed");
		else
			System.out.println("failed");

		// Test 11: intersection method
		System.out.print("Test 11, UnsortedSet intersection method: ");
		s3 = s2.intersection(s1);
		if (s3.toString().equals("(5, 6, 7, 8, 9, 10)")) 
			System.out.println("passed");
		else
			System.out.println("failed");

		// The following test cases are for sorted set


		// Test 12: Create a sorted set with unsorted set
		UnsortedSet<Integer> list1 = new UnsortedSet<Integer>();
		list1.add(9);
		list1.add(3);
		list1.add(1);
		list1.add(5);
		SortedSet<Integer> list2 = new SortedSet<Integer>(list1);
		System.out.print("Test 12, SortedSet constructor method: ");
		if(list2.toString().equals("(1, 3, 5, 9)"))
			System.out.println("passed");
		else
			System.out.println("failed");

		// Test 13: add method
		System.out.print("Test 13, SortedSet add method: ");
		list2.add(7);
		if(list2.toString().equals("(1, 3, 5, 7, 9)"))
			System.out.println("passed");
		else
			System.out.println("failed");

		// Test 14: add all method
		System.out.print("Test 14, SortedSet add all method: ");
		list1.clear();
		list1.add(1);
		list1.add(3);
		list1.add(6);
		list1.add(4);
		list2.addAll(list1);
		if(list2.toString().equals("(1, 3, 4, 5, 6, 7, 9)"))
			System.out.println("passed");
		else
			System.out.println("failed");


		// Test 15: remove method
		System.out.print("Test 15, SortedSet  remove method: ");
		list2.remove(4);
		list2.remove(6);
		if(list2.toString().equals("(1, 3, 5, 7, 9)"))
			System.out.println("passed");
		else
			System.out.println("failed");

		// Test 16: clear and size method
		System.out.print("Test 16, SortedSet clear and size method: ");
		list2.clear();
		if(list2.size() == 0)
			System.out.println("passed");
		else
			System.out.println("failed");

		// Test 17: contains method
		System.out.print("Test 17, SortedSet contains method: ");
		list2.add(4);
		list2.add(2);
		list2.add(3);
		list2.add(23);
		list2.add(9999);
		if(list2.contains(9999))
			System.out.println("passed");
		else 
			System.out.println("failed");

		// Test 18: contains all method
		System.out.print("Test 18, SortedSet contains all method: ");
		if(!list2.containsAll(list1))
			System.out.println("passed");
		else
			System.out.println("failed");

		// Test 19: union method
		System.out.print("Test 19, SortedSet union method: ");
		ISet<Integer> resultList = list2.union(list1);
		if(resultList.toString().equals("(1, 2, 3, 4, 6, 23, 9999)"))
			System.out.println("passed");
		else
			System.out.println("failed");

		// Test 20: difference method
		System.out.print("Test 20, SortedSet difference method: ");
		resultList = list1.difference(list2);
		if(resultList.toString().equals("(1, 6)"))
			System.out.println("passed");
		else
			System.out.println("failed");

		// Test 21: intersection method
		System.out.print("Test 21, SortedSet intersection method: ");
		resultList = list2.intersection(list1);
		if(resultList.toString().equals("(3, 4)"))
			System.out.println("passed");
		else
			System.out.println("failed");


		// Test 22: minimum method
		System.out.print("Test 22, SortedSet min method: ");
		if(list2.min() == 2)
			System.out.println("passed");
		else
			System.out.println(false);

		// Test 23: maximum method
		System.out.print("Test 23, SortedSet max method: ");
		if(list2.max() == 9999)
			System.out.println("passed");
		else
			System.out.println("failed");

		// Test 24: SortedSet size method
		System.out.print("Test 24, SortedSet size method: ");
		if(list2.size() == 5)
			System.out.println("passed");
		else
			System.out.println("failed");

		// Test 25: UnsortedSet size method
		System.out.print("Test 25, UnsortedSet size method");
		if(list1.size() == 4)
			System.out.println("passed");
		else
			System.out.println("failed");

        
//         CS314 Students. Uncomment this section when ready to 
//         run your experiments
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                }
                catch(Exception e) {
                    System.out.println("Unable to change look and feel");
                }
        		Scanner sc = new Scanner(System.in);
        		String response = "";
        		do {
        			largeTest();
        			System.out.print("Another file? Enter y to do another file: ");
        			response = sc.next();
        		} while( response != null && response.length() > 0 
                      && response.substring(0,1).equalsIgnoreCase("y") );

    }

    /*
     * Method asks user for file and compares run times to add words from file to
     * various sets, including CS314 UnsortedSet and SortedSet and Java's
     * TreeSet and HashSet.
     */
    private static void largeTest(){
        System.out.println();
        System.out.println("Opening Window to select file. You may have to minimize other windows.");
        String text = convertFileToString();
        System.out.println();
        System.out.println("***** CS314 SortedSet: *****");
        processTextCS314Sets(new SortedSet<String>(), text);
        System.out.println("****** CS314 UnsortedSet: *****");
        processTextCS314Sets(new UnsortedSet<String>(), text);
        System.out.println("***** Java HashSet ******");
        processTextJavaSets( new HashSet<String>(), text);
        System.out.println("***** Java TreeSet ******");
        processTextJavaSets( new TreeSet<String>(), text);
    }

    
    /*
     * pre: set != null, text != null
     * Method to add all words in text to the given set. Words are delimited by
     * white space.
     * This version for CS314 sets.
     */
    private static void processTextCS314Sets(ISet<String> set, String text){
        Stopwatch s = new Stopwatch();
        Scanner sc = new Scanner(text);
        int totalWords = 0;
        s.start();
        while( sc.hasNext() ){
            totalWords++;
            set.add(sc.next());
        }
        s.stop();
        sc.close();

        showResultsAndWords(set, s, totalWords, set.size());
    }


    /*
     * pre: set != null, text != null
     * Method to add all words in text to the given set. Words are delimited by
     * white space.
     * This version for Java Sets.
     */
    private static void processTextJavaSets(Set<String> set, String text){
        Stopwatch s = new Stopwatch();
        Scanner sc = new Scanner(text);
        int totalWords = 0;
        s.start();
        while( sc.hasNext() ){
            totalWords++;
            set.add(sc.next());
        }
        s.stop();
        sc.close();

        showResultsAndWords(set, s, totalWords, set.size());
    }

    
    /*
     * Show results of add words to given set.
     */
    private static <E> void showResultsAndWords(Iterable<E> set, Stopwatch s, 
            int totalWords, int setSize) {

        System.out.println("Time to add the elements in the text to this set: " + s.toString() );
        System.out.println("Total number of words in text including duplicates: " + totalWords);
        System.out.println("Number of distinct words in this text " + setSize);


        System.out.print("Enter y to see the contents of this set: ");
        Scanner sc = new Scanner(System.in);
        String response = sc.next();

        if( response != null && response.length() > 0 && response.substring(0,1).equalsIgnoreCase("y") ){
            for(Object o : set)
                System.out.println(o);
        }	
        System.out.println();
    }


    /*
     * Ask user to pick a file via a file choosing window and
     * convert that file to a String. Since we are evalutatin the file
     * with many sets convert to string once instead of reading through
     * file multiple times.
     */
    private static String convertFileToString() {
        //create a GUI window to pick the text to evaluate
        JFileChooser chooser = new JFileChooser(".");
        StringBuilder text = new StringBuilder();
        int retval = chooser.showOpenDialog(null);

        chooser.grabFocus();

        //read in the file
        if (retval == JFileChooser.APPROVE_OPTION) {
            File source = chooser.getSelectedFile();
            try {
                Scanner s = new Scanner( new FileReader( source ) );

                while( s.hasNextLine() ) {
                    text.append( s.nextLine() );
                    text.append(" ");
                }

                s.close();
            }
            catch(IOException e) {
                System.out.println("An error occured while trying to read from the file: " + e);
            }
        }

        return text.toString();
    }
}