/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectSahara;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author christopherbae
 */

public class GraphThree extends Graph {
    public ArrayList<Node> build() {
        return new ArrayList<>(
            Arrays.asList(
                
                new Node("A", new Edge[]{
                    new Edge(7,"J",0),
                    new Edge(2,"B",1),
                    new Edge(4,"E",2)}),
                new Node("B", new Edge[]{
                    new Edge(2,"A",0),
                    new Edge(5,"C",1)}),
                new Node("C", new Edge[]{
                    new Edge(5,"B",0),
                    new Edge(4,"H",1)}),
                new Node("D", new Edge[]{
                    new Edge(6,"F",0),
                    new Edge(8,"I",1),
                    new Edge(3,"J",2)}),
                new Node("E", new Edge[]{
                    new Edge(4,"A",0),
                    new Edge(15,"G",1),
                    new Edge(2,"H",2)}),
                new Node("F", new Edge[]{
                    new Edge(6,"D",0),
                    new Edge(4,"I",1)}),
                new Node("G", new Edge[]{
                    new Edge(15,"E",0),
                    new Edge(5,"J",1)}),
                new Node("H", new Edge[]{
                    new Edge(4,"C",0),
                    new Edge(2,"E",1)}),
                new Node("I", new Edge[]{
                    new Edge(8,"D",0),
                    new Edge(4,"F",1)}),
                new Node("J", new Edge[]{
                    new Edge(7,"A",0),
                    new Edge(3,"D",1),
                    new Edge(5,"G",2),})
                
                ));            
               
    }
                  
    public String endingNode(){
        return "F";
    }
    public String startingNode(){
        return "C";
    }
                

}
