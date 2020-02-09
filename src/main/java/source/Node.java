package source;

import java.util.Comparator;

class Node implements Comparator<Node> { 
    public int node; 
    public int cost;
    public int salida;
    public Node() 
    { 
    } 
  
    public Node(int node, int cost,int salida) 
    { 
        this.node = node; 
        this.cost = cost; 
        this.salida = salida; 
    } 
    
    @Override
    public int compare(Node node1, Node node2) 
    { 
        if (node1.cost < node2.cost) 
            return -1; 
        if (node1.cost > node2.cost) 
            return 1; 
        return 0; 
    } 
}