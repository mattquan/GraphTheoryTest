public class Node {
    private final String name;
    private Edge[] adjacencies;
    public Node(String name, Edge[] myEdges) { 
        this.name = name;
        adjacencies = myEdges;
    }
    public String getName() { 
        return name; 
    }
    public String setName(String name) {
        this.name = name;
    }
    public Edge[] getAdjacentEdges() {
        return adjacencies;
    }
    public void setAdjacentEdges(Edge[] setThis){
        adjacencies = setThis;

    }

}