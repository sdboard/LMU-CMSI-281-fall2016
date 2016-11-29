//MergeSort.java
public class MergeSort{
	//testing for branching
	public static void main(String[] args){

	}
	public static void mergesort(int[] array){
		int[] helper = new int[array.length];
		mergesort(array,helper, 0, array.length-1);
	}

	public static void mergesort(int[] array, int[] helper, int low, int high){
		if ( low < high ) {
			int middle = (low+high)/2;
			mergesort(array,helper,low,middle);
			mergesort(array,helper,middle+1,high);
			merge(array,helper,low,middle,high);
		}
	}
	public static void merge(int[] array, int[] helper, int low, int high){
		//copy both halves into the helper
		for(int i = low; i <= high; i++){
			helper[i] = array[i];
		}
		int helperLeft = low;
		int helperRight = middle + 1;
		int current = low;
		//interate through left and right arrays
		//compart lowest unpicked element of each array
		//put lower one in lower value in the actual array
		while (helperLeft <= middle && helperRight <= high) {
			if ( helper[helperLeft] <= helper[helperRight] ) {
				array[current] = helper[helperLeft];
				helperLeft++
			} else {
				array[current] = helper[helperRight]:
				helperRight++;
			}
			current++;
		}
		//copy rest of left into target
		int remaining = middle - helperLeft;
		for (int i = 0; i <= remaining; i++){
			array[current+i ] = helper[helperLeft+i];
		}

	}
}