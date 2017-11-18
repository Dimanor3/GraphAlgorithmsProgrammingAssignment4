import static java.lang.String.*;
import java.util.*;

/*
 * Class to execute the Floyd Warshall algorithm to find all pairs shortest paths.
 */
public class FW {
	private List<Vertex> vertices; 							// List of graph vertices.
	private List<Edge> edges; 								// List of graph edges.
	private int numV; 										// Number of vertices in the graph.
	private double[][] fwMatrix; 							// Matrix of weights used to carry out the floyd warshall algorithm.
	private int[][] nextMatrix; 							// Matrix of indices used to carry out the floyd warshall.
	private String shortestPaths; 							// All pairs shortest paths, in a string format for printability.
	private final int POSITIVE_INF = Integer.MAX_VALUE;		// A large integer to represent positive infinity.
	private ArrayList<Vertex> tempPath;
	
	
	/**
	 * Constructor
	 * @param Graph G a graph of vertices and edges.
	 */
	public void FW (Graph G) {
		vertices = G.getVerticesG ();	// Extract vertices from graph.
		edges = G.getEdgiesG ();		// Extract edges from graph.
		numV = vertices.size ();		// Get the number of vertices from the graph.
		
		
		ArrayList<Vertex> newVertices = new ArrayList<Vertex>();
		for (int i = 0; i < (int) numV / 10; i++)
		{
			newVertices.add(vertices.get(i));
		}
		
		vertices = newVertices;
		numV = vertices.size();
		
		fwMatrix = new double[numV][numV]; // Initialize square matrix size of number of vertices.
		
		for (int i = 0; i < numV; i++) { // Loop through matrix.
			for (int j = 0; j < numV; j++) {
				fwMatrix[i][j] = POSITIVE_INF; // Set all values to positive infinity.
			
				if (i == j)
				{
					fwMatrix[i][j] = 0; //every vertex has a path to itself with weight 0
				}
				
			}
		}
		
		// Loop through edges at the intersection of 
		// two vertices (where an edge exists), set 
		// the fwMatrix equal to the weight.
		for (Edge eachEdge: edges) {
			
			int start = -1;
			int end = -1;
			
			if (vertices.contains(eachEdge.getBeginLocation()) && vertices.contains(eachEdge.getEndLocation()))
			{
				start = vertices.indexOf(eachEdge.getBeginLocation());
				end = vertices.indexOf(eachEdge.getEndLocation());
			}
			
			if (start != -1 && end != -1)
				fwMatrix[start][end] = eachEdge.getWeightofEdge (); //add weight of edge to matrix at the intersection
		}
		
		nextMatrix = constructNextMatrix(); //fill next matrix with initial values
	}
	
	/**
	 * Execution of the floyd warshall algorithm.
	 */
    public void doFW () {
    	// Loop through the matrix.
        for (int x = 0; x < numV; x++) {
            for (int y = 0; y < numV; y++) {
                for (int z = 0; z < numV; z++) {
                    
                	if (fwMatrix[y][x] == POSITIVE_INF || fwMatrix[x][z] == POSITIVE_INF){ 
						
                    	continue;
                    	
                    } 
                    
                    // For all other edges where vertices are not the same.
					double yz = fwMatrix[y][z]; // weight variables for relaxation comparison
                    double yx = fwMatrix[y][x];
                    double xz = fwMatrix[x][z];
                   
                    // Compare using relaxation
                    if (yz > yx + xz) { //if shorter path
                        fwMatrix[y][z] = yz + xz;
                        nextMatrix[y][z] = nextMatrix[x][z]; // Update next matrix.
                        }
					}
				}
			}
        
        shortestPaths = getResult (); // Get the string formatted version of the result.
    }
	
    /**
     * Method to get the printable string representation of all the shortest paths.
     * @return String shortestPaths the string version of all pairs shortest path solution.
     */
	public String getSPairsPath () {
		return shortestPaths;
	}
	
	/**
	 * A method to traverse the next matrix to return a list version of the path between a vertex pair,
	 * which will be converted to a string for printing.
	 * 
	 * @return List<Vertex> path a list of the vertices in the shortest path of two vertices.
	 */
	private void getFWPath (int k, int j) {
		
		if (k == j)
		{
			tempPath.add(vertices.get(k));
					
		}
		
		else if (nextMatrix[k][j] == 0)
		{
			tempPath.add(null);
		}
		
		else
		{
			getFWPath(k, nextMatrix[k][j]);
			tempPath.add(vertices.get(j));
		}
		
	}
 
	
	/**
	 * A method to get the string version of all the shortest paths for all
	 * pairs in the graph.
	 * @return String a string version of all the shortest paths for all pairs.
	 */
    private String getResult ()	{   
		StringBuilder SB = new StringBuilder ();
		
		//a meta-data message
		SB.append("Note: since the graph is too large to compute this algorithm in ram, we will be )"
				+ "showing the all pairs shortest path for a sampling of vertex pairs \n");
		
		// Loop through the matrix.
		for (int k = 0; k < numV; k++) {
			
            for (int h = 0; h < numV; h++) {
                
            	if (fwMatrix[k][h] < 100) { // If a path exists.
					
            		SB.append("\nShortest Path from: " + vertices.get (k).getVertexName () + " to: " + vertices.get (h).getVertexName () + "\n");
					getFWPath (k, h); // Get the path between vertices
					
					for (int i = 0; i < tempPath.size(); i++)
					{
						SB.append(tempPath.get(i).toString() + " --> ");
					}
					
					SB.append("\nTotal Path Weight: " + fwMatrix[h][k] + " ");
					tempPath = new ArrayList<Vertex>();
				}
            	
			}
		}

		return SB.toString ();
    }
    
    private int[][] constructNextMatrix()
    {
    	int n[][] = new int[numV][numV];
    	
    	for (int i = 0; i < numV; i++)
    	{
    		for (int k = 0; k < numV; k++)
    		{
    			if (fwMatrix[i][k] != 0 && fwMatrix[i][k] != POSITIVE_INF)
    			{
    				n[i][k] = i;
    			}
    			
    			else
    			{
    				n[i][k] = -1;
    			}
    		}
    	}
    	
    	return n;
    }
    
}
