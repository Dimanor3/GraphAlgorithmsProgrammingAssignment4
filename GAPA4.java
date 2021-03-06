/*
	Bijan Razavi
	Elizabeth Thomas
	Gyovanni Boston-Crompton
*/

/*
	README file
	---------------------------

	Program Design Description
	--------------------------

	For this we had 7 classes, GAPA4 (main), ReadFile, graph, edge, vertex, Dijkstra and
	Floyd-Warshall. With these 7 classes we went ahead and designed them to complete all
	the required tasks, from setting up the graph to performing the instructed algorithm.

	Breakdown of Key Functions
	--------------------------

	Graph creates two lists of vertexes and edges then plots them all into the graph.
	
	Dijkstra runs the Dijkstra algorithm and checks the length of time it took to run.
	
	Floyd-Warshall runs the Floyd-Warshall algorithm and checks the length of time it took
	to run.
	
	Print prints out the results of either algorithm.
	
	Performance prints out the amount of time it took to run the algorithm.
	
	Quit quits the program.

	Our Compiler
	------------

	We wrote our program in java, so our compiler was javac.

	Our Platform
	------------

	The platform we used to write this program in was an Intel i5 processor
	running windows 10.

	What works and Fails
	--------------------

	Our program properly reads any number of files, places them into an ArrayList,
	checks the amount of time it takes for the program to run, runs a working findLCS 
    function on the ArrayList, and outputs all the required information.

    Some issues we ran into was an odd duplication issue. Whenever we used two files,
    one of which was empty and another of which had content, the program reads the
    first file into the ArrayList twice. This issue was solved by clearing the unorderedlist
    in between reads (within the ReadFile class.)
    
    An issue with this program is that it could be made even more space efficient. We did not
    attempt to do so, but future modifications could improve on this factor.

	Data Structure Design Description
	---------------------------------

	The data structure we choose to use was both List and arraylist, this is because they
	both are scalable unlike some other data structures, "cough" "cough" array "cough"
	"cough". This is very convenient for this project since many things are huge in size
	we won't have to worry much about presetting the sizes.
*/

import java.io.*;
import java.util.Scanner;
import java.util.*;

public class GAPA4 {
	public static void main (String[] args) {
        // Used to get user input.
        Scanner input = new Scanner (System.in);

        // Determines which algorithm the user choose,
        // it's for printing purposes.
        int whichAlgorithm = -1;

		// Saves the data found in astro-ph.txt
		// to later be parsed and turned into a
		// graph.
		ArrayList<String> gapa4List = new ArrayList<String> ();

		// Creates an ArrayList of Edges and Vertexes to
		// fed into the graph.
		List<Edge> edges = new ArrayList<Edge> ();
		List<Vertex> vertexes = new ArrayList<Vertex> ();
		
		// Gets access to the Dijkstra class.
		Dijkstra dijkstraAlgo = null;
		
		// Gets access to the FW class.
		FW floydWarshallAlgo = null;
		
		// Makes graph.
		Graph graphD = null;
		Graph graphF = null;

		// Gets access to the readfile class.
		ReadFile rF = new ReadFile ();
        
        // Instantiates start, end and totalTime.
        long start = 0, end = 0, totalTimeDijkstra = 0, totalTimeFW = 0;

		// Attempts to open selected file(s).
		// Opens selected files.
		rF.openFile ("astro-ph.txt");
		
		// Reads selected file into gapa4List.
		gapa4List.addAll (rF.readFile ());

		// Closes selected file.
		rF.closeFile ();
		
		// Used to create each edge's unique ID.
		int edgeID = 0;

		// Used to determine what the user
		// wants to do.
        int choice = -1;
		
		// Used to determine if the graph
		// has been created.
		Boolean graphCreated = false;
		
		// Just used to keep a warning from occurring
		// before the user has had the chance to input
		// anything.
		Boolean firstRun = true;

        do {
            do {
				if (!firstRun && (choice <= 0 || choice >= 7)) {
					System.out.println ("\nThat's not an option, please try again :)\n");
				} 

				if (firstRun) {
					firstRun = false;
					System.out.println ("");
				}
				
                System.out.println ("What do you want to do?");
                System.out.println ("1. Graph");
                System.out.println ("2. Dijkstra");
                System.out.println ("3. Floyd-Warshall");
                System.out.println ("4. Print");
                System.out.println ("5. Performance");
                System.out.println ("6. Quit");

                choice = input.nextInt ();
            } while (choice <= 0 || choice >= 7);

            switch (choice) {
				// Creates the graph.
                case 1:
					if (!graphCreated) {
						for (int i = 0; i < gapa4List.size (); i++) {
							if (gapa4List.get (i).contains ("id")) {
								vertexes.add (new Vertex (gapa4List.get (i + 1), gapa4List.get (i + 3).replaceAll ("[\"]", "") + " " + gapa4List.get (i + 4).replaceAll ("[\"]", "")));
							}
							
							if (gapa4List.get (i).contains ("source")) {
								edges.add (new Edge (Integer.toString (edgeID), vertexes.get (Integer.valueOf (gapa4List.get (i + 1))), vertexes.get (Integer.valueOf (gapa4List.get (i + 3))), Double.parseDouble (gapa4List.get (i + 5))));
								
								edgeID++;
							}
						}

						// Makes graph.
						graphD = new Graph (vertexes, edges);
						graphF = new Graph (vertexes, edges);
						System.out.println ("\nThe graph has been created!\n");
						
						graphCreated = true;
						
					} else {
						System.out.println ("\nThe graph has already been created\n");
					}
                    break;

				// Runs Dijkstra's algorithm.
                case 2:
					if (graphCreated) {
						whichAlgorithm = 1;

						// Gets access to the Dijkstra class.
						dijkstraAlgo = new Dijkstra (graphD);
						
						// Gets the starting time of findLCS.
						start = System.nanoTime ();

						// Completes the Dijkstra's algorithm.
						dijkstraAlgo.doDijkstra (vertexes.get (5500));

						// Gets the ending time of findLCS.
						end = System.nanoTime ();

						// Gets the total time that findLCS ran.
						totalTimeDijkstra = end - start;

						System.out.println ("\nDijkstra has been performed!\n");
					} else {
						System.out.println ("\nThe graph has not been built yet, please build it before calling me!\n");
					}
					
                    break;

				// Runs Floyd-Warshall's algorithm.
                case 3:
                    if (graphCreated) {
						whichAlgorithm = 2;
						
						// Gets access to the FW class.
						floydWarshallAlgo = new FW ();
						floydWarshallAlgo.FW (graphF);

						// Gets the starting time of findLCS.
						start = System.nanoTime ();

						floydWarshallAlgo.doFW ();

						// Gets the ending time of findLCS.
						end = System.nanoTime ();

						// Gets the total time that findLCS ran.
						totalTimeFW = end - start;

						System.out.println ("\nFloyd-Warshall has been performed!\n");
					} else {
						System.out.println ("\nThe graph has not been built yet, please build it before calling me!\n");
					}
					
                    break;

				// Prints out the results of either
				// Dijkstra's or Floyd-Warshall's 
				// algorithm.
                case 4:
                    if (whichAlgorithm == 1) {
                        System.out.println ("\nDijkstra's result:\n" + dijkstraAlgo.getSPath (vertexes.get (18)) + "\n");
                    } else if (whichAlgorithm == 2) {
                        System.out.println ("\nFloyd-Warshall's result:\n" + floydWarshallAlgo.getSPairsPath () + "\n");
                    } else {
						System.out.println ("\nNo algorithms have been called, please call one!\n");
					}
					
                    break;

				// Prints out the length of time that
				// Dijkstra's or Floyd-Warshall's 
				// algorithm took to complete.
                case 5:
                    if (whichAlgorithm == 1) {
                        System.out.println ("\nThe total time to run Dijkstra's Algorithm is: " + totalTimeDijkstra + "\n");
                    } else if (whichAlgorithm == 2) {
                        System.out.println ("\nThe total time to run Floyd-Warshall's Algorithm is: " + totalTimeFW + "\n");
                    } else {
						System.out.println ("\nNo algorithms have been called, please call one!\n");
					}
					
                    break;
            }
        } while (choice != 6);

        System.out.println ("\nQuitting!\n");

        input.close ();
	}
}
