import java.util.Stack;

class HistogramArea {
    public int largestRectangleArea(int[] h) {
        Stack<Integer> st=new Stack<>();
        st.push(-1);
        int ma=0;
        // 2,5,5,5,4,4,3,5
        for(int i=0;i<h.length;i++){
            if(st.peek()==-1||h[st.peek()]<h[i]){
                st.push(i);
            }else{
                while(st.peek()!=-1&&h[st.peek()]>=h[i]){
                   
                    int height=h[st.pop()];
                    int area=height*(i-st.peek()-1);
                    ma=Math.max(area,ma);
                }
                st.push(i);
            }
        }
        while(st.peek()!=-1){
             int height=h[st.pop()];
            int area=height*(h.length-st.peek()-1);
            ma=Math.max(area,ma);
           
        }
        return ma;
    }
}