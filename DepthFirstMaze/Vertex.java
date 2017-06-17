import java.util.Iterator;

public class Vertex
{
  private String name;
  private int x;
  private int y;
  private DoublyLinkedList<Edge> edges;

  public Vertex()
  {
	  name = ""; //initialize empty string
	  x = -1; //dummy coordinates
	  y = -1;
	  edges = new DoublyLinkedList<Edge>(); //create new linked list of edges for vertex
  }

  public void setName(String n)
  {
	  name = n; //set variable of name to n
  }

  public String getName()
  {
	  return name; //return name of room
  }

  public void setXCoord(int xCoord)
  {
	  x = xCoord; //set x value to values passed into xCoord
  }

  public int getXCoord()
  {
	  return x;  //return the x value
  }

  public void setYCoord(int yCoord)
  {
	  y = yCoord; //set y to value passed into yCoord
  }

  public int getYCoord()
  {
	  return y; //return the y value
  }

  public void addEdge(Edge e)
  {
	 
	 edges.add(e); //add edge into linked list 
	 
  }

  public Iterator<Edge> getEdgesIterator()
  {
	return edges.iterator(); //returns edges linked list iterator
	  
  }
}
