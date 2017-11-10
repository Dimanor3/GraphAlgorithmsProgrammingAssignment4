import java.util.*;


/**
This class will vertices of the graph.
*/

public class Graph{
  private final List<Vertex> verticesG;
  private final List<Edge> edgiesG;

  public Graph(List<Vertex> verticesG, List<Edge> edgiesG)
  {
    this.verticesG = verticesG;
    this.edgiesG = edgiesG;
  }

  public List<Vertex> getVerticesG()
  {
    return verticesG;
  }

  public List<Edge> getEdgiesG()
  {
    return edgiesG;
  }
}
