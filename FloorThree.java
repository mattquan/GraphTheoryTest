
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphs;
import java.util.*;
/**
 *
 * @author yanasang
 */
public class FloorThree implements Graph{
    
    public ArrayList<Node> build() {
        ArrayList <String> elevator = new ArrayList();
        elevator.add("third floor elevator");
        ArrayList <String> desk = new ArrayList();
        desk.add("NICU");
        desk.add("premature babies");
        desk.add("neonatal intensive care unit");
        desk.add("babies");
        desk.add("preemies");
        return new ArrayList<>(
            Arrays.asList( 
                new Node("E8/9-3", elevator, new Edge[]{
                    new Edge(27.445,"desk",0),}),                   
                new Node("desk", desk, new Edge[]{
                    new Edge(27.445,"E8/9",0)})       
                ));            
               
    }
}

