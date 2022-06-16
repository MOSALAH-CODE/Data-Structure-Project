package Graph;

import java.util.LinkedList;

public class Graph {
    private int V;
    private LinkedList<Integer> adj[];

    Graph(int v){
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    static void addEdge(Graph g, int v,int w){
        g.adj[v].add(v);
        g.adj[v].add(w);
    }

    static void delEdge(Graph g, int u, int v){

        for (int i = 0; i < g.adj[u].size(); i++){
            if (g.adj[u].get(i) == v){
                g.adj[u].remove(i);
                break;
            }
        }
        for (int i = 0; i < g.adj[v].size(); i++){
            if (g.adj[v].get(i) == u){
                g.adj[v].remove(i);
                break;
            }
        }
    }

    static void printGraph(Graph g){
        for (int v = 0; v < g.V; ++v){
            System.out.print("vertex " + v + " ");
            for (Integer x : g.adj[v])
                System.out.print("-> " + x);
            System.out.println("");
        }
        System.out.println("");
    }

    void BFS(int v){
        boolean[] visited = new boolean[V];

        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[v]=true;
        queue.add(v);

        while (queue.size() != 0){
            v = queue.poll();
            System.out.print(v+" ");

            for (int n : adj[v]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }


    void DFS(int v){
        boolean[] visited = new boolean[V];
        DFSUtil(v, visited);
    }

    void DFSUtil(int v, boolean[] visited){
        visited[v] = true;
        System.out.print(v + " ");

        for (int n : adj[v]) {
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }


    public static void main(String[] args){
        Graph g = new Graph(4);

        addEdge(g,0, 1);
        addEdge(g,0, 2);
        addEdge(g,1, 2);
        addEdge(g,2, 0);
        addEdge(g,2, 3);
        addEdge(g,3, 3);

        System.out.print("BFS (starting from vertex 2): ");
        g.BFS(2);


        System.out.print("\n\nDFS (starting from vertex 2): ");
        g.DFS(2);

        System.out.println("\n\nPrint Graph: ");
        printGraph(g);

        System.out.println("2 -> 3 edge deleted");
        delEdge(g, 2, 3);

        System.out.println("\nPrint Graph:");
        printGraph(g);
    }
}
