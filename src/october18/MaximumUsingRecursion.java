package october18;

public class MaximumUsingRecursion {

	
	static int findmax(int[] arr,int idx,int maxTillNow) {
		if(idx == arr.length) {
			return maxTillNow;
		}
		
		int maxim = Math.max(maxTillNow, arr[idx]);
		int x =  findmax(arr,idx+1,maxim);
		return x;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,5,3,4};
		int result = findmax(arr,0,0);
		System.out.println(result);

	}

}
