
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
public class FloorFour implements Graph{
    
    public ArrayList<Node> build() {
        ArrayList <String> elevator = new ArrayList();
        elevator.add("fourth floor elevator");
        ArrayList <String> desk = new ArrayList();
        desk.add("PICU");
        desk.add("pediatric");
        desk.add("childrens center");
        desk.add("kids");
        desk.add("pediatric intensive care unit");
        return new ArrayList<>(
            Arrays.asList( 
                new Node("E8/9-4", elevator, new Edge[]{
                    new Edge(24.321,"desk",0),}),                   
                new Node("desk", desk, new Edge[]{
                    new Edge(24.321,"E8/9-4",0)})       
                ));            
               
    }
}

