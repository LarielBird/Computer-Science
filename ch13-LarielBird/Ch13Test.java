import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.*;
import java.lang.*;
/**
 * JUnit Test class for Searching and Sorting
 */
public class Ch13Test {
	/**
	 * Base lists
	 */
	static List<Integer> sorted, reverse, empty, single; 
	
	/**
	 * Reset the base lists just in case
	 */
	@BeforeEach 
	void reset(){
		sorted = new ArrayList<>(Arrays.asList(9001,9002,9003,9004,9005));
		reverse = new ArrayList<>(Arrays.asList(9005,9004,9003,9002,9001));
		empty = new ArrayList<>();
		single = new ArrayList<>(Arrays.asList(9003));
	}
	
	/**
	 * Tests iterative binary search using sorted list
	 */
	@Test 
	public void testItrBinary() throws IllegalArgumentException{
		assertTrue(itrBinary(sorted, 9003), "contained this value");
		assertFalse(itrBinary(sorted, -1), "did not contain this value");
		assertThrows(IllegalArgumentException.class, ()->{itrBinary(null, 3);}, "null is not a valid parameter");
	}
	
	/**
	 * Tests descending bubble using the base lists
	 */
	@Test 
	public void testDescendBubble() throws IllegalArgumentException{
		assertEquals(empty, descendBubble(empty), "empty list should not break things");
		assertEquals(single, descendBubble(single), "single list should not break things");
		assertEquals(reverse, descendBubble(reverse), "reverse list should still be reversed");
		assertEquals(reverse, descendBubble(sorted), "sorted should not break things");
		assertThrows(IllegalArgumentException.class, ()->{descendBubble(null);}, "null is not a valid parameter");
	}
	
	/**
	 * Tests selectionHi using the base lists
	 */
	@Test 
	public void testSelectionHi() throws IllegalArgumentException{
		assertEquals(empty, selectionHi(empty), "empty list should not break things");
		assertEquals(single, selectionHi(single), "single list should not break things");
		assertEquals(sorted, selectionHi(reverse), "should sort a reversed list");
		assertEquals(sorted, selectionHi(sorted), "sorted list should not break things");
		assertThrows(IllegalArgumentException.class, ()->{selectionHi(null);}, "null is not a valid parameter");
	}
	
	/**
	 * Tests randomQuick using the base lists
	 */
	@Test 
	public void testRandomQuick() throws IllegalArgumentException{
		assertEquals(empty, randomQuick(empty), "empty list should not break things");
		assertEquals(single, randomQuick(single), "single list should not break things");
		assertEquals(sorted, randomQuick(reverse), "should sort a reversed list");
		assertEquals(sorted, randomQuick(sorted), "sorted list should not break things");
		assertThrows(IllegalArgumentException.class, ()->{randomQuick(null);}, "null is not a valid parameter");
	}
	
	/**
	 * An iterative implementation of binary search.
	 * 
	 * Precondition: list must be sorted.
	 * 
	 * @param sorted The list to be searched
	 * @param number The number to find
	 * @return True if the number exists in the list, false otherwise
	 * @throws IllegalArgumentException if the list is null
	 */
	public static boolean itrBinary(List<Integer> arr, int i) throws IllegalArgumentException{
		if(arr.equals(null)) return false;
		//Initialize both sides
		int right = arr.size();
		int left = 0;
		while(right >= left){
			right--;
			int middle = left + (right - left) / 2;
			//if middle is target number return true
			if (arr.get(middle) == i){
			return true;
			}
			//if not check if the middle is less than target
            else if (arr.get(middle) < i){
				left = middle + 1;
			}
		}
		//if not found in the while loop, return false because its not in there
		return false;
	}
	
	/**
	 * Sorts a list using bubble sort in descending order rather than ascending order.
	 * 
	 * @param list The list that needs to be sorted.
	 * @return The sorted list
	 * @throws IllegalArgumentException if the list is null
	 */
	public static List<Integer> descendBubble(List<Integer> array) throws IllegalArgumentException{
		LinkedList<Integer> temp = new LinkedList<>();
		for(int i = array.size(); i > 0; i--){
			for(int j = array.size() - 1; j > 0; j--){
				if(array.get(j) > array.get(j - 1)){
				swap(array, j, j - 1);
				}
			}
		}
		return temp;
	}
	public static void swap(List<Integer> array, int i, int j){
		int temp = array.get(i);
		array.set(i,j);
		array.set(j,temp);
		
	}
	
	/**
	 * Sorts a list by selecting for the highest value each iteration.
	 * 
	 * @param list The list that needs to be sorted.
	 * @return The sorted list
	 * @throws IllegalArgumentException if the list is null
	 */
	public static int selectionHi(List<Integer> array) throws IllegalArgumentException{
				int temp = 0;
		for(int i = 0; i < array.size(); i++){
			int maxIndex = i;
			for(int j = i; j < array.size(); j++){
				if(array.get(j) < array.get(maxIndex)){
					maxIndex = j;
					temp = maxIndex;
				}
			}
			swap(array, i, maxIndex);
			//System.out.println(array[maxIndex]);
		}
		//System.out.println(Arrays.toString(array));
		return array.get(temp);
	}
	
	/**
	 * Sorts a list using quicksort with a random pivot.
	 * 
	 * @param list The list that needs to be sorted.
	 * @return The sorted list
	 * @throws IllegalArgumentException if the list is null
	 */
	public static List<Integer> randomQuick(List<Integer> list) throws IllegalArgumentException{
		Random rand = new Random();
		if(list.size()<=1){
			return list;
		}
		List<Integer> list2 =  new ArrayList<>(list);
		//need to code to where pivot equals a random element in the arraylist
		Integer pivot = list2.remove(rand.nextInt(list2.size()));
		List<Integer> left =  new ArrayList<>();
		List<Integer> right =  new ArrayList<>();
		Iterator<Integer> itr = list2.iterator();
		while(itr.hasNext()){
			Integer i = itr.next();
			if(i.compareTo(pivot) <= 0){
			left.add(i);
		}else{
				right.add(i);
			}
		}
		left = randomQuick(left);
		right = randomQuick(right);
		left.add(pivot);
		left.addAll(right);
		return left;
	}
}
