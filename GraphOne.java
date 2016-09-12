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
 * @author Matt
 */
public  class GraphOne extends Graph {
   
    
    public ArrayList<Node> build() {
        return new ArrayList<>(
            Arrays.asList(
                                   
                new Node("A", new Edge[]{
                    new Edge(2, "O", 0),
                    new Edge(2, "B", 1),
                    new Edge(7, "D", 2),
                    new Edge(12, "F", 3),}),
                new Node("B", new Edge[]{
                    new Edge(5, "O", 0),
                    new Edge(2, "A", 1),
                    new Edge(4, "D", 2),
                    new Edge(1, "C", 3),
                    new Edge(3, "E", 4),}),
                new Node("C", new Edge[]{
                    new Edge(4, "O", 0),
                    new Edge(1, "B", 1),
                    new Edge(4, "E", 2),}),
                new Node("D", new Edge[]{
                    new Edge(4, "B", 0),
                    new Edge(7, "A", 1),
                    new Edge(1, "E", 2),
                    new Edge(5, "T", 3),}),
                new Node("E", new Edge[]{
                    new Edge(4, "C", 0),
                    new Edge(3, "B", 1),
                    new Edge(1, "D", 2),
                    new Edge(7, "T", 3),}),
                new Node("F", new Edge[]{
                    new Edge(12, "A", 0),
                    new Edge(3, "T", 1),}),
                new Node("O", new Edge[]{
                    new Edge(2, "A", 0),
                    new Edge(5, "B", 1),
                    new Edge(4, "C", 2)}), 
                new Node("T", new Edge[]{
                    new Edge(3, "F", 0),
                    new Edge(5, "D", 1),
                    new Edge(7, "E", 2),})
            ));
    }

    public String endingNode() {
        return "T";
    }

    public String startingNode() {
        return "O";
    }
   
    
}
