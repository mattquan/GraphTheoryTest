/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProjectSahara;

/**
 *
 * @author tinawu
 */
import java.util.*;

public class Path {
    
    //instance variables
    private double weight;
    private ArrayList <String> path = new ArrayList <String> ();
    
    //constructor
    public Path (String initialNode, String finalNode){
        //this.weight = weight;
        path.add(initialNode);
        path.add(finalNode);
    }
    public Path (String initialNode, String finalNode, double weight){
        this.weight = weight;
        path.add(initialNode);
        path.add(finalNode);
    }
    
    public Path (String initialNode){
        //this.weight = weight;
        path.add(initialNode);
    }
    public Path(Path temp){
        //weight = temp.getWeight();
        ArrayList<String> newPath = new ArrayList<>();
        for (int i =0; i <temp.getPath().size();i++) {
            newPath.add(temp.getPath().get(i));
        }
        path = newPath;
    }

    
    
    public void add (Edge edge){
        //this.weight += edge.getWeight();
        //System.out.println(edge.getTargetNode());
        path.add(edge.getTargetNode());
    }
    
    public void add (String targetNode) {
        path.add(targetNode);
    }
    
    public double getWeight(){
        //return weight;
        return 0;
    }
    
    public ArrayList<String> getPath(){
        return path;
    }
    
    public String getLast(){
        return path.get(path.size()-1);
    }
   
    public String toString(){
        return path.toString();
    }
}
