/*
	Bijan Razavi
	Elizabeth Thomas
	Gyovanni Boston-Crompton
*/

import java.io.*;
import java.util.*;

/*
	This class is used to get access to any user
	provided text document.

	Once the text document is read it is, within
	this class, turned into a usable String arraylist
	for main.

	Afterwards it returns the arraylist to main.
*/
public class readfile {
	// This scanner will be used to open, read and close the choosen file.
	private Scanner read;

	// This arraylist holds the provided content found
	// in the text document.
	private ArrayList<String> txtData = new ArrayList<String> ();

    /*
	    This function opens the file.
	*/
	public void openFile (String fileName) {
		try {
			read = new Scanner (new File (fileName));
		} catch (Exception e) {
			System.out.println ("Could not find file\n");
		}
	}

	/*
	    This function reads the file and turns the data into a String
	    arraylist for main, afterwards, it returns the arraylist.
	*/
	public ArrayList<String> readFile () {
		while (read.hasNext ()) {
			txtData.add (read.next ().replaceAll ("[;]", ""));
		}

		return txtData;
	}

	// This function closes the file.
	public void closeFile () {
		read.close ();
	}

	// This function clears the data found inside txtData
	public void clearFile () {
	    txtData.clear ();
	}
}
