package december17Graph;

import december3.HashMap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class Graph {

    HashMap<String,HashMap<String,Integer> > graph = new HashMap<>();

    private boolean containsVertex(String v){
        if (graph.containsKey(v)){
            return true;
        }
        else{
            graph.put(v,new HashMap<>());
        }
        return true;
    }

    public void addEdge(String v1,String v2,int wt){
        if (containsVertex(v1) && containsVertex(v2)){
            graph.get(v1).put(v2,wt);
            graph.get(v2).put(v1,wt);
        }
    }

    public void display(){
        ArrayList<String> cities = new ArrayList<>(graph.keySet());
        for (String city: cities) {
            System.out.print(city + "----> ");
            ArrayList<String> connectedCities = new ArrayList<>(graph.get(city).keySet());
            for (String connectedCity:connectedCities) {
                System.out.print("( " + connectedCity + " , " + graph.get(city).get(connectedCity) + " )");
            }
            System.out.println();
        }
    }

    public void printAllPath(String s,String d){
        HashSet<String> visited = new HashSet<>();
        printAllPath(s,d,"",visited);
    }

    private void printAllPath(String src,String dest,String path,HashSet<String> visited){
        if (src.equals(dest)){
            System.out.println(path + dest);
            return;
        }

        visited.add(src);
        ArrayList<String> connectedCities = graph.get(src).keySet();
        for (String connectedCity: connectedCities ) {
            if (visited.contains(connectedCity)){
                continue;
            }
            printAllPath(connectedCity,dest,path+src+ "--> ",visited);
        }
        visited.remove(src);
    }

    public boolean hasPath(String src,String dest){
        HashSet<String> visited = new HashSet<>();
        return hasPath(src,dest,visited);
    }

    private boolean hasPath(String src,String dest,HashSet<String> visited){
        if(src.equals(dest)){
            return true;
        }
        visited.add(src);
        ArrayList<String> neighbours = new ArrayList<>(graph.get(src).keySet());
        for (String neighbour: neighbours) {
            if (visited.contains(neighbour)){
                continue;
            }
            boolean ans = hasPath(neighbour,dest,visited);
            if(ans == true){
                return true;
            }
        }

        return false;
    }


    public void dfs(){
        ArrayList<String> cities = new ArrayList<>(graph.keySet());
        HashSet<String> visited = new HashSet<>();
        for (String city : cities) {
            if(visited.contains(city)){
                continue;
            }
            dfs(city,visited);
        }
    }

    private void dfs(String src,HashSet<String> visited){
        visited.add(src);
        System.out.print(src + "-->");
        ArrayList<String> neighbours = new ArrayList<>(graph.get(src).keySet());
        for (String neighbour: neighbours) {
            if(visited.contains(neighbour)){
                continue;
            }
            dfs(neighbour,visited);
        }
    }


    public void bfs(){
        ArrayList<String> cities = new ArrayList<>(graph.keySet());
        HashSet<String> visited = new HashSet<>();
        for (String city : cities) {
            if(visited.contains(city)){
                continue;
            }
            LinkedList<String> q = new LinkedList<>();
            q.addLast(city);
            while (q.size() > 0){
                String currCity = q.removeFirst();
                if(visited.contains(currCity)){
                    continue;
                }
                visited.add(currCity);
                System.out.print(currCity + "......");
                ArrayList<String> neighbours = new ArrayList<>(graph.get(currCity).keySet());
                for (String neighbour: neighbours){
                    if(visited.contains(neighbour)){
                        continue;
                    }
                    q.addLast(neighbour);
                }
            }

        }
    }

    public int shortestPathUnWeighted(String src,String dest){
        HashSet<String> visited = new HashSet<>();
        LinkedList<String> q = new LinkedList<>();
        q.addLast(src);
        q.addLast(null);
        int level = 0;
        while (!(q.size() == 1 && q.getFirst()==null)){
            String currCity = q.removeFirst();
            if(currCity == null){
                level++;
                q.addLast(null);
                continue;
            }
            if(visited.contains(currCity)){
                continue;
            }
            if(currCity == dest){
                return level;
            }
            visited.add(currCity);
            ArrayList<String> neighbours = new ArrayList<>(graph.get(currCity).keySet());
            for (String neighbour: neighbours){
                if(visited.contains(neighbour)){
                    continue;
                }
                q.addLast(neighbour);
            }
        }
        return -1;
    }


}
