package October24;

public class KeyPadProblem {
	
	public static String keypad(char num) {
		if(num == '1') {
			return "-";
		}
		
		if(num == '2') {
			return "abc";
		}

		if(num == '3') {
			return "def";
		}
 
		if(num == '4') {
			return "ghi";
		}

		if(num == '5') {
			return "jkl";
		}

		if(num == '6') {
			return "mno";
		}

		if(num == '7') {
			return "pqrs";
		}
		
		if(num == '8') {
			return "tuv";
		}
		if(num == '9') {
			return "wxyz";
		}
		return "";
	}
	
	
	public static void printKP(String ques,String ans) {
		// base case
		
		if(ques.equals("")) {
			System.out.println(ans);
			return;
		}
		
		// take first character of ques - find keypad string
		String keyPadString = keypad(ques.charAt(0));
		
		// iterate over keypad string and add it into ans and call the recursion
		for(int i=0;i<keyPadString.length();i++) {
			printKP(ques.substring(1),ans+keyPadString.charAt(i));
		}
		
		
	}
	
	public static void main(String[] args) {
		printKP("","");
	}
	
	
	
}
