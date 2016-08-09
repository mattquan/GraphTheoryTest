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
 * @author Steffi
 */

public class GraphFive implements Graph {
    public ArrayList<Node> build() {
        return new ArrayList<>(
            Arrays.asList(
                    
                    new Node("L", new Edge[]{
                        new Edge(1,"Q",0),
                        new Edge(4,"O",1),
                        new Edge(5,"N",2),}),
                    new Node("M", new Edge[]{
                        new Edge(2,"Q",0),}),
                    new Node("N", new Edge[]{
                        new Edge(3,"O",0),
                        new Edge(5,"L",1),}),
                    new Node("O", new Edge[]{
                        new Edge(3,"N",0),
                        new Edge(4,"L",1),
                        new Edge(10,"P",2),}),
                    new Node("P", new Edge[]{
                        new Edge(10,"O",0),}),
                    new Node("Q", new Edge[]{
                        new Edge(1,"L",0),
                        new Edge(2,"M",1),
                        new Edge(4,"T",2),
                        new Edge(5,"V",3),
                        new Edge(7,"S",4),}),
                    new Node("R", new Edge[]{
                        new Edge(3,"X",0),}),
                    new Node("S", new Edge[]{
                        new Edge(3,"U",0),
                        new Edge(4,"T",1),
                        new Edge(7,"Q",2),}),
                    new Node("T", new Edge[]{
                        new Edge(2,"V",0),
                        new Edge(4,"Q",1),
                        new Edge(4,"S",2),}),
                    new Node("U", new Edge[]{
                        new Edge(3,"S",0),
                        new Edge(3,"V",1),
                        new Edge(4,"X",2),}),
                    new Node("V", new Edge[]{
                        new Edge(2,"T",0),
                        new Edge(2,"W",1),
                        new Edge(3,"U",2),
                        new Edge(5,"Q",3),}),
                    new Node("W", new Edge[]{
                        new Edge(2,"V",0),
                        new Edge(5, "X",1),}),
                    new Node("X", new Edge[]{
                        new Edge(2,"Y",0),
                        new Edge(3,"X",1),
                        new Edge(4,"U",2),
                        new Edge(4,"Z",3),
                        new Edge(5,"W",4),}),
                    new Node("Y", new Edge[]{
                        new Edge(2,"X",0),
                        new Edge(6,"Z",1),}),
                    new Node("Z", new Edge[]{
                        new Edge(4,"X",0),
                        new Edge(6,"Y",1),})
                
                ));
    }

    @Override
    public String endingNode() {
        return "P";
    }

    @Override
    public String startingNode() {
        return "Y";
    }
   
    
}
                    


    

