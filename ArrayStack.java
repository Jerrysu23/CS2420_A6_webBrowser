package assign06;

import java.util.NoSuchElementException;

/** 
 * Representation of a stack data structure (backed by a basic array).
 * 
 * @author Erin Parker
 * @version March 3, 2021
 *
 * @param <E> - the type of elements contained in the stack
 */
public class ArrayStack<E> implements Stack<E> {
	
	private E[] stack;
	private int top;
	
	@SuppressWarnings("unchecked")
	public ArrayStack() {
		stack = (E[])new Object[100]; 
		top = -1;
	}

	public void clear() {
		top = -1;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public E peek() throws NoSuchElementException {
		if(top == -1)
			throw new NoSuchElementException();
		return stack[top];
	}

	public E pop() throws NoSuchElementException {
		if(top == -1)
			throw new NoSuchElementException();

		return stack[top--];    
	}

	@SuppressWarnings("unchecked")
	public void push(E element) {
		// expand the backing array, as needed
		if(top + 1 == stack.length) {
			Object[] temp = new Object[stack.length * 2];
			for(int i = 0; i < stack.length; i++)
				temp[i] = stack[i];
			stack = (E[])temp;  
		}
		
		stack[++top] = element;
	}

	public int size() {
		return top + 1;
	}
}