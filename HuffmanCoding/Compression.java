import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;


public class Compression {
	
	// instance variables
	private TreeMap<Integer,Integer> frequency;
	private int inbits;
	// map for the huffman code as value and the ascii value as key
	private HashMap<Integer,String> huffmanMap;
	// bits for the original file
	//private int bits;
	private HuffmanCodeTree myTree;
	
	public Compression(){
		frequency = new TreeMap<Integer,Integer>();
	}
	
	// read the input file
	public void read(BitInputStream name) throws IOException{
		
		while ((inbits = name.readBits(IHuffConstants.BITS_PER_WORD)) != -1){
			if ( ! frequency.containsKey(inbits))
				frequency.put(inbits, 1);
			else{
				int newVal = frequency.get(inbits)+1;
				frequency.put(inbits, newVal);
			}
		}
		frequency.put(IHuffConstants.PSEUDO_EOF, 1);
		name.close();
		
	}
	
	// return a processed priority queue
	public PriorityQueue<TreeNode> addQueue(){
		PriorityQueue<TreeNode> queue = new PriorityQueue<TreeNode>();
		
		for(int x : frequency.keySet()){
			TreeNode temp = new TreeNode(x, frequency.get(x));
			queue.enqueue(temp);
		}
		
		System.out.println("Priority queue in ascending order: " + queue);
		return queue;
	}
	
	//create a huffmanCode tree
	public HuffmanCodeTree HuffmanTree(PriorityQueue<TreeNode> queue){
		HuffmanCodeTree tree = new HuffmanCodeTree();
		tree.getTree(queue);
		
		//testing purpose
		tree.printTree();
		
		myTree = tree;
		
		//return the HuffmanCode tree
		return tree;
	}

	//create a table/map for the huffmanCode Tree
	public HashMap<Integer, String> getMap(HuffmanCodeTree tree){
		//get the map from HuffmanCode tree;
		huffmanMap = tree.getHuffmanMap();
		return huffmanMap;
	}
	
	//  return the huffmancode map
	public HashMap<Integer, String> getHuffManMap(){
		return huffmanMap;
	}
	
	
	// write the output file method
	public void writeFile(BitInputStream in, BitOutputStream out, int header) throws IOException{
		// BitInputStream object
		//BitInputStream bits = in;
		
		// 1.Write out the magic number
		out.writeBits(IHuffConstants.BITS_PER_INT, IHuffConstants.MAGIC_NUMBER);
		
		// DO WE ONLY NEED TO WRITE ONE? OR BOTH, IF SO, DO WE NEED TO WRITE BOTH OUTPUT FILE?
		// 2.Write out the store_Counts or store_tree 
		//2-1 store counts
		if(header == IHuffConstants.STORE_COUNTS){
			out.writeBits(IHuffConstants.BITS_PER_INT, IHuffConstants.STORE_COUNTS);
			for (int k = 0; k < IHuffConstants.ALPH_SIZE; k++){
				if( !frequency.containsKey(k))
					out.writeBits(IHuffConstants.BITS_PER_INT, 0);
				else
					out.writeBits(IHuffConstants.BITS_PER_INT, frequency.get(k));
			
			}		
		}
		if(header == IHuffConstants.STORE_TREE){
			out.writeBits(IHuffConstants.BITS_PER_INT, IHuffConstants.STORE_TREE);
			writeTree(out,myTree.root());
		}
		
		
		//4. The actual compressed dta
		while ((inbits = in.readBits(IHuffConstants.BITS_PER_WORD)) != -1){
			if(huffmanMap.containsKey(inbits)){
				String path = huffmanMap.get(inbits);
				for (int i = 0 ;i < path.length(); i++){
					char ch = path.charAt(i);
					out.writeBits(1, Integer.valueOf(Character.toString(ch)));
				}
			}
		}
		
		//5. Write the PSEUDO_EOF
		String path_PEOF =  huffmanMap.get(IHuffConstants.PSEUDO_EOF); 
		for (int i = 0; i< path_PEOF.length();i++){
			char ch = path_PEOF.charAt(i);
			out.writeBits(1, Integer.valueOf(Character.toString(ch)));
		}
		
	}

	private void writeTree(BitOutputStream out, TreeNode root) {
		if(root != null){
			if(root.isLeaf()){
				out.writeBits(1, 1);
				out.writeBits(IHuffConstants.BITS_PER_WORD + 1,root.getValue());
			}
			//if it's internal node
			out.writeBits(1,0);
		}
		writeTree(out, root.getLeft());
		writeTree(out, root.getRight());
		
	}
	
	
	
	
	
	
	
	
	
	
}
