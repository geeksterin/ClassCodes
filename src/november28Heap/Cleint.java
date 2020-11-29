package november28Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class Cleint {

	public static void main(String[] args) {
//		int[] arr = { 2, 5, 1, 8, 3, 0, 11 };
//		Heap h = new Heap(arr, false);
//		h.display();
////		h.add(10);
////		h.add(30);
////		h.add(9);
////		h.add(15);
////		h.add(40);
////        h.display();
//
////		int[] arr = { 4, 3, 2, 6 };
////		nRopes(arr);

		MedianPQ m = new MedianPQ();
		m.add(10);
		System.out.println(m.peek());
		m.add(100);
		System.out.println(m.peek());
		m.add(90);
		System.out.println(m.peek());
		m.add(80);
		System.out.println(m.peek());
		m.add(110);
		System.out.println(m.peek());
		m.add(105);
		System.out.println(m.peek());
		m.add(120);
		System.out.println(m.peek());
	}

	public static void nRopes(int[] arr) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		for (int val : arr) {
			pq.add(val);
		}

		int cost = 0;
		while (pq.size() > 1) {
			int min = pq.poll();
			int sec_min = pq.poll();
			cost += min + sec_min;
			pq.add(min + sec_min);
		}

		System.out.println(cost);
	}
}
