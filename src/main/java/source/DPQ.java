package source;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*; 
public class DPQ { 
    private Distance dist[]; 
    private Set<Integer> settled; 
    private PriorityQueue<Node> pq; 
    private int V; // Number of vertices 
    List<List<Node> > adj; 
  
    public DPQ(int V) 
    { 
        this.V = V; 
        dist = new Distance[V]; 
        for (int i=0;i<V;++i ){
            dist[i]=new Distance();
        }
        settled = new HashSet<Integer>(); 
        pq = new PriorityQueue<Node>(V, new Node()); 
    } 
  
    // Function for Dijkstra's Algorithm 
    public void dijkstra(List<List<Node> > adj, int src) 
    { 
        this.adj = adj; 
  
        for (int i = 0; i < V; i++) 
            dist[i].add(new Node(src, 100000)); 
  
        // Add source node to the priority queue 
        pq.add(new Node(src, 0)); 
  
        // Distance to the source is 0 
        Distance foo = new Distance();
        foo.add(new Node (src,0));
        dist[src] = foo;
        while (settled.size() != V) { 
  
            // remove the minimum distance node  
            // from the priority queue  
            int u = pq.remove().node; 
  
            // adding the node whose distance is 
            // finalized 
            settled.add(u); 
  
            e_Neighbours(u); 
        } 
    } 
  
    // Function to process all the neighbours  
    // of the passed node 
    private void e_Neighbours(int u) 
    { 
        Distance newDistance = new Distance(); 
  
        // All the neighbors of v 
        for (int i = 0; i < adj.get(u).size(); i++) { 
            Node v = adj.get(u).get(i); 
  
            // If current node hasn't already been processed 
            if (!settled.contains(v.node)) { 
                //newDistance = dist[u] + edgeDistance; 
                newDistance = dist[u].copy();
                newDistance.add(v);
  
                // If new distance is cheaper in cost 
                //if (newDistance < dist[v.node]) 
                if (newDistance.is_less(dist[v.node]))
                    dist[v.node] = newDistance; 
  
                // Add the current node to the queue 
                pq.add(new Node(v.node, dist[v.node].get_cost())); 
            } 
        } 
    } 
    // Driver code 
    public static void main(String arg[]) 
    { 
        int V = 5; 
        int source = 0; 
  
        // Adjacency list representation of the  
        // connected edges 
        List<List<Node> > adj = new ArrayList<List<Node> >(); 
  
        // Initialize list for every node 
        for (int i = 0; i < V; i++) { 
            List<Node> item = new ArrayList<Node>(); 
            adj.add(item); 
        } 
  
        // Inputs for the DPQ graph 
        adj.get(0).add(new Node(1, 9)); 
        adj.get(0).add(new Node(2, 6)); 
        adj.get(0).add(new Node(3, 5)); 
        adj.get(0).add(new Node(4, 3)); 
  
        adj.get(2).add(new Node(1, 2)); 
        adj.get(2).add(new Node(3, 4)); 
  
        // Calculate the single source shortest path 
        DPQ dpq = new DPQ(V); 
        dpq.dijkstra(adj, source); 
  
        // Print the shortest path to all the nodes 
        // from the source node 
        System.out.println("The shorted path from node :"); 
        for (int i = 0; i < dpq.dist.length; i++) 
            System.out.println(source + " to " + i + " is "
                               + dpq.dist[i].get_cost()+ dpq.dist[i].to_String()); 
    } 
} 
  
// Class to represent a node in the graph 
 
