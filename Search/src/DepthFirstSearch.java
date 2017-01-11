
public class DepthFirstSearch {
	private TreeNode root;
	
	public class TreeNode {
		public TreeNode left;
		public TreeNode right;
		public int data;
	}
	
	public static void main(String[] args) {
		int a[] = {1,3,3,4,5,5,6,6,8,9,23,34,34,90,93,98,238,374,8723};
		
		System.out.println("recursive");
		System.out.println(indexR);
		if(indexR != -1) {
			System.out.println(a[indexR]);
		}
	}
}
