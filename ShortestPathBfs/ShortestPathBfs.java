package ShortestPathBfs;

import java.util.*;

class ShortestPathBfs {

    public static void bfsSearch(Map<String,List<String>> adj, String startNode, String targetNode){
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Map<String,String> parentMap = new HashMap<>();
        
        System.out.println("Traversal:");
        System.out.print(startNode);
        visited.add(startNode);
        queue.add(startNode);
        parentMap.put(startNode,null);

        while(!queue.isEmpty()){
            String node = queue.poll();

            if(node == targetNode){
                break;
            }
           
            List<String> adjacentNodes = adj.get(node);
            for(String s:adjacentNodes){
                if(!visited.contains(s)){
                    visited.add(s);
                    System.out.print(s);
                    queue.add(s);
                    parentMap.put(s,node);
                }
            }
        }

        //shortest path
        List<String> shortestPathList = new LinkedList<>();
        String node = targetNode;
        System.out.println("\nShortest Path:");
        shortestPathList.add(node);
        while(node!=null){
            String parentNode = parentMap.get(node);
            if(parentNode == startNode){
                shortestPathList.add(startNode);
                break;
            }
            shortestPathList.add(parentNode);
            node=parentNode;
        }
        Collections.reverse(shortestPathList);
        System.out.print(String.join("",shortestPathList));
    }

    public static void main(String args[]){
        //Adjacency Matrix
        Map<String,List<String>> adj = new HashMap<>();
        adj.put("A", Arrays.asList("B", "D"));
        adj.put("B", Arrays.asList("A", "C", "E"));
        adj.put("C", Arrays.asList("B", "F"));
        adj.put("D", Arrays.asList("A", "E"));
        adj.put("E", Arrays.asList("B", "D", "F"));
        adj.put("F", Arrays.asList("C", "E"));

        bfsSearch(adj,"A","F");
    }
}