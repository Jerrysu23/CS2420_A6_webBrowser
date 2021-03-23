package assign06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 * Here are some test for LinkedListStack class
 * @author Luan Xing&& Junlin Su
 *
 */

class LinkedListStackTest {
	
	LinkedListStack<Integer> temp = new LinkedListStack<>();

	@Test
	void testClear() {
		temp.push(1);
		temp.push(1);
		temp.push(1);
		temp.push(1);
		temp.push(1);
		temp.push(1);
		assertEquals(6, temp.size());
		temp.clear();
		assertEquals(0, temp.size());
		
		
	}
	@Test
	void testIsEmpty() {
		assertTrue(temp.isEmpty());
	}
	
	@Test
	void testPeek() {
		temp.push(1);
		temp.push(2);
		temp.push(4);
		temp.push(8);
		temp.push(16);
		assertEquals(16, (int) temp.peek());
	}
	
	@Test
	void testPop() {
		temp.push(1);
		temp.push(2);
		temp.push(4);
		temp.push(8);
		temp.push(16);
		assertEquals(16, (int) temp.pop());
		assertEquals(8, (int) temp.peek());
	}
}
