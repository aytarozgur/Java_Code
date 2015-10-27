import java.util.*;


public class PriorityQueue<E>{
	
	private int size;
	private LinkedList<TreeNode> list;
	
	
	// constructor
	public PriorityQueue(){
		list = new LinkedList<TreeNode>();
		size = 0;
		
	}
	
	//size method
	public int size(){
		return size;
		
	}
		
	// enqueue, add method
	public void enqueue(TreeNode n){
			int insertPos = list.size();
			for (int i = list.size()-1; i >= 0; i--) {
				if(list.get(i).compareTo(n) > 0){
					insertPos--;
				}
			}
			list.add(insertPos, n);
		size++;	
	}
	
	// dequeue, remove method
	public TreeNode dequeue(){
		size--;	
		return list.removeFirst();	
	}
	
	public boolean isEmpty(){
		return size==0;
	}
	
	public String toString(){
		String ret = "";
		for (TreeNode node : list) {
			ret += node;
		}
		return ret;
	}
	
	

}
