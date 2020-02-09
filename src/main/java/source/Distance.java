package source;


import java.util.ArrayList;
import java.util.List;

class Distance  {
    public List <Node> recorrido;
    public Distance() {
        recorrido = new ArrayList<Node>();
    }
    public void add(Node n){
        recorrido.add(n);
    }
    public int get_cost(){
        int result = 0;
        for (Node nodo : this.recorrido){
            result += nodo.cost;
        }
        return result;
    }
    public boolean is_less(Distance d){
        return this.get_cost()<d.get_cost();
    }
    public Distance copy() {
        Distance foo = new Distance();
        for (Node nodo : this.recorrido){
            foo.add(nodo);
        }
        return foo;
    }
    
    public String to_String(){
        String s = "";
        for (Node nodo : this.recorrido){
            s+= "\ndestino: "+nodo.node+" ,costo: "+nodo.cost;
        }
        return s;
    }
}