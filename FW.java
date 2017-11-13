import static java.lang.String.format;
import java.util.Arrays;
 
public class FloydWarshall {
	
	private int[][] edgeWeights;
	private String shortestPath;
	private double[][] fwMatrix;
	private int[][] nextEdge;
	private final double POSITIVE_INF = double.POSITIVE_INFINITY;
	
	public FW(Graph G) 
	{
		int[][] edgeWeights = new int[G.numEdges()][3];
		edges = G.getEdgiesG();
		i, j = 0;
		for (edge e: edgies)
		{
			edgeWeights[i][j] = e.getBeginLocation();
			edgeWeights[i][j + 1] = e.getEndLocation();
			edgeWeights[i][j + 2] = e.getWeightofEdge();
			i++;
		}
		
		fwMatrix = new double[G.numVertices()][G.numVertices()];
        for (double[] eachRow : fwMatrix)
            Arrays.fill(eachRow, POSITIVE_INF);
 
        for (int[] weight : edgeWeights)
            fwMatrix[weight[0] - 1][weight[1] - 1] = weight[2];
 
        nextEdge = new int[G.numVertices()][G.numVertices()];
        for (int k = 0; k < nextEdge.length; k++) {
            for (int h = 0; h < nextEdge.length; h++)
                if (k != h)
                    nextEdge[k][h] = h + 1;
        }
	}
 
    public void doFW() {
        for (int x = 0; x < numVertices; x++){
            for (int y = 0; y < numVertices; y++){
                for (int z = 0; z < numVertices; z++){
                    if (fwMatrix[y][x] + fwMatrix[x][z] < fwMatrix[y][z]) {
                        fwMatrix[y][z] = fwMatrix[y][x] + fwMatrix[x][z];
                        nextEdge[y][z] = nextEdge[y][x];
                    }
				}
			}
		}
        shortestPath = getResult(fwMatrix, nextEdge);
    }
	
	public String getSPairsPath()
	{
		return shortestPath;
	}
	
 
    private static String getResult(double[][] fwMatrix, int[][] nextEdge) {
        StringBuilder SB = new StringBuilder();
		SB.append("vertices   path weight   shortest path \n");
        for (int k = 0; k < nextEdge.length; k++) {
            for (int h = 0; h < nextEdge.length; h++) {
                if (k != h) {
                    int a = k + 1;
                    int b = h + 1;
                    String resultString = format("%d --> %d    %2d     %s", a, b,
                            (int)fwMatrix[k][h], a);
                    do {
                        u = nextEdge[a - 1][b - 1];
                        resultString += " --> " + a;
                    } while (a != b);
                    SB.append(resultString + "\n");
                }
            }
        }
		return SB.toString();
    }
}