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
        //runDijkstrasAlgorithm(g2.build(),g2.startingNode(),g2.endingNode());
        GraphThree g3 = new GraphThree();
        //runDijkstrasAlgorithm(g3.build(),g3.startingNode(),g3.endingNode());
        GraphFour g4 = new GraphFour();
        //runDijkstrasAlgorithm(g4.build(),g4.startingNode(),g4.endingNode());
        GraphSix g6 = new GraphSix();
        //runDijkstrasAlgorithm(g6.build(), g6.startingNode(), g6.endingNode());
        FloorGround fg = new FloorGround();
        runDijkstrasAlgorithm(fg.build(),Keys.nodeNameEastWingFloorGround,Keys.nodeNameHallwayFloorGroundC);
    }

    public static void runDijkstrasAlgorithm(ArrayList<Node> listOfNodes, String startingNodeString, String endingNodeString) {
        //creating the unvisited list
        System.out.println("listOfNodes"+listOfNodes+"");
        ArrayList<Node> unvisited = new ArrayList();
        for (Node node : listOfNodes) {
            unvisited.add(node);
        }
        //set my starting node
        Node startingNode = binarySearchAndReturn(startingNodeString, listOfNodes);
        //precondition of starting node. it's weight is 0, not infinity
        startingNode.setWeight(0);
        //because by default, minPath is null. so the first one has to have a non null path so that it can copy to all the other nodes.
        startingNode.setMinPath(new Path(startingNode.getName()));

        //set my ending node
        Node endingNode = binarySearchAndReturn(endingNodeString, listOfNodes);
        //first move. and also so i can initilzie chosen node
        Node chosenNode = startingNode;
        while (chosenNode != endingNode) {
            System.out.println("chosenNode" + chosenNode);
            System.out.println("chosenNodePath" + chosenNode.getMinPath());
            System.out.println("chosenNodeWeight" + chosenNode.getWeight());
            //for each edge in my chosen node, look at that connecting edge and update values if necessary
            for (Edge edge : chosenNode.getAdjacentEdges()) {
                //panda is that particular targetnode from that particular edge
                Node panda = binarySearchAndReturn(edge.getTargetNode(), listOfNodes);
                //update only if panda has been unvisited. if it has already been visited, we don't look at it. 
                //basiclaly don't look at the targetnode if, as a node, the targetnode has already been looked at
                //confusing a bit. becuase panda is a target node. but that node only goes to unvisited if it was ever the chosenNode
                //so if panda was already a chosenNode, then don't look at it, basically, if that makes more sense
                if (binarySearch(panda, unvisited)) {
                    double suggestedWeight = chosenNode.getWeight() + edge.getWeight();
                    //only if my new weight < my old weight, do i update
                    if (suggestedWeight < panda.getWeight()) {
                        //update values
                        panda.setWeight(suggestedWeight);
                        
                        //so i can add myself, the panda, to the new improved chain. becuase the old chain came from the chosenNode, the startingNode of the edge (vs. targetNode).
                        //and THAT path/chain does not include the targetNode/panda. so you have to add itself to the new, min path. beecause the min path takes
                        //vestiges of the old chain from chosenNode + the panda node.
                        String self = panda.getName();
                        Path path = new Path(chosenNode.getMinPath());
                        path.add(self);
                        panda.setMinPath(path);
                        //debugging info
                        System.out.println("panda:" + panda);
                        System.out.println("pandaWeight" + panda.getWeight());
                    } else {
                        //debugging info
                        System.out.println("did not update becuase wasn't min" + panda);
                    }
                } else {
                    //debugging info
                    System.out.println("did not look at " + panda+", already updated");                   
                }
            }
            //remove the chosenNode from the unvisited list becuase it was visited
            binarySearchAndDestroyNode(chosenNode.getName(), unvisited);
            //debugging info
            System.out.println(unvisited);
            
            //choosing the newest minNode
            Node minNode = new Node();
            for (Node node : unvisited) {
                if (node.getWeight() < minNode.getWeight()) {
                    minNode = node;
                }
            }
            chosenNode = minNode;
        }
        //done!
        //this printout works becuase of polymorphism. eventually, chosenNode will = endingNode, and then when that happens, endingNode will have already been altered. 
        System.out.println("The shortest path is " + endingNode.getMinPath() + "with weight" + endingNode.getWeight());

    }

    public static Node binarySearchAndReturn(String findThis, ArrayList<Node> listOfNodes) {
        //returns index of the toBeDestroyed within the array
        int min = 0;
        int max = listOfNodes.size() - 1;
        int index;

        while (max - min > -1) {
            index = (min + max) / 2;
            if (listOfNodes.get(index).getName().equals((findThis))) {
                //found it!
                return listOfNodes.get(index);
            } else if (listOfNodes.get(index).getName().compareToIgnoreCase(findThis) < 0) {
                min = index + 1;
            } else { //(unselected[center+1] > toBeDestroyed)
                max = index - 1;
            }

        }
        return null;
    }

    public static void binarySearchAndDestroyNode(String toBeDestroyed, ArrayList<Node> searchThis) {
        //returns index of the toBeDestroyed within the array
        int min = 0;
        int max = searchThis.size() - 1;
        int index;

        while (max - min > -1) {
            index = (min + max) / 2;
            if (searchThis.get(index).getName().equals(toBeDestroyed)) {
                searchThis.remove(index);
                break;
            } else if (searchThis.get(index).getName().compareToIgnoreCase(toBeDestroyed) < 0) {
                min = index + 1;
            } else { //(unselected[center+1] > toBeDestroyed)
                max = index - 1;
            }
        }
    }

    public static boolean binarySearch(Node checkThis, ArrayList<Node> inThis) {
        //returns a boolean. checks the path. 
        //will return true if the path's last element is in the unselected.
        int min = 0;
        int max = inThis.size() - 1;
        int index;

        while (max - min > -1) {
            index = (min + max) / 2;
            if (inThis.get(index).getName().equals(checkThis.getName())) {
                //found it!
                return true;
            } else if (inThis.get(index).getName().compareToIgnoreCase(checkThis.getName()) < 0) {
                min = index + 1;
            } else { //(unselected[center+1] > toBeDestroyed)
                max = index - 1;
            }

        }
        return false;
    }


    /*public static void binarySearchAndDestroy(String toBeDestroyed,ArrayList<String> unselected){
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
    }*/
 /*public static ArrayList<Path> cloneAndAdd(int indexOfPathIAmCloning, Edge edgeIAmAdding, ArrayList<Path> container){
        Path clone = new Path(container.get(indexOfPathIAmCloning));
        clone.add(edgeIAmAdding);
        //System.out.println("clone"+clone);
        container.add(clone);
        return container;
    }
     */
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
 /*public static boolean binarySearchAndConfirm(Path checkThis, ArrayList<String> unselected){
        //this is just a binarySearch
       //returns a boolean. checks the path. 
       //will return true if the path's last element is in the unselected.
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
    }*/
 /*public static void runFakeDijkstrasAlgorithm (ArrayList<Node> listOfNodes, String startingNodeString, String endingNodeString) {
        int counter = 1;
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
            counter++;
            //so this clones and adds the adjcancies to the new paths
            for (int i =1; i < chosenNode.getAdjacentEdges().length;i++) {
                cloneAndAdd(indexOfChosenPath,chosenNode.getAdjacentEdges()[i],container);
            }
            container.get(indexOfChosenPath).add(chosenNode.getAdjacentEdges()[0]);
            
            //and this removes all the paths that included the chosen one, cuz we've moved on
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
            System.out.println("counter:"+counter);
        }
        
        System.out.println("This is your shortest path!: "+shortestPath+" with weight "+shortestPath.getWeight());
        
    }*/
}
