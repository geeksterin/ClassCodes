package October31;

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
}
