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
public class GraphTwo extends Graph {
    public ArrayList<Node> build() {
        return new ArrayList<>(
            Arrays.asList(
                                   
                new Node("A", new Edge[]{
                    new Edge(4, "D", 0),
                    new Edge(3, "C", 1)}),
                new Node("B", new Edge[]{
                    new Edge(7, "H", 0),
                    new Edge(4, "G", 1),
                    new Edge(4, "D", 2)}),
                new Node("C", new Edge[]{
                    new Edge(2, "D", 0),
                    new Edge(3, "E", 1),
                    new Edge(6, "F", 2),
                    new Edge(3, "A", 3)}),
                new Node("D", new Edge[]{
                    new Edge(4, "A", 0),
                    new Edge(2, "C", 1),
                    new Edge(5, "E", 2),}),
                new Node("E", new Edge[]{
                    new Edge(5, "D", 0),
                    new Edge(3, "C", 1),
                    new Edge(1, "F", 2),
                    new Edge(2, "H", 3),}),
                new Node("F", new Edge[]{
                    new Edge(6, "C", 0),
                    new Edge(1, "E", 1),
                    new Edge(5, "G", 2),}),
                new Node("G", new Edge[]{
                    new Edge(5, "F", 0),
                    new Edge(4, "B", 1),
                    new Edge(2, "H", 2)}), 
                new Node("H", new Edge[]{
                    new Edge(2, "G", 0),
                    new Edge(7, "B", 1),
                    new Edge(2, "E", 2),})
            ));
    }

    public String endingNode() {
        return "B";
    }

    public String startingNode() {
        return "A";
    }
}
