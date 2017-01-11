
public class BubbleSort {
	public static void sort(int[] a) {
		if(a.length<=1) {
			return;
		}
		boolean sorted = false;
		while(!sorted) {
			sorted = true;
			int temp;
			for(int i=0; i<a.length-1; i++) {
				if(a[i]>a[i+1]) {
					temp = a[i+1];
					a[i+1]=a[i];
					a[i]=temp;
					sorted = false;
				}
			}
		}
	}
	public static void main(String[] args) {
		int a[] = {5,4,8,1,3,6,34,8723,9,5,3,238,98,374,93,34,6,90,23};
		BubbleSort.sort(a);
		
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
