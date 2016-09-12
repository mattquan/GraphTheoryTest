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
 * @author tinawu
 */
public class GraphSix extends Graph {
    
    public ArrayList<Node> build() {
        return new ArrayList<>(
            Arrays.asList(
                                   
                new Node("A", new Edge[]{
                    new Edge(2, "B", 0),
                    new Edge(4, "C", 1),
                    new Edge(1, "D", 2),}),
                new Node("B", new Edge[]{
                    new Edge(2, "A", 0),
                    new Edge(3, "C", 1),
                    new Edge(1, "E", 2)}),
                new Node("C", new Edge[]{
                    new Edge(4, "A", 0),
                    new Edge(3, "B", 1),
                    new Edge(2, "E", 2),
                    new Edge(2, "F", 3)}),
                new Node("D", new Edge[]{
                    new Edge(1, "A", 0),
                    new Edge(5, "F", 1),
                    new Edge(4, "G", 2)}),
                new Node("E", new Edge[]{
                    new Edge(1, "B", 0),
                    new Edge(2, "C", 1),
                    new Edge(3, "H", 2)}),
                new Node("F", new Edge[]{
                    new Edge(2, "C", 0),
                    new Edge(5, "D", 1),
                    new Edge(3, "G", 2),
                    new Edge(4, "J", 3),
                    new Edge(2, "I", 4),
                    new Edge(3, "H", 5)}),
                new Node("G", new Edge[]{
                    new Edge(4, "D", 0),
                    new Edge(3, "F", 1),
                    new Edge(2, "K", 2)}),
                new Node("H", new Edge[]{
                    new Edge(3, "E", 0),
                    new Edge(3, "F", 1),
                    new Edge(1, "L", 2),
                    new Edge(8, "O", 3)}),
                new Node("I", new Edge[]{
                    new Edge(2, "F", 0),
                    new Edge(3, "J", 1),
                    new Edge(2, "M", 2),
                    new Edge(3, "L", 3)}),
                new Node("J", new Edge[]{
                    new Edge(4, "F", 0),
                    new Edge(3, "I", 1),
                    new Edge(6, "M", 2),
                    new Edge(3, "N", 3),
                    new Edge(6, "K", 4)}),
                new Node("K", new Edge[]{
                    new Edge(2, "G", 0),
                    new Edge(6, "J", 1),
                    new Edge(4, "N", 2),
                    new Edge(2, "R", 3)}),
                new Node("L", new Edge[]{
                    new Edge(1, "H", 0),
                    new Edge(6, "O", 1),
                    new Edge(3, "M", 2),
                    new Edge(3, "I", 3)}),
                new Node("M", new Edge[]{
                    new Edge(2, "I", 0),
                    new Edge(3, "L", 1),
                    new Edge(4, "O", 2),
                    new Edge(2, "L", 3),
                    new Edge(5, "N", 4),
                    new Edge(2, "P", 5),
                    new Edge(6, "J", 6)}),
                new Node("N", new Edge[]{
                    new Edge(4, "K", 0),
                    new Edge(3, "J", 1),
                    new Edge(5, "M", 2),
                    new Edge(2, "Q", 3),
                    new Edge(1, "R", 4)}),
                new Node("O", new Edge[]{
                    new Edge(8, "H", 0),
                    new Edge(6, "L", 1),
                    new Edge(4, "M", 2),
                    new Edge(2, "P", 3),
                    new Edge(6, "S", 4)}),
                new Node("P", new Edge[]{
                    new Edge(2, "M", 0),
                    new Edge(2, "O", 1),
                    new Edge(2, "S", 2),
                    new Edge(1, "T", 3),
                    new Edge(1, "Q", 4)}),
                new Node("Q", new Edge[]{
                    new Edge(2, "N", 0),
                    new Edge(1, "P", 1),
                    new Edge(3, "T", 2),
                    new Edge(8, "R", 3)}),
                new Node("R", new Edge[]{
                    new Edge(2, "K", 0),
                    new Edge(1, "N", 1),
                    new Edge(8, "Q", 2),
                    new Edge(5, "T", 3)}),
                new Node("S", new Edge[]{
                    new Edge(6, "O", 0),
                    new Edge(2, "P", 1),
                    new Edge(2, "Z", 2)}),
                new Node("T", new Edge[]{
                    new Edge(5, "R", 0),
                    new Edge(3, "Q", 1),
                    new Edge(1, "P", 2),
                    new Edge(8, "Z", 3)}),
                new Node("Z", new Edge[]{
                    new Edge(2, "S", 0),
                    new Edge(8, "T", 1)})
            ));
    }

    public String endingNode() {
        return "Z";
    }

    public String startingNode() {
        return "A";
    }
   
}
