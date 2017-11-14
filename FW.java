import static java.lang.String.format;
import java.util.Arrays;
import java.util.List;
 
public class FloydWarshall {
	private List<vertex> vertices;
	private List<vertex> edges;
	private int numVertices;
	private int[][] fwMatrix;
	private int[][] nextMatrix;
	private String shortestPaths;
	private final int POSITIVE_INF = (int)double.POSITIVE_INFINITY;
	
	public FW (Graph G)	{
		vertices = G.getVerticesG ();
		edges = G.getEdgiesG ();
		numV = vertices.size ();
		
		fwMatrix = new int[numV][numV];

		for (int i = 0; i < numV; i++) {
			for (int j = 0; j < numV; j++) {
				fwMatrix[i][j] = POSITIVE_INF;
				nextMatrix[i][j] = 0;
			}
		}
		
		for (edge eachEdge: edges) {
			fwMatrix[vertices.indexOf (eachEdge.getBeginLocation ())][vertices.indexOf (eachEdge.getEndLocation ())] = eachEdge.getWeightOfEdge ();
		}
	}
 
    public void doFW () {
        for (int x = 0; x < numV; x++) {
            for (int y = 0; y < numV; y++) {
                for (int z = 0; z < numV; z++) {
                    if (y == z)	{
						fwMatrix[y][z] = 0;
                    } else {
						int yz = fwMatrix[y][z];
                        int yx = fwMatrix[y][x];
                        int xz = fwMatrix[x][z];
                        int sum = (yx != POSITIVE_INF && xz != POSITIVE_INF) ? (yx + xz): Integer.MAX_VALUE;
                        if (yz > sum) {
                            sums[y][z] = sum;
							nextMatrix[y][z] = x;
                        }
					}
				}
			}
		}

        shortestPaths = getResult ();
    }
	
	public String getSPairsPath () {
		return shortestPaths;
	}
	
	public List<vertex> getPath (int i, int j) {
		List<vertex> path = new List ();
		
		getPath (i, P[i][j]);
		path += vertices.get (P[i][j]);
		getPath (P[i][j], j);

		return path;
	}
 
    private String getResult ()	{   
		List<vertex> tempPath;
		StringBuilder SB = new StringBuilder ();

		for (int k = 0; k < numV; k++) {
            for (int h = 0; h < numV; h++) {
                if (fwMatrix[k][h] != POSITIVE_INF) {
					SB.append ("\nShortest Path from: " + vertices.get (k).getDolphinName () + " to: " + vertices.get (h).getDolphinName () + "\n");
					tempPath = getPath (k, h);
					for (vertex v: tempPath) {	
						SB.append (v.getDolphinName () + " --> ");
					}

					SB.append ("\nTotal Path Weight: " + fwMatrix[h][k] + " ");
				}
			}
		}

		return SB.toString ();
    }
}
