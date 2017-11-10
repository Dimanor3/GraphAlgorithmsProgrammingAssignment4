/**
This class will vertices of the graph.
*/

public class Vertex{

  final private String dolphinId;
  final private String dolphinName;

  public Vertex(String dolphinId, String dolphinName){
    this.dolphinId = dolphinId;
    this.dolphinName = dolphinName;
  }

  /**
  This get method will get the dolphin's name.
  @return dolphinName: This will return the dolphin's name.
  */
  public String getDolphinName()
  {
    return dolphinName;
  }

  /**
  This get method will get the dolphin's ID.
  @return dolphinId: This will return the dolphin's ID.
  */
  public String getDolphinId(){
    return dolphinId
  }

  }
