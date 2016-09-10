package NavigationAlgorithm;
import java.util.*;

//@author nickprimamore

public class FloorTwo implements Graph{
	
	public ArrayList<Node> build(){
		
		ArrayList <String> elevator = new ArrayList();
        elevator.add("Second floor elevator");
        ArrayList <String> desk = new ArrayList();
        desk.add("Cardiac Telemetry");
        desk.add("Cardiothoracic ICU");
        desk.add("Cardiothoracic Stepdown");
        desk.add("Burn Center Control Room");
        desk.add("Burn Surgery Section");
        desk.add("Burn Center Administrator");
        desk.add("Burn Center");
        desk.add("Burn ICU");
        desk.add("Burn Step Down Unit");
        desk.add("Department of Emergency Medicine");



        return new ArrayList<>(
            Arrays.asList( 
                new Node("E8 || E9", elevator, new Edge[]{
                    new Edge(42,"Desk",0),}),                   
                new Node("Desk", desk, new Edge[]{
                    new Edge(42,"E8 || E9",0)})       
                ));            
               
    }
}
