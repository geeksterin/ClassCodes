package October24;

public class print2DBoardPath {

	public static void printPaths(int x,int y,int n,String ans){
		// base case
		if(x==n && y==n) {
			System.out.println(ans);
			return;
		}
		if(x >n || y>n) {
			return;
		}
		
		printPaths(x,y+1,n,ans+"H");
		printPaths(x+1,y,n,ans+"V");
		printPaths(x+1,y+1,n,ans+"D");
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printPaths(1,1,3,"");
	}

}
