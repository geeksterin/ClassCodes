package october21;
import java.util.*;

public class getBoardPath {

	public static ArrayList<String> printAllBoardPath(int row,int col,int n){
		
//		/ base case
		if(row == n && col == n) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;

		}
		else if(row > n || col >n) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}
		
		
		ArrayList<String> mr = new ArrayList<>();
		
		ArrayList<String> rr = printAllBoardPath(row+1,col,n);
		for(String ele:rr) {
			mr.add("V"+ele);
		}
		 rr = printAllBoardPath(row,col+1,n);
		 for(String ele:rr) {
			 mr.add("H"+ele);
		 }
		 return mr;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(printAllBoardPath(1,1,2));
	}

}
