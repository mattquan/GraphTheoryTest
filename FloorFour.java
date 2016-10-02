
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectsahara;
import java.util.*;
/**
 *
 * @author yanasang
 */
public class FloorFour extends Graph{
    public ArrayList<Node> build() {
        
        
        return new ArrayList<>(
            Arrays.asList( 
                new Node(Keys.nodeNameElevatorFloorFour, new Edge[]{
                    new Edge(24.321,Keys.nodeNameDeskFloorFour,0),}),                   
                new Node(Keys.nodeNameDeskFloorFour, new Edge[]{
                    new Edge(24.321,Keys.nodeNameElevatorFloorFour,0)})       
                ));            
               
    }
}

