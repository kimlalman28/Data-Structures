import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class Maze
{
  private Vertex[] rooms;

  public Maze(String filename)
  {
	  File input = new File(filename); //read in file
	  
	  Scanner scan; //for lines
	  Scanner values; //for values contained in the lines
	  String name; //stored values
	  int xCoordinate, yCoordinate, v1, v2; //stores values
	  int i=0; //index for array
	  
	try {
		
		scan = new Scanner(input); //create instance of scanner with input file
		String line = scan.nextLine(); //reads line
		int numRooms = Integer.parseInt(line); //first line is the number of vertices
		 
		rooms = new Vertex[numRooms]; //create array of vertices of a size which is stored in numRooms
		line = scan.nextLine(); //read next line
		
		while(!line.isEmpty()){ //continue to read next line until it reads in a blank line
			values = new Scanner(line); //creates an instance which will read values in the line
			
			name = values.next(); //stores name of room
		    xCoordinate = Integer.parseInt(values.next()); //stores x coordinate of room
		    yCoordinate = Integer.parseInt(values.next()); //stores y coordinate of room
			  
		    Vertex v = new Vertex(); //create new instance of vertex
		    	v.setName(name); //set name for vertex
		    	v.setXCoord(xCoordinate); //set x coordinate of vertex
		    	v.setYCoord(yCoordinate); //set y coordinate of vertex
					rooms[i] = v; //store vertex in rooms array with respective index
		   line = scan.nextLine(); //read next line
		   i++; //increment indexing
	   }
			line = scan.nextLine(); //read line to get to next part of maze file
	   
	   while(!line.equals("-1 -1")){ //keep reading next line until it reads "-1 -1"
		   values = new Scanner(line); //create instance of scanner that will store values in the lines
		   v1 = Integer.parseInt(values.next()); //stores room1 vertex
		   v2 = Integer.parseInt(values.next()); //stores room2 vertex

		   if(v2 >= rooms.length) { //check for invalid edges, will not add invalid edges to graph
			   line = scan.nextLine(); //read next line
			   continue;
		   }
		   Edge e = new Edge(); //create instance of a new edge
		   e.setAdjacentVertex(v2); //set the adjacent vertex of the current vertex
		   rooms[v1].addEdge(e); //add the edge with respect to vertices linked list
		   
		   line = scan.nextLine(); //read next line
	   }
		
	} catch (FileNotFoundException e) { //if file is not found, throw exception
		e.printStackTrace();
	}
} //end maze method

  public Vertex[] getRooms() 
  {
	  return rooms; //returns array of vertices
  }

  public String toString()
  {
	  String maze = toStringA() +"\n"+ toStringB(); //calls two helper methods to construct toString() method
	  return maze;
	  
  }
  
  private String toStringA(){
	  //helper method for room names and coordinates
	  String allRooms = Integer.toString(rooms.length)+"\n";
	  for(int i=0; i<rooms.length; i++){
		  allRooms = allRooms + rooms[i].getName()+" "+rooms[i].getXCoord()+" "+rooms[i].getYCoord()+"\n";
	  }
	  return allRooms;
	  
  }
  
  private String toStringB(){
	  //helper method for edges
	 String allEdges = "";
	 for(int i=0; i<rooms.length; i++){
		 Iterator<Edge> r = rooms[i].getEdgesIterator();
		 while(r.hasNext()){
			allEdges = allEdges + i + " " + r.next().getAdjacentVertex() + "\n"; 
		 }
	 }
	 return allEdges;
  }
  
}//end maze class
