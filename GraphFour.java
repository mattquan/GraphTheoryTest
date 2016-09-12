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
 * @author mattquan
 */
public class GraphFour extends Graph {
    
    public ArrayList<Node> build() {
        return new ArrayList<>(
            Arrays.asList(
                
                new Node("A", new Edge[]{
                    new Edge(5,"B",0),
                    new Edge(6,"C",1),}),                    
                new Node("B", new Edge[]{
                    new Edge(5,"A",0),
                    new Edge(2,"D",1),
                    new Edge(8,"E",2)}),
                new Node("C", new Edge[]{
                    new Edge(6,"A",0),
                    new Edge(4,"D",1),
                    new Edge(10,"F",2)}),
                new Node("D", new Edge[]{
                    new Edge(2,"B",0),
                    new Edge(7,"E",1)}),                 
                new Node("E", new Edge[]{
                    new Edge(8,"B",0),
                    new Edge(7,"D",1),
                    new Edge(2,"F",2)}),
                new Node("F", new Edge[]{
                    new Edge(2,"E",0),
                    new Edge(10,"C",1),
                    new Edge(6,"G",2),}),
                new Node("G", new Edge[]{
                    new Edge(6,"F",0),
                    new Edge(6,"H",1),
                    new Edge(4,"I",2),}),
                new Node("H", new Edge[]{
                    new Edge(6,"G",0),
                    new Edge(5,"I",1)}),
                new Node("I", new Edge[]{
                    new Edge(4,"G",0),
                    new Edge(5,"H",1)})       
                
                ));            
               
    }
                
    public String endingNode(){
        return "H";
                    }
    public String startingNode(){
        return "A";
    }
          
}
