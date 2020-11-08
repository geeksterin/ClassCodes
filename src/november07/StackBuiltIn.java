package november07;

import java.util.Stack;

public class StackBuiltIn {
	public static void main(String[] args) {
		// push
		// pop
		//peek
		//empty
		Stack<Integer> s = new Stack<>();
		s.push(10);
		System.out.println(s.peek());
		s.push(15);
		int top = s.pop();
		System.out.println(top);
		// one element in stack - it will print false
		System.out.println(s.empty());
		s.pop();
		//it will print true
		System.out.println(s.empty());
		s.size()
	}
	
}
