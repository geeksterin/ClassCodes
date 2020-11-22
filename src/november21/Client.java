package november21;
import java.util.*;
public class Client {

    public static void main(String[] args){

        int[] arr = {1,2,4,-1,5,-1,-1,3,6,-1,7,-1,-1,-1};
        int[] arr2 = {1,2,3,4,5,6,-1,-1,-1,-1,-1};

        BinaryTree bt = new BinaryTree(arr);
//        bt.display();
//        System.out.println("--------------------");
//        bt.removeLeafs();
//        bt.display();
//
//        ArrayList<BinaryTree.Node> ar = bt.PathNodeToRoot(5);
//        for (BinaryTree.Node n: ar) {
//            System.out.print(n.data +  "  " );
//        }

//        bt.kthDesendentofNode(2,3);
//        System.out.print(bt.maxWidth());
        bt.preIter();
    }


}
