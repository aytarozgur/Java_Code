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
 *  Grader name:
 *  Section number:
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
 * In this implementation of the ISet interface the elements in the Set are 
 * maintained in ascending order.
 * 
 * The data type for E must be a type that implements Comparable.
 * 
 * Students are to implement methods that were not implemented in AbstractSet 
 * and override methods that can be done more efficiently. An ArrayList must 
 * be used as the internal storage container. For methods involving two set, 
 * if that method can be done more efficiently if the other set is also a 
 * SortedSet do so.
 */
public class SortedSet<E extends Comparable<? super E>> extends AbstractSet<E> {

	// instance variable
    private ArrayList<E> myCon;

    // O(1)
    /**
     * create an empty SortedSet
     */
    public SortedSet() {
    	myCon = new ArrayList<E>();
    }

    
    // O(NlogN)
    /**
     * create a SortedSet out of an unsorted set. <br>
     * @param other != null
     */
    public SortedSet(ISet<E> other) {
    	if(other == null) throw new IllegalArgumentException();
    	
    	if(!(other instanceof SortedSet)){
    		UnsortedSet<E> otherSet = (UnsortedSet<E>) other;
    		this.myCon = otherSet.getList();
    		mergeSort(this.myCon);
    	} 
    }

    
    // O(1)
    /**
     * Return the smallest element in this SortedSet.
     * <br> pre: size() != 0
     * @return the smallest element in this SortedSet.
     */
    public E min() {
    	return myCon.get(0);
    }

    // O(1)
    /**
     * Return the largest element in this SortedSet.
     * <br> pre: size() != 0
     * @return the largest element in this SortedSet.
     */
    public E max() {
    	return myCon.get(myCon.size() - 1);
    }

    
    // O (N)
    /**
     * Add an item to this set.
     * <br> item != null
     * @param item the item to be added to this set. item may not equal null.
     * @return true if this set changed as a result of this operation, false otherwise.
     */
    public boolean add(E item) {
		if(item == null)	throw new IllegalArgumentException();
		//if(myCon.contains(item)) return false;
		if(myCon.size() == 0 || myCon.get(size()-1).compareTo(item) < 0) 
			myCon.add(item);
		else{
			int index = 0;
			for (int i = 0; i < size(); i++) {
				if(myCon.get(i).compareTo(item) < 0) index++;
				//add this statement to avoid checking contains 
				else if(myCon.get(i).compareTo(item) == 0){
					return false;
				}
			}
			myCon.add(index, item);
		}
		return true;
	}

    
    // O(N)
	/**
     * A union operation. Add all items of otherSet that are not already present in this set
     * to this set.
     * @param otherSet != null
     * @return true if this set changed as a result of this operation, false otherwise.
     */
	public boolean addAll(ISet<E> otherSet) {
		
		if(otherSet == null) throw new IllegalArgumentException();

		SortedSet<E> otherSortedSet = getSorted(otherSet);
		
		int size = this.size();
		
		ArrayList<E> result = new ArrayList<E>();
		int thisIndex = 0;
		int thisEnd = this.size();
		int otherIndex = 0;
		int otherEnd = otherSet.size();
		
		// loop with two indices of both Sets' arrayLists
		while(thisIndex < thisEnd && otherIndex < otherEnd){

			if(myCon.get(thisIndex).compareTo(otherSortedSet.myCon.get(otherIndex)) == 0){
				result.add(myCon.get(thisIndex));
				thisIndex++;
				otherIndex++;
			} else if(myCon.get(thisIndex).compareTo(otherSortedSet.myCon.get(otherIndex)) > 0){
				result.add(otherSortedSet.myCon.get(otherIndex));
				otherIndex++;
			} else { // compareTo < 0
				result.add(myCon.get(thisIndex));
				thisIndex++;
			}
		}

		// add the rest elements into the result arraylist
		while(thisIndex < thisEnd){
			result.add(myCon.get(thisIndex));
			thisIndex++;
		}
		
		// add the rest elements into the result arraylist
		while(otherIndex < otherEnd){
			result.add(otherSortedSet.myCon.get(otherIndex));
			otherIndex++;
		}
		// reassign myCon to result arraylist
		myCon = result;
		return size != myCon.size();
		
	}
			
	
	// O(logN)
	/**
     * Determine if item is in this set. 
     * <br>pre: item != null
     * @param item element whose presence is being tested. Item may not equal null.
     * @return true if this set contains the specified item, false otherwise.
     */
	public boolean contains(E item) {
		// binary search item in the internal storage
		return binarySearch(myCon, item);
	}
	
	// O(N)
	/**
     * Determine if all of the elements of otherSet are in this set.
     * <br> pre: otherSet != null
     * @param otherSet != null
     * @return true if this set contains all of the elements in otherSet, 
     * false otherwise.
     */
	public boolean containsAll(ISet<E> otherSet) {
		if(otherSet == null) throw new IllegalArgumentException();
		
		SortedSet<E> otherSortedSet = getSorted(otherSet);

	    int thisIndex = 0;
	    int thisEnd = this.size();
	    int otherIndex = 0;
	    int otherEnd = otherSortedSet.size();
	    
	    while(thisIndex < thisEnd && otherIndex < otherEnd){
	    	if(myCon.get(thisIndex).compareTo(otherSortedSet.myCon.get(otherIndex)) < 0){
	    		thisIndex++;
	    	} else if(myCon.get(thisIndex).compareTo(otherSortedSet.myCon.get(otherIndex)) > 0){
	    		// break the loop set thisindex to thisend
	    		thisIndex = thisEnd;
	    	} else { // equals, move both indices
	    		thisIndex++;
	    		otherIndex++;
	    	}
	    }
	    return otherIndex == otherEnd ;
	}
	
	
	// O (N)
	/**
     * Create a new set that is the difference of this set and otherSet. Return an ISet of 
     * elements that are in this Set but not in otherSet. Also called
     * the relative complement. 
     * <br>Example: If ISet A contains [X, Y, Z] and ISet B contains [W, Z] then
     * A.difference(B) would return an ISet with elements [X, Y] while
     * B.difference(A) would return an ISet with elements [W]. 
     * <br>pre: otherSet != null
     * <br>post: returns a set that is the difference of this set and otherSet.
     * Neither this set or otherSet are altered as a result of this operation.
     * <br> pre: otherSet != null
     * @param otherSet != null
     * @return a set that is the difference of this set and otherSet
     */
	public ISet<E> difference(ISet<E> otherSet) {
		if(otherSet == null){
			throw new IllegalArgumentException();
		}
		
		SortedSet<E> otherSortedSet = getSorted(otherSet);

		SortedSet<E> result = new SortedSet<E>();
		
		int thisIndex = 0;
		int otherIndex = 0;
		int thisEnd = this.size();
		int otherEnd = otherSortedSet.size();
		
		while(thisIndex < thisEnd && otherIndex < otherEnd){

			if(myCon.get(thisIndex).compareTo(otherSortedSet.myCon.get(otherIndex)) == 0){
				thisIndex++;
				otherIndex++;
			} else if(myCon.get(thisIndex).compareTo(otherSortedSet.myCon.get(otherIndex)) < 0){
				result.add(myCon.get(thisIndex));
				thisIndex++;
			} else{
				otherIndex++;
			}
		}
		
		while(thisIndex < thisEnd){
			result.add(myCon.get(thisIndex));
			thisIndex++;
		}
		
		return result;
	}
	

	// O(N)
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
		if(otherSet == null){
			throw new IllegalArgumentException();
		}

		SortedSet<E> otherSortedSet = getSorted(otherSet);

		SortedSet<E> result = new SortedSet<E>();
		
		int thisIndex = 0;
		int otherIndex = 0;
		int thisEnd = this.size();
		int otherEnd = otherSortedSet.size();

		while(thisIndex < thisEnd && otherIndex < otherEnd){
			if(myCon.get(thisIndex).compareTo(otherSortedSet.myCon.get(otherIndex)) == 0){
				result.add(myCon.get(thisIndex));
				thisIndex++;
				otherIndex++;
			} else if(myCon.get(thisIndex).compareTo(otherSortedSet.myCon.get(otherIndex)) < 0){
				thisIndex++;
			} else{
				otherIndex++;
			}
		}
		return result;
	}

	// O(1)
	public Iterator<E> iterator() {
		Iterator<E> it = myCon.iterator();
		return it;
	}

	
	// O(N)
	/**
     * Remove the specified item from this set if it is present.
     * pre: item != null
     * @param item the item to remove from the set. item may not equal null.
     * @return true if this set changed as a result of this operation, false otherwise
     */
	public boolean remove(E item) {
		if(item == null)  throw new IllegalArgumentException();
		
		if(this.contains(item)){ 
			return myCon.remove(item); 
		}
		return false;
	}

	// O(1)
	public int size() {
		return myCon.size();
	}
	
	
	// O(N)
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
		
		SortedSet<E> otherSortedSet = getSorted(otherSet);
		
		SortedSet<E> result = new SortedSet<E>();
		
		int thisIndex = 0;
		int thisEnd = this.size();
		int otherIndex = 0;
		int otherEnd = otherSortedSet.size();
		
		while(thisIndex < thisEnd && otherIndex < otherEnd){

			if(myCon.get(thisIndex).compareTo(otherSortedSet.myCon.get(otherIndex)) == 0){
				E temp = myCon.get(thisIndex);
				result.add(temp);
				thisIndex++;
				otherIndex++;
			} else if(myCon.get(thisIndex).compareTo(otherSortedSet.myCon.get(otherIndex)) < 0){
				result.add(myCon.get(thisIndex));
				thisIndex++;
			} else { // this is less than other element
				result.add(otherSortedSet.myCon.get(otherIndex));
				otherIndex++;
			}
		}
		
		while(thisIndex < thisEnd){
			result.add(myCon.get(thisIndex));
			thisIndex++;
		}
		
		while(otherIndex < otherEnd){
			result.add(otherSortedSet.myCon.get(otherIndex));
			otherIndex++;
		}
		return result;
	}
	
	// O (N)
	/**
     * Determine if this set is equal to other.
     * Two sets are equal if they have exactly the same elements.
     * The order of the elements does not matter.
     * <br>pre: none
     * @param other the object to compare to this set 
     * @return true if other is a Set and has the same elements as this set
     */
	public boolean equals(Object other){
    	if(other == null || !(other instanceof ISet<?>)) return false;

    	if(!(other instanceof SortedSet<?>)) return super.equals(other);

    	SortedSet<?> otherSortedSet = (SortedSet<?>) other;

    	if(this.size() != otherSortedSet.size()) return false;
    	// loop through once compare each element in myCon
    	for(int i = 0; i < this.myCon.size(); i++){
    		if(!this.myCon.get(i).equals(otherSortedSet.myCon.get(i)))
    			return false;
    	}
    	return true;
	}
	
	
	// Code for mergeSort from "Building Java Programs, third Edition by Stuart Reges"
	// Recursive merge sort helper method O(NlogN)
	private void mergeSort(ArrayList<E> list){
		int size = list.size();
		ArrayList<E> left = new ArrayList<E>();
		ArrayList<E> right = new ArrayList<E>();
		
		if(list.size() > 1){
			// fill the left list 
			for (int i = 0; i < size / 2; i++) left.add(list.get(i));
			// fill the right list
			for (int i = size / 2; i < size; i++) right.add(list.get(i));

			// recursive calls
			mergeSort(left);
			mergeSort(right);
			
			// merge method
			merge(list, left, right);
		}
	}

	// Merge sort helper method
	private void merge(ArrayList<E> result, ArrayList<E> left, ArrayList<E> right){
		int leftIndex = 0;
		int rightIndex = 0;
		
		for (int i = 0; i < result.size(); i++) {
			// if rightIndex exceeds the size or left value is smaller, take left item
			if(rightIndex >= right.size() || (leftIndex < left.size() && left.get(leftIndex).compareTo(right.get(rightIndex)) <= 0)){
				result.set(i, left.get(leftIndex));
			    leftIndex++;
			} else {
				result.set(i, right.get(rightIndex));
				rightIndex++;
			}
		}
	}
	
	// return boolean value if the list has the item O(logN)
	private boolean binarySearch(ArrayList<E> list, E item){
		return binarySearch(list, item, 0, list.size() - 1);
	}
	// Recursive Binary Search method
	private boolean binarySearch(ArrayList<E> list, E target, int min, int max){
		if(min > max){
			return false;
		} else {
			int middle = (min + max) / 2;
			if(list.get(middle).equals(target)){
				return true;
			} else if(list.get(middle).compareTo(target) < 0){
				return binarySearch(list, target, middle + 1, max );
			} else{
				return binarySearch(list, target, min, middle - 1);
			}
		}
	}

	// helper method to create a new SortedSet or perform casting task
	private SortedSet<E> getSorted (ISet<E> other){
		if(other instanceof SortedSet) return (SortedSet<E>) other;
		return new SortedSet<E>(other);
	}
	
    	
}
	
	
	
	



