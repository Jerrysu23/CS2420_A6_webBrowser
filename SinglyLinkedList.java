package assign06;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class implements the List interface with a singly-linked list.
 * 
 * @author Junlin Su and Luan Xing.
 * @version March 7, 2021.
 * 
 * @param <E>
 */
public class SinglyLinkedList<E> implements List<E> {
	/**
	 * A private class is used to represent  some node variables
	 */
	private class Node {
		public E data;
		public Node next;

		public Node(E data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node first;// first node of the list
	private int size;//  the size of the list


	public SinglyLinkedList() {
		this.first = null;
		this.size = 0;
	}

	/**
	 * Inserts an element at the beginning of the list.
	 * O(1) for a singly-linked list.
	 * 
	 * @param element - the element to add
	 */
	@Override
	public void insertFirst(E element) {
		first = new Node(element, first);
		size++;
	}

	/**
	 * Inserts an element at a specific position in the list.
	 * O(N) for a singly-linked list.
	 * 
	 * @param index - the specified position
	 * @param element - the element to add
	 * @throws IndexOutOfBoundsException if index is out of range (index < 0 || index > size())
	 */
	@Override
	public void insert(int index, E element) throws IndexOutOfBoundsException {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException();
		if (index == 0)
			insertFirst(element);
		else {
			Node prevNode = first;
			for (int i = 0; i < index - 1; i++) {
				prevNode = prevNode.next;
			}
			prevNode.next = new Node(element, prevNode.next);
			size++;
		}
	}

	/**
	 * Gets the first element in the list.
	 * O(1) for a singly-linked list.
	 * 
	 * @return the first element in the list
	 * @throws NoSuchElementException if the list is empty
	 */
	@Override
	public E getFirst() throws NoSuchElementException {
		if (this.size == 0) {
			throw new NoSuchElementException();
		}
		return first.data;
	}

	/**
	 * Gets the element at a specific position in the list.
	 * O(N) for a singly-linked list.
	 * 
	 * @param index - the specified position
	 * @return the element at the position
	 * @throws IndexOutOfBoundsException if index is out of range (index < 0 || index >= size())
	 */
	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		Node currentNode = first;
		for (int i = 0; i < index; i++) {
			currentNode = currentNode.next;
		}
		return currentNode.data;
	}

	/**
	 * Deletes and returns the first element from the list.
	 * O(1) for a singly-linked list.
	 * 
	 * @return the first element
	 * @throws NoSuchElementException if the list is empty
	 */
	@Override
	public E deleteFirst() throws NoSuchElementException {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		E removed = first.data;
		first = first.next;
		size--;
		return removed;
	}

	/**
	 * Deletes and returns the element at a specific position in the list.
	 * O(N) for a singly-linked list.
	 * 
	 * @param index - the specified position
	 * @return the element at the position
	 * @throws IndexOutOfBoundsException if index is out of range (index < 0 || index >= size())
	 */
	@Override
	public E delete(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		if(index == 0) {
			Node prevHead = first;
			first = first.next;
			return prevHead.data;
		}
		Node prevNode = first;
		Node deleted;
		for (int i = 0; i < index - 1; i++) {
			prevNode = prevNode.next;
		}
		deleted = prevNode.next;
		prevNode.next = deleted.next;
		size--;
		return deleted.data;
		
	}

	/**
	 * Determines the index of the first occurrence of the specified element in the list, 
	 * or -1 if this list does not contain the element.
	 * O(N) for a singly-linked list.
	 * 
	 * @param element - the element to search for
	 * @return the index of the first occurrence; -1 if the element is not found
	 */
	@Override
	public int indexOf(E element) {
		Node temp = first;
		int index = 0;
		while (temp.data != null) {
			if (temp.data.equals(element)) {
				return index;
			}
			index++;
			temp = temp.next;
		}
		return -1;
	}

	/**
	 * O(1) for a singly-linked list.
	 * 
	 * @return the number of elements in this list
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * O(1) for a singly-linked list.
	 * 
	 * @return true if this collection contains no elements; false, otherwise
	 */
	@Override
	public boolean isEmpty() {
		if(size==0)
			return true;
		else 
			return false;
	}

	/**
	 * Removes all of the elements from this list.
	 * O(1) for a singly-linked list.
	 */
	@Override
	public void clear() {
		first = null;
		size = 0;
	}

	/**
	 * Generates an array containing all of the elements in this list in proper sequence 
	 * (from first element to last element).
	 * O(N) for a singly-linked list.
	 * 
	 * @return an array containing all of the elements in this list, in order
	 */
	@Override
	public Object[] toArray() {
		Object[] array = new Object[size];
		Node temp = first;
		for (int i = 0; i < size; i++) {
			array[i] = temp.data;
			temp = temp.next;
		}
		return array;
	}

	/**
	 * @return an iterator over the elements in this list in proper sequence (from first 
	 * element to last element)
	 */
	@Override
	public Iterator<E> iterator() {
		return new SinglyLinkedListIterator();
	}

/**
 * 
 * Here are the methods for the iterator requirements: hasNext, next, and remove.
 *
 */
	private class SinglyLinkedListIterator implements Iterator<E> {

		private  Node current = first;
		private  Node lastNode;
		private  boolean state = false;
		private int nextIndex;
		
		@Override
		public boolean hasNext() {
			return current!= null;
		}
		
		@Override
		public E next() throws IllegalStateException{
			if(!hasNext()) {
				throw new IllegalStateException();
			}
			lastNode =current;
			current=current.next;
			state = true;
			return lastNode.data;
		}
		
		@Override
		public void remove() throws IllegalStateException{
			if(state == false) 
				throw new IllegalStateException();
				nextIndex--;
				current =current.next;
				state =false;
			}
		}

}

