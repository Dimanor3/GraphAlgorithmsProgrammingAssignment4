import java.util.List;

/*
 * class for graph object
 */
public class Graph {
    private final List<Vertex> verticesG; //list of vertices
    private final List<Edge> edgiesG; //list of edges

   /**
    * constructor
    * @param List<Vertex> verticesG a list of vertices in the graph
    * @param List<Edge> edgiesG a list of edges in the graph
    */
    public Graph (List<Vertex> verticesG, List<Edge> edgiesG) {
        this.verticesG = verticesG;
        this.edgiesG = edgiesG;
    }

    /**
     * A get method to return the vertices in the graph
     * @return List<Vertex> verticesG a list of vertices in the graph
     */
    public List<Vertex> getVerticesG () {
        return verticesG;
    }

    /**
     * A get method to return the edges in the graph
     * @return List<Edge> edgiesG a list of edges in the graph
     */
    public List<Edge> getEdgiesG () {
        return edgiesG;
    }

    /**
     * A get method to return the number of vertices in the graph
     * @return int the number of vertices in the graph
     */
    public int numV () {
    	return verticesG.size ();
    }

    /**
     * A get method to return the number of edges in the graph
     * @return int the number of edges in the graph
     */
    public int numE () {
    	return edgiesG.size ();
    }
}