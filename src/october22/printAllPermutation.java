package october22;

public class printAllPermutation {

	public static void printAllP(String ques,String ans) {
		
		if(ques.equals("")) {
			System.out.println(ans);
			return;
		}
		
		for(int i=0;i<ques.length();i++) {
			String newQ = ques.substring(0,i)+ques.substring(i+1);
							//starting          //ending
			Sting newA = ans+ques.charAt(i);
			
			printAllP(newQ,newA);
		}
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abc";
		printAllP("abc","");
	}

}
