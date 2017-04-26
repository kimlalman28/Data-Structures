public class Edge
{
  private int adjacentVertex;

  public Edge()
  {
	  adjacentVertex = -1; //initialize to a dummy vertex
  }

  public void setAdjacentVertex(int i)
  {
	  adjacentVertex = i; //set the adjacent vertex equal to value that is passed into method
  }

  public int getAdjacentVertex()
  {
	  return adjacentVertex; //return the adjacent vertex
  }
}
