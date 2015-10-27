/*  Student information for assignment:
 *
 *  On OUR honor, Chang Chih Chi and Anna Mengjie Yu, this programming assignment is OUR own work
 *  and WE have not provided this code to any other student.
 *
 *  Number of slip days used: 0
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


import java.util.Iterator;
import java.util.ArrayList;

/**
 * A simple implementation of an ISet. 
 * Elements are not in any particular order.
 * Students are to implement methods that 
 * were not implemented in AbstractSet and override
 * methods that can be done more efficiently. 
 * An ArrayList must be used as the internal storage container.
 *
 */
public class UnsortedSet<E> extends AbstractSet<E> {
	private ArrayList<E> myCon;
	
	
	// Constructor
	public UnsortedSet(){
		myCon = new ArrayList<E>();
	}
	
	
	// O(N)
	/**
     * Add an item to this set.
     * <br> item != null
     * @param item the item to be added to this set. item may not equal null.
     * @return true if this set changed as a result of this operation, false otherwise.
     */
	public boolean add(E item) {
		if(item == null)	throw new IllegalArgumentException();
		
		if(!myCon.contains(item)){
			myCon.add(item);
			return true;
		} else {
			return false;
		}
	}

	
	//O(N^2)
	/**
     * create a new set that is the intersection of this set and otherSet.
     * <br>pre: otherSet != null<br>
     * <br>post: returns a set that is the intersection of this set and otherSet.
     * Neither this set or otherSet are altered as a result of this operation.
     * <br> pre: otherSet != null
     * @param otherSet != null
     * @return a set that is the intersection of this set and otherSet
     */
	public ISet<E> intersection(ISet<E> otherSet) {
		ISet<E> result = new UnsortedSet<E>();
		
		// O(N)
		for(E value : otherSet){
			if(myCon.contains(value)){
				result.add(value); // O(N)
			}
		}
		return result;
	}


	
	// O(1)
	/**
     * Return the number of elements of this set.
     * pre: none
     * @return the number of items in this set
     */
	public int size() {
		return myCon.size();
	}

	
	// O(N^2)
	/**
     * Create a new set that is the union of this set and otherSet.
     * <br>pre: otherSet != null
     * <br>post: returns a set that is the union of this set and otherSet.
     * Neither this set or otherSet are altered as a result of this operation.
     * <br> pre: otherSet != null
     * @param otherSet != null
     * @return a set that is the union of this set and otherSet
     */
	public ISet<E> union(ISet<E> otherSet) {
		if(otherSet == null)	throw new IllegalArgumentException();
		
		ISet<E> result = new UnsortedSet<E>();
		result.addAll(this);
		result.addAll(otherSet);
		return result;
	}
	

	// O(1)
	public Iterator<E> iterator() {
		Iterator<E> it = myCon.iterator();
		return it;
		
	}
	
	// Helper method to get internal storage
	public ArrayList<E> getList(){
		ArrayList<E> result = new ArrayList<E>(myCon);
		return result;
	}
	
}
