package BFS;

import java.util.*;

class bfs {

    public static void bfsSearch(Map<String,List<String>> adj, String startNode){
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        System.out.println(startNode);
        visited.add(startNode);
        queue.add(startNode);

        while(!queue.isEmpty()){
            String node = queue.poll();
           
            List<String> adjacentNodes = adj.get(node);
            for(String s:adjacentNodes){
                if(!visited.contains(s)){
                    visited.add(s);
                    visited.add(s);
                    queue.add(s);
                }
            }
        }
    }

    public static void main(String args[]){
        //Adjacency Matrix
        Map<String,List<String>> adj = new HashMap<>();
        adj.put("A", Arrays.asList("B", "C"));
        adj.put("B", Arrays.asList("A", "D", "E"));
        adj.put("C", Arrays.asList("A", "F"));
        adj.put("D", Arrays.asList("B"));
        adj.put("E", Arrays.asList("B"));
        adj.put("F", Arrays.asList("C"));

        bfsSearch(adj,"A");
    }
}