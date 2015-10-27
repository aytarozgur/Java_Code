import java.util.*;


public class HuffmanCodeTree {
	private TreeNode root;
	private int size;
	
	
	public HuffmanCodeTree(){
		root = null;
		size = 0;
	}
	
	public void getTree(PriorityQueue<TreeNode> queue){
		if(queue == null) throw new IllegalArgumentException();
		
		while(queue.size() > 1){
			TreeNode leftNode = queue.dequeue();
			TreeNode rightNode = queue.dequeue();
			int totalWeight = leftNode.getWeight() + rightNode.getWeight();
			TreeNode temp = new TreeNode(0,totalWeight,leftNode,rightNode);
			queue.enqueue(temp);
		}
		root = queue.dequeue();
	}
	
	public TreeNode root(){
		return root;
	}
	
	
	// size method
	public int size(){
		return sizeHelper(root);
	}

	private int sizeHelper(TreeNode n) {
		if(n == null) return 0;
		else
			return 1 + sizeHelper(n.getLeft()) + sizeHelper(n.getRight());
	}
	
	//get HuffmanMap method
	//post: return a HashMap<value, corresponding binary string>
	public HashMap<Integer,String> getHuffmanMap(){
		HashMap<Integer,String> result = new HashMap<Integer,String>();
		String path="";
		getMap(result,root,path);
		return result;
	}
	
	
	
	//helper method
	private void getMap(HashMap<Integer, String> map, TreeNode root, String path) {
		if (root != null){
			//if left, add 0 to the string
			getMap(map,root.getLeft(),path+"0");
			//if the current node is a leaf,put the value and corresponding path into the map
			if(root.isLeaf()) map.put(root.myValue, path);
			//if right, add 1 to the string
			getMap(map,root.getRight(),path+"1");
		}
		
	}

	// print the whole tree method
	public void printTree(){
		printTree(root, "");
	}

	private void printTree(TreeNode n, String spaces) {
		if(n != null){
			printTree(n.getRight(), spaces + "  ");
			System.out.println(spaces + n);
			printTree(n.getLeft(), spaces + "  ");
			
		}
	}
	
	


}
