/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

/**
 *
 * @author mariusg
 */
public interface IPathAlgorithm {
    Vertex[] calculatePath(Vertex start, Vertex end, IGraph graph);
}
