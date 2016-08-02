/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProjectSahara;

/**
 *
 * @author tinawu
 */
public class Node {
    private String name;
    private Edge[] adjacencies;
    public Node(String name, Edge[] myEdges) { 
        this.name = name;
        adjacencies = myEdges;
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

}
