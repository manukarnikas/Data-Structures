package Dijkstra;

/*

  Graph:
      (2)
  A ----- B
  | \     |
 (4) (5) (1)
  |     \ |
  C-------D
     (3)

 
  Note: 
    Dijkstra's algorithm is bfs with priority queue
 
  output:
    Shortest distance from A to A = 0
    Path from A to A: A

    Shortest distance from A to B = 2
    Path from A to B: A -> B

    Shortest distance from A to C = 4
    Path from A to C: A -> C

    Shortest distance from A to D = 3
    Path from A to D: A -> B -> D

 */

 import java.util.*;

 class Edge {
     String target;
     int weight;
 
     Edge(String target, int weight) {
         this.target = target;
         this.weight = weight;
     }
 }
 
 public class Dijkstra {
 
     public static Map<String, Integer> dijkstra(Map<String, List<Edge>> graph, String start,
                                                Map<String, String> previous) {
         Map<String, Integer> distances = new HashMap<>();
         for (String node : graph.keySet()) {
             distances.put(node, Integer.MAX_VALUE);
             previous.put(node, null);
         }
         distances.put(start, 0);
 
         PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                 Map.Entry.comparingByValue()
         );
         pq.add(new AbstractMap.SimpleEntry<>(start, 0));
 
         while (!pq.isEmpty()) {
             String current = pq.poll().getKey();
             int currentDist = distances.get(current);
 
             for (Edge edge : graph.get(current)) {
                 int newDist = currentDist + edge.weight;
                 if (newDist < distances.get(edge.target)) {
                     distances.put(edge.target, newDist);
                     previous.put(edge.target, current);  // track path
                     pq.add(new AbstractMap.SimpleEntry<>(edge.target, newDist));
                 }
             }
         }
         return distances;
     }
 
     // Helper to reconstruct and print path
     public static void printPath(String start, String end, Map<String, String> previous) {
         List<String> path = new ArrayList<>();
         for (String at = end; at != null; at = previous.get(at)) {
             path.add(at);
         }
         Collections.reverse(path);
 
         if (!path.get(0).equals(start)) {
             System.out.println("No path from " + start + " to " + end);
         } else {
             System.out.println("Path from " + start + " to " + end + ": " + String.join(" -> ", path));
         }
     }
 
     public static void main(String[] args) {
         // Build the graph (same as before)
         Map<String, List<Edge>> graph = new HashMap<>();
         graph.put("A", Arrays.asList(new Edge("B", 2), new Edge("C", 4), new Edge("D", 5)));
         graph.put("B", Arrays.asList(new Edge("A", 2), new Edge("D", 1)));
         graph.put("C", Arrays.asList(new Edge("A", 4), new Edge("D", 3)));
         graph.put("D", Arrays.asList(new Edge("A", 5), new Edge("B", 1), new Edge("C", 3)));
 
         Map<String, String> previous = new HashMap<>();
         Map<String, Integer> distances = dijkstra(graph, "A", previous);
 
         // Print all shortest paths
         for (String node : graph.keySet()) {
             System.out.println("\nShortest distance from A to " + node + " = " + distances.get(node));
             printPath("A", node, previous);
         }
     }
 }
 
