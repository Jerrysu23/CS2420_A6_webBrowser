package assign06;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import assign06.SinglyLinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * A series of tests for the SinglyLinkedList class.
 * @author Luan Xing && Junlin Su
 *
 */
class SinglyLinkedListTests {
	
	private SinglyLinkedList<Integer> list, emptyList;
	private SinglyLinkedList<String> WordList;
	
	@BeforeEach
	void setUp() throws Exception{
		list = new SinglyLinkedList<Integer>();
		list.insertFirst(7);
		list.insertFirst(6);
		list.insertFirst(5);
		list.insertFirst(4);
		list.insertFirst(3);
		list.insertFirst(2);
		list.insertFirst(1);
		
		WordList = new SinglyLinkedList<String>();
		WordList.insertFirst("noodle");
		WordList.insertFirst("bread");
		WordList.insertFirst("likes:");
		WordList.insertFirst("food");
		WordList.insertFirst("of");
		WordList.insertFirst("lots");
		WordList.insertFirst("have");
		WordList.insertFirst("we");
	}
	
	
	
	@Test
	void testInsertFirst() {		
		assertEquals(1, (int)list.get(0));
		assertEquals(5, (int)list.get(4));
		assertEquals(7, (int)list.get(6));
		
		assertEquals("have", WordList.get(1));
		assertEquals("lots", WordList.get(2));
		assertEquals("of", WordList.get(3));

	}
	
	@Test
	void testInsert() {
		list.insert(7, 8);
		list.insert(8, 9);
		list.insert(9, 10);
		assertEquals(8, (int)list.get(7));
		assertEquals(9, (int)list.get(8));
		assertEquals(10, (int)list.get(9));
		
		
		WordList.insert(8, "rice");
		WordList.insert(4, "chinese");
		WordList.insert(4, "traditional");
		assertEquals("rice", WordList.get(10));
		assertEquals("traditional", WordList.get(4));
		assertEquals("chinese", WordList.get(5));
	}
	
	@Test
	void testClear() {
		list.clear();
		
		assertThrows(NoSuchElementException.class, ()->{list.getFirst();});
		assertEquals(0, list.size());
	}
	
	@Test
	void testDeleteFirst() {
		list.deleteFirst();
		assertEquals(2, (int)list.get(0));
		WordList.deleteFirst();
		assertEquals("have", (String)WordList.get(0));

	}
	
	@Test
	void testDelete() {
		assertEquals(1, (int)list.delete(0));
		assertEquals(5, (int)list.delete(3));
		WordList.delete(0);
		assertEquals("have", (String)WordList.get(0));
		assertEquals("lots", (String)WordList.get(1));
	}
	
	@Test
	void testToArray() {
		Integer[] finish = new Integer[] {1, 2, 3, 4, 5, 6, 7};
		assertArrayEquals(finish, list.toArray());
		

	}
	@Test
	void testThrows()  {
		list = new SinglyLinkedList<Integer>();
	
		assertThrows(NullPointerException.class, ()->{emptyList.deleteFirst();});
		assertThrows(NullPointerException.class, ()->{emptyList.getFirst();});
		
	}
	

}