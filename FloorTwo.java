package ProjectSahara;
import java.util.*;

//@author nickprimamore

public class FloorTwo extends Graph{
	
	public ArrayList<Node> build(){
		
      

        return new ArrayList<>(
                //alphabetical order
            Arrays.asList(                    
                                   
                new Node(Keys.nodeNameDeskFloorTwo, Keys.descriptionDeskFloorTwo, new Edge[]{
                    new Edge(19.963,Keys.nodeNameElevatorFloorTwo,0)}),
                new Node(Keys.nodeNameElevatorFloorTwo, new Edge[]{
                    new Edge(19.963,Keys.nodeNameDeskFloorTwo,0),})
                ));            
               
    }
}
