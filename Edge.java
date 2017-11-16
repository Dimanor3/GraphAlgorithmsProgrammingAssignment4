/**
This class will create the edges of the graph.
*/

public class Edge {

  //variable declaration
  private Vertex startLocation;
  private Vertex endLocation;
  private Edge nextEdge;
  private double value;

  /**

  */
  public Edge(Vertex startLocation, Vertex endLocation, double value){

    this.startLocation = startLocation;
    this.endLocation = endLocation;
    this.value = value;
  }

  public Vertex getStartLocation()
  {
    return startLocation;
  }

  public Vertex getEndLocation()
  {
    return endLocation;
  }

  public long getValue()
  {
    return value;
  }
  
  public Edge getNextEdge()
  {
	  return nextEdge;
  }


  }
