/**
This class will create the edges of the graph.
*/

public class Edge {
  private final String dolphinId;
  private final Vertex location;
  private final Vertex origin;
  private final int weightOfEdge;

  /**
    Overloaded Constructor
    @param String dolphinId:
    @param Vertex endLocation:
    @param Vertex beginLocation:
    @param int weightOfEdge:
  */
  public Edge (String dolphinId, Vertex beginLocation, Vertex endLocation, int weightOfEdge) {
    this.dolphinId = dolphinId;
    this.endLocation = endLocation;
    this.beginLocation = beginLocation;
    this.weightOfEdge = weightOfEdge;
  }

  /**
  This get method will get the dolphin's name.
  @return dolphinName: This will return the dolphin's name.
  */
  public String getDolphinId () {
    return dolphinId;
  }

  /**
  This get method will get the end of the edge's location.
  @return dolphinName: This will return the end of the edge location.
  */
  public String getEndLocation () {
    return endLocation;
  }

  /**
  This get method will get the beginning of the edge location.
  @return dolphinName: This will return where the beginning of the edge location.
  */
  public String getBeginLocation () {
    return beginLocation;
  }

  /**
  This get method will get the weight of the edge.
  @return weightOfEdge: This will return the weight of the edge.
  */
  public String getWeighofEdge () {
    return weightOfEdge;
  }

  /**
  This toString method will return the string of the beginning and the end location of the edge.
  */
  public String toString () {
    return beginLocation + " " + endLocation;
  }
}
