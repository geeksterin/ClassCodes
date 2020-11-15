package November12;

import java.util.LinkedList;
import java.util.Queue;

public class QueueInbuilt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> q = new LinkedList<>();
		q.add(10);
		q.add(5);
		q.add(100);
		System.out.println(q);
		q.remove();
		System.out.println(q);
		System.out.println(q.isEmpty());
		
	}

}
