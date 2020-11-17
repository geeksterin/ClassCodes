package november15;

public class Client {

	public static void main(String[] args) {
		int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
				-1 };
//		int[] arr = {10,20,-1,30,-1,40,-1,-1};
		GenericTree gt = new GenericTree(arr);
//		gt.postOrder();
		gt.printLevelOrderZigZag();
//		System.out.println(gt.nodeToRootPath(120));
//		gt.display();

	}

}
