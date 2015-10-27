/*  Student information for assignment:
 *
 *  On my honor, Anna Mengjie Yu, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  Name: Anna Mengjie Yu
 *  email address: annayu2010@gmail.com
 *  UTEID: my3852
 *  Section 5 digit ID: 90130
 *  Grader name: Erik
 *  Number of slip days used on this assignment: 0
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements IList<E> {
	// CS314 student. Add you instance variables here.
	// You decide what instance variables to use. 
	private int size;
	private DoubleListNode<E> first;
	private DoubleListNode<E> last;
	
	// Must adhere to assignment requirements. No ArrayLists or Java LinkedLists.

	private class LLIterator implements Iterator<E>{
		/**
		 * return an Iterator for this list.
		 * <br>pre: none
		 * <br>post: return an Iterator object for this List
		 */
		private int indexToRemove;
		private DoubleListNode<E> nodeWithNextData ;
		private boolean removeOk;
		
		private LLIterator() {
            nodeWithNextData = first;
            removeOk = false;
            indexToRemove = -1;
        }
		
		public boolean hasNext()
		{ return nodeWithNextData!= null; }

		public E next()
		{ if (!this.hasNext())
			throw new NoSuchElementException("There is no such element.");
		E data = nodeWithNextData.getData();
		nodeWithNextData = nodeWithNextData.getNext();
		removeOk = true;
		indexToRemove ++;
		return data;
		}

		public void remove()
		{
			removeOk = false;
			LinkedList.this.remove(indexToRemove);
			indexToRemove--;
		}
	}

	
	public void add(E item){
		/**
		 * Add an item to the end of this list.
		 * <br>pre: item != null
		 * <br>post: size() = old size() + 1, get(size() - 1) = item
		 * @param item the data to be added to the end of this list
		 * O(1)
		 */
		if (item == null)
			throw new IllegalArgumentException("Item should not be null.");
		else
		{
			DoubleListNode<E> newLast = new DoubleListNode<E>(null, item, null);
			if (size == 0) {
				first = newLast;
			} else {
				newLast.setPrev(last);
				last.setNext(newLast);
			}
			last = newLast;
			this.size++;
		}		
	}


	
	public void insert(int pos, E item){
		/**
		 * Insert an item at a specified position in the list.
		 * <br>pre: 0 <= pos <= size(), item != null
		 * <br>post: size() = old size() + 1, get(pos) = item, all elements in
		 * the list with a positon >= pos have a position = old position + 1
		 * @param pos the position to insert the data at in the list
		 * @param item the data to add to the list
		 * O(n)
		 */
		if ( pos < 0 || pos > size || item == null)
			throw new IllegalArgumentException("input is invalid.");
		else if( pos == size)
		{
			this.add(item);
		}
		else if (pos == 0)
		{
			DoubleListNode<E> newFirst = new DoubleListNode<E>(null, item, first);
			first.setPrev(newFirst);
			first = newFirst;
			size++;
		}
		else
		{
			DoubleListNode<E> temp = first;
			for (int i = 0; i < pos-1; i++)
				temp = temp.getNext();
			DoubleListNode<E> beforeItem = temp;
			DoubleListNode<E> afterItem = temp.getNext();
			DoubleListNode<E> insertItem = new DoubleListNode<E>(beforeItem, item, afterItem);
			beforeItem.setNext(insertItem);
			afterItem.setPrev(insertItem);
			this.size++;			
		}

	}


	//*****failed 2 tests in set( ) function
	public E set(int pos, E item){
		/**
		 * Change the data at the specified position in the list.
		 * the old data at that position is returned.
		 * <br>pre: 0 <= pos < size(), item != null
		 * <br>post: get(pos) = item, return the
		 * old get(pos)
		 * @param pos the position in the list to overwrite  
		 * @param item the new item that will overwrite the old item
		 * @return the old data at the specified position
		 * o(n)
		 * -2 not return the correct old data
		 */
		if (pos < 0 || pos >= size || item == null)
			throw new IllegalArgumentException("pos is not a valid input or "
					+ "item should not be null.");
		else
		{
			E oldData = null;
			
			if( pos == (size-1))
			{
				oldData = last.getData();
				last.setData(item);
				//return last.getData();
			}

			else if (pos == 0)
			{
				oldData = first.getData();
				first.setData(item);
				//return first.getData();
			}		
			else
			{   
				DoubleListNode<E> temp = first;
				for (int i = 0; i < pos ; i++)
				{
					temp = temp.getNext();
				}
				 oldData = temp.getData();
				temp.setData(item);
				//return oldData;
			}
			
			return oldData;
		}
		
	}


	
	public E get(int pos){
		// TODO Auto-generated method stub
		/**
		 * Get an element from the list.
		 * <br>pre: 0 <= pos < size()
		 * <br>post: return the item at pos
		 * @param pos specifies which element to get
		 * @return the element at the specified position in the list
		 * O(n)
		 */
		if (pos < 0 || pos >= size)
			throw new IllegalArgumentException("pos is invalid.");
		else
		{
			DoubleListNode<E> temp = first;
			for (int i = 0; i < pos; i++)
			{
				temp = temp.getNext();
			}	
			
			return temp.getData();			
		}
	}


	public E remove(int pos){
		// TODO Auto-generated method stub
		/**
		 * Remove an element in the list based on position.
		 * <br>pre: 0 <= pos < size()
		 * <br>post: size() = old size() - 1, all elements of
		 * list with a positon > pos have a position = old position - 1
		 * @param pos the position of the element to remove from the list
		 * @return the data at position pos
		 * o(n)
		 */
		if (pos < 0 || pos >= size)
			throw new IllegalArgumentException("Input is not a valid integer.");
		else if (size == 1)
		{
			E data = first.getData();
			first = last = null;
			size = 0;
			return data;
		}
		else if (pos == 0)
		{
			E data = first.getData();
			first = first.getNext();
			first.setPrev(null);
			size--;
			return data;
		}
		else if (pos == size -1)
		{
			DoubleListNode<E> temp = first;
			for (int i = 0; i < pos -1; i++)
			{
				temp = temp.getNext();
			}			
			E data = temp.getNext().getData();
			last = temp;
			temp.setNext(null);
			size--;			
			return data;
		}
		else 
		{
			DoubleListNode<E> temp = first;
			for (int i = 0; i < pos-1; i++)
			{
				temp = temp.getNext();
			}			
			DoubleListNode<E> beforePos = temp;
			E posData = temp.getNext().getData();
			DoubleListNode<E> afterPos = temp.getNext().getNext();
			beforePos.setNext(afterPos);
			afterPos.setPrev(beforePos);
			this.size--;
			return posData;
		}

	}


	//***** 2 points off due to not O(1)
	public boolean remove(E obj){
		// TODO Auto-generated method stub
		/**
		 * Remove the first occurrence of obj in this list.
		 * Return <tt>true</tt> if this list changed as a result of this call, <tt>false</tt> otherwise.
		 * <br>pre: obj != null
		 * <br>post: if obj is in this list the first occurrence has been removed and size() = old size() - 1. 
		 * If obj is not present the list is not altered in any way.
		 * @param obj The item to remove from this list.
		 * @return Return <tt>true</tt> if this list changed as a result of this call, <tt>false</tt> otherwise.
		 * O(n)
		 */
		if (obj == null)
			throw new IllegalArgumentException("obj should not be null");
		else
		{
			boolean changed = false;
			DoubleListNode<E> temp = first;
			int index = 0;
			while ( temp != null && !changed)
			{
				if (temp.getData().equals(obj) )
				{	
					this.remove(index);
					changed = true;
				}
				else
				{
					temp = temp.getNext();
					index++;
				}
			}
			return changed;			
		}
	}


	
	public IList<E> getSubList(int start, int stop){
		// TODO Auto-generated method stub
		/**
		 * Return a sublist of elements in this list from <tt>start</tt> inclusive to <tt>stop</tt> exclusive.
		 * This list is not changed as a result of this call.
		 * <br>pre: <tt>0 <= start < size(), start <= stop <= size()</tt>
		 * <br>post: return a list whose size is stop - start and contains the elements at positions start through stop - 1 in this list.
		 * @param start index of the first element of the sublist.
		 * @param stop stop - 1 is the index of the last element of the sublist.
		 * @return a list with <tt>stop - start</tt> elements, The elements are from positions <tt>start</tt> inclusive to
		 * <tt>stop</tt> exclusive in this list.
		 * O(n)
		 */
		if (start < 0 || start > size || stop < start || stop > size)
			throw new IllegalArgumentException("Input start and stop not valid");
		else
		{
			//initialize a doubleLinkedList
			LinkedList<E> subList = new LinkedList<E>();
			
			//get node from start+1 to stop
			for (int i = start ; i <= stop-1; i++)
			{
				E data = this.get(i);
				subList.add(data);
			}
			return subList;	
		}		
	}


	
	public int size(){
		// TODO Auto-generated method stub
		/**
		 * Return the size of this list. In other words the number of elements in this list.
		 * <br>pre: none
		 * <br>post: return the number of items in this list
		 * @return the number of items in this list
		 * O(1)
		 */
		return size;
	}


	
	public int indexOf(E item){
		// TODO Auto-generated method stub
		/**
		 * Find the position of an element in the list.
		 * <br>pre: item != null
		 * <br>post: return the index of the first element equal to item
		 * or -1 if item is not present
		 * @param item the element to search for in the list
		 * @return return the index of the first element equal to item or a -1 if item is not present
		 * O(n)
		 */
		if (item == null)
			throw new IllegalArgumentException();
		else
		{
			int indexOfNotFound = -1;
			int index = 0;
			DoubleListNode<E> temp = first;
			while (temp != null)
			{
				if(item.equals(temp.getData()))
					return index;
				else
				{
					temp = temp.getNext();
					index++;
				}
			}
			return indexOfNotFound;
		}
		
	}


	
	public int indexOf(E item, int pos){
		// TODO Auto-generated method stub

		/**
		 * find the position of an element in the list starting at a specified position.
		 * <br>pre: 0 <= pos < size(), item != null
		 * <br>post: return the index of the first element equal to item starting at pos
		 * or -1 if item is not present from position pos onward
		 * @param item the element to search for in the list
		 * @param pos the position in the list to start searching from
		 * @return starting from the specified position return the index of the first element
		 *  equal to item or a -1 if item is not present between pos and the end of the list
		 *  o(n)
		 */
		if ( pos < 0 || pos >= size || item == null)
			throw new IllegalArgumentException("Input is invalid.");
		else
		{
			int index = this.indexOf(item);
			//if the first occurrence is at position >= pos
			if (index >= pos)
				return index;
			//find the 2nd element if it exists
			else
			{
				DoubleListNode<E> temp = first;
				int indexOfNotFound = -1;
				int nextIndex = 0;
				while (temp != null)
				{
					if (item.equals(temp.getData()) && nextIndex >= pos)
						return nextIndex;
					else
					{
						temp = temp.getNext();
						nextIndex++;
					}							
				}
				return indexOfNotFound;
			}		
		}
	}


	
	public void makeEmpty(){
		// TODO Auto-generated method stub
		/**
		 * return the list to an empty state.
		 * <br>pre: none
		 * <br>post: size() = 0
		 * O(n)
		 */
		DoubleListNode<E> temp = first;
		while (temp != null)
		{
			DoubleListNode<E> trailer = temp;
			temp = temp.getNext();
			trailer.setData(null);
			trailer.setNext(null);
 		}
		
		first = last = null;
		size = 0;
	}


	public Iterator<E> iterator(){
		// TODO Auto-generated method stub
		//O(1)
		return new LLIterator();
	}


	
	public void removeRange(int start, int stop){
		/**
		 * Remove all elements in this list from <tt>start</tt> inclusive to <tt>stop</tt> exclusive.
		 * <br>pre: <tt>0 <= start < size(), start <= stop <= size()</tt>
		 * <br>post: <tt>size() = old size() - (stop - start)</tt>
		 * @param start position at beginning of range of elements to be removed
		 * @param stop stop - 1 is the position at the end of the range of elements to be removed
		 * O(n)
		 */
		if (start < 0 || start > size || start > stop || stop > size)
			throw new IllegalArgumentException("Invalid start and stop integer!");
		else
		{
			int indexShift = 0;
			for (int i = start; i <= stop-1; i++)
			{
				this.remove(i-indexShift);
				indexShift++;				
			}
		}

	}


	
	public void addFirst(E item){
		/**
		 * add item to the front of the list.
		 * <br>pre: item != null
		 * <br>post: size() = old size() + 1, get(0) = item
		 * @param item the data to add to the front of this list
		 * O(1)
		 */
		this.insert(0, item);

	}



	
	public void addLast(E item){
		/**
		 * add item to the end of the list.
		 * <br>pre: item != null
		 * <br>post: size() = old size() + 1, get(size() -1) = item
		 * @param item the data to add to the end of this list
		 * O(1)
		 */
		this.add(item);

	}



	
	public E removeFirst(){	
		/**
		 * remove and return the first element of this list.
		 * <br>pre: size() > 0
		 * <br>post: size() = old size() - 1
		 * @return the old first element of this list
		 * O(1)
		 */
		E firstItem = first.getData();
		this.remove(0);
		return firstItem;
	}


	/**
	 * remove and return the last element of this list.
	 * <br>pre: size() > 0
	 * <br>post: size() = old size() - 1
	 * @return the old last element of this list
	 */
	
	public E removeLast(){	
		/**
		 * remove and return the last element of this list.
		 * <br>pre: size() > 0
		 * <br>post: size() = old size() - 1
		 * @return the old last element of this list
		 * O(1)
		 */
		E lastItem = last.getData();
		this.remove(size-1);
		return lastItem;
	}


	
	public String toString(){
		//O(n)
		if(size == 0)
			return "[]";
		DoubleListNode<E> temp = first;
		final int ELEMENTS_WITHOUT_COMMAS = size - 1;
		StringBuilder sb = new StringBuilder("[");
		for(int i = 0; i < ELEMENTS_WITHOUT_COMMAS; i++) {
			sb.append(temp.getData().toString());
			sb.append(", ");
			temp = temp.getNext();
		}
		// add last element without comma and space
		sb.append(temp.getData().toString());
		sb.append("]");
		return sb.toString();
	}

	/**
	 * Check if this list is equal to another Object.
	 * Follow the contract of IList
	 * <br>pre: none
	 * @return true if other is a non null IList object
	 * with the same elements as this LinkedList in the same
	 * order.
	 * O(n)
	 */
	
	public boolean equals(Object other){
		boolean result = other instanceof LinkedList;
		if (result && this != other)
		{
			//****** 1 point off due to not using wild card
			LinkedList<?> otherList = (LinkedList<?>) other;
			result = size == otherList.size;
			if(result)
			{
				DoubleListNode<E> tempInThis = first;
				DoubleListNode<?> tempOfOther = otherList.first;
				while (result && tempInThis != null)
				{
					result = tempInThis.getData()
							.equals(tempOfOther.getData());
					tempInThis = tempInThis.getNext();
					tempOfOther = tempOfOther.getNext();
				}
			}
		}		
		return result;
	}


}