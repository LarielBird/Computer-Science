//@author Leah Bird

import java.util.*;
public class Ch10 {
	
	public static void main (String[] args) {
		ArrayList<String> list1 = new ArrayList<>();
		list1.add("how");
		list1.add("are");
		list1.add("you?");
		ArrayList<Integer> list2 = new ArrayList<>();
		Collections.addAll(list2, 3,8,92,4,2,17,9);
		ArrayList<Integer> list3 = new ArrayList<>();
		Collections.addAll(list3, 4,7,9,2,7,7,5,3,5,1);
		//doubleList(list1);
		//minToFront(list2);
		//stutter(list1, 4);
		filterRange(list3, 5,7);
	}
	
	
		
	public static void doubleList(ArrayList<String>givenList) {
		if(givenList == null) throw new IllegalArgumentException();
		//initialize newList to transfer modified data
		ArrayList<String> newList = new ArrayList<>(givenList);
		String placeholder = "";
		//goes through the given list and gets the word at index i then stores it into a new array
		for(int i = givenList.size()-1; i >= 0; i--){
			String word = givenList.get(i);
			newList.add(word);
		}
		System.out.println(newList);
	}
	public static void minToFront(ArrayList<Integer>givenList){
		if(givenList == null) throw new IllegalArgumentException();
		//initialize newList to transfer modified data
		ArrayList<Integer> newList = new ArrayList<>(givenList);
		Collections.sort(newList);
		//variables
		int temp = newList.get(0);
		int num = 0;
		//go through the array, when it finds the location of the num to move, remove it then move to the front.
		for(int i = 0; i < givenList.size()-1 ;i++){
			num = givenList.get(i);
			if(temp == num){
				givenList.remove(i);
				givenList.add(0, temp);
				System.out.println(givenList);
			}
		}
	}
	public static void stutter(ArrayList<String>givenList,int k) {
		if(givenList == null) throw new IllegalArgumentException();
		//initialize newList to transfer modified data
		ArrayList<String> newList = new ArrayList<>();
		String placeholder = "";
		
		for(int i = givenList.size()-1; i >= 0; i--){
			String word = givenList.get(i);
			//Similar to doubleList except theres a loop for how many times a word should be added to the new array.
			for(int j = 0 ; j < k; j++){
				newList.add(word);
			}
		}
		System.out.println(newList);
	}
	public static void filterRange(ArrayList<Integer>givenList,int min,int max){
		if(givenList == null) throw new IllegalArgumentException();
		ArrayList<Integer> newList = new ArrayList<>(givenList);
		int num = 0;
		for(int i = givenList.size()-1; i >= 0; i--){
			num = givenList.get(i);
			if(num >= min && num <= max){
				newList.remove(i);
			}
		}
		System.out.println(newList);
	}
}

