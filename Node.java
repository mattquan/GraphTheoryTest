public class Node {
    private String name;
    private Edge[] adjacencies;
    public Node(String name, Edge[] myEdges) { 
        this.name = name;
        adjacencies = myEdges;
    }
    public String getName() { 
        return name; 
    }
    public void setName(String name) {
        this.name = name;
    }
    public Edge[] getAdjacentEdges() {
        return adjacencies;
    }
    public void setAdjacentEdges(Edge[] setThis){
        adjacencies = setThis;

    }

}
