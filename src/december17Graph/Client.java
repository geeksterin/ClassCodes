package december17Graph;

import java.util.concurrent.Delayed;

public class Client {

    public static void main(String[] args){
        Graph g = new Graph();
        g.addEdge("Delhi","Jaipur",200);
        g.addEdge("Delhi","Amritsar",500);
        g.addEdge("Amritsar","Dehradun",300);
        g.addEdge("Jaipur","Ahemdabad",500);
        g.addEdge("Amritsar","Jaipur",200);
        g.addEdge("Delhi","Ahemdabad",1000);
        g.addEdge("Delhi","Surat",1987);
//        g.display();
        g.addEdge("Mumbai","Bhopal",10000);
        g.addEdge("Bhopal","Lucknow",2000);

//        g.bfs();
        int ans = g.shortestPathUnWeighted("Surat","Mumbai");
        System.out.print(ans);
//        g.printAllPath("Delhi","Ahemdabad");

//        System.out.println(g.hasPath("Delhi","Ahemdabad"));

//        g.dfs();

    }
}
