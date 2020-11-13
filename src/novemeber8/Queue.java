package novemeber8;

public class Queue {
	protected int[] data;
	protected int front;
	protected int rear;
	protected int size;

	Queue(int cap) {
		this.front = -1;
		this.rear = -1;
		this.data = new int[cap];
	}

	public void enqueue(int val) throws Exception {
		if (this.size == data.length) {
			throw new Exception("Queue is Full");
		}
		this.rear++;
		this.rear = this.rear % data.length;
		this.data[this.rear] = val;
		if (this.front == -1) {
			this.front++;
		}
		this.size++;
	}

	public int dequeue() throws Exception {
		if (this.size == 0) {
			throw new Exception("Queue is Empty");
		}
		int temp = this.data[this.front];
		this.front++;
		this.front = this.front % data.length;
		this.size--;
		return temp;
	}

	public int front() throws Exception {
		if (size == 0) {
			throw new Exception("Queue is Empty");
		}

		return this.data[this.front];
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0 ? true : false;
	}

	public void display() {
		System.out.println("----------------------------");
		for (int i = 0; i < this.size; i++) {
			System.out.print(data[(front + i) % data.length] + ",");
		}
		System.out.println(".");
		System.out.println("----------------------------");
	}

}
