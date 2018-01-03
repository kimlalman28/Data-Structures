Maze Assignment
===============


The goal is to solve the maze using depth-first search. Depth First Maze is a continuation of Maze. Both programs use the Doubly Linked List and Array data structure. <br />

Your goal is to find the first possible path from the first room in the maze (rooms[0]) to the last one (if n is the number of rooms then rooms[n-1]) by applying the depth-first search algorithm. The depth-first search algorithm uses recursion (recursive calls) to find the solution. For a graph, since it can have cycles, the depth-first search algorithm employs a Boolean array visited to keep track of the visited status (visited or unvisited) of each vertex in the graph. Initially, all vertices are unvisited <br />

**Depth-First Search Algorithm (DFS):**
1. Find a path from a source vertex to the destination vertex in a graph.
2. Start the search by making the current vertex the source vertex.
3. Determine if the current vertex leads to the destination vertex:
- Mark the current vertex as visited.
- For each of the current vertex’s outgoing edges, check the visited status of the edge’s adjacent vertex.
- If the adjacent vertex is visited then move on to the next adjacent vertex.
- If the adjacent vertex is unvisited then determine if there is a path from the adjacent vertex to destination vertex by recursively carrying out step 3 with the adjacent vertex being the current vertex in the recursive call to depth-first search.
4. Once the depth-first search algorithm reaches the destination vertex it adds it to the solution path, and then recursively adds all the vertices on the direct path back to the source vertex.
<br /><br />

A .maze file is basically a text file containing all the information needed to construct the maze.
- The first line of the file contains an integer (n) which is the number of rooms/vertices in the graph.
- The next n lines each contain the name of a room (String) and its x and y coordinates (integers) in that order. The name of the room is 1 or more characters. DO NOT assume the name is only 1 character in length. The name, x and y coordinates are separated by one or more spaces. DO NOT assume the three values are only separated by only 1 space.
- After the list of vertices are the edges/corridors. Each edge is listed as two integers, room1 and room2, the indices of its start and end vertices. The room1 and room2 indices are separated by one or more spaces. DO NOT assume the two values are only separated by only 1 space. Store each valid edge by adding an Edge object with the target room2 to room1's list of edges.
- The .maze file will end with a line containing -1 -1.
- You may assume that the input file is correctly formatted, except that some edges may point to non-existent vertices. You should ignore any invalid edges, keep going without adding them to your graph.
<br /><br />

The command to run the program for Maze is:

    java Assignment1 sample.maze
<br />
The command to run the program for Depth First Maze is:

    java Assignment2 sample.maze


