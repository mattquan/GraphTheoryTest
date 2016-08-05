/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProjectSahara;
import java.util.*;
/**
 *
 * @author tinawu
 */
public class Main {   
    
    
    
    public static void main(String[] args) {
        
   
        //System.out.println("Unselected:"+unselected);
        GraphOne g1 = new GraphOne();
        //runDijkstrasAlgorithm(g1.build(),g1.startingNode(),g1.endingNode());
        GraphTwo g2 = new GraphTwo();
        runDijkstrasAlgorithm(g2.build(),g2.startingNode(),g2.endingNode());
        GraphThree g3 = new GraphThree();
        runDijkstrasAlgorithm(g3.build(),g3.startingNode(),g3.endingNode());
       
    } 
    
    public static void runDijkstrasAlgorithm (ArrayList<Node> listOfNodes, String startingNodeString, String endingNodeString) {
        Node startingNode = binarySearchAndReturn(startingNodeString, listOfNodes);
        //building the unselected arraylist
        ArrayList<String> unselected  = new ArrayList<>();
        for (Node node:listOfNodes) {
            if (!node.getName().equals(startingNodeString)) {
            unselected.add(node.getName());
            }
        } 
        
         //Exploding the first node
         ArrayList<Path> container = new ArrayList<>();
        for(Edge edge: startingNode.getAdjacentEdges()){
            container.add(new Path(startingNode.getName(), edge.getTargetNode(), edge.getWeight()));
        }
        System.out.println("Container:"+container);
        //Choosing the shortest path 
        Path shortestPath = container.get(0);
        int indexOfChosenPath = 0;
        for (int i =1; i <container.size();i++ ) {
            if(container.get(i).getWeight() < shortestPath.getWeight()){
                shortestPath = container.get(i);
                indexOfChosenPath = i;
            }
        }
        binarySearchAndDestroy(shortestPath.getLast(),unselected);
        
        //Selecting that node and then adding new paths into my container
        Node chosenNode = binarySearchAndReturn(shortestPath.getLast(),listOfNodes);
        
        //here's my main while loop
        while (!chosenNode.getName().equals(endingNodeString)) {

            for (int i =1; i < chosenNode.getAdjacentEdges().length;i++) {
                cloneAndAdd(indexOfChosenPath,chosenNode.getAdjacentEdges()[i],container);
            }
            container.get(indexOfChosenPath).add(chosenNode.getAdjacentEdges()[0]);
            
            
            for (int i=container.size()-1; i>=0;i--) {
                if (!binarySearchAndConfirm(container.get(i),unselected)) {
                    container.remove(i);
                }
            }

            //Choosing the shortest path 
            shortestPath = container.get(0);
            indexOfChosenPath = 0;
            for (int i =1; i <container.size();i++ ) {
                if(container.get(i).getWeight() < shortestPath.getWeight()){
                    shortestPath = container.get(i);
                    indexOfChosenPath = i;
                }
            }
            System.out.println("Unselected:"+unselected);
            System.out.println("Container:"+container);
            System.out.println("shortestPath:"+shortestPath);
            binarySearchAndDestroy(shortestPath.getLast(),unselected);
            chosenNode = binarySearchAndReturn(shortestPath.getLast(),listOfNodes);
            System.out.println("chosenNode:"+chosenNode);
        }
        
        System.out.println("This is your shortest path!: "+shortestPath+" with weight "+shortestPath.getWeight());
        
    }

    public static void binarySearchAndDestroy(String toBeDestroyed,ArrayList<String> unselected){
       //returns index of the toBeDestroyed within the array
       int min = 0;
       int max = unselected.size()-1;
       int index;
       
       while (max-min > -1){
           index = (min+max)/2;
           if (unselected.get(index).equals(toBeDestroyed)){
               unselected.remove(index);
               break;
           }
           else if (unselected.get(index).compareToIgnoreCase(toBeDestroyed)<0){
               min = index+1;
           }
           else { //(unselected[center+1] > toBeDestroyed)
               max = index-1;
           }
       }
    }
    
    public static Node binarySearchAndReturn(String findThis, ArrayList<Node> listOfNodes){
       //returns index of the toBeDestroyed within the array
       int min = 0;
       int max = listOfNodes.size()-1;
       int index;
       
       while (max-min > -1){
           index = (min+max)/2;
           if (listOfNodes.get(index).getName().equals((findThis))){
               //found it!
               return listOfNodes.get(index);
           }
           else if (listOfNodes.get(index).getName().compareToIgnoreCase(findThis)<0){
               min = index+1;
           }
           else { //(unselected[center+1] > toBeDestroyed)
               max = index-1;
           }
          
       }
       return null;
    }
public static boolean binarySearchAndConfirm(Path checkThis, ArrayList<String> unselected){
       //returns index of the toBeDestroyed within the array
       int min = 0;
       int max = unselected.size()-1;
       int index;
       
       while (max-min > -1){
           index = (min+max)/2;
           if (unselected.get(index).equals(checkThis.getLast())){
               //found it!
               return true;
           }
           else if (unselected.get(index).compareToIgnoreCase(checkThis.getLast())<0){
               min = index+1;
           }
           else { //(unselected[center+1] > toBeDestroyed)
               max = index-1;
           }
          
       }
       return false;
    }
public static ArrayList<Path> cloneAndAdd(int indexOfPathIAmCloning, Edge edgeIAmAdding, ArrayList<Path> container){
        Path clone = new Path(container.get(indexOfPathIAmCloning));
        clone.add(edgeIAmAdding);
        //System.out.println("clone"+clone);
        container.add(clone);
        return container;
        
    }
    /*public static boolean binarySearchAndConfirm(Path checkThis){
        boolean found = false;
        int index = unselected.size()/2;
        int num = (unselected.size() - index)/2;
        while(!(unselected.get(index).equals(checkThis.getLast()))){
            if((checkThis.getLast().compareToIgnoreCase(unselected.get(index).getName())>0)){
                index = num + index; 
            }
            else {
                index = index - num;
            }
            num = (num + 1)/2;
        }
    }*/
    
    
    
    
    
    
    /*public static void binarySearchAndDestroy( String key){
        int index = unselected.size()/2;
        int num = (unselected.size() - index)/2;
        while(!(unselected.get(index).equals(key))){
            if((key.compareToIgnoreCase(unselected.get(index))>0)){
                index = num + index; 
            }
            else {
                index = index - num;
            }
            num = (num + 1)/2;
        }
        unselected.remove(index);
    }*/
    
    /*public static Node binarySearchAndReturn(String key){
        int index = listOfNodes.size()/2;
        int num = (listOfNodes.size() - index)/2;
        while(!(listOfNodes.get(index).equals(key))){
            if((key.compareToIgnoreCase(listOfNodes.get(index).getName())>0)){
                index = num + index; 
            }
            else {
                index = index - num;
            }
            num = (num + 1)/2;
        }
        return listOfNodes.get(index);
    }*/
    
    
    

}
