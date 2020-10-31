package october31Linkedlist;

public class Linklist {
	public class Node{
		int Nodedata;
		Node Nodenext;
	}
	
	Node Head;
	int size;
	Node Tail;
	
	public void Addlast(int d) {
		Node newnode = new Node();
		newnode.Nodedata = d;

		if(size==0) {
			Head = newnode;
			Tail = newnode;
		}
		else {
			Tail.Nodenext = newnode;
			Tail = newnode;
		}
		size++;
	}
	
	public void display() {
		Node temp = Head;
		while(temp != null) {
			//print data of temp
			System.out.print(temp.Nodedata + "-->");
			temp = temp.Nodenext;
		}
	}
	
	public void addFirst(int d) {
		Node newnode = new Node();
		newnode.Nodedata = d;
		
		if(size == 0) {
			Head = newnode;
			Tail = newnode;
		}
		else {
			newnode.Nodenext = Head;
			Head = newnode;
		}
		size++;
	}
	
	public void addAt(int d,int pos) {
		if(pos<0 || pos>size) {
			System.out.println("pos is out of bound");
			return;
		}
		else if(pos == 0) {
			addFirst(d);
		}
		else if(pos == size) {
			Addlast(d);;
		}
		else {
			Node temp = Head;
			int counter = 0;
			while(counter < pos-1) {
				temp = temp.Nodenext;
				counter++;
			}
			Node newnode = new Node();
			newnode.Nodedata = d;
			newnode.Nodenext = temp.Nodenext;
			temp.Nodenext = newnode;	
		}
		size++;
		
	}
	
	public void removeFirst() {
		if(size == 1) {
			Head = null;
			Tail = null;
			size--;
		}
		else if(size > 0) {
			Head = Head.Nodenext;
			size--;
		}
		else {
			System.out.println("nothing to remove");
		}
	}
	
	public void removeLast() {
		if(size==0) {
			System.out.println("nothing to remove");
		}
		else if(size==1) {
			Head = null;
			Tail = null;
			size--;
		}
		else {
			// get second last
			int counter = 0;
			Node temp = Head;
			while(counter < size - 2) {
				temp = temp.Nodenext;
				counter++;
			}
			temp.Nodenext = null;
			Tail = temp;
			size--;
		}
	}
	
	public void removeAt(int pos) {
		if(pos<1 || pos>size) {
			System.out.println("out of bound");
			return;
		}
		else if(pos == 1) {
			removeFirst();
		}
		else if(pos == size) {
			removeLast();
		}
		else {
			int counter = 0;
			Node temp = Head;
			while(counter < pos - 2) {
				temp = temp.Nodenext;
				counter++;
			}
			temp.Nodenext = temp.Nodenext.Nodenext;
			size--;
		}
	}
	
	boolean isempty() {
		if(size==0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	int getsize() {
		return size;
	}
	
	
	
	
}
