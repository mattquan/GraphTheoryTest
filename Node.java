/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor
 */

package ProjectSahara;
import java.util.*;

/**
 *
 * @author tinawu
 */
public class Node {

    
    private String name;
    private ArrayList<String> description;
    private Edge[] adjacencies;
    private double weight;
    private Path minPath;
    public Node(String name, Edge[] myEdges) { 
        this.name = name;
        adjacencies = myEdges;
        weight = Double.MAX_VALUE;
        minPath = null;
    }
    public Node(String name, ArrayList<String> description, Edge[] myEdges) { 
        this.name = name;
        adjacencies = myEdges;
        weight = Double.MAX_VALUE;
        minPath = null;
        this.description = description;
    }
    public Node () {
        weight = Double.MAX_VALUE;
    }
    public String getName() { 
        return name; 
    }
    public void setName(String name) {
        this.name = name;
    }
    public Edge[] getAdjacentEdges() {
        return adjacencies;
    }
    public void setAdjacentEdges(Edge[] setThis){
        adjacencies = setThis;

    }
    public String toString() {
        return name;
    }
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Path getMinPath() {
        return minPath;
    }

    public void setMinPath(Path minPath) {
        this.minPath = minPath;
    }
}
