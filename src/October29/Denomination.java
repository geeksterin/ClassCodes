package October29;

public class Denomination {

	public static int foo(int ruppee,int[] deno,int index) {
		//base case
		if(ruppee == 0) {
			return 1;
		}
		if(ruppee < 0) {
			return 0;
		}
		int count = 0;
		for(int i=index;i<deno.length;i++) {
			count += foo(ruppee-deno[i],deno,i);
		}
		return count;
	}
	
	public static int foo1(int ruppee,int[] deno) {
		//base case
		if(ruppee == 0) {
			return 0;
		}
		
		if(ruppee < 0) {
			return 100000002;
		}
		
		int mincoin = 100000002;
		for(int i=0;i<deno.length;i++) {
			mincoin = Math.min(mincoin,foo1(ruppee-deno[i],deno));
		}
		return mincoin+1;
	}
	
	
	
	
	public static void main(String[] args) {
		int[] denomination = {1,5,7,10,15};
		int num = 10;
		System.out.println(foo(num,denomination,0));
		System.out.println(foo1(14,denomination));
		
	}
}
