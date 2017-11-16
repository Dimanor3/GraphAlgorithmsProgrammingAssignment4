import java.io.*;
import java.util.*;

public class readGML
{
	private Scanner fileInput;
	private StringTokenizer stok;
	private ArrayList<Vertex> vertices;
	private ArrayList<Edge> edges;
	
	public void openFile(String filePath)throws IOException
	{
		try
		{
			fileInput = new Scanner(new File (filepath));
		}
		catch (Exception e)
		{
			throw new FileNotFoundException("The file could not be found");
		}
		
		stok = new StringTokenizer(fileInput, " ");
	}
	
	public void readGML()
	{
		vertices = new ArrayList<Vertex>();
		Vertex tempV;
		String tempID;
		String tempName;
		
		while (fileInput.hasNextLine())
		{
		while (stok.hasMoreTokens())
		{
			if (stok.nextToken().equals("node"))
			{
				fileInput.nextLine();
				fileInput.nextLine();
				stok.nextToken();
				String tempID = stok.nextToken();
				fileInput.nextLine();
				stok.nextToken();
				tempName = stok.nextToken() + stok.nextToken();
				tempV = new Vertex(tempID, tempName);
				System.out.println(tempV.toString());
				vertices.add(tempV);
			}
			
		}
		}
	}
}


