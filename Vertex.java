/**
This class will vertices of the graph.
*/

public class Vertex {
  final private String dolphinId;
  final private String dolphinName;

  public Vertex (String dolphinId, String dolphinName) {
    this.dolphinId = dolphinId;
    this.dolphinName = dolphinName;
  }

  /**
  This get method will get the dolphin's name.
  @return dolphinName: This will return the dolphin's name.
  */
  public String getDolphinName () {
    return dolphinName;
  }

  /**
  This get method will get the dolphin's ID.
  @return dolphinId: This will return the dolphin's ID.
  */

  public boolean equals (Object vertex) {
    if (this == vertex) {
      return true;
    }

    if (vertex == null) {
      return false;
    }

    if (getClass () != vertex.getClass ()) {
      return false;
    }

    Vertex newVertex = (Vertex) vertex;
    
    {
      if (dolphinId == null) {
        return false;
      }

      else if (!dolphinId.equals (newVertex.dolphinId)) {
        return false;
      }

      return true;
    }
  }

  public String getDolphinId () {
    return dolphinId;
  }

  public int makeVertex () {
    int finalNumber = 1;
    int number = 31;

    number = number * finalNumber + ((dolphinId == null) ? 0 : id.makeVertex ());

    return number;
  }
}
