import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.*;
import java.lang.*;

/**
 * JUnit Tests for Chapter 14
 */
@SuppressWarnings("deprecation")
public class Ch14Test {
	public static void main (String[] args) {
		}
	/**
	 * Base Stacks and Queues
	 */
	static Queue<Integer> emptyQueue, singleQueue, palindrome, notPalindrome;
	static Stack<Integer> emptyStack, singleStack, sortedStack, notSortedStack, 
						equalStack, minStack, minRemovedStack, minRemovedStack2;
	/**
	 * Reset the base data structures just in case
	 */
	@BeforeEach 
	void reset(){
		emptyQueue = new LinkedList<Integer>();
		singleQueue = new LinkedList<Integer>(List.of(1));
		palindrome = new LinkedList<Integer>(List.of(3, 8, 17, 9, 17, 8, 3));
		notPalindrome = new LinkedList<Integer>(List.of(3, 17, 9, 4, 17, 3));
		
		emptyStack = new Stack<Integer>();
		singleStack = new Stack<Integer>();singleStack.push(1);
		sortedStack = new Stack<Integer>();
		equalStack = new Stack<Integer>();
		notSortedStack = new Stack<Integer>();notSortedStack.push(1);
		List<Integer> sortedList = List.of(20, 20, 17, 11, 8, 8, 3, 2);
		for(int i: sortedList){
			sortedStack.push(i);notSortedStack.push(i);equalStack.push(i);
		}
		
		List<Integer> minList = List.of(2, 8, 3, 19, 2, 3, 2, 7, 12, -8, 4);
		minStack = new Stack<Integer>();
		minRemovedStack = new Stack<Integer>();
		minRemovedStack2 = new Stack<Integer>();
		for(int i: minList){
			minStack.push(i);minRemovedStack.push(i);minRemovedStack2.push(i);
			if(i == -8){
				minRemovedStack.pop();
				minRemovedStack2.pop();
			} else if(i == 2){
				minRemovedStack2.pop();
			}
		}		
		return;
	}
	
	/**
	 * Tests 14.5 equals
	 */
	@Test 
	public void testEquals(){
		assertTrue(equals(sortedStack, equalStack), "sorted == equal");
		assertFalse(equals(sortedStack, minStack), "sorted != min");
		assertEquals(sortedStack, equalStack, "sorted == equal again, ensure nothing changed");//ensure sorted is "unchanged"
		assertFalse(equals(emptyStack, singleStack), "empty != single");
		assertFalse(equals(null, emptyStack), "null != single");
		assertTrue(equals(null,null), "null == null");
	}
	
	/**
	 * Tests 14.8 isPalindrome
	 */
	@Test 
	public void testIsPalindrome(){
		assertTrue(isPalindrome(emptyQueue), "empty is palindrom");
		assertTrue(isPalindrome(palindrome), "palindrome is palindrom");
		assertTrue(isPalindrome(palindrome), "palindrome is palindrom again");//ensure palindrome is "unchanged"
		assertNotEquals(emptyQueue, palindrome, "empty != palindrome");
		assertTrue(isPalindrome(singleQueue), "single is palindrome");
		assertFalse(isPalindrome(notPalindrome), "not palindrome is not palindrome");
		assertThrows(IllegalArgumentException.class, ()->{isPalindrome(null);}, "null is invalid input");
	}
	
	/**
	 * Tests 14.15 isSorted
	 */
	@Test 
	public void testIsSorted(){
		assertTrue(isSorted(sortedStack), "sorted is sorted");
		assertEquals(sortedStack, equalStack, "sorted should not have been changed");//ensure sortedStack is "unchanged"
		assertFalse(isSorted(notSortedStack), "not sorted is not sorted");
		assertTrue(isSorted(emptyStack),"empty is sorted");
		assertTrue(isSorted(singleStack), "single is sorted");
		assertThrows(IllegalArgumentException.class, ()->{isSorted(null);}, "null is invalid input");
	}
	
	/**
	 * Tests 14.19 removeMin
	 */
	@Test 
	public void testRemoveMin(){
		assertEquals(-8, removeMin(minStack), "should have removed -8");
		assertEquals(minStack, minRemovedStack, "min == minRemoved");
		assertEquals(2, removeMin(minStack), "should have removed 2");
		assertEquals(minStack, minRemovedStack2, "min == minRemoved2");
		assertThrows(IllegalArgumentException.class, ()->{removeMin(null);}, "null is invalid input");
		assertThrows(IllegalArgumentException.class, ()->{removeMin(emptyStack);}, "empty is invalid input");
	}

	/**
	 * Checks if two stacks of Integers have the same sequence of Integers.
	 * 
	 * You can use one stack as auxillary storage. Both stacks should look 
	 * as they did before the method was called.
	 * 
	 * @param s1 The first stack
	 * @param s2 The second stack
	 * @return true if the stacks have the same sequence
	 */
	public static boolean equals(Stack<Integer> s1, Stack<Integer> s2){
		if (s1 == null || s2 == null){
			return true;
		}
		if (s1.isEmpty() && s2.isEmpty()){
			return true;
		}
		Stack<Integer> temp1 = new Stack<Integer>();
		temp1.addAll(s1);
		Stack<Integer> temp2 = new Stack<Integer>();
		temp2.addAll(s2);
		
		do {
			if(temp1.pop() != temp2.pop()){
				return false;
			}
		}while(temp1.isEmpty() || temp2.isEmpty());
		if(temp1.pop() != temp2.pop()){
				return false;
		}
		return true;
	}
	
	/**
	 * Checks if a queue of Integers has the same sequence forwards and backwards.
	 * 
	 * Use one stack as auxilary storage. The queue needs to look as 
	 * it did prior to this function call after it returns.
	 * 
	 * @param q The candidate palindrome
	 * @return true if the queue is a palindrome
	 * @throws IllegalArgumentException if the queue is null
	 */
	public static boolean isPalindrome(Queue<Integer> queue){
		if (queue == null) throw new IllegalArgumentException();
		Queue<Integer> temp = new LinkedList<>();
		temp.addAll(queue);
		Stack<Integer> stack = new Stack<Integer>(); 
		while (!queue.isEmpty()) { 
            stack.push(queue.remove()); 
        }
        queue = temp;
        while (!queue.isEmpty()) { 
            if(stack.pop() != queue.remove()){
				return false;
			}
        }
        return true;
	}
	/**
	 * Checks if a stack of Integers is sorted
	 * 
	 * Use one queue or stack, but not both, as auxilary storage. 
	 * The stack needs to look as it did prior to this function call after it returns.
	 * 
	 * @param s The candidate sorted stack
	 * @return true if the stack is sorted
	 * @throws IllegalArgumentException if the stack is null
	 */
	public static boolean isSorted(Stack<Integer> stack1){
		if (stack1 == null) throw new IllegalArgumentException();
		Stack<Integer> temp = new Stack<Integer>(); 
		temp.addAll(stack1);
		int temp2 = Integer.MIN_VALUE;
		//System.out.println(temp);
		while(!temp.isEmpty()) { 
			if(temp2 > temp.peek()){
				return false;
			}
			temp2 = temp.pop();
        }
	return true;
	}
	
	/**
	 * Removes the minimum value from a stack.
	 * 
	 * Use one queue as auxilary storage. 
	 * The stack needs to maintain relative ordering sans min(s).
	 * 
	 * @param s The stack to have elements removed
	 * @return the smallest element in the stack
	 * @throws IllegalArgumentException if the stack is null or empty
	 */
	public static int removeMin(Stack<Integer> stack1){
		if (stack1 == null) throw new IllegalArgumentException();
		Stack<Integer> temp = new Stack<Integer>(); 
		temp.addAll(stack1);
		int temp2 = Integer.MAX_VALUE;
		int temp3 = temp.pop();
		//System.out.println(temp);
		while(!temp.isEmpty()) { 
			if(temp2 > temp3){
				temp2 = temp3;
			}
			temp3 = temp.pop();
        }
        return temp2;
	}
}
