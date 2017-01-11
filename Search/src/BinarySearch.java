
public class BinarySearch {
	//search recursive
	public static int findR(int val, int[] array, int low, int mid, int high) {
		if(low > high) {
			return -1;
		}
		if(val == array[mid]) {
			return mid;
		} else if(val > array[mid]) {
			return findR(val, array, mid, (mid+high)/2, high);
		} else {
			return findR(val, array, low, (low+mid)/2, mid);
		}
	}
	
	//search iterative
	public static int findI(int val, int[]array) {
		int low = 0;
		int high = array.length-1;
		int mid = (low+high)/2;
		while(low<high) {
			if(array[mid] == val) {
				return mid;
			} else if(val>array[mid]) {
				low=mid;
				mid = (low+high)/2;
			} else {
				high = mid;
				mid = (low+high)/2;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int a[] = {1,3,3,4,5,5,6,6,8,9,23,34,34,90,93,98,238,374,8723};
		int indexR = BinarySearch.findR(23, a, 0, a.length/2, a.length-1);
		int indexI = BinarySearch.findI(23, a);
		
		System.out.println("recursive");
		System.out.println(indexR);
		if(indexR != -1) {
			System.out.println(a[indexR]);
		}
		System.out.println("iterative");
		System.out.println(indexI);
		if(indexI != -1) {
			System.out.println(a[indexI]);
		}
	}
}
