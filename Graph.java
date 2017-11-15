import java.util.*;
import java.io.*;


/**
This class will create the graph using the vertices and edges classes.
*/

public class Graph {

  //declaration of variables
  private Vertex verticesG;

  /**
  Will return the vertex that is specified by a certain dolphinId
  @param String dolphinId: will hold the dolphinId
  @return Vertex newVerticesG: will return the specific vertex called.
  */
  private Vertex getGraphVertex(String dolphinId){
    Vertex newVerticesG = verticesG;
    while(newVerticesG != null && !newVerticesG.dolphinId.equals(dolphinId)){
      newVerticesG = newVerticesG.nextV;
    }
    return newVerticesG;
  }

  /**
  This method will add the vertex of the certain dolphinId.
  @param String dolphinId: will hold the dolphinId
  @return Vertex newVerticesG: will return the specific vertex added.
  */
  private Vertex addGraphVertex(String dolphinId){
    Vertex newVerticesG = new Vertex(dolphinId);

    //will add to the beginning of the list.
    newVerticesG.nextV = verticesG;
    verticesG = newVerticesG;

    return newVerticesG;
  }

  /**
  This method will add the edge between the specific start and end vertices and will be
  stored in the adjacency list.
  */
  public void addGraphEdge(String startLocation, String endLocation){
    //creation of first node and if statement for adding the node into the graph.
    Vertex firstNode = getGraphVertex(String dolphinId);
    if(firstNode == null){
      firstNode = addGraphVertex(startLocation);
    }

    //creation of the last node and if statement for adding the node into the graph.
    Vertex lastNode = getGraphVertex(endLocation);
    if(endNode == null){
      endNode = addGraphVertex(endLocation);
    }

    //creates a new edge
    Edge edgiesG = new Edge(firstNode, lastNode);
    firstNode.addToAdjacencyList(edgiesG);

    }

    /**
    To String will create the view of the graph using the vertices.
    @return String graphCreate: Will return the graph of the vertices.
    */
    public String toString(){
      String graphCreate = " ";
      Vertex graphVertex = verticesG;

      while (graphVertex != null){
        graphCreate += graphVertex;
        graphVertex = graphVertex.nextV;

      }
      return graphCreate;
    }
}
