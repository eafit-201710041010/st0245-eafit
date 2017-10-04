import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LinkedListMauricioTest {
	@Test
	public void testInsert() {
		LinkedListMauricio list = new LinkedListMauricio();
		list.insert(2, 0);
		list.insert(1, 0);
		list.insert(3, 2);
		
		assertEquals(list.get(0),1);
		assertEquals(list.get(1),2);
		assertEquals(list.get(2),3);
	}

	@Test (expected = Exception.class) 
	public void testRemove() {
		LinkedListMauricio list = new LinkedListMauricio();
		//Borrar vacio
		list.remove(0);
		list.insert(5, 0);
		list.insert(4, 0);
		list.insert(3, 0);
		list.insert(2, 0);
		list.insert(1, 0);
		//Borrar primero
		assertTrue(list.contains(1));
		list.remove(0);
		assertFalse(list.contains(1));
		//Borrar ultimo
		assertTrue(list.contains(5));
		list.remove(3);
		assertFalse(list.contains(5));
	}

	@Test
	public void testContains() {
		LinkedListMauricio list = new LinkedListMauricio();
		list.insert(5, 0);
		list.insert(4, 0);
		list.insert(3, 0);
		list.insert(2, 0);
		list.insert(1, 0);
		assertTrue(list.contains(3));
		assertFalse(list.contains(10));
	}

}