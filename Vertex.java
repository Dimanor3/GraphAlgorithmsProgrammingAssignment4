/**
This class will vertices of the graph.
*/

public class Vertex {

  //variable declaration
  private String astroName;
  private int astroId;
  private Edge edgies;
  private Vertex nextV;
  //private boolean touched;
  //private boolean finished;
  private double value;
  private Vertex astroP;

  /**
  Overloaded Constructor
  */
  public Vertex(int astroId)
  {
    this.astroId = astroId;
    this.astroName = astroName;
    value = Double.POSITIVE_INFINITY;
  }
  /**
  Will create the adjacency list for the vertex using the specified edge.
  @param Edge edgiesG: will hold the edge.
  */
  public void addAstroToAdjacencyList(Edge edgiesG){
    edgiesG.next = edgies;
    edgies = edgiesG;
  }

  /**
  This toString method will show the representation of the vertex.
  @return String create: returns the string of vertexes with their edges.
  */
  public String toString(){
    String create = "vertex " + astroId + astroName + ":\n";
    Edge anotherEdge = edgies;

    //will go through the edges and add a string of edges each time.
    while(anotherEdge != null){
      create += "\tedge to " + anotherEdge.endLocation.astroId;
      create += "(value = ) " + anotherEdge.value + ")\n";
      anotherEdge = anotherEdge.nextEdge;

    }
    return create;
  }

  /**
  This will return the string that will specify the path of the spanning tree from
  the root. Will return the shortest path when called for Dijkstra's algorithm.
  */
  public String pathAstroString()
  {
      String astroStr;
      if(astroP == null){
        astroStr = astroId;
      }
      else {
        astroStr = astroP.pathAstroString() + "->" + astroId;
      }

      return astroStr;
  }

  /**
  String method to get the astroName.
  @return String astroName: Name of astro
  */
  public String getAstroName()
  {
    //returns the astro name
    return astroName;
  }
  
  /**
  String method to get the astroId
  @return String astroId: Id of the astro
  */
  public String getAstroId()
  {
    //returns the astro id
    return astroId;
  }
}
