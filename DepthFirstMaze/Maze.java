import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class Maze
{
	private Vertex[] rooms;
	private DoublyLinkedList<Vertex> pathSolution;

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

		pathSolution = new DoublyLinkedList<Vertex>(); //create a linked list to hold maze solution
	} //end maze method



	public Vertex[] getRooms() 
	{
		return rooms; //returns array of vertices
	}

//ASSIGNMENT 1
//	public String toString()
//	{
//		String maze = toStringA() +"\n"+ toStringB(); //calls two helper methods to construct toString() method
//		return maze;
//
//	}
//
//	private String toStringA(){
//		//helper method for room names and coordinates
//		String allRooms = Integer.toString(rooms.length)+"\n";
//		for(int i=0; i<rooms.length; i++){
//			allRooms = allRooms + rooms[i].getName()+" "+rooms[i].getXCoord()+" "+rooms[i].getYCoord()+"\n";
//		}
//		return allRooms;
//
//	}
//
//	private String toStringB(){
//		//helper method for edges
//		String allEdges = "";
//		for(int i=0; i<rooms.length; i++){
//			Iterator<Edge> r = rooms[i].getEdgesIterator();
//			while(r.hasNext()){
//				allEdges = allEdges + i + " " + r.next().getAdjacentVertex() + "\n"; 
//			}
//		}
//		return allEdges;
//	}

	public void findPath(){
		if(pathSolution == null){
			System.out.println("No Path"); //when an addition call is made, first check if it stores null
			return;
		}
		else if(!pathSolution.isEmpty()){
			print(); //if linked list is not null and not empty, print path
			return;
		}
		else if(pathSolution.isEmpty()){ //if linked list is empty, it will go through the search
			Boolean[] visited = new Boolean[rooms.length]; //array to store if a room has been visited
			
			for(int i=0; i<rooms.length; i++){ //initialize all elements in array as false since they have not been visited
				visited[i] = false;
			}
			
			pathSolution = dfs(0, rooms.length-1, visited); //call on dfs and store result into solution linked list
			if(pathSolution == null) System.out.println("No Path"); //if pathSolution returns null, there is no path
			else print(); //print if there is a path
		}
	}

	private DoublyLinkedList<Vertex> dfs(int s, int end, Boolean[] visited){
		visited[s] = true; 
		
		if(s==end){ //when last room is visited
			DoublyLinkedList<Vertex> path = new DoublyLinkedList<Vertex>(); //create a linked list that will store the path on the way back
			path.add(0, rooms[s]); //add this room to the front of the linked list
			return path; //return this linked list so it can add rooms on the way back to source
		}

		Iterator<Edge> currVertex = rooms[s].getEdgesIterator();
		while(currVertex.hasNext()){ //get next room while there is an adjacent room to the current room

			Edge vertex = currVertex.next();
			int adjV = vertex.getAdjacentVertex(); 
			if(!visited[adjV]) { //if not visited, recursively call dfs
				DoublyLinkedList<Vertex> path = dfs(adjV, rooms.length-1, visited); //store what is returned into linked list
				if(path!=null){ 
					path.add(0,rooms[s]); //if what is returned is not null, add the room to the linked list
					return path; //return path linked list so it can be added to
				}
			}

		}
		return null; //return null if room does not lead to final room
	}

	private void print(){ //method to print out pathSolution linked list
		Iterator<Vertex> pathSol = pathSolution.iterator();
		while(pathSol.hasNext()){
			Vertex room = pathSol.next();
			System.out.println(room.getName()+" "+room.getXCoord()+" "+room.getYCoord());
		}
	}

}//end maze class
