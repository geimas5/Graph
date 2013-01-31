/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

/**
 *
 * @author mariusg
 */
public class Vertex {
    private String name;
    private String id;
    
    public Vertex(String name, String id){
        this.name = name;
        this.id = id;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getId(){
        return this.id;
    }
    
    @Override
    public boolean equals(Object c){
        if(!(c instanceof Vertex))
            return false;
        
        Vertex obj = (Vertex)c;
        
        return (
                this.name.equals(obj.name) &&
                this.id.equals(obj.id)
                );
        
    }
    
    @Override
    public int hashCode() {
        int hash = 13;
        hash = (hash * 7) + this.id.hashCode();
        hash = (hash * 7) + this.name.hashCode();
        return hash;
    }
}
