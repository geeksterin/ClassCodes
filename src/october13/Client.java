package october13;

public class Client {

	public static void main(String[] args) {
		Graph g = new Graph();
		g.addVertex("A");
		g.addVertex("B");

		g.addEdge("A", "B", 0);
		g.addEdge("B", "A", 0);

		System.out.println(g.isCyclic());
	}

}
