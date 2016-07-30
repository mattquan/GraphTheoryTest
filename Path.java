package Path;
import java.util.*;
/**
 *
 * @author yanasang
 */
public class Path {
    
    //instance variables
    private double weight;
    private ArrayList <String> path = new ArrayList <String> ();
    
    //constructor
    public Path (Node initialNode, Node finalNode, double weight){
        this.weight = this.weight +weight;
        path.add(initialNode.getName());
        path.add(finalNode.getName());
    }
    
    public void add (Node addThisNode){
        double weightToAdd = addThisNode.getAdjacencies.get(*INDEX*).getWeight()
        weight += weightToAdd;
        path.add(addThisNode.getName());
    }
    
}
