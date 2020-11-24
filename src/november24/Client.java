package november24;

public class Client {

	public static void main(String[] args) {
		int[] arr = {12,25,37,50,62,75,87};
		int[] arr2= {1,2,4,5,6,8,9};
		BST bst = new BST(arr2);
		bst.display();
//		System.out.println(bst.pir(87));
//		bst.pir(800, 1000);
		System.out.println("-------------------");
		bst.replaceWithSumofLargerNodes();
		bst.display();
	}
}
