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
public class GraphTwo {
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
                    new Edge(7, "H", 3),}),
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
}
