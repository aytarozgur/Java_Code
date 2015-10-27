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
 *  Section number: 90130 * 
 */

import java.util.Iterator;


/**
 * Students are to complete this class. 
 * Students should implement as many methods
 * as they can using the Iterator from the iterator 
 * method and the other methods. 
 *
 */
public abstract class AbstractSet<E> implements ISet<E> {

    /* NO INSTANCE VARIABLES ALLOWED.
     * NO DIRECT REFERENCE TO UnsortedSet OR SortedSet ALLOWED.
     * (In other words the data types UnsortedSet and SortedSet
     * will not appear any where in this class.)
     * Also no direct references to ArrayList or other Java Collections.
     */
	
	
	// O(N^2)
	/**
     * A union operation. Add all items of otherSet that are not already present in this set
     * to this set.
     * @param otherSet != null
     * @return true if this set changed as a result of this operation, false otherwise.
     */
   public boolean addAll(ISet<E> otherSet){
	   if(otherSet == null){
		   throw new IllegalArgumentException();
	   }
	   boolean isAdd = false;
	   for(E value : otherSet){
		   if(!this.contains(value)){
			   this.add(value);
			   isAdd = true;
		   }
	   }
	   return isAdd;
   }
   
   
	// O (N^2)
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
    public ISet<E> difference(ISet<E> otherSet){
    	ISet<E> result = this.union(otherSet);
    	// union set remove the otherSet's items will remain the difference
    	for(E value : otherSet){ // O (N)
    		result.remove(value); // O(N)
    	}
    	return result;
    }
    	
	
	// O(N)
	/**
     * Determine if item is in this set. 
     * <br>pre: item != null
     * @param item element whose presence is being tested. Item may not equal null.
     * @return true if this set contains the specified item, false otherwise.
     */
    public boolean contains(E item){
       if(item == null){
    	   throw new IllegalArgumentException();
       }
    	for(E value : this){
    	   if(value.equals(item))
    		   return true;
       }
    	return false;
    }
	
    
    // O(N^2)
    /**
     * Determine if all of the elements of otherSet are in this set.
     * <br> pre: otherSet != null
     * @param otherSet != null
     * @return true if this set contains all of the elements in otherSet, 
     * false otherwise.
     */
    public boolean containsAll(ISet<E> otherSet){
    	if(otherSet == null) throw new IllegalArgumentException();
    	
    	for(E value : otherSet){ // O(N)
    		if(!this.contains(value)) // O(N)
    			return false;
    	}
    	return true;
    }
	
	
    // O(N)
    /**
     * Remove the specified item from this set if it is present.
     * pre: item != null
     * @param item the item to remove from the set. item may not equal null.
     * @return true if this set changed as a result of this operation, false otherwise
     */
    public boolean remove(E item){
    	Iterator<E> itr = this.iterator();
    	while(itr.hasNext()){
    		if(itr.next().equals(item)){
    			itr.remove();
    			return true;
    		}
    	}
    	return false;
    }     
    
    
    // O(N)
    /**
     * Make this set empty.
     * <br>pre: none
     * <br>post: size() = 0
     */
    public void clear(){
    	Iterator<E> itr = this.iterator();
    	while(itr.hasNext()){
    		itr.next();
    		itr.remove();
    	}
    }
    
    
    
    /**
     * Return the number of elements of this set.
     * pre: none
     * @return the number of items in this set
     */
    public int size(){
    	int count = 0;
    	Iterator<E> itr = this.iterator();
    	while(itr.hasNext()){
    		if(itr.next() == null){
    			count++;
    		}
    	}
    	return count;
    } 
   
    
	// O(N^2)
    /**
     * Determine if this set is equal to other.
     * Two sets are equal if they have exactly the same elements.
     * The order of the elements does not matter.
     * <br>pre: none
     * @param other the object to compare to this set 
     * @return true if other is a Set and has the same elements as this set
     */
    public boolean equals(Object other){
    	if(other == null) return false;
    	
    	if(!(other instanceof ISet<?>)) return false;
    	
		ISet<?> otherSet = (ISet<?>) other;
		if(this.size() != otherSet.size()) return false;
		
		Iterator<E> itr = this.iterator();
		while(itr.hasNext()){
			boolean result = false;
			E val = itr.next();
			for (Iterator<?> iterator = otherSet.iterator(); iterator.hasNext() && !result;) {
				Object itrOther = iterator.next();
				if(val.equals(itrOther))
					result = true;
			}
			if(!result) return false;
		}
		return true;
    }
    
    
    public String toString() {
        StringBuilder result = new StringBuilder();
        String seperator = ", ";
        result.append("(");

        Iterator<E> it = this.iterator();
        while (it.hasNext()) {
            result.append(it.next());
            result.append(seperator);
        }
        // get rid of extra separator
        if (this.size() > 0)
            result.setLength(result.length() - seperator.length());

        result.append(")");
        return result.toString();
    }
}
