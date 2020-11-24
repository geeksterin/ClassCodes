package november24;

public class BST {
	private Node root;
	private int size;

	private class Node {
		int data;
		Node left;
		Node right;
	}

	public BST(int[] sa) {
		root = construct(sa, 0, sa.length - 1);
	}

	private Node construct(int[] sa, int lo, int hi) {
		if (lo > hi) {
			return null;
		}
		Node node = new Node();
		int mid = (lo + hi) / 2;
		node.data = sa[mid];
		node.left = construct(sa, lo, mid - 1);
		node.right = construct(sa, mid + 1, hi);
		return node;
	}

	public void display() {
		display(root);
	}

	public void display(Node node) {
		if (node == null) {
			return;
		}

//		String str = (node.left != null ? node.left.data + " " : ".") + ("<--" + node.data + "--> ")
//				+ (node.right != null ? node.right.data + "" : ".");
//		System.out.println(str);
		if (node.left != null) {
			System.out.print(node.left.data + " ");
		} else {
			System.out.print(".");
		}
		System.out.print("<--" + node.data + "--> ");
		if (node.right != null) {
			System.out.print(node.right.data);
		} else {
			System.out.print(".");
		}
		System.out.println();

		display(node.left);
		display(node.right);
	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {
		if (node.right == null) {
			return node.data;
		}
		return max(node.right);
	}

	public int min() {
		return min(this.root);
	}

	private int min(Node node) {
		if (node.left == null) {
			return node.data;
		}
		return min(node.left);
	}

	public boolean find(int data) {
		return find(root, data);
	}

	private boolean find(Node node, int data) {
		if (node == null) {
			return false;
		}
		if (node.data == data) {
			return true;
		}

		if (data < node.data) {
			return find(node.left, data);
		} else
			return find(node.right, data);
	}

	public void pir(int lo, int hi) {
		pir(root, lo, hi);
		System.out.println();
	}

	private void pir(Node node, int lo, int hi) {
		if (node == null) {
			return;
		}
		if (node.data < lo) {
			pir(node.right, lo, hi);
		} else if (node.data > hi) {
			pir(node.left, lo, hi);
		} else {
			pir(node.left, lo, hi);
			System.out.print(node.data + " ");
			pir(node.right, lo, hi);
		}
	}

	private int sumTillNow;

	public void replaceWithSumofLargerNodes() {
		sumTillNow = 0;
		replaceWithSumofLargerNodes(root);
	}

	private void replaceWithSumofLargerNodes(Node node) {
		if (node == null) {
			return;
		}
		replaceWithSumofLargerNodes(node.right);
		sumTillNow += node.data;
		node.data = sumTillNow;
		replaceWithSumofLargerNodes(node.left);
	}

}
