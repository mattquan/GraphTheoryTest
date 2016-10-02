
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
public class FloorThree extends Graph{
    
    public ArrayList<Node> build() {
        
        
        return new ArrayList<>(
            Arrays.asList( 
                new Node(Keys.nodeNameElevatorFloorThree, new Edge[]{
                    new Edge(27.445,Keys.nodeNameDeskFloorThree,0),}),                   
                new Node(Keys.nodeNameDeskFloorThree, new Edge[]{
                    new Edge(27.445,Keys.nodeNameElevatorFloorThree,0)})       
                ));            
               
    }
}

