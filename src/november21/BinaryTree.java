package november21;

import november15.GenericTree;

import java.util.Stack;

public class BinaryTree {

    Node root;
    int size;

    private class Node{
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



}
