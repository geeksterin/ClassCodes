package december17Graph;

import java.util.concurrent.Delayed;

public class Client {

	public static void main(String[] args) {
		Graph g = new Graph();
//		g.addEdge("Delhi", "Jaipur", 200);
//		g.addEdge("Delhi", "Amritsar", 500);
//		g.addEdge("Amritsar", "Dehradun", 300);
//		g.addEdge("Jaipur", "Ahemdabad", 500);
//		g.addEdge("Amritsar", "Jaipur", 200);
//		g.addEdge("Delhi", "Ahemdabad", 1000);
//		g.addEdge("Delhi", "Surat", 1987);
////        g.display();
//		g.addEdge("Mumbai", "Bhopal", 10000);
//		g.addEdge("Bhopal", "Lucknow", 2000);

//        g.bfs();
//		int ans = g.shortestPathUnWeighted("Surat", "Mumbai");
//		System.out.print(ans);
//        g.printAllPath("Delhi","Ahemdabad");

//        System.out.println(g.hasPath("Delhi","Ahemdabad"));

//        g.dfs();\\g.addEdge("A", "D", 40);
		g.addEdge("A", "D", 40);
		g.addEdge("B", "A", 10);
		g.addEdge("B", "C", 10);
		g.addEdge("C", "D", 10);
		g.addEdge("D", "E", 2);
		g.addEdge("F", "E", 3);
		g.addEdge("E", "G", 8);
		g.addEdge("F", "G", 3);
		g.addEdge("C", "F", 100);
		
//		g.display();
//		System.out.println(g.isCyclic());
		g.hamiltonianPath("A");

	}
}
