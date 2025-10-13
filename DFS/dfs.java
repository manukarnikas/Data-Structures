package DFS;

import java.util.*;

class dfs {

    public static void dfsSearch(Map<String,List<String>> adj, String startNode){
        Stack<String> stack = new Stack<>();
        Set<String> visited = new HashSet<>();
        
        stack.push(startNode);

        while(!stack.isEmpty()){
            String node = stack.pop();
            if(!visited.contains(node)){
                visited.add(node);
                System.out.println(node);

                List<String> adjacentNodes = adj.get(node);
                Collections.reverse(adjacentNodes);
                for(String s:adjacentNodes){
                    stack.push(s);
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

        dfsSearch(adj,"A");
    }
}