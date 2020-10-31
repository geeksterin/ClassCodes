package october31Linkedlist;

public class client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Linklist l1 = new Linklist();
		l1.Addlast(5);
		l1.Addlast(10);
		l1.Addlast(20);
		l1.addAt(15,2);
		l1.display();
		System.out.println();
		l1.removeAt(2);
		l1.display();
	}

}
