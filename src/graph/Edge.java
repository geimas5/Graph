/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

/**
 *
 * @author mariusg
 */
public class Edge {
    private String id;
    private Vertex source;
    private Vertex dest;
    private int weight;
    
    public Edge(String id, Vertex source, Vertex dest, int weight){
        this.id = id;
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }
    
    public String getId(){
        return this.id;
    }
    
    public Vertex getSource(){
        return this.source;
    }
    
    public Vertex getDestination(){
        return this.dest;
        
    }
    
    public int getWeight(){
        return this.weight;
    }
    
    @Override
    public boolean equals(Object c){
        if(!(c instanceof Edge))
            return false;
        
        Edge obj = (Edge)c;
        
        return (
                this.id.equals(obj.id) &&
                this.dest.equals(obj.dest) &&
                this.source.equals(obj.source) &&
                this.weight == obj.weight
                );
    }
}
