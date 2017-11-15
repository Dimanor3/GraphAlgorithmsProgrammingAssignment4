import static java.lang.String.format;
import java.util.Arrays;
import java.util.List;

import sun.security.provider.certpath.Vertex;
 
public class FW {
	private List<Vertex> vertices;
	private List<Edge> edges;
	private int numV;
	private int[][] fwMatrix;
	private int[][] nextMatrix;
	private String shortestPaths;
	private final int POSITIVE_INF = Integer.MAX_VALUE;
	
	public void FW (Graph G)	{
		vertices = G.getGraphVertex ();
		edges = G.getEdgiesG ();
		numV = vertices.size ();
		
		fwMatrix = new int[numV][numV];

		for (int i = 0; i < numV; i++) {
			for (int j = 0; j < numV; j++) {
				fwMatrix[i][j] = POSITIVE_INF;
				nextMatrix[i][j] = 0;
			}
		}
		
		for (Edge eachEdge: edges) {
			fwMatrix[vertices.indexOf( eachEdge.getBeginLocation ())][vertices.indexOf (eachEdge.getEndLocation ())] = eachEdge.getWeightofEdge ();
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
                            fwMatrix[y][z] = sum;
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
	
	public List<Vertex> getPath (int i, int j) {
		ArrayList<Vertex> path = new ArrayList<Vertex> ();
		
		getPath (i, nextMatrix[i][j]);
		path.add(vertices.get (nextMatrix[i][j]));
		getPath (nextMatrix[i][j], j);

		return path;
	}
 
    private String getResult ()	{   
		List<Vertex> tempPath;
		StringBuilder SB = new StringBuilder ();

		for (int k = 0; k < numV; k++) {
            for (int h = 0; h < numV; h++) {
                if (fwMatrix[k][h] != POSITIVE_INF) {
					SB.append ("\nShortest Path from: " + vertices.get (k).getDolphinName () + " to: " + vertices.get (h).getDolphinName () + "\n");
					tempPath = getPath (k, h);
					for (Vertex v: tempPath) {	
						SB.append (v.getDolphinName () + " --> ");
					}

					SB.append ("\nTotal Path Weight: " + fwMatrix[h][k] + " ");
				}
			}
		}

		return SB.toString ();
    }
}
