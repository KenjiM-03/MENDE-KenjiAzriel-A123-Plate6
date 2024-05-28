public class App {
    static class Graph
    {
        int v, e;
        int[][] dir;
        //Graph 
        Graph(int v, int e) {
            this.v = v;
            this.e = e;
            dir = new int[v][];
            for (int i = 0; i < v; i++)
                dir[i] = new int[v];
        }
    }
    static Graph createGraph(int v, int e)
    {
        Graph G = new Graph(v, e);
 
 
        //direction from 0
        G.dir[0][1] = 1;
        G.dir[0][2] = 1;
        G.dir[0][3] = 1;
 
        //direction from 1
        G.dir[1][0] = 1;
        G.dir[1][3] = 1;
        G.dir[1][2]= 1;
        //direction from 2
        G.dir[2][0] = 1;
        G.dir[2][3] = 1;
        G.dir[2][1] = 1;
 
        //direction from 3
        G.dir[3][0] = 1;
        G.dir[3][1] = 1;
        G.dir[3][2] = 1;
 
        return G;
    }
 
    static int findDegree(Graph G, int ver)
    {
        int degree = 0;
        for (int i = 0; i < G.v; i++) {
            if (G.dir[ver][i] == 1)
                degree++;
        }
        
          // below line is to account for self loop in graph
        // check sum of degrees in graph theorem
        if(G.dir[ver][ver] == 1) degree++;
        return degree;
    }
 
  
   // Driver code
   public static void main(String[] args)
   {
       int vertices = 4;
       int edges = 5;
        
       // Creating a Graph
       Graph G = createGraph(vertices, edges);
       //This is for chosing which vertice to identify how many degrees
       int ver = 2;
        
       // Function calling
       int degree = findDegree(G, ver);
       System.out.println(degree);
   }
}

