package november21;

public class Client {

    public static void main(String[] args){

        int[] arr = {1,2,4,-1,5,-1,-1,3,6,-1,7,8,-1,-1,-1};
        int[] arr2 = {1,2,3,4,5,6,-1,-1,-1,-1,-1};

        BinaryTree bt = new BinaryTree(arr2);
//        bt.display();
//        System.out.println("--------------------");
//        bt.removeLeafs();
//        bt.display();

        bt.printSingleChild();
    }

}
