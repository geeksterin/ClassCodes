package october31Linkedlist;

public class LinkedList {
	public class Node {
		int data;
		Node next;
	}

	private Node head;
	private int size;
	private Node tail;

	public void Addlast(int d) {
		Node newnode = new Node();
		newnode.data = d;

		if (size == 0) {
			this.head = newnode;
			tail = newnode;
		} else {
			tail.next = newnode;
			tail = newnode;
		}
		size++;
	}

	public void display() {
		Node temp = head;
		while (temp != null) {
			// print data of temp
			System.out.print(temp.data + "-->");
			temp = temp.next;
		}

		System.out.println();
	}

	public void addFirst(int d) {
		Node newnode = new Node();
		newnode.data = d;

		if (size == 0) {
			head = newnode;
			tail = newnode;
		} else {
			newnode.next = head;
			head = newnode;
		}
		size++;
	}

	public void addAt(int d, int pos) {
		if (pos < 0 || pos > size) {
			System.out.println("pos is out of bound");
			return;
		} else if (pos == 0) {
			addFirst(d);
		} else if (pos == size) {
			Addlast(d);
			;
		} else {
			Node temp = head;
			int counter = 0;
			while (counter < pos - 1) {
				temp = temp.next;
				counter++;
			}
			Node newnode = new Node();
			newnode.data = d;
			newnode.next = temp.next;
			temp.next = newnode;
		}
		size++;

	}

	public void removeFirst() {
		if (size == 1) {
			head = null;
			tail = null;
			size--;
		} else if (size > 0) {
			head = head.next;
			size--;
		} else {
			System.out.println("nothing to remove");
		}
	}

	public void removeLast() {
		if (size == 0) {
			System.out.println("nothing to remove");
		} else if (size == 1) {
			head = null;
			tail = null;
			size--;
		} else {
			// get second last
			int counter = 0;
			Node temp = head;
			while (counter < size - 2) {
				temp = temp.next;
				counter++;
			}
			temp.next = null;
			tail = temp;
			size--;
		}
	}

	public void removeAtIdx(int idx) {
		removeAt(idx + 1);
	}

	private void removeAt(int pos) {
		if (pos < 1 || pos > size) {
			System.out.println("out of bound");
			return;
		} else if (pos == 1) {
			removeFirst();
		} else if (pos == size) {
			removeLast();
		} else {
			int counter = 0;
			Node temp = head;
			while (counter < pos - 2) {
				temp = temp.next;
				counter++;
			}
			temp.next = temp.next.next;
			size--;
		}
	}

	boolean isempty() {
		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}

	int getsize() {
		return size;
	}

	public int getFirst() {
		if (this.size == 0) {
			return -1;
		}

		return this.head.data;
	}

	public int getLast() {
		if (this.size == 0) {
			return -1;
		}

		return this.tail.data;
	}

	public int getAt(int idx) {
		if (idx >= this.size || idx < 0) {
			return -1;
		}

		int count = 0;
		Node temp = this.head;
		while (count < idx) {
			temp = temp.next;
			count++;
		}

		return temp.data;
	}

	public Node getNodeAt(int idx) {
		if (idx >= this.size || idx < 0) {
			return null;
		}

		int count = 0;
		Node temp = this.head;
		while (count < idx) {
			temp = temp.next;
			count++;
		}

		return temp;
	}

	public void reverseDI() {
		int l = 0;
		int r = this.size - 1;
		while (l < r) {
			Node lNode = getNodeAt(l);
			Node rNode = getNodeAt(r);

//			swap
			int temp = lNode.data;
			lNode.data = rNode.data;
			rNode.data = temp;
			l++;
			r--;
		}
	}

	public void reversePI() {
		Node curr = this.head;
		Node prev = null;
		while (curr != null) {
			Node temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}

		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
	}

	class Helper {
		Node left;
	}

	public boolean isPalindrome() {
		Helper hp = new Helper();
		hp.left = head;
		Node right = head;
		return isPalindromeHelper(hp, right, 0);
	}

	private boolean isPalindromeHelper(Helper hp, Node right, int level) {
		if (right == null) {
			return true;
		}

		boolean bl = isPalindromeHelper(hp, right.next, level + 1);

		if (bl == false) {
			return false;
		}
		if (right.data != hp.left.data) {
			return false;
		}
		hp.left = hp.left.next;

		return true;
	}

	public int mid() {
		Node fast = this.head;
		Node slow = this.head;
		while (fast != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		return slow.data;
	}

	public int kFromLast(int k) {
		Node fast = this.head;
		Node slow = this.head;

		for (int i = 0; i < k; i++) {
			fast = fast.next;
		}

		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}

		return slow.data;
	}

	public void fold() {
		Helper hp = new Helper();
		hp.left = this.head;
		Node right = this.head;
		fold(hp, right, 0);
	}

	private void fold(Helper hp, Node right, int floor) {
		if (right == null) {
			return;
		}

		fold(hp, right.next, floor + 1);
		if (floor > size / 2) {
			Node currLeftNext = hp.left.next;
			hp.left.next = right;
			right.next = currLeftNext;
			hp.left = currLeftNext;
		}

		if (floor == size / 2) {
//			even
			right.next = null;
			tail = right;
		}
	}

	public void reverDR() {
		Helper hp = new Helper();
		hp.left = this.head;
		Node right = this.head;
		reverDR(hp, right, 0);
	}

	private void reverDR(Helper hp, Node right, int floor) {
		if (right == null) {
			return;
		}

		reverDR(hp, right.next, floor + 1);
		if (floor >= size / 2) {
			int temp = hp.left.data;
			hp.left.data = right.data;
			right.data = temp;
			hp.left = hp.left.next;
		}
	}

	private Node left;

	public void fold2() {
		left = this.head;
		Node right = this.head;
		fold2(right, 0);
	}

	private void fold2(Node right, int floor) {
		if (right == null) {
			return;
		}

		fold2(right.next, floor + 1);
		if (floor > size / 2) {
			Node currLeftNext = left.next;
			left.next = right;
			right.next = currLeftNext;
			left = currLeftNext;
		}

		if (floor == size / 2) {
//			even
			right.next = null;
			tail = right;
		}
	}

}
