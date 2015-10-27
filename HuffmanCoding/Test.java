import java.util.*;
import java.io.*;


public class Test {

	public static void main(String[] args) throws IOException {
		Compression test1 = new Compression();
		test1.read("smallTxt.txt");
		PriorityQueue<TreeNode> queue = test1.addQueue();
		HuffmanCodeTree tree =test1.HuffmanTree(queue);
		test1.getMap(tree);
		
		
		
	}

}
