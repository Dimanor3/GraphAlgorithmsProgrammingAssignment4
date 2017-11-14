import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Dijkstra {
    private List<vertex> vertices;                  // Vertices.
    private List<edge> edges;                       // Edges.
    private Set<vertex> explored;                   // Explored vertices.
    private Set<vertex> unexplored;                 // Unexplored vertices.
    private Map<vertex, vertex> parent;             // Predecessors of path vertices.
    private Map<vertex, Integer> length;            // Weight associated with path.
	private stringSPath;

	/**
		Constructor
    **/
    public Dijkstra (Graph graph) {
        /*
         * Make a duplicate of the vertices and edges
         * in the graph to work with the algorithm,
         * from the input graph.
         */
        this.vertices = new ArrayList<vertex> (graph.getVertexesG ());
        this.edges = new ArrayList<edge> (graph.getEdgiesG ());
    }

	
	/**
		Execution of the algorithm.
		@param vertex s the starting vertex (source)
	**/
    public void doDijkstra (vertex s) {
		explored = new HashSet<vertex> ();          // Hash Set of vertices that have been discovered.
        unexplored = new HashSet<vertex> ();        // Hash set of vertices not yet discovered.
        length = new HashMap<vertex, Integer> ();   // Hash Map representing the length associated with each vertex.
        parent = new HashMap<vertex, vertex> ();    // Hash map to keep track of the predessors.
        length.put (s, 0);                          // Source vertex has an initial length of zero.
        unexplored.add (s);                         // s gets added to the discovered vertices.
        
        /*
    		Loop through the unexplored vertices extract the
            minimum vertex from the unexplored and add it to 
            the explored find the minimum length for that
            vertex.
        */
		while (unexplored.size () > 0) {
            vertex currentV = findMinV (unexplored);
            explored.add (currentV);
            unexplored.remove (currentV);
            findMinLens (currentV);
        }
    }

	/**
		Performs the relaxation step for vertices.
		Updates the lengths and parent pointers accordingly
		@param vertex currentV
	**/
    private void findMinLens (vertex currentV) {
       
	   List<vertex> neighbors = getAdjacents (currentV);     // Get the neighboring vertices of the current vertex.
        
		// Loop through all the neighbors, reachable unxeplored from currentV.
		for (vertex v : neighbors) {
			//relaxation step for each vertex in the neighboring vertices
			//if a shorter path is found, it is added
            
            /*
               Relaxation step for each vertex in the neighboring
               vertices, if a shorter path is found, it is added.
             */
            if (getLen (v) > getLen (currentV) + getEdgeLen (currentV, v)) {    // Triangle inequality.
                length.put (v, getLen (currentV) + getEdgeLen (currentV, v));
                parent.put (v, currentV);
                unexplored.add (v);
            }
        }
    }

	/**
		Gets the length of edge and returns
		@param vertex currentV
		@param vertex v
		@return int weight of edge
	**/
    private int getEdgeLen (vertex currentV, vertex v) {
        /*
           Loop through all edges in the edge hash set,
           find the current edge and return its associated
           weight.
         */
		for (edge e : edges) {
            if (e.getBeginLocation ().equals (currentV) && e.getEndLocation ().equals (v)) {
                return e.getWeightofEdge ();
            }
        }

        throw new RuntimeException ("Error");
    }

	/**
		Returns the neighboring elements of a vertex
		@param vertex currentV
		@return List<vertex> an adjacency list of vertices
	**/
    private List<vertex> getAdjacents (vertex currentV) {
        List<vertex> neighbors = new ArrayList<vertex> ();
        for (edge e : edges) {
            if (e.getBeginLocation ().equals (currentV) && !isExplored (e.getEndLocation ())) {
                neighbors.add (e.getEndLocation ());
            }
        }

        return neighbors;
    }

	/**
		Finds and returns the minimum length vertex in a set of vertices
		@param Set<vertex> vertices a set of vertices (Hash Set) to be searched
		@return vertex min the minimum length (weight) vertex in the set
	**/
    private vertex findMinV (Set<vertex> vertices) {
        vertex min = null;  // Initialize minimum.
        /*
           Loop through all vertices.
           Update minimum as you go (if smaller length is found)
           and return min.
         */
		for (vertex v : vertices) {
            if (min == null) {
                min = v;
            } else {
                if (getLen (v) < getLen (min)) {
                    min = v;
                }
            }
        }

        return min;
    }

	
	/**
		Returns true if the vertex has been explored, false if not
		@param vertex v
		@return boolean true/false 
	**/
    private boolean isExplored (vertex v) {
        return explored.contains (v);
    }

	/**
		Finds and returns the length (weight) of input vertex
		@param vertex target
		@return int len the length (weight) of smallest value or null if no length
	**/
    private int getLen (vertex target) {
        Integer len = length.get (target);  // Get length of the input vertex.
        
		//if the input vertex length is null, return positive infinity
		//otherwise return the length of the input vertex
        
        /*
           If the input vertex length is null, return positive
           infinity, otherwise, return the length of the input
           vertex.
         */
		if (len == null) {
            return Integer.MAX_VALUE;
        } else {
            return len;
        }
    }

    /**
		Returns the shortest path, as a linked list of vertices in that path
		@param vertex v the source vertex
		@return LinkedList<vertex> the vertices in the shortest path
	**/
    public LinkedList<vertex> getSPath (vertex v) {
		
		// Create a linked list of vertices in the shortest path.
        LinkedList<vertex> shortestP = new LinkedList<vertex>();
        vertex leg = v;             // Each leg in the path, to be updated.
		StringBuilder SB = new StringBuilder ();
        
		// If the shortest path does not exist
		// return null.
        if (parent.get (leg) == null) {
            return null;
        }
		
		// If the shortest path exists.
        shortestP.add (leg);     // Add the first leg of the path.

        /*
           Follow the predecessors produced by the algorithm,
           add each one to the shortest path.
         */
        while (parent.get (leg) != null) {
            leg = parent.get (leg);
            shortestP.add (leg);
        }
		
        /*
           Reorder the linkedlist so the shortest path
           terminates in the input vertex (forward order).
         */
        Collections.reverse (shortestP);
		
		for (vertex eachVertex : shortestP)
		{
			SB.append (eachVertex.getDolphinName ());
		}
		
		stringSPath = SB.tostring ();

		return stringSPath;
    }

}
