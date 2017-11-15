/**
This class will vertices of the graph.
*/

public class Vertex {

  //variable declaration
  private String dolphinName;
  private int dolphinId;
  private Edge edgies;
  private Vertex nextV;
  private boolean touched;
  private boolean finished;
  private double cost;

  /**
  Overloaded Constructor
  */
  public Vertex(int dolphinId, String dolphinName)
  {
    this.dolphinId = dolphinId;
    this.dolphinName = dolphinName;
  }
  /**
  Will create the adjacency list for the vertex using the specified edge.
  @param Edge edgiesG: will hold the edge.
  */
  public void addToAdjacencyList(Edge edgiesG){
    edgiesG.next = edgies;
    edgies = edgiesG;
  }

  /**
  This toString method will show the representation of the vertex.
  @return String create: returns the string of vertexes with their edges.
  */
  public String toString(){
    String create = "vertex " + dolphinId + dolphinName + ":\n";
    Edge anotherEdge = edgies;

    //will go through the edges and add a string of edges each time.
    while(anotherEdge != null){
      create += "\tedge to " + anotherEdge.endLocation.dolphinId;
      anotherEdge = anotherEdge.nextEdge;
    }
    return create;
  }

  /**
  String method to get the dolphinName.
  @return String dolphinName: Name of Dolphin
  */
  public String getDolphinName()
  {
    //returns the dolphin name
    return dolphinName;
  }

  /**
  String method to get the dolphinId
  @return String dolphinId: Id of the Dolphin
  */
  public String getDolphinId()
  {
    //returns the dolphin id
    return dolphinId;
  }
}
