package october22;
import java.util.*;

public class AllPathwithDiagnol {

	public static ArrayList<String> AllPathWD(int r,int c,int er,int ec){
		// base case
		if(r == er && c == ec) {
			ArrayList<String> br = new ArrayList<String>();
			br.add("");
			return br;
		}
		
		else if(r > er || c >ec) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}
		
		
		// recursion pls give me result if i will horizontally
		ArrayList<String> mr= new ArrayList<>();
		ArrayList<String> rr = AllPathWD(r,c+1,er,ec);
		for(String ele:rr) {
			mr.add("H"+ele);
		}
		
		// Vertical result
		rr = AllPathWD(r+1,c,er,ec);
		for(String ele:rr) {
			mr.add("V"+ele);
		}		
		
		rr = AllPathWD(r+1,c+1,er,ec);
		for(String ele:rr) {
			mr.add("D"+ele);
		}
		
		return mr;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3,m = 3;
		System.out.println(AllPathWD(1,1,n,m));
	}

}
