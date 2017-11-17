import static java.lang.String.*;
import java.util.*;

/*
 * Class to execute the Floyd Warshall algorithm to find all pairs shortest paths.
 */
public class FW {
	private List<Vertex> vertices; 							// List of graph vertices.
	private List<Edge> edges; 								// List of graph edges.
	private int numV; 										// Number of vertices in the graph.
	private int[][] fwMatrix; 								// Matrix of weights used to carry out the floyd warshall algorithm.
	private int[][] nextMatrix; 							// Matrix of indices used to carry out the floyd warshall.
	private String shortestPaths; 							// All pairs shortest paths, in a string format for printability.
	private final int POSITIVE_INF = Integer.MAX_VALUE;		// A large integer to represent positive infinity.
	
	/**
	 * Constructor
	 * @param Graph G a graph of vertices and edges.
	 */
	public void FW (Graph G) {
		vertices = G.getVerticesG ();	// Extract vertices from graph.
		edges = G.getEdgiesG ();		// Extract edges from graph.
		numV = vertices.size ();		// Get the number of vertices from the graph.
		
		fwMatrix = new int[numV][numV]; // Initialize square matrix size of number of vertices.

		for (int i = 0; i < numV; i++) { // Loop through matrix.
			for (int j = 0; j < numV; j++) {
				fwMatrix[i][j] = POSITIVE_INF; // Set all values to positive infinity.
				nextMatrix[i][j] = 0; // Set next indices all equal to 0.
			}
		}
		
		// Loop through edges at the intersection of 
		// two vertices (where an edge exists), set 
		// the fwMatrix equal to the weight.
		for (Edge eachEdge: edges) {
			fwMatrix[vertices.indexOf ( eachEdge.getBeginLocation ())][vertices.indexOf (eachEdge.getEndLocation ())] = eachEdge.getWeightofEdge ();
		}
	}
 
	/**
	 * Execution of the floyd warshall algorithm.
	 */
    public void doFW () {
    	// Loop through the matrix.
        for (int x = 0; x < numV; x++) {
            for (int y = 0; y < numV; y++) {
                for (int z = 0; z < numV; z++) {
                    if (y == z)	{ // Every vertex has a path to itself, where weight is 0.
						fwMatrix[y][z] = 0;
                    } else { // For all other edges where vertices are not the same.
						int yz = fwMatrix[y][z]; // Set weights.
                        int yx = fwMatrix[y][x];
                        int xz = fwMatrix[x][z];
                        // Compare using relaxation.
                        int sum = (yx != POSITIVE_INF && xz != POSITIVE_INF) ? (yx + xz): POSITIVE_INF;
                        if (yz > sum) {
                            fwMatrix[y][z] = sum;
							nextMatrix[y][z] = x; // Update next matrix.
                        }
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
	private List<Vertex> getPath (int i, int j) {
		ArrayList<Vertex> path = new ArrayList<Vertex> ();
		
		getPath (i, nextMatrix[i][j]); // Get the path.
		path.add (vertices.get (nextMatrix[i][j])); // Add the path to the list.
		getPath (nextMatrix[i][j], j); // Get the alternate path.

		return path;
	}
 
	
	/**
	 * A method to get the string version of all the shortest paths for all
	 * pairs in the graph.
	 * @return String a string version of all the shortest paths for all pairs.
	 */
    private String getResult ()	{   
		List<Vertex> tempPath;
		StringBuilder SB = new StringBuilder ();
		
		// Loop through the matrix.
		for (int k = 0; k < numV; k++) {
            for (int h = 0; h < numV; h++) {
                if (fwMatrix[k][h] != POSITIVE_INF) { // If a path exists.
					SB.append ("\nShortest Path from: " + vertices.get (k).getVertexName () + " to: " + vertices.get (h).getVertexName () + "\n");
					tempPath = getPath (k, h); // Get the path between vertices.
					for (Vertex v: tempPath) {	// Add the path to the final string.
						SB.append (v.getVertexName () + " --> ");
					}

					SB.append ("\nTotal Path Weight: " + fwMatrix[h][k] + " ");
				}
			}
		}

		return SB.toString ();
    }
}
