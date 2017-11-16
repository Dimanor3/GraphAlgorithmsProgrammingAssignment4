import java.util.*;
import java.io.*;


/**
This class will create the graph using the vertices and edges classes.
*/

public class Graph {

  //declaration of variables
  private Vertex verticesG;

  /**
  Will return the vertex that is specified by a certain astroId
  @param String astroId: will hold the astroId
  @return Vertex newVerticesG: will return the specific vertex called.
  */
  private Vertex getGraphVertex(String astroId){
    Vertex newVerticesG = verticesG;
    while(newVerticesG != null && !newVerticesG.astroId.equals(astroId)){
      newVerticesG = newVerticesG.getnextV();
    }
    return newVerticesG;
  }

  /**
  This method will add the vertex of the certain astroId.
  @param String astroId: will hold the astroId
  @return Vertex newVerticesG: will return the specific vertex added.
  */
  private Vertex addGraphVertex(String astroId){
    Vertex newVerticesG = new Vertex(astroId);

    //will add to the beginning of the list.
    newVerticesG.nextV = verticesG;
    verticesG = newVerticesG;

    return newVerticesG;
  }

  /**
  This method will add the edge between the specific start and end vertices and will be
  stored in the adjacency list.
  */
  public void addGraphEdge(String startLocation, String endLocation, double value){
    //creation of first node and if statement for adding the node into the graph.
    Vertex firstNode = getGraphVertex(astroId);
    if(firstNode == null){
      firstNode = addGraphVertex(startLocation);
    }

    //creation of the last node and if statement for adding the node into the graph.
    Vertex lastNode = getGraphVertex(endLocation);
    if(endNode == null){
      endNode = addGraphVertex(endLocation);
    }

    //creates a new edge
    Edge edgiesG = new Edge(firstNode, lastNode, value);
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

    public void getAstroInformation(String astroFileName){
      String astroString = " ";

      try{
        Scanner astroFile = new Scanner(new File(astroFileName));

        while(astroFile.hasNextLine()){
          astroString = astroFile.nextLine();
          Scanner astroLine = new Scanner(astroString);

          String startLocation = line.next();
          String endLocation = line.next();
          double value = line.nextDouble();
          addEdge(startLocation, endLocation, value);
        }catch (IOException except){
          System.out.println("Error Finding: " + astroFileName);
          System.exit(1);
        }catch (NoSuchElementException except)
        {
          System.out.println("invalid input for the line " + astroString);
          System.exit(1);
        }
      }
    }
}
