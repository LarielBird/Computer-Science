import java.util.*;
public class Ch11 {
	
	public static void main (String[] args) {
		List<Integer> nums1 = new LinkedList<>(List.of(4,6,8,2,4));
		List<Integer> nums2 = new LinkedList<>(List.of(2,4,8,10,8,6));
		//alternate(nums1,nums2);
		//sortAndRemoveDuplicates(nums1);
		//hasOdd(nums1);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("hi", 10);
		map.put("hia", 19);
		map.put("hello", 19);
		map.put("bye", 15);

		//is1to1(map);
	}
	public static List alternate(List<Integer> list1,List<Integer> list2){
		if(list1 == null|| list2 == null) throw new IllegalArgumentException();
		//Initialize variables and iterators
		List<Integer> newList = new LinkedList<>();
		Iterator<Integer> i = list1.iterator();
		Iterator<Integer> j = list2.iterator();
		//for(int x = 0;i.hasNext() || j.hasNext(); x++){
		while(i.hasNext() || j.hasNext()){
			if(i.hasNext()){
				newList.add(i.next());
				//i.next();
				System.out.println("list1");
			}
			if (j.hasNext()){
				newList.add(j.next());
				//j.next();
				System.out.println("list2");
			}
		}
		//System.out.println(newList);
		return newList;
	}
	public static void sortAndRemoveDuplicates(List<Integer> nums){
		if(nums == null) throw new IllegalArgumentException();
		//List<Integer> temp = new ArrayList<>(nums);
		//Collections.sort(temp);
		//System.out.println(temp);
		Set<Integer> numSet = new TreeSet<>(nums);
		nums.clear();
		nums.addAll(numSet);
		System.out.println(numSet);
	}
	public static boolean hasOdd(Set<Integer> nums){
		if(nums == null) throw new IllegalArgumentException();
		//initialize
		Iterator<Integer> i = nums.iterator();
		int temp = 0;
		//for(int x = 0; i.hasNext(); x++){
		while(i.hasNext()){
			temp = (int)i.next();
			//temp = nums.get(x);
			if(temp % 2 != 0){
				System.out.println("True");
				return true;
			}
			/*else if(!i.hasNext()){
				System.out.println("False");
				return false;
			}*/
		}
		return false;
	}
	public static boolean is1to1(Map<String, String> strings){
		if(strings == null)throw new IllegalArgumentException();
		Set<String> set = new HashSet<>(strings.values());
		return set.size() == strings.keySet().size();
		/*int size  = strings.size() + set.size();
		int total = 0;
		
		if(size % 2 == 0){
			System.out.println(set);
			System.out.println("True");
			return true;
		}
		else{
			System.out.println("False");
			return false; 
		}*/
	}
}

