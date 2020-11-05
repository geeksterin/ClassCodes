package october31Linkedlist;

import java.util.ArrayList;

public class client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList l1 = new LinkedList();
//		l1.Addlast(5);
//		l1.Addlast(10);
//		l1.Addlast(20);
//		l1.addAt(15, 2);
//		l1.display();
//		l1.removeAtIdx(2);
//		l1.display();
//		l1.addFirst(30);
//		l1.addFirst(40);
//		l1.addFirst(50);
//		l1.addFirst(60);
//		l1.display();
//		l1.reverseDI();
//		l1.display();
//		l1.reversePI();
//		l1.display();

//		l1.Addlast(1);
//		l1.Addlast(10);
//		l1.Addlast(2);
//		l1.Addlast(20);
//		l1.Addlast(20);
//		l1.Addlast(3);
//		l1.Addlast(30);
//		l1.Addlast(4);
//		l1.Addlast(5);
//		l1.Addlast(60);

//		l1.fold();
//		l1.display();
//		l1.oddEvenSeperation();
//		l1.display();
//		LinkedList.makeCycle(l1);
//		System.out.println(LinkedList.isCycle(l1));
//		l1.display();
//		l1.reversePR();
//		l1.display();

//		LinkedList l2 = new LinkedList();
//		l2.Addlast(5);
//		l2.Addlast(15);
//		l2.Addlast(20);
//		l2.Addlast(50);
//		l2.display();
//
//		LinkedList l3 = LinkedList.mergeTwoSortedLists(l1, l2);
////		LinkedList l4 = mergeTwoSortedLists2(l1, l2);
//		l3.display();

//		System.out.println(l1.isPalindrome());

//		LinkedList l2 = new LinkedList();
//		l2.addFirst(100);
//		l2.display();
//		System.out.println(l2);
//		l2.printThis();
		ArrayList<String> list1 = new ArrayList<>();
		list1.add("Aman");
		list1.add("Geekster");
		list1.add("Cs");
		
		ArrayList<String> list2 = new ArrayList<>();
		list2.add("Gfg");
		list2.add("Dixita");
		list2.add("Physics");
		
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		list.add(list1);
		list.add(list2);
		System.out.println(list.get(1).get(1));
	}

	public static LinkedList mergeTwoSortedLists2(LinkedList l1, LinkedList l2) {
		LinkedList res = new LinkedList();
		while (l1.getsize() > 0 && l2.getsize() > 0) {
			int val1 = l1.getFirst();
			int val2 = l2.getFirst();
			if (val1 < val2) {
				res.Addlast(val1);
				l1.removeFirst();
			} else {
				res.Addlast(val2);
				l2.removeFirst();
			}
		}

		while (l1.getsize() > 0) {
			int val = l1.getFirst();
			res.Addlast(val);
			l1.removeFirst();
		}

		while (l2.getsize() > 0) {
			int val = l2.getFirst();

			res.Addlast(val);
			l2.removeFirst();

		}

		return res;
	}

}
