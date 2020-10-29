package October29;
public class RodCuttingProblem {
	public static int cutRod(int n,int price[],int lengths[])
	{
		if (n <= 0)
			return 0;
		int max_val = Integer.MIN_VALUE;
		// Recursively cut the rod in different pieces and compare different 
		//configurations
		for (int i = 0; i<lengths.length; i++) {
			if(lengths[i]<=n)
				max_val = Math.max(max_val,price[i]+cutRod(n-lengths[i],price,lengths));
		}
		return max_val;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] length = {1,3,7,10};
		int[] price = {2,5,10,25};
		System.out.println(cutRod(13,price,length));
	}
	
}
