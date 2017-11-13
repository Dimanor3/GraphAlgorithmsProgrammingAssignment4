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

	For this we had 3 classes, all which were imported from the insertion sort homework.
	With these 3 classes, we went ahead and modified them to both include findLCS as well
    as fix any issues that the previous assignment had and add some new functionality.

	Breakdown of Algorithm
	----------------------

	The longest common subsequence algorithm compares a table of characters, implemented as a
	two dimensional array, and searches for character matches in the horizontal and vertical 
	character intersection. It then traverses the table, moving either left or up depending on 
	the table entry. When the characters match, the traversal may move diagonally. Matching characters
	get added to the longest common subsequence (in our implementation this is an array of
	characters LCS).

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
    in between reads (within the readFile class.)
    
    An issue with this program is that it could be made even more space efficient. We did not
    attempt to do so, but future modifications could improve on this factor.

	Data Structure Design Description
	---------------------------------

	The data structure we choose to use was an arraylist, this is because arraylists are
	scalable unlike their array counterparts. This is very convenient for this project
	since the list of numbers we could be given can end up being any size.
	
	The data structure used to implement the LCS table for the algorithm was a two dimensional
	array of characters.
*/

import java.io.*;
import java.util.Scanner;
import java.util.*;

public class GAPA4 {
	public static void main (String[] args) {
		String gapa4ListString = "";

        Scanner input = new Scanner (System.in);

		// Takes the DNA Strands to have LCS ran on it.
		ArrayList<String> gapa4List = new ArrayList<String> ();

        ArrayList<String> finalizedGAPA4 = new ArrayList<String> ();

		// Gets access to the readfile class.
		readfile rF = new readfile ();

		// Gets access to the writefile class.
		writefile wF = new writefile ();

		// Gets access to the LCS class.
		GAPA4 gapa4Access = new GAPA4 ();

        long start = 0, end = 0, totalTime = 0;

		// Attempts to open selected file(s).
		for (int i = 0; i < args.length; i++) {
            // Opens selected files.
			rF.openFile (args[i]);
            
			// Reads selected file into gapa4List.
			gapa4List.addAll (rF.readFile ());
            
            rF.clearFile ();

    		// Closes selected file.
	    	rF.closeFile ();
		}

        int choice = -1;

        do {
            do {
                System.out.println ("What do you want to do?");
                System.out.println ("1. Graph");
                System.out.println ("2. Dijkstra");
                System.out.println ("3. Kruskal");
                System.out.println ("4. Print");
                System.out.println ("5. Performance");
                System.out.println ("6. Quit");

                choice = input.nextInt ();
            } while (choice <= 0 || choice >= 7);

            switch (choice) {
                case 1:

                    System.out.println ("\nThe graph has been created!\n");
                    break;

                case 2:
    	        	// Gets the starting time of findLCS.
	            	start = System.nanoTime ();


            		// Gets the ending time of findLCS.
            		end = System.nanoTime ();

            		// Gets the total time that findLCS ran.
            		totalTime = end - start;

                    System.out.println ("\nDijkstra has been performed!\n");
                    break;

                case 3:
            		// Gets the starting time of findLCS.
            		start = System.nanoTime ();


            		// Gets the ending time of findLCS.
            		end = System.nanoTime ();

            		// Gets the total time that findLCS ran.
            		totalTime = end - start;

                    System.out.println ("\nFloyd-Warshall has been performed!\n");
                    break;

                case 4:
                    break;

                case 5:
                    break;
            }
        } while (choice != 6);

        System.out.println ("\nQuitting!\n");

        input.close ();
	}
}
