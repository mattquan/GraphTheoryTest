/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectSahara;
import java.util.*;

/**
 *
 * @author Steffi
 */
public class FloorOne extends Graph{
    public ArrayList<Node> build(){
        
        
        return new ArrayList<>(
                Arrays.asList(
                    new Node(Keys.nodeNameHallwayFloorOneA,  new Edge[]{
                        new Edge(22.2, Keys.nodeNameHallwayFloorOneB,0)
                    }),
                    new Node(Keys.nodeNameHallwayFloorOneB, new Edge[]{
                        new Edge(22.2, Keys.nodeNameHallwayFloorOneA, 0),
                        new Edge(10.7, Keys.nodeNameHallwayFloorOneC, 1),
                        new Edge (13.3, Keys.nodeNameHallwayFloorOneD, 2)
                    }),
                    new Node(Keys.nodeNameHallwayFloorOneC, new Edge[]{
                        new Edge(10.7, Keys.nodeNameHallwayFloorOneB, 0),
                        new Edge(21.7, Keys.nodeNameHallwayFloorOneD, 1),
                        new Edge(39.9, Keys.nodeNameHallwayFloorOneF, 2)
                    }),
                    new Node(Keys.nodeNameHallwayFloorOneD, new Edge[]{
                        new Edge(13.3, Keys.nodeNameHallwayFloorOneB, 0),
                        new Edge(21.7, Keys.nodeNameHallwayFloorOneC, 1),
                        new Edge(10.7, Keys.nodeNameHallwayFloorOneE, 2)
                    }),
                    new Node(Keys.nodeNameHallwayFloorOneE, new Edge[]{
                        new Edge(10.7, Keys.nodeNameHallwayFloorOneD, 0)
                    }),
                    new Node(Keys.nodeNameHallwayFloorOneF, new Edge[]{
                        new Edge(39.9, Keys.nodeNameHallwayFloorOneC, 0)
                    }),
                    new Node(Keys.nodeNameHallwayFloorOneG, new Edge[]{
                        new Edge(14.138, Keys.nodeNameHallwayFloorOneB, 0)
                    }),
                    new Node(Keys.nodeNameElevatorFloorOne, new Edge[]{
                        new Edge(10.5, Keys.nodeNameHallwayFloorOneA, 0),
                        new Edge(11.7, Keys.nodeNameHallwayFloorOneB, 1)
                    })          
                        
                    ));                        
    }
}
