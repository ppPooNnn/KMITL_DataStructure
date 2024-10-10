package solutions.pack12b_SSP;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {

    int[][] adjMatrix;
    int[] previous, distance;
    boolean[] visted;
    int source;

    public Dijkstra(int[][] adjMatrix, int source) {
        this.adjMatrix = adjMatrix;
        this.source = source;
        previous = new int[adjMatrix.length];
        distance = new int[adjMatrix.length];
        visted = new boolean[adjMatrix.length];
    }
    
    //Task 1 imeplement the findSSP method using Dijkstra's algorithm
    public void findSSP() {
        int N = adjMatrix.length;
        int[] dist = new int[N];
        boolean[] visited = new boolean[N];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{source, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int currentDist = curr[1];

            if (visited[node]) continue;
            visited[node] = true;

            for (int i = 0; i < N; i++) {
                if (adjMatrix[node][i] != -1 && !visited[i]) {
                    int newDist = currentDist + adjMatrix[node][i];
                    if (newDist < dist[i]) {
                        dist[i] = newDist;
                        pq.offer(new int[]{i, newDist});
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println("Node " + i + ": Distance = " + (dist[i] == Integer.MAX_VALUE ? "Infinity" : dist[i]));
        }

    }

    //Task 2 implement the printAllSSP method to print the shortest path 
    //from the source to all other nodes
    public void printAllSSP() {
        int N = adjMatrix.length;

        for (int i = 0; i < N; i++) {
            if (i != source) {
                System.out.print("Shortest path from " + source + " to " + i + " is ");
    
                    StringBuilder path = new StringBuilder();
                    int currentNode = i;
    
                    while (currentNode != -1) {
                        path.insert(0, currentNode);
                        if (previous[currentNode] == -1 || currentNode == source) {
                            break;
                        }
                        path.insert(0, " -> ");
                        currentNode = previous[currentNode];
                    }
    
                    System.out.println(path.toString().trim());
                    System.out.println("with a distance of " + distance[i]);
                    System.out.println();
            }
        }
    }
}