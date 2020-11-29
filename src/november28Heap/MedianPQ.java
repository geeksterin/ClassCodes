package november28Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianPQ {
	PriorityQueue<Integer> maxPQ = new PriorityQueue<Integer>(Collections.reverseOrder());
	PriorityQueue<Integer> minPQ = new PriorityQueue<Integer>();

	public void add(int data) {
		if (maxPQ.size() == 0 && minPQ.size() == 0) {
			maxPQ.add(data);
		} else if (maxPQ.size() == 0) {
			maxPQ.add(data);
		} else if (minPQ.size() == 0) {
			minPQ.add(data);
		} else {
			if (data < maxPQ.peek()) {
				maxPQ.add(data);
			} else {
				minPQ.add(data);
			}

			balance();
		}
	}

	private void balance() {
		if (maxPQ.size() - minPQ.size() > 1) {
			minPQ.add(maxPQ.remove());
		} else if (minPQ.size() - maxPQ.size() > 1) {
			maxPQ.add(minPQ.remove());
		}
	}

	public int remove() {
		int x;
		if (maxPQ.size() >= minPQ.size()) {
			x = maxPQ.remove();
		} else {
			x = minPQ.remove();
		}
		balance();
		return x;
	}

	public int peek() {
		return maxPQ.size() >= minPQ.size() ? maxPQ.peek() : minPQ.peek();
	}
}
