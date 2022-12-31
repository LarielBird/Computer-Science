import java.util.*;
public class Ch12 {
	
	public static void main (String[] args) {
		List<String> list = new ArrayList<>(List.of("Janet","Morgan","Robert","Char"));
		//subsets(list);
		//System.out.println(doubleDigits(-257));
		//System.out.println(sumTo(2));
		System.out.println(permut(3,2));
	}
	
	public static int doubleDigits(int n){
		String nums = Integer.toString(n);
		String temp = "";
		if(n<0){
			temp = doubleDigits(nums,nums.length() + 2);
			temp = temp.substring(1,temp.length());
		}
		else{
			temp = doubleDigits(nums,nums.length()+ 1);
		}
		int result = Integer.parseInt(temp);
		return result;
	}
	public static int count = 0;
	public static String output = "";
	
	private static String doubleDigits(String nums, int index){
		if (index < 0) return "";
		if( count <= index){
			output += nums.charAt(count);
			output += nums.charAt(count);
			//System.out.println(count);
			count++;
			doubleDigits(nums, index - 1);
		}
		return output;
	}
	
	public static double sumTo(int n){
		if(n < 0) throw new IllegalArgumentException();
		double value = 0;
		return sumTo(n,value);
	}
	private static double sumTo(int n, double value){
		//System.out.println(n);
		if(n == 0) return value;
		value += (double) 1/n;
		//System.out.println(value);
		return sumTo(n-1, value);
	}
	
	public static int permut(int n, int r){
		long temp = recursiveFactorial(n);
		long temp2 = recursiveFactorial(n-r);
		return (int)(temp/temp2);
	}
	private static long recursiveFactorial(int n){
		if(n == 0){
			return 1L;
		}
		return n * recursiveFactorial(n - 1);
	}
	
	//Problem done in class:
	public static Set<String> sets = new HashSet<>();
	
	public static void subsets(List<String> list){
		String set = list.toString();
		if(!sets.contains(set)){
			sets.add(set);
			System.out.println(set);
			subsets(list,list.size() - 1);
		}
	}
	private static void subsets(List<String> list, int index){
		if(index<0) return;
		//System.out.println(list.toString() + ", "+index);
		List<String> copy = new ArrayList<>(list);
		subsets(list, index - 1);
		copy.remove(index);
		subsets(copy);
	}
}
