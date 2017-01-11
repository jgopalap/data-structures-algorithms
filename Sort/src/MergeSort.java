
/*
 * Algorithm for performing merge sort.
 * In addition to the original array that is given to sort, one more array
 * is used to perform the copying in sorted order two subarrays partitioned 
 * from a larger array.
 */
public class MergeSort {
	public static void sort(int[] array, int[] sortedArray, int len, int offset) {
		if(len == 1) {
			sortedArray[offset] = array[offset];
			return;
		}
		if(len == 2) {
			if(array[offset] > array[offset + 1]) {
				sortedArray[offset] = array[offset+1];
				sortedArray[offset+1] = array[offset];
			} else {
				sortedArray[offset] = array[offset];
				sortedArray[offset+1] = array[offset+1];
			}
			array[offset] = sortedArray[offset];
			array[offset+1] = sortedArray[offset+1];
			return;
		}
		
		int leftSize = len/2;
		int rightSize = len - len/2;
		int leftOffset = offset;
		int rightOffset = leftOffset + leftSize;
		
		//sort the left half
		sort(array, sortedArray, leftSize, leftOffset);
		//sort the right half
		sort(array, sortedArray, rightSize, rightOffset);
		//merge
		int i=leftOffset;
		int j=rightOffset;
		int z = leftOffset;
		while(i<(leftSize+leftOffset) && j<(rightSize+rightOffset)) {
			if(array[i] < array[j]) { 
				sortedArray[z] = array[i];
				i++;
				z++;
			} else {
				sortedArray[z] = array[j];
				j++;
				z++;
			}
		}		
		while(i<(leftSize+leftOffset)) {
			sortedArray[z] = array[i];
			i++;
			z++;
		}
		while(j<(rightSize+rightOffset)) {
			sortedArray[z] = array[j];
			j++;
			z++;
		}
		//update the original array to allow previous recursive call to 
		//copy in sorted order from original array
		for(i=leftOffset; i<(leftOffset+leftSize+rightSize);i++) {
			array[i]=sortedArray[i];
		}
		
	}
	
	public static void main(String[] args) {
		int a[] = {5,4,8,1,3,6,34,8723,9,5,3,238,98,374,93,34,6,90,23};
		int[] sortedArray = new int[a.length];
		MergeSort.sort(a, sortedArray, a.length, 0);
		for(int i=0; i<sortedArray.length; i++) {
			System.out.print(sortedArray[i] + " ");
		}
	}
}
