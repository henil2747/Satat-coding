import java.io.*;
import java.util.*;
class Dag satat{
   
// Perform DFS to count the 
// in-degree and out-degree 
// of the graph
static void dfs(int u, Vector<Integer> adj[], 
                int[] vis, int[] inDeg,
         int[] outDeg)
{
  // Mark the source 
  // as visited
  vis[u] = 1;
   
  // Traversing adjacent nodes
  for (int v : adj[u]) 
  {
    // Mark out-degree as 1
      outDeg[u] = 1;
    // Mark in-degree as 1
      inDeg[v] = 1;
      
    // If not visited
    if (vis[v] == 0) 
    {
   
      // DFS Traversal on
      // adjacent vertex
      dfs(v, adj, vis, 
          inDeg, outDeg);
    }
  }
}
   
// Function to return minimum 
// number of edges required 
// to make the graph strongly 
// connected
static int findMinimumEdges(int source[], 
                            int N, int M, 
                            int dest[])
{
  // For Adjacency List
  @SuppressWarnings("unchecked")
  Vector<Integer> []adj = 
         new Vector[N + 1];
    
  for (int i = 0; i < adj.length; i++)
    adj[i] = new Vector<Integer>();
    
  // Create the Adjacency List
  for (int i = 0; i < M; i++) 
  {
    adj].add(dest[i]);
  }
   
  // Initialize the in-degree array
  int inDeg[] = new int[N + 1];
   
  // Initialize the out-degree array
  int outDeg[] = new int[N + 1];
   
  // Initialize the visited array
  int vis[] = new int[N + 1];
   
  // Perform DFS to count 
  // in-degrees and out-degreess
  dfs(1, adj, vis, inDeg, outDeg);
   
  // To store the result
  int minEdges = 0;
   
  // To store total count of 
  // in-degree and out-degree
  int totalIndegree = 0;
  int totalOutdegree = 0;
   
  // Find total in-degree
  // and out-degree
  for (int i = 1; i <= N; i++) 
  {
    if (inDeg[i] == 1)
      totalIndegree++;
    if (outDeg[i] == 1)
      totalOutdegree++;
  }
   
  // Calculate the minimum
  // edges required
  minEdges = Math.max(N - totalIndegree, 
                      N - totalOutdegree);
   
  // Return the minimum edges
  return minEdges;
}
   
// Driver Code
public static void main(String[] args)
{
  int N = 5, M = 5;
  int source[] = {1, 3, 1, 3, 4};
  int destination[] = {2, 2, 3, 4, 5};
   
  // Function call
  System.out.print(findMinimumEdges(source, 
                                    N, M, 
                                    destination));
}
}