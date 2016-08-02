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
    
    static ArrayList<String> unselected ;
    static ArrayList<Node> listOfNodes;
    static ArrayList<Path> container;
    
    public static void main(String[] args) {
        listOfNodes = new ArrayList<Node>();
        unselected = new ArrayList<String>();
        //Creating the graph
        Node O = new Node("O", new Edge[] {
            new Edge(2, "A", 0), 
            new Edge(5, "B", 1),
            new Edge(4, "C", 2)
        });
        Node A = new Node("A", new Edge[]{
            new Edge(2, "O", 0),
            new Edge(2, "B", 1),
            new Edge(7, "D", 2),
            new Edge(12, "F", 3),
        });
        Node B = new Node("B", new Edge[]{
            new Edge(5, "O", 0),
            new Edge(2, "A", 1),
            new Edge(4, "D", 2),
            new Edge(1, "C", 3),
            new Edge(3, "E", 4),
        });
        Node C = new Node("C", new Edge[]{
            new Edge(4, "O", 0),
            new Edge(1, "B", 1),
            new Edge(4, "E", 2),
        });
        Node D = new Node("D", new Edge[]{
            new Edge(4, "B", 0),
            new Edge(7, "A", 1),
            new Edge(1, "E", 2),
            new Edge(5, "T", 3),
        });
        Node E = new Node("E", new Edge[]{
            new Edge(4, "C", 0),
            new Edge(3, "B", 1),
            new Edge(1, "D", 2),
            new Edge(7, "T", 3),
        });
        Node F = new Node("F", new Edge[]{
            new Edge(12, "A", 0),
            new Edge(3, "T", 1),
        });
        Node T = new Node("T", new Edge[]{
            new Edge(3, "F", 0),
            new Edge(5, "D", 1),
            new Edge(7, "E", 2),
        });
        
        unselected.add("A");
        unselected.add("B");
        unselected.add("C");
        unselected.add("D");
        unselected.add("E");
        unselected.add("F");
        //unselected.add("O");
        unselected.add("T");
        
        listOfNodes.add(A);
        listOfNodes.add(B);
        listOfNodes.add(C);
        listOfNodes.add(D);
        listOfNodes.add(E);
        listOfNodes.add(F);
        listOfNodes.add(O);
        listOfNodes.add(T);
        System.out.println("List of nodes:"+listOfNodes);
        System.out.println("Unselected:"+unselected);
        //Exploding the first node
        container = new ArrayList<Path>();
        for(Edge a: O.getAdjacentEdges()){
            container.add(new Path("O", a.getTargetNode(), a.getWeight()));
        }
        System.out.println("Container:"+container);
        //Choosing the shortest path 
        Path chosen = container.get(0);
        int indexOfChosenPath = 0;
        for (int i =1; i <container.size();i++ ) {
            if(container.get(i).getWeight() < chosen.getWeight()){
                chosen = container.get(i);
                indexOfChosenPath = i;
            }
        }
        binarySearchAndDestroy(chosen.getLast());
        
        //Selecting that node and then adding new paths into my container
        Node chosenNode = binarySearchAndReturn(chosen.getLast());
        
        //here's my main while loop
        while (!chosenNode.getName().equals("T")) {

            for (int i =1; i < chosenNode.getAdjacentEdges().length;i++) {
                cloneAndAdd(indexOfChosenPath,chosenNode.getAdjacentEdges()[i]);
            }
            container.get(indexOfChosenPath).add(chosenNode.getAdjacentEdges()[0]);
            
            
            for (int i=container.size()-1; i>=0;i--) {
                if (!binarySearchAndConfirm(container.get(i))) {
                    container.remove(i);
                }
            }

            //Choosing the shortest path 
            Path chosenSecondTime = container.get(0);
            indexOfChosenPath = 0;
            for (int i =1; i <container.size();i++ ) {
                if(container.get(i).getWeight() < chosenSecondTime.getWeight()){
                    chosenSecondTime = container.get(i);
                    indexOfChosenPath = i;
                }
            }
            System.out.println("Unselected:"+unselected);
            System.out.println("Container:"+container);
            System.out.println("chosenNode"+chosenSecondTime.getLast());
            binarySearchAndDestroy(chosenSecondTime.getLast());
            chosenNode = binarySearchAndReturn(chosenSecondTime.getLast());
            
        }
        
    } 
    public static void binarySearchAndDestroy(String toBeDestroyed){
       //returns index of the toBeDestroyed within the array
       int min = 0;
       int max = unselected.size()-1;
       int index;
       
       while (max-min > -1){
           index = (min+max)/2;
           if (unselected.get(index).equals(toBeDestroyed)){
               unselected.remove(index);
           }
           else if (unselected.get(index).compareToIgnoreCase(toBeDestroyed)<0){
               min = index+1;
           }
           else { //(unselected[center+1] > toBeDestroyed)
               max = index-1;
           }
       }
    }
    
    public static Node binarySearchAndReturn(String findThis){
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
public static boolean binarySearchAndConfirm(Path checkThis){
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
public static void cloneAndAdd(int indexOfPathIAmCloning, Edge edgeIAmAdding){
        Path clone = new Path(container.get(indexOfPathIAmCloning));
        clone.add(edgeIAmAdding);
        //System.out.println("clone"+clone);
        container.add(clone);
        
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
