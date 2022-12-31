import java.util.*;
class Ch13 {
	public static void main(String args[]){
		ArrayList<Integer> arrList = new ArrayList<>();
		arrList.add(12);
		arrList.add(5);
		arrList.add(7);
		arrList.add(9);
		arrList.add(3);
		
		System.out.println(quickSort(arrList));
		
		
    }
    
	public static boolean binarySearch(int arr[], int i){
		//Initialize both sides
		int right = arr.length;
		int left = 0;
		while(right >= left){
			right--;
			int middle = left + (right - left) / 2;
			//if middle is target number return true
			if (arr[middle] == i){
			return true;
			}
			//if not check if the middle is less than target
            else if (arr[middle] < i){
				left = middle + 1;
			}
		}
		//if not found in the while loop, return false because its not in there
		return false;
	}
	public static void bubbleSort(int[]array){
		for(int i = array.length; i > 0; i--){
			for(int j = array.length - 1; j > 0; j--){
				if(array[j] > array[j - 1]){
				swap(array, j, j - 1);
				}
			}
		}
		System.out.println(Arrays.toString(array));
	}
	public static int selectionSort(int[] array){
		int temp = 0;
		for(int i = 0; i < array.length; i++){
			int maxIndex = i;
			for(int j = i; j < array.length; j++){
				if(array[j] < array[maxIndex]){
					maxIndex = j;
					temp = maxIndex;
				}
			}
			swap(array, i, maxIndex);
			//System.out.println(array[maxIndex]);
		}
		//System.out.println(Arrays.toString(array));
		return array[temp];
	}
	public static void swap(int[]array, int i, int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	public static List<Integer> quickSort(List<Integer> list){
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
		left = quickSort(left);
		right = quickSort(right);
		left.add(pivot);
		left.addAll(right);
		return left;
	}
}
