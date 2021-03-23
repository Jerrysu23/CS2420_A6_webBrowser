package assign06;

import java.util.NoSuchElementException;

/**
 * This class implements the Stack interface. It represents a generic stack.
 * 
 * @author Junlin Su and Luan Xing.
 * @version March 7, 2021.
 * 
 * @param <E> - the type of elements contained in the stack
 */

public class LinkedListStack<E> implements Stack<E> {

	private SinglyLinkedList<E> linkedListStack;
	
	/**
	 * Create a new LinkedListStack
	 */
	public LinkedListStack() {
		linkedListStack = new SinglyLinkedList<>();
	}

	/**
	 * Removes all of the elements from the stack.
	 */
	@Override
	public void clear() {
		linkedListStack.clear();
	}

	/**
	 * @return true if the stack contains no elements; false, otherwise.
	 */
	@Override
	public boolean isEmpty() {
		return linkedListStack.isEmpty();
	}

	/**
	 * Returns, but does not remove, the element at the top of the stack.
	 * 
	 * @return the element at the top of the stack
	 * @throws NoSuchElementException if the stack is empty
	 */
	@Override
	public E peek() throws NoSuchElementException {
		return linkedListStack.getFirst();
	}

	/**
	 * Returns and removes the item at the top of the stack.
	 * 
	 * @return the element at the top of the stack
	 * @throws NoSuchElementException if the stack is empty
	 */
	@Override
	public E pop() throws NoSuchElementException {
		return linkedListStack.deleteFirst();
	}

	/**
	 * Adds a given element to the stack, putting it at the top of the stack.
	 * 
	 * @param element - the element to be added
	 */
	@Override
	public void push(E element) {
		linkedListStack.insertFirst(element);
	}

	/**
	 * @return the number of elements in the stack
	 */
	@Override
	public int size() {
		return linkedListStack.size();
	}

}
