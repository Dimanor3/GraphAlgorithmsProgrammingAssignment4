/*
 * A class to hold vertex objects for a graph
 */
public class Vertex {
    final private String vertexID;
    final private String vertexName;

    /**
     * Constructor
     * @param String vertexID
     * @param String vertexName
     */
    public Vertex(String vertexID, String vertexName) {
        this.vertexID = vertexID;
        this.vertexName = vertexName;
    }
    
    /**
     * A get method to return the vertex id
     * @return String vertexID
     */
    public String getVertexId() {
        return vertexID;
    }

    /**
     * A get method to return the vertex name
     * @return String vertexName
     */
    public String getVertexName() {
        return vertexName;
    }

    
    /**
     * An overridden equals method to determine if two vertices are the same object
     * (and therefore the same vertex)
     * @param Object otherV the vertex to be compared with this
     * @return boolean true/false
     */
    @Override
    public boolean equals(Object otherV) {
        if (this == otherV) //if the same object (thereby vertex)
            return true;
        if (otherV == null) //if the newOther vertex is null
            return false;
        if (this.getClass() != otherV.getClass()) //if the two are not the same type of object
            return false;
        Vertex newOther = (Vertex) otherV; //cast to Vertex to compare as vertices
        if (vertexID == null) { //if trying to compare to a null vertex
            if (newOther.vertexID != null)
                return false;
        } else if (!vertexID.equals(newOther.vertexID)) //compare by ids
            return false;
        return true;
    }

    /**
     * Overridden toString method
     * @return String a string representing the vertex (using name)
     */
    @Override
    public String toString() {
        return vertexName;
    }

}