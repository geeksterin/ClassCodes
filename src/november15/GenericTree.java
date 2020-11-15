package november15;

import java.util.*;

public class GenericTree {
	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	private Node root;
	private int size;

	public GenericTree(int[] arr) {
		Stack<Node> st = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == -1) {
				st.pop();
			} else {
				Node node = new Node();
				this.size++;
				node.data = arr[i];

				if (st.size() > 0) {
					st.peek().children.add(node);
				} else {
					this.root = node;
				}
				st.push(node);
			}
		}
	}

	public void display() {
		display(root);
	}

	private void display(Node node) {
		System.out.print(node.data + "->");

		for (Node child : node.children) {
			if (child == null) {
				continue;
			}
			System.out.print(child.data + ",");
		}
		System.out.println(".");

		for (Node child : node.children) {
			if (child == null) {
				continue;
			}
			display(child);
		}
	}

	public int size2() {
		return size2(root);
	}

	private int size2(Node node) {
		int size = 0;
		for (Node child : node.children) {
			int csize = size2(child);
			size += csize;
		}

		size++;
		return size;
	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {
		int max = node.data;
		for (Node child : node.children) {
			int cmax = max(child);
			max = Math.max(cmax, max);
		}

		return max;
	}

	public boolean find(int data) {
		return find(root, data);
	}

	private boolean find(Node node, int data) {
		if (node.data == data) {
			return true;
		}

		for (Node child : node.children) {
			boolean childres = find(child, data);
			if (childres == true) {
				return true;
			}
		}

		return false;
	}

	public int height() {
		return height(root);
	}

	private int height(Node node) {
		int ht = 0;
		for (Node child : node.children) {
			int cht = height(child);
			ht = Math.max(cht, ht);
		}

		ht++;
		return ht;
	}

	public ArrayList<Integer> nodeToRootPath(int data) {
		return nodeToRootPath(root, data);
	}

	private ArrayList<Integer> nodeToRootPath(Node node, int data) {

		if (node.data == data) {
			ArrayList<Integer> bres = new ArrayList<Integer>();
			bres.add(node.data);
			return bres;
		}

		for (Node child : node.children) {
			ArrayList<Integer> rres = nodeToRootPath(child, data);
			if (rres.size() > 0) {
				rres.add(node.data);
				return rres;
			}
		}

		return new ArrayList<>();
	}

	public void removeLeaves() {
		removeLeaves(root);
	}

	private void removeLeaves(Node node) {
		for (int i = node.children.size() - 1; i >= 0; i--) {
			Node child = node.children.get(i);
			if (child.children.size() == 0) {
				node.children.remove(child);
			} else {
				removeLeaves(child);
			}
		}
	}

}
