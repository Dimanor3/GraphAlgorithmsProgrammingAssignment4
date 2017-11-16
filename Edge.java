/**
This class will create the edges of the graph.
*/

public class Edge {

  //variable declaration
  public Vertex startLocation;
  public Vertex endLocation;
  public Edge nextEdge;
  public double value;

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

  public double getValue()
  {
    return value;
  }


  }
