/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.*;
import java.util.Map.Entry;


/**
 *
 * @author mariusg
 */
public class Dijkstra implements IPathAlgorithm {
    
    private AbstractMap<Vertex, Integer> distance = null;
    private AbstractMap<Vertex, Vertex> previous = null;
    private ArrayList<Vertex> settled;
    private ArrayList<Vertex> unSettled;
    
    public Dijkstra(){
        
    }

    @Override
    public Vertex[] calculatePath(Vertex start, Vertex end, IGraph graph) {
        initialize(start);
        
        while(this.unSettled.size() > 0) {
            Vertex v = findMin();
            unSettled.remove(v);
            settled.add(v);
            
            for(Edge e: graph.findEdges(v)){
                Vertex u = e.getDestination();
                
                if(unSettled.contains(u)) {
                    int origDist = getDistanceEntry(u);
                    int currDist = this.distance.get(v) + e.getWeight();
                    
                    if(currDist < origDist){
                        this.distance.put(u, currDist);
                        this.previous.put(u, v);
                    }
                }
                else if(!settled.contains(u)) {
                   this.distance.put(u, this.distance.get(v) + e.getWeight());
                   this.previous.put(u, e.getSource());
                   this.unSettled.add(u);
                }
            }
        }
        
        LinkedList<Vertex> path = new LinkedList<>();
        path.add(end);
        
        Vertex current = end;
        while(!current.equals(start)){
            current = this.previous.get(current);
            path.add(0, current);
        }
        
        Vertex[] toReturn = new Vertex[path.size()];
        return path.toArray(toReturn);
    }
    
    private void initialize(Vertex start) {
        this.distance = new HashMap<>();
        this.previous = new HashMap<>();
        this.settled = new ArrayList<>();
        this.unSettled = new ArrayList<>();
        
        this.distance.put(start, 0);
        this.unSettled.add(start);
    }
    
    private Vertex findMin(){
        Vertex min = null;
        int dist = Integer.MAX_VALUE;
        
        for(Vertex v : this.unSettled){
            int vDist = this.distance.get(v);
            
            if(vDist < dist){
                min = v;
                dist = vDist;
            }
        }
        
        return min;
    }
    
    private int getDistanceEntry(Vertex vertex){
        Integer dist = this.distance.get(vertex);
        if(dist == null) return Integer.MAX_VALUE;
        
        return dist;
    }
}
