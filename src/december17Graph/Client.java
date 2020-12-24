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
//		g.addEdge("A", "D", 40);
//		g.addEdge("B", "A", 10);
//		g.addEdge("B", "C", 10);
//		g.addEdge("C", "D", 10);
//		g.addEdge("D", "E", 2);
//		g.addEdge("F", "E", 3);
//		g.addEdge("E", "G", 8);
//		g.addEdge("F", "G", 3);
//		g.addEdge("C", "F", 100);
		g.addEdge("0", "1", 4);
		g.addEdge("0", "7", 8);
		g.addEdge("1", "2", 8);
		g.addEdge("1", "7", 11);
		g.addEdge("2", "8", 2);
		g.addEdge("2", "3", 7);
		g.addEdge("2", "5", 4);
		g.addEdge("3", "5", 14);
		g.addEdge("3", "4", 9);
		g.addEdge("4", "5", 10);
		g.addEdge("5", "6", 2);
		g.addEdge("6", "8", 6);
		g.addEdge("6", "7", 1);
		g.addEdge("8", "7", 7);
//		g.dijkstra("0");
		Graph h = g.Prims();
		h.display();
		
//		g.display();
//		System.out.println(g.isCyclic());
//		g.hamiltonianPath("A");

	}
}
