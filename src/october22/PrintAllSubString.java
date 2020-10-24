package october22;

public class PrintAllSubString {

	public static void findAllSS(String ques,String ans) {
		// base case
		if(ques.equals("")) {
			System.out.println(ans);
			return;
		}
		// with me
		findAllSS(ques.substring(1),ans + ques.charAt(0));
		
		//without me
		findAllSS(ques.substring(1),ans);
		return;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abc";
		findAllSS(s,"");
	}

}
