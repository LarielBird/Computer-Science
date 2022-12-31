import java.util.*;
public class Ch14 {
	public static void main (String[] args) {
		//TESTING
		Stack<Integer> stack = new Stack<>();
		stack.push(57);
		stack.push(2);
		stack.push(-4);

		Stack<Integer> stack2 = new Stack<>();
		stack2.push(57);
		stack2.push(50);
		stack2.push(4);

		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		queue.add(50);
		queue.add(4);

		//isPalindrome();
		//System.out.println(isSorted(stack));
		//System.out.println(removeMin(stack2));
		
		//System.out.println(equals(stack,stack2));
		//System.out.println(isPalindrome(queue));
		
	}
	
	//HOMEWORK PROBLEMS
	
	public static boolean equals(Stack<Integer> stack1, Stack<Integer> stack2){
		if (stack1 == null || stack2 == null){
			return true;
		}
		if (stack1.isEmpty() && stack2.isEmpty()){
			return true;
		}
		Stack<Integer> temp1 = new Stack<Integer>();
		temp1.addAll(stack1);
		Stack<Integer> temp2 = new Stack<Integer>();
		temp2.addAll(stack2);
		
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

