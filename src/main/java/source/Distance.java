package source;


import java.util.ArrayList;
import java.util.List;

class Distance  {
    public List <Node> recorrido;
    public Distance() {
        recorrido = new ArrayList<Node>();
    }
    public boolean add(Node n){
        if (this.recorrido.size() !=0 ){
            if ( this.get_total_time()>n.salida)
                return false;
        }
        recorrido.add(n);
        return true;
    }
    public int get_cost(){
        return this.get_total_time();
        
        
        /*
        int result = 0;
        for (Node nodo : this.recorrido){
            result += nodo.cost;
        }
        return result;*/
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
            s+= "\ndestino: "+nodo.node+" ,costo: "+nodo.cost+", salida: "+nodo.salida;
        }
        return s;
    }

    int get_last_salida() {
        return this.recorrido.get(this.recorrido.size()-1).salida;
    }

    int get_total_time() {
        return this.get_last_salida()+this.recorrido.get(this.recorrido.size()-1).cost;
    }
}