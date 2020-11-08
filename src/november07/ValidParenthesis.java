package november07;

public class ValidParenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	public boolean isValid(String s) {
	    Stack<String> st = new Stack<>();
	    for(int i=0;i<s.length();i++){
	        if(s.charAt(i) == '(' || s.charAt(i)=='{' || s.charAt(i)=='['){
	            st.push(s.charAt(i)+"");
	        }
	        else{
	            String curcha = s.charAt(i) + "";
	            if(st.empty()){
	                return false;
	            }
	            String top = st.pop();
	            if((top.equals("(") && curcha.equals(")")) || (top.equals("{") && curcha.equals("}")) || (top.equals("[") && curcha.equals("]"))){
	                continue;
	            }
	            else{
	                return false;
	            }
	        }
	    }
	    // System.out.println(st.size());
	    if(st.size() == 0){
	        return true;
	    }
	    else{
	        return false;
	    }
	    
	}

}
