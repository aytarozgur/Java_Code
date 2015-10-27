
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

/**
 * Main/launch program for Huff assignment. A better
 * comment than this is warranted.
 *
 */
public class Huff {

    public static void main(String[] args){
        HuffViewer sv = new HuffViewer("Huffman Compression");
        IHuffProcessor proc = new SimpleHuffProcessor();
        sv.setModel(proc);    
    }
}
