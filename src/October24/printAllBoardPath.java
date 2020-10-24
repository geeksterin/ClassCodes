package October24;

public class printAllBoardPath {

	public static void printABP(int ques,int n,String ans) {
		// base case
		if(ques == n) {
			System.out.println(ans+"-"+n);
			return;
		}
		if(ques>n) {
			return;
		}
		
		for(int i=1;i<=6;i++) {
			printABP(ques+i,n,ans+"-"+ques);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printABP(1, 5, "");
	}

}
