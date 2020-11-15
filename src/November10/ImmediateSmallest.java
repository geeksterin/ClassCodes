package November10;

import java.util.ArrayList;
import java.util.Stack;

public class ImmediateSmallest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> s = new Stack<>();
		int arr[] = {1,10,5,2,1,100,200,500,150};
		ArrayList<Integer> ans = new ArrayList<>();
		for(int i=0;i<arr.length;i++) {
			//what is my ans - i will keep removing from stack untill
			//either it is not empty and top is greater equals me
			while(!s.isEmpty() && s.peek()>=arr[i]) {
				s.pop();
			}
			int sol = -1;
			if(!s.isEmpty()) {
				sol = s.peek();
			}
			ans.add(sol);
			
			s.push(arr[i]);
		}
		
		System.out.println(ans);
		
	}

}
