package assign06;

import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 * 
 * @author Junlin Su and Luan Xing.
 * @version March 7, 2021.
 */

public class WebBrowserTester {

	/**
	 * Tester file for all of Assignment 06. To make it easier to read, things that
	 * would normally be multiple tests are now one, but still test for the same
	 * things with the same circumstances.
	 * 
	 * @author Carter Edginton & Wenlin Li
	 *
	 */

	// private variables
	SinglyLinkedList<Integer> littleList;
	SinglyLinkedList<Integer> threeList;
	SinglyLinkedList<Integer> emptyList;
	LinkedListStack<Integer> littleStack;

	@BeforeEach
	void setUp() throws Exception {
		littleList = new SinglyLinkedList<Integer>();
		littleList.insertFirst(1); // 1
		threeList = new SinglyLinkedList<Integer>();
		threeList.insertFirst(1); // 1
		threeList.insertFirst(2); // 2 1
		threeList.insertFirst(3); // 3 2 1
		emptyList = new SinglyLinkedList<Integer>();
		littleStack = new LinkedListStack<Integer>();
		littleStack.push(3);// 3
		littleStack.push(2);// 2 3
		littleStack.push(1);// 1 2 3
	}

	@Test
	void insertFirstSLL() {
		assertEquals(1, littleList.get(0));// Test that correct value inserted in correct spot
		assertEquals(1, littleList.size());// test that size is correct/updated with insertion
		assertEquals(3, threeList.size());
		assertEquals(1, threeList.get(2));// ensure items in correct spot
		assertEquals(2, threeList.get(1));
		assertEquals(3, threeList.get(0));
	}

	@Test
	void insertNormalSLL() {
		littleList.insert(1, 2);
		assertEquals(2, littleList.get(1)); // ensures can add to end without exception
	}

	@Test
	void insertNormalSLLThrows() {
		assertThrows(IndexOutOfBoundsException.class, () -> { // test for throwing with bad index
			littleList.insert(6, 6);
		});
	}

	@Test
	void getFirstSLL() {
		assertEquals(1, littleList.getFirst());// test for retrieving correct value
	}

	@Test
	void getFirstSLLThrows() {
		assertThrows(NoSuchElementException.class, () -> {// test for empty list exception
			emptyList.getFirst();
		});
	}

	@Test
	void getSLL() {
		assertEquals(1, littleList.get(0)); // test that retrieves correct value.
		assertEquals(1, threeList.get(2));
	}

	@Test
	void getSLLThrows() {
		assertThrows(IndexOutOfBoundsException.class, () -> { // ensures exception when out of bounds
			littleList.get(4);
		});
	}

	@Test
	void deleteFirstSLL() {
		assertEquals(3, threeList.deleteFirst());// test that returns correct deleted value
		assertEquals(2, threeList.size()); // test size is updated
		assertEquals(2, threeList.getFirst()); // test that new first value is correct
	}

	@Test
	void deleteFirstSLLThrows() {
		assertThrows(NoSuchElementException.class, () -> { // exception with empty list
			emptyList.deleteFirst();
		});
	}

	@Test
	void deleteSLL() {
		assertEquals(2, threeList.delete(1));// test that returns correct deleted value
		assertEquals(2, threeList.size());// test size is updated
		assertEquals(1, threeList.get(1));// test that new value is correct
	}

	@Test
	void deleteSLLThrows() {
		assertThrows(IndexOutOfBoundsException.class, () -> {// exception when bad index
			littleList.delete(3);
		});
	}

	@Test
	void indexOfSLL() {
		assertEquals(0, littleList.indexOf(1));// test that it returns correct value
	}

	@Test
	void indexOfSLLCantFind() {
		assertEquals(-1, threeList.indexOf(4));// test that it returns the "not found" value
	}

	@Test
	void sizeSLL() {
		assertEquals(1, littleList.size());// test for correct values
		assertEquals(3, threeList.size());
		assertEquals(0, emptyList.size());
	}

	@Test
	void isEmptySLL() {
		assertTrue(emptyList.isEmpty()); // test if returns false empty
		assertFalse(threeList.isEmpty());// test if returns true not empty
	}

	@Test
	void clearSLLSize() {
		threeList.clear();
		assertEquals(0, threeList.size()); // ensure change of length
	}

	@Test
	void clearSLLIsEmpty() {
		threeList.clear();
		assertTrue(threeList.isEmpty()); // ensures is empty
	}

	@Test
	void clearSLLThrows() {
		threeList.clear();
		assertThrows(IndexOutOfBoundsException.class, () -> {// value at index 0 does not exist.
			threeList.get(0);
		});
	}

	@Test
	void toArraySLLValuesCorrect() {
		Object[] arr = threeList.toArray();
		assertEquals(3, arr[0]);// all values are correct
		assertEquals(2, arr[1]);
		assertEquals(1, arr[2]);
	}

	@Test
	void toArraySLLLengthCorrect() {
		Object[] arr = threeList.toArray();
		assertEquals(3, arr.length);// array length is correct
	}

	@Test
	void iterationTest() {
		int sum = 0;
		for (Integer i : threeList) {
			sum += i;
		}
		assertEquals(6, sum);
	}

	@Test
	void iterationNextThrows() {
		Iterator<Integer> it = littleList.iterator();
		it.next();
		assertThrows(NoSuchElementException.class, () -> {
			it.next();
		});
	}

	@Test
	void iterationRemoveThrows() {
		Iterator<Integer> it = threeList.iterator();
		it.next();
		it.remove();
		assertThrows(IllegalStateException.class, () -> {
			it.remove();
		});
	}

	/*
	 * END OF SinglyLinkedList TESTS
	 * 
	 * 
	 * 
	 * START OF LinkedListStack TESTS
	 */

	@Test
	void clearStack() {
		littleStack.clear();
		assertThrows(NoSuchElementException.class, () -> {// should be empty, so peek should throw.
			littleStack.peek();
		});
		assertEquals(0, littleStack.size());// making sure that size is updated and empty.
		assertTrue(littleStack.isEmpty());
	}

	@Test
	void isEmptyStack() {
		assertFalse(littleStack.isEmpty());// test that returns false when has elements
		littleStack.clear();
		assertTrue(littleStack.isEmpty()); // test that returns true with no elements
	}

	@Test
	void peekStack() {
		assertEquals(1, littleStack.peek());// Test that peek returns correct value
		littleStack.pop();
		assertEquals(2, littleStack.peek());// Test that peek works for different value.
	}

	@Test
	void popStack() {
		assertEquals(1, littleStack.pop());// test for returns a value when popping
		assertEquals(2, littleStack.size());// test for changes size

	}

	@Test
	void WebBrowserTest() throws MalformedURLException {
		URL link = new URL("https://a");
		assertEquals("https://a", link.toString()); // true
		assertNotEquals("https://b", link.toString()); // false
		assertNotEquals(new URL("https://b"), link); // unexpectedly true
	}

	@Test
	void WebBrowserBackTest() throws MalformedURLException {
		URL link1 = new URL("https://a");
		URL link2 = new URL("https://b");
		WebBrowser history = new WebBrowser();
		history.visit(link1);
		history.visit(link2);
		assertEquals("https://a", history.back().toString()); // true

	}

	@Test
	void WebBrowserForwardTest() throws MalformedURLException {
		URL link1 = new URL("https://a");
		URL link2 = new URL("https://b");
		WebBrowser history = new WebBrowser();
		history.visit(link1);
		history.visit(link2);
		history.back();
		assertEquals("https://b", history.forward().toString()); // true
	}

	@Test
	void WebBrowserForwardTest2() throws MalformedURLException {
		URL link1 = new URL("https://a");
		URL link2 = new URL("https://b");
		URL link3 = new URL("https://c");
		WebBrowser history = new WebBrowser();
		history.visit(link1);
		history.visit(link2);
		history.visit(link3);
		history.back();
		assertEquals("https://c", history.forward().toString()); // true
	}

	@Test
	void WebBrowserBackTest2() throws MalformedURLException {
		URL link1 = new URL("https://a");
		URL link2 = new URL("https://b");
		URL link3 = new URL("https://c");
		WebBrowser history = new WebBrowser();
		history.visit(link1);
		history.visit(link2);
		history.visit(link3);
		history.back();
		assertEquals("https://a", history.back().toString()); // true
	}

	@Test
	void WebBrowserForwardTest3() throws MalformedURLException {
		URL link1 = new URL("https://a");
		URL link2 = new URL("https://b");
		URL link3 = new URL("https://c");
		URL link4 = new URL("https://d");

		WebBrowser history = new WebBrowser();
		history.visit(link1);
		history.visit(link2);
		history.visit(link3);
		history.visit(link4);
		history.back();
		history.back();
		assertEquals("https://c", history.forward().toString()); // true
	}

	@Test
	void webBrowserCreateList() throws MalformedURLException {
		SinglyLinkedList<URL> list = new SinglyLinkedList<URL>();
		URL link1 = new URL("https://a");
		URL link2 = new URL("https://b");
		URL link3 = new URL("https://c");
		list.insertFirst(link1);// visit a
		list.insertFirst(link2);// visit b hist a
		list.insertFirst(link3);// visit c hist b a
		WebBrowser browser = new WebBrowser(list);
		assertEquals("https://b", browser.back().toString());
		assertEquals("https://a", browser.back().toString());

	}
}
