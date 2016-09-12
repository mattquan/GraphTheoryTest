package ProjectSahara;
import java.util.*;

//@author nickprimamore

public class FloorTwo implements Graph{
	
	public ArrayList<Node> build(){
		
        


        return new ArrayList<>(
                //alphabetical order
            Arrays.asList(                    
                                   
                new Node(Keys.nodeNameDeskFloorTwo, Keys.descriptionDeskFloorTwo, new Edge[]{
                    new Edge(42,Keys.nodeNameElevatorFloorTwo,0)}),
                new Node(Keys.nodeNameElevatorFloorTwo, new Edge[]{
                    new Edge(42,Keys.nodeNameDeskFloorTwo,0),})
                ));            
               
    }
}
