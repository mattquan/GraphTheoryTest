/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProjectSahara;

/**
 *
 * @author tinawu
 */
public class Edge {
    private double weight;
    private String targetNode;
    private int index;
    public Edge(double w, String n, int i){
        weight = w;
        targetNode = n;
        index = i;
    }
    public double getWeight(){
        return weight;
    }
    public void setWeight(double a){
        weight = a;
    }
    public String getTargetNode(){
        return targetNode;
    }
    public void setTargetNode(String n){
        targetNode = n;
    }
    public int getIndex(){
        return index;
    }
    public void setIndex(int i){
        index = i;
    }
}