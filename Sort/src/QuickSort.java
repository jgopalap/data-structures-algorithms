/**
 * 
 * @author jgopalap
 * Quicksort involves taking a pivot, let's say the last element to start
 * and then moving all the elements that are less than the pivot to the left 
 * side.  Every time an element that is less than the pivot is encountered
 * the tracking index, wall, is moved up, except when encountering an element
 * that is greater.  For the latter the next time a lower element is encountered
 * it is swapped with the greater element.  This is done recursively for all 
 * the elements on the left of the pivot.  The same process is followed
 * for the elements on the right of the pivot. 
 *
 */
public class QuickSort {
	public static void sort(int[] array, int pivotIndex, int wallIndex) {
		if(wallIndex>=pivotIndex) {
			return;
		}
		int iWallIndex = wallIndex;
		//moving all lower elements to left of pivot
		for(int i=wallIndex; i<array.length; i++) {
			if(array[i] <= array[pivotIndex]) {
				int temp = array[iWallIndex];
				array[iWallIndex] = array[i];
				array[i] = temp;
				iWallIndex++;
			}
		}
		//sort left half
		sort(array, pivotIndex-1, wallIndex);
		//sort right half
		sort(array, array.length-1, pivotIndex+1);
	}

	public static void main(String[] args) {
		int a[] = {5,4,8,1,3,6,34,8723,9,5,3,238,98,374,93,34,6,90,23};
		QuickSort.sort(a, a.length-1, 0);
		
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
