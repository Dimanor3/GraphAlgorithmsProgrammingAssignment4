/*
 * Class for edge objects in the graph
 */
public class Edge  {
    private String edgeID; //the id number of the edge
    private Vertex beginLoc; //the first vertex in the edge
    private Vertex endLoc; //the second vertex in the edge
    private double edgeWeight; //the weight of the edge

    /**
     * Constructor
     * @param String edgeID
     * @param Vertex beginLoc
     * @param Vertex endLoc
     * @param double edgeWeight
     */
    public Edge (String edgeID, Vertex beginLoc, Vertex endLoc, double edgeWeight) {
        this.edgeID = edgeID;
        this.beginLoc = beginLoc;
        this.endLoc = endLoc;
        this.edgeWeight = edgeWeight;
    }

    /**
     * get method to return the id number of the edge
     * @retun String edgeID
     */
    public String getEdgeID () {
        return edgeID;
    }
    
    /**
     * get method to return the vertex at the end of the edge
     * @return Vertex endLoc
     */
    public Vertex getEndLocation () {
        return endLoc;
    }

    /**
     * get method to return the vertex at the start of the edge
     * @return Vertex beginLoc
     */
    public Vertex getBeginLocation () {
        return beginLoc;
    }
    
    /**
     * get method to return the weight of the edge
     * @return int edgeWeight
     */
    public double getWeightofEdge () {
        return edgeWeight;
    }

    /**
     * Overridden toString() method to return a string form of the edge
     * @return String a string form of the edge
     */
    @Override
    public String toString () {
        return beginLoc + " --> " + endLoc;
    }


}