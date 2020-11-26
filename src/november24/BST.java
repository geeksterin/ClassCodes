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

	public void add(int data) {
		root = add(root, data);
	}

	private Node add(Node node, int data) {

		if (node == null) {
			Node temp = new Node();
			temp.data = data;
			return temp;
		}

		if (data > node.data) {
			node.right = add(node.right, data);
		} else {
			node.left = add(node.left, data);
		}

		return node;
	}

	public void add2(int data) {
		add(root, data);
	}

	public void add2(Node node, int data) {
		if (data > node.data) {
			if (node.right == null) {
				Node temp = new Node();
				temp.data = data;
				node.right = temp;
				return;
			}
			add2(node.right, data);
		} else {
			if (node.left == null) {
				Node temp = new Node();
				temp.data = data;
				node.left = temp;
				return;
			}
			add2(node.left, data);
		}
	}

	public void remove(int data) {
		root = remove(root, data);
	}

	private Node remove(Node node, int data) {
		if (data > node.data) {
			node.right = remove(node.right, data);
		} else if (data < node.data) {
			node.left = remove(node.left, data);
		} else {
//			no child
			if (node.left == null && node.right == null) {
				return null;
			} else if (node.right == null) { // only left child
				return node.left;
			} else if (node.left == null) { // only right child
				return node.right;
			} else {
				int lmax = max(node.left); // both the childs
				node.data = lmax;
				node.left = remove(node.left, lmax);
			}
		}

		return node;
	}

	public int lca(int d1, int d2) {
		return lca(root, d1, d2);
	}

	private int lca(Node node, int d1, int d2) {
		if (node.data < d1 && node.data < d2) {
			return lca(node.right, d1, d2);
		} else if (node.data > d1 && node.data > d2) {
			return lca(node.left, d1, d2);
		} else {
			return node.data;
		}
	}

	public void targetSumPair(int sum) {
		targetSumPair(root, sum);
	}

	public void targetSumPair(Node node, int sum) {
		if (node == null) {
			return;
		}
		if (find(sum - node.data)) {
			if (node.data < (sum - node.data)) {
				System.out.println(node.data + " " + (sum - node.data));
			}
		}
		targetSumPair(node.left, sum);
		targetSumPair(node.right, sum);
	}

}
