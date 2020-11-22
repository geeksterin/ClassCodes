package november21;

import november15.GenericTree;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Stack;

public class BinaryTree {

    Node root;
    int size;

    public class Node{
        int data;
        Node left;
        Node right;
    }

    public BinaryTree(int[] arr){
        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node node = new Node();
                node.data = arr[i];

                if (size != 0) {
                    if(st.peek().left == null){
                        st.peek().left = node;
                    }
                    else{
                        st.peek().right = node;
                    }
                } else {
                    root = node;
                }
                this.size++;
                st.push(node);
            }
        }



    }

    public void display(){
        display(root);
    }

    private void display(Node node){
        if(node == null){
            return;
        }
        else{
            String str = "";
            str += node.left != null ? node.left.data+" -> " : "$->";
            str += node.right != null ? node.data + "<-" + node.right.data :  node.data + "<-$" ;
            System.out.println(str);
            display(node.left);
            display(node.right);
        }
    }

    // size
    public int size1(){
        return size1(root);
    }

    private int size1(Node node){
        // base case
        if(node == null){
            return 0;
        }

        // lc size
        int lcSize = size1(node.left);

        // rc size
        int rcSize = size1(node.right);

        // return lc + rc + 1;
        return lcSize + rcSize + 1;

    }

    // find the max node
    public int max(){
        return max(root);
    }
    private  int max(Node node){
        if(node == null){
            return Integer.MIN_VALUE;
        }
        int lmv = max(node.left);
        int rmv = max(node.right);
        int mv = Math.max(lmv,rmv);
        return Math.max(mv,node.data);
    }

    // find the min value
    public int min(){
        return min(root);
    }
    private  int min(Node node){
        if(node == null){
            return Integer.MAX_VALUE;
        }
        int lmv = min(node.left);
        int rmv = min(node.right);
        int mv = Math.min(lmv,rmv);
        return Math.min(mv,node.data);
    }


    // height of the tree
    public int height(){
        return height(root);
    }
     private int height(Node node){
        if(node == null){
            return 0;
        }
        else{
            return Math.max(height(node.left),height(node.right)) + 1;
        }
     }

     // whether a element is present or not
    public boolean find(int num){
        return find(root,num);
    }

    private boolean find(Node node,int num){
        if(node == null){
            return false;
        }

        return (node.data == num)||find(node.left,num)||find(node.right,num);
    }

    //Remove leafs

    // check if i am leaf
    // check if left leaf or not
    // check is leaf or not
    // accordingly take decision

    public void removeLeafs(){
        removeLeafs(root);
    }

    private void removeLeafs(Node node){
        // base case
        if(node == null)
            return;
        if(node.left == null && node.right == null){
            return;
        }
        if(isLeaf(node.left)){
            node.left = null;
        }
        if(isLeaf(node.right)){
            node.right = null;
        }
        removeLeafs(node.left);
        removeLeafs(node.right);

    }

    private boolean isLeaf(Node node){
        if(node == null)
            return false;
        if(node.left == null && node.right==null)
            return true;
        else return false;
    }

    public void removeLeafs1(){

        if(root==null){
            return;
        }
        if(isLeaf(root)){
            root = null;
            return;
        }

        removeLeafs1(root,root.left);
        removeLeafs1(root,root.right);
    }

    private void removeLeafs1(Node parent,Node child){
        if(child == null){
            return ;
        }

        if(child.left == null && child.right == null){
            // remove child from parent
            // parent = node left and right
            if(parent.left == child){
                parent.left = null;
            }
            else{
                parent.right = null;
            }
            return;
        }
        removeLeafs1(child,child.left);
        removeLeafs1(child,child.right);

    }

    // print single child
    public void printSingleChild(){
        printSingleChild(root);
    }

    private void printSingleChild(Node node){
        if (node == null){
            return;
        }
        if(node.left != null && node.right == null){
            System.out.print(node.left.data);
            printSingleChild(node.left);
        }
        else if(node.right != null && node.left == null){
            System.out.print(node.right.data);
            printSingleChild(node.right);
        }
        else {
            printSingleChild(node.left);
            printSingleChild(node.right);
        }

    }

    public ArrayList<Node> PathNodeToRoot(int data){
        return PathNodeToRoot(root,data);
    }

    private ArrayList<Node> PathNodeToRoot(Node node,int data){
        // base case
        // if node is null return empty list
        if(node == null){
            ArrayList<Node> ls = new ArrayList<>();
            return ls;
        }

        // if data is found return list with currelement
        if(node.data == data){
            ArrayList<Node> ls = new ArrayList<>();
            ls.add(node);
            return ls;
        }

        // left pe call
        ArrayList<Node> lr = PathNodeToRoot(node.left, data);
        if(lr.size() > 0){
            lr.add(node);
            return lr;
        }

        ArrayList<Node> rr = PathNodeToRoot(node.right,data);
        if(rr.size() > 0){
            rr.add(node);
            return rr;
        }

        return new ArrayList<Node>();

    }

    public void kthDesendentofNode(int data,int k){
        findNodeAndPrint(root,data,k);
    }

    private void findNodeAndPrint(Node node,int data,int k){
        //base case
        // node is null - return
        if(node == null){
            return;
        }
        // node.data is data - extra function printkthdesendent
        if(node.data == data){
            printKthDesendent(node,k);
            return;
        }
        //call to left
        findNodeAndPrint(node.left,data,k);
        // call to right
        findNodeAndPrint(node.right,data,k);
    }

    private void printKthDesendent(Node node, int k){
        if(node == null){
            return ;
        }
        if(k == 0){
            System.out.print(node.data);
            return;
        }
        else{
            printKthDesendent(node.left,k-1);
            printKthDesendent(node.right,k-1);
        }
    }

    public int maxWidth(){
        return maxWidth(root).maxdiameter;
    }

    class pair{
        int height;
        int maxdiameter;
        pair(int h,int md){
            height = h;
            maxdiameter = md;
        }
    }

    public pair maxWidth(Node node){
        // base case
        if(node == null){
            return new pair(0,0);
        }

        pair p1 = maxWidth(node.left);
        pair p2  = maxWidth(node.right);

        // calculate height
        int height = Math.max(p1.height,p2.height)+1;
        int mydiameter = p1.height + p2.height + 1;
        int maxDiameter = Math.max(mydiameter, Math.max(p1.maxdiameter,p2.maxdiameter));
        return new pair(height,maxDiameter);
    }

    class pair1{
        Node node;
        int state;
        pair1(Node n, int s){
            node = n;
            state = s;
        }
    }

    public void preIter(){
        Stack<pair1> stack = new Stack<pair1>();
        pair1 p1 = new pair1(root,0);
        stack.push(p1);
        while(stack.isEmpty() == false){
            pair1 topPair = stack.peek();
            if(topPair.state == 0){
                System.out.print(topPair.node.data + " ");
                topPair.state ++ ;
            }
            else if (topPair.state == 1){
                if(topPair.node.left != null){
                    stack.push(new pair1(topPair.node.left,0));
                }
                topPair.state ++ ;
            }
            else if(topPair.state == 2){
                if (topPair.node.right != null){
                    stack.push(new pair1(topPair.node.right,0));
                }
                topPair.state++;
            }
            else{
                stack.pop();
            }
        }
    }

}
