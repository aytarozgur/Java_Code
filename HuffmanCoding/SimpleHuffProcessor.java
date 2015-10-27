/*  Student information for assignment:
*
*  On <MY|OUR> honor, Anna Mengjie Yu and Chang Chih Chi, this programming assignment is <MY|OUR> own work
*  and <I|WE> have not provided this code to any other student.
*
*  Number of slip days used: 0
*
*  Student 1 (Student whose turnin account is being used)
*  UTEID: my3852
*  email address: annayu2010@gmail.com
*  Grader name: Eric
*  Section number: 90130
*  
*  Student 2: Chang Chih Chi
 *  UTEID: cc45524
 *  email address: johnnychang6@gmail.com
 *  Grader name: Eric
 *  Section number: 90130
*  
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;


public class SimpleHuffProcessor implements IHuffProcessor {
	private Compression myCompression;
	private Decompression myDecompression;
	private HuffViewer myViewer;
    private BitInputStream file;
    private int headerFormat;
    
    public int compress(InputStream in, OutputStream out, boolean force) throws IOException {
    	
    	
    	
    	
        throw new IOException("compress is not implemented");
        //return 10;
    }

    public int preprocessCompress(InputStream in, int headerFormat) throws IOException {
    	this.headerFormat = headerFormat;
        file = new BitInputStream(in);
    	// create a compression object
        myCompression = new Compression();
        // read in inputstream and create a map<value, frequency>
        myCompression.read(file);
        // create a priority queue
        PriorityQueue<TreeNode> queue = myCompression.addQueue();
        // create a frequency tree ;
        HuffmanCodeTree tree = myCompression.HuffmanTree(queue);
        // create a HuffmanCode map
		System.out.println(myCompression.getMap(tree));
        
//    	showString("Not working yet");
//        myViewer.update("Still not working");
//        throw new IOException("preprocess not implemented");
        return 0;
    }

    public void setViewer(HuffViewer viewer) {
        myViewer = viewer;
    }

    public int uncompress(InputStream in, OutputStream out) throws IOException {
        throw new IOException("uncompress not implemented");
        //return 0;
    }
    
    private void showString(String s){
        myViewer.update(s);
    }
    
   

}
