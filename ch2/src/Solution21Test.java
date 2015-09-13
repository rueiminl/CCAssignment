

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class Solution21Test {

	@Test
	public void test() {
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(2);
		list1.add(4);
		list1.add(5);
		list1.add(2);
		list1.add(6);
		list1.add(7);
		list1.add(7);
		list1.add(6);
		LinkedList<Integer> listWithoutDups1 = new LinkedList<Integer>();
		for (Integer i = 1; i <= 7; i++)
			listWithoutDups1.add(i);
		Solution21.removeDups(list1);
		assertTrue(list1.equals(listWithoutDups1));

		LinkedList<Integer> list2 = new LinkedList<Integer>();
		list2.add(1);
		list2.add(1);
		list2.add(1);
		list2.add(1);
		list2.add(1);
		LinkedList<Integer> listWithoutDups2 = new LinkedList<Integer>();
		listWithoutDups2.add(1);
		Solution21.removeDups(list2);
		assertTrue(list2.equals(listWithoutDups2));

		LinkedList<Integer> list3 = new LinkedList<Integer>();
		LinkedList<Integer> listWithoutDups3 = new LinkedList<Integer>();
		Solution21.removeDups(list3);
		assertTrue(list3.equals(listWithoutDups3));
	}

	@Test
	public void testFollowUp() {
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(2);
		list1.add(4);
		list1.add(5);
		list1.add(2);
		list1.add(6);
		list1.add(7);
		list1.add(7);
		list1.add(6);
		LinkedList<Integer> listWithoutDups1 = new LinkedList<Integer>();
		for (Integer i = 1; i <= 7; i++)
			listWithoutDups1.add(i);
		Solution21.removeDups2(list1);
		assertTrue(list1.equals(listWithoutDups1));

		LinkedList<Integer> list2 = new LinkedList<Integer>();
		list2.add(1);
		list2.add(1);
		list2.add(1);
		list2.add(1);
		list2.add(1);
		LinkedList<Integer> listWithoutDups2 = new LinkedList<Integer>();
		listWithoutDups2.add(1);
		Solution21.removeDups2(list2);
		assertTrue(list2.equals(listWithoutDups2));

		LinkedList<Integer> list3 = new LinkedList<Integer>();
		LinkedList<Integer> listWithoutDups3 = new LinkedList<Integer>();
		Solution21.removeDups2(list3);
		assertTrue(list3.equals(listWithoutDups3));
	}
}
