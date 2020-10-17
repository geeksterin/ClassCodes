package October14;

import java.util.*;

public class ArrayListClass {

	public static void main(String[] args) {
//		int[] arr = { 10, 20, 30, 40, 50, 5 };
//		ArrayList<Integer> ll = evenElements(arr);
//		System.out.println(ll);
//		ll.add(1, 5);
//		System.out.println(ll);
//		ll.remove(1);
//		System.out.println(ll);
//		for (int i = 0; i < ll.size(); i++) {
//			System.out.print(ll.get(i) + " ");
//		}
//		System.out.println();
//		for (int val : ll) {
//			System.out.print(val + " ");
//		}

		HashMap<Integer, String> hmap = new HashMap<>();
		hmap.put(0, "fdsa");
		hmap.put(4, "fasd");
		System.out.println(hmap);
		ArrayList<Integer> list = new ArrayList<>(hmap.keySet());
		
	}

	public static ArrayList<Integer> evenElements(int[] arr) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int val : arr) {
			if (val % 2 == 0) {
				list.add(val);
			}
		}

		return list;
	}

}
