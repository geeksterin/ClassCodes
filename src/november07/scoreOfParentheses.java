package november07;

public class scoreOfParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int scoreOfParentheses(String S) {
        Stack<String> st = new Stack<>();
        //run a loop
        for(int i=0;i<S.length();i++){
            int t = 0;
            char currele = S.charAt(i);
            if(currele == ')'){
                while(st.peek().charAt(0) != '('){
                    t += Integer.parseInt(st.pop());
                }
                st.pop();
                if(t==0){
                    st.push("1");
                }
                else{
                    st.push(Integer.toString(2*t));
                }
            }
            else{
                st.push(currele+"");
            }
        }
        
        int ans = 0;
        while(!st.isEmpty())
            ans += Integer.parseInt(st.pop());
        
        return ans;
    }

}
