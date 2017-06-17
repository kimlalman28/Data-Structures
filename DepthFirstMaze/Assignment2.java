
public class Assignment2 {

	public static void main(String[] args){
		
		Maze newMaze = new Maze(args[0]); //new instance of maze 
		
		//System.out.print(newMaze); //calls custom toString() method - Assignment 1
		newMaze.findPath();
		System.out.println();
		newMaze.findPath();
	}
	
}
