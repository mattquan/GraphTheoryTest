/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectsahara;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author mattquan
 */
public class Keys {
    //floor ground
    final public static String nodeNameHallwayFloorGroundA = "hallwayFloorGroundA";
    final public static String nodeNameHallwayFloorGroundB = "hallwayFloorGroundB";
    final public static String nodeNameHallwayFloorGroundC = "hallwayFloorGroundC";
    final public static String nodeNameEastWingFloorGround = "eastWingGround";
    final public static String nodeNameElevatorFloorGround = "elevatorFloorGround";
    
    //floor one
    final public static String nodeNameHallwayFloorOneA = "hallwayFloorOneA";
    final public static String nodeNameHallwayFloorOneB = "hallwayFloorOneB";
    final public static String nodeNameHallwayFloorOneC = "hallwayFloorOneC";
    final public static String nodeNameHallwayFloorOneD = "hallwayFloorOneD";
    final public static String nodeNameHallwayFloorOneE = "hallwayFloorOneE";
    final public static String nodeNameHallwayFloorOneF = "hallwayFloorOneF";
    final public static String nodeNameElevatorFloorOne = "elevatorFloorOne";
    
    //floor two
    final public static String nodeNameElevatorFloorTwo = "elevatorFloorTwo";
    final public static String nodeNameDeskFloorTwo = "deskFloorTwo";
    final public static ArrayList<String> descriptionDeskFloorTwo  = new ArrayList<>(Arrays.asList(
            "Cardiac Telemetry",
            "Cardiothoracic ICU",
            "Cardiothoracic ICU",
            "Burn Center Control Room",
            "Burn Surgery Section",
            "Burn Center Administration",
            "Burn Center Administrator",
            "Burn Center",
            "Burn ICU",
            "Burn Intensive Care Unit",
            "Burn Step Down Unit",
            "Department of Emergency Medicine"
    ));
    

    //floor three
    final public static String nodeNameElevatorFloorThree = "elevatorFloorThree";
    final public static String nodeNameDeskFloorThree = "deskFloorThree";
    final public static ArrayList<String> descriptionDeskFloorThree = new ArrayList<>(Arrays.asList(
            "NICU",
            "premature babies",
            "neonatal intensive care unit",
            "babies",
            "baby",
            "preemies" 
    ));  
    
    //floor four
    final public static String nodeNameElevatorFloorFour = "elevatorFloorFour";
    final public static String nodeNameDeskFloorFour = "deskFloorFour";
    final public static ArrayList<String> descriptionDeskFloorFour = new ArrayList<>(Arrays.asList(
            "PICU",
            "pediatric",
            "childrens center",
            "kids",
            "pediatric intensive care unit"
    ));
    
          
            
    //rooms!
    final public static ArrayList<Node> floorGroundRooms = new ArrayList<>(Arrays.asList(
            new Node(Keys.nodeNameEastWingFloorGround,  new Edge[]{
                    new Edge(324.2,Keys.nodeNameHallwayFloorGroundA,0),
                    new Edge(369,Keys.nodeNameHallwayFloorGroundB,1)
                })
    ));
    
   
    
            
            
    
   public static ArrayList<Node> add(ArrayList<Node> myList, Node addThis) 
    {
        for(int index = 0; index < myList.size(); index++)
        {
        	String addThisName = addThis.getName();
        	String nodeInMyListName = myList.get(index).getName();
        	
        	if((addThisName.compareToIgnoreCase(nodeInMyListName)) < 0)
        			{
        				myList.add(index, addThis);
        				return myList;
        			}   	
        }
        
        myList.add(addThis);
        return myList;
    }

}
