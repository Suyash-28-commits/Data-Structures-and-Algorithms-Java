import java.util.*;
public class GraphCode {

    static class Edge{ //Edges of a Graph
        int src; //source
        int dest; //destination
        // int wt; //weight

        public Edge(int s,int d){
            this.src = s;
            this.dest = d;
            // this.wt = w;
        }
    }
    //create a Graph using Adjacency List
    public static void createGraph(ArrayList<Edge>graph[]){
        for(int i = 0; i<graph.length;i++){
            graph[i] = new ArrayList<>(); //creating an empty arrayList at each index
        }
        //undireced graph
        graph[0].add(new Edge(0,2)); //vertex 0
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1,0)); //vertex 1


        graph[2].add(new Edge(2,1)); //vertex 2
        

        graph[3].add(new Edge(3,4)); //vertex 3

        //Directed and weighted graph
        // graph[0].add(new Edge(0,1,10));
        // graph[0].add(new Edge(0,2,15));
        // graph[0].add(new Edge(0,3,30));

        // graph[1].add(new Edge(1,0,10));
        // graph[1].add(new Edge(1,3,40));


        // graph[2].add(new Edge(2,0,15));
        // graph[2].add(new Edge(2,3,50));

        // graph[3].add(new Edge(3,1,40));
        // graph[3].add(new Edge(3,2,50));

    }

    //Graph Traversals
    //1-> Breadth First Search
    //->Graph without subgraphs or components
    public static void bfs(ArrayList<Edge> graph[],int V){
        //creation of Queue
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[V];//checks for elements which are earlioer vsisted in the traversal or not
        q.add(0); //0->starting point of graph
        while(!q.isEmpty()){
            int curr = q.remove();
            if(vis[curr] == false){ //if node is not visted earlier
                System.out.print(curr+" ");
                vis[curr] = true;
                //add neighbours of the current vertex in queque
                for(int i = 0 ; i<graph[curr].size();i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }
    //->Graph that can have compoments or can be a single components
    public static void bfsComp(ArrayList<Edge> graph[],int V,boolean[]vis,int start){
        //creation of Queue
        Queue<Integer> q = new LinkedList<>();
        
        q.add(start); //starting point of graph
        while(!q.isEmpty()){
            int curr = q.remove();
            if(vis[curr] == false){ //if node is not visted earlier
                System.out.print(curr+" ");
                vis[curr] = true;
                //add neighbours of the current vertex in queque
                for(int i = 0 ; i<graph[curr].size();i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    //2->Depth First Search(DFS) Traversal
    public static void dfs(ArrayList<Edge>graph[],int curr, boolean vis[]){
        System.out.print(curr+" ");
        vis[curr] = true;

        //function call for the first neighbours
        for(int i =0; i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(vis[e.dest] == false){
                dfs(graph,e.dest, vis);
            }
        }
    }

    //Q->Print all paths from source to target
    //Approach 1-> Modified DFS Traversal
    public static void printAllPaths(ArrayList<Edge>graph[],int curr,boolean[]vis,String path,int tar){
        if(curr == tar){//Base Case
            //->when current vertex upon traversing becomes equal to target vertex
            //shows that targer vertex has reached
            //print all the paths
            System.out.println(path);
            return;
        }

        for(int i = 0; i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){//if current nod's neighbour's are not visited
                vis[curr] = true; //make current vertex visited

                //function call to traverse further
                printAllPaths(graph,e.dest, vis, path+e.dest, tar);
                //Backtracking ->>> steps
                //make current vertex visited earlier to not visited
                //all vertex can be visited more than once/*  */
                vis[curr] = false;
            }
        }
    }

    //Cycle detection in Graphs
    //Cycle detection for undirected graphs
    //using modified DFS tarversal
    public static boolean isCycleUndirected(ArrayList<Edge>graph[],boolean vis[],int curr, int par){
        vis[curr] = true;

        //loop on neighbours of current node
        for(int i =0; i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            //1st condition - if currrent node is visted and if parent is not equal to current node
            if(vis[e.dest] && par!= e.dest){//condition for cycle detection
                return true;
            }else if(!vis[e.dest]){
                if(isCycleUndirected(graph, vis,e.dest,curr)){
                    return true;
                }
            }
        }
        return false;
    }
    
    //Cycle Detection - Directed Graph
    //modified DFS Traversal
    public static boolean isCycleDirected(ArrayList<Edge>graph[],boolean vis[], int curr, boolean[]rec){
        vis[curr] = true;
        rec[curr] = true;
        
        //loop on neighbours
        for(int i =0; i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(rec[e.dest]){ //cycle detection
                return true;
            }else if(!vis[e.dest]){//traverse further to look for cycles
                
                if(isCycleDirected(graph, vis,e.dest,rec)){
                    return true;
                }
            }
        }
        rec[curr] = false;//backtarck steps
        return false;
    }
    
    //Topological sort -> using modified DFS Traversal
    //Utility function for topological sort
    public static void topSortUtil(ArrayList<Edge> graph[],boolean vis[],int curr, Stack<Integer>stack){
        vis[curr] = true;
        
        //loop on current vertex's neighbours
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) topSortUtil(graph, vis,e.dest, stack);
        }

        stack.push(curr); //push current node at the end
    }

    //topological sort function
    public static void topSort(ArrayList<Edge>graph[],int V){
        boolean vis[] = new boolean[V];


        
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<V; i++){
            if(!vis[i]) topSortUtil(graph, vis, i, stack);
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }

    //Shortest Path Algorithms
    //Dijkstra's Algorithm
    //Creation Of pair node for Priority Queue
    //Pair class -> node(current vertex) & distance
    public static class Pair implements Comparable<Pair>{
        int node; //current vertex
        int dist; //distance of node

        public Pair(int n, int d){
            this.node = n;
            this.dist = d;
        }

        @Override
        public int compareTo(Pair p2){
            return this.dist - p2.dist;


        }
    }
    //Dikhstra's Algorith using BFS and Priority Queue
    // public static void dikjstra(ArrayList<Edge>graph[],int src,int V){
    //     //Creation of priority queue to store pairs
    //     PriorityQueue<Pair> pq = new PriorityQueue<>();
    //     int dist[]= new int[V];//array storing distances

    //     for(int i = 0; i<V;i++){
    //         //Initializing all the elements except source to infinite
    //         //Integer.MAX_VALUE reperesents infinity for our program 
    //         if(i!=src) dist[i] = Integer.MAX_VALUE;//Integer.MAX_VALUE -> finite value
    //     }
    //     boolean vis[] = new boolean[V];//visited array

    //     pq.add(new Pair(0,0));

    //     while(!pq.isEmpty()){
    //         Pair curr = pq.remove();

    //         if(!vis[curr.node]){
    //             vis[curr.node] = true;

    //             for(int i = 0; i<graph[curr.node].size();i++){
    //                 Edge e = graph[curr.node].get(i);

    //                 //Implementing condition of relaxation
    //                 int u = e.src;
    //                 int v = e.dest;

    //                 //condition of relaxation
    //                 if(dist[u] +e.wt <dist[v]){
    //                     dist[v] = dist[u]+e.wt;
    //                     pq.add(new Pair(v,dist[v]));
    //                 }
    //             }
    //         }
    //     }

    //     //printing shortest path
    //     for(int i = 0; i<V;i++){
    //         System.out.print(dist[i]+" ");
    //     }      
    // }

    //Bellman Ford Algorithm
    //uses Dynamic Programming
    // public static void bellman(ArrayList<Edge>graph[],int src, int V){
    //     int dist[] = new int[V];
    //     dist[0] = 0;
    //     for(int i=0; i<V;i++){
    //         if(i!=src) dist[i]=Integer.MAX_VALUE;
    //     }

    //     //O(V.E) time complexity
    //     for(int k=0;k<V-1;k++){//O(V)

    //         //O(E)
    //         for(int i=0;i<V;i++){
    //             for(int j=0;j<graph[i].size();j++){
    //                 Edge e = graph[i].get(j);
    //                 int u = e.src;
    //                 int v = e.dest;
    //                 if(dist[u]!= Integer.MAX_VALUE && dist[u]+e.wt<dist[v]){
    //                     dist[v] = dist[u] +e.wt;
    //                 }
    //             }
    //         }
    //     }
    //     //detec -ve cycle in graph
    //     for(int i=0;i<V;i++){
    //         for(int j=0;j<graph[i].size();j++){
    //             Edge e = graph[i].get(j);
    //             int u = e.src;
    //             int v = e.dest;
    //             if(dist[u]!= Integer.MAX_VALUE && dist[u]+e.wt<dist[v]){
    //                 System.out.println("negative cycle");


    //             }
    //         }
    //     }

    //     for(int i=0;i<V;i++){
    //         System.out.print(dist[i]+" ");
    //     }

    // }

    //Minimum Spanning Tree (MST) in graphs
    //Prim's Algorithm to find Minimum Spanning Tree
    //creation of Priority Queue Node for finding minimum weight edge
    public static class Doublet implements Comparable<Doublet>{
        int node;
        int cost;

        public Doublet(int n,int c){
            this.node = n;
            this.cost = c;
        }
        @Override
        public int compareTo(Doublet d2){
            return this.cost - d2.cost;
        }
    }

    //Prim's algorithm to Find MST in graphs
    // public static void primsAlgo(ArrayList<Edge>graph[],int V){
    //     PriorityQueue<Doublet> pq = new PriorityQueue<>();//non-MST Set
    //     boolean vis[] = new boolean[V];//MST Set

    //     int mstCost = 0;

    //     pq.add(new Doublet(0,0));
    //     while(!pq.isEmpty()){
    //         Doublet curr = pq.remove();
    //         if(!vis[curr.node]){
    //             vis[curr.node] = true;
    //             mstCost += curr.cost;
    //             for(int i=0; i<graph[curr.node].size();i++){
    //                 Edge e = graph[curr.node].get(i);
    //                 if(!vis[e.dest]){
    //                     pq.add(new Doublet(e.dest,e.wt));
    //                 }
    //             }
    //         }
    //     }

    //     System.out.println("cost of MST "+mstCost);
    // }
    
    //Strongly Connecteed Components (SCC)
    //Kosaraju's Algorithm
    //topological sort function
    public static void top(ArrayList<Edge>graph[],int curr, boolean vis[],Stack<Integer>s){
        vis[curr] = true;
        
        for(int i = 0; i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);

            if(!vis[e.dest]) top(graph, e.dest, vis, s);
        }

        s.push(curr);
    }
    //DFS
    public static void DFS(ArrayList<Edge>graph[],int curr,boolean vis[]){
        vis[curr] = true;
        System.out.print(curr+" ");

        for(int i=0; i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) DFS(graph,e.dest, vis);
        }
    }

    //Kosaraju's Algorithm
    public static void kosarajuAlgo(ArrayList<Edge>graph[],int V){
        //Step -1
        Stack<Integer>s = new Stack<>();
        boolean vis[] = new boolean[V];
        for(int i = 0; i<V;i++){
            if(!vis[i]) top(graph, i, vis, s);
        }

        //Step - 2
        //Finding Transpose of graph
        ArrayList<Edge>transpose[] = new ArrayList[V];
        for(int i=0; i<transpose.length;i++){
            vis[i] = false;
            transpose[i] = new ArrayList<>();
        }

        for(int i =0; i<V;i++){
            for(int j = 0 ; j<graph[i].size();j++){
                Edge e = graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest,e.src));
            }
        }

        //Step-3
        while(!s.isEmpty()){
            int curr = s.pop();
            if(!vis[curr]) {
                DFS(transpose, curr, vis);
                System.out.println();
            }
        }

    }

    public static void main(String[]args){
        int V =5; //number of vertexes of graph
        //Graph data structure
        /*    1----3
         *   /     |\
         *  /      | \
         * 0       |  5--6
         *  \      | /
         *   \     |/
         *    2----4
         */
        ArrayList<Edge> graph[] = new ArrayList[V];

        // createGraph(graph);
        // //print 2's neighbours
        // for(int i = 0; i<graph[2].size();i++){
        //     Edge e = graph[2].get(i);
        //     System.out.println(e.dest+" , "+e.wt);
        // }

        //Breadth First Search (Traversal)
        // bfs(graph, V);
        // System.out.println();

        //Breadth First Search(Traversal) for disjoint components of a Graph
        // boolean vis[] = new boolean[V];//checks for elements which are earlier vsisted in the traversal or not
        // for(int i = 0; i<V;i++){
        //     if(vis[i] == false){
        //         int start = i;
        //         bfsComp(graph, V, vis, start);
        //     }
        // }

        //Depth First Search(Traversal) for disjoint components of a Graph
        // boolean vis[] = new boolean[V];//checks for elements which are earlier vsisted in the traversal or not
        //  for(int i = 0; i<V;i++){
        //     if(vis[i] == false){
        //         int start = i;
        //         dfs(graph, i, vis); //i->start
                
        //     }
        // }
        // dfs(graph, 0, vis); //0-> starting point , so it wil be passed as the the current node first
        
        //print all path from source to target
        //Approach 1-> modified DFS approach
        // int src = 0 , tar = 5;
        // System.out.println("All paths");
        // printAllPaths(graph, src,new boolean[V],"0", tar);

        //Cycle detection - undirected graph
        // ArrayList<Edge> graph[] = new ArrayList[V];

        // createGraph(graph);
        // System.out.println(isCycleUndirected(graph,new boolean[V],0, -1));

        //Cycle detection - directed graph
        // createGraph(graph);
        // boolean vis[] = new boolean[V]; //visited array
        // //keeps track of whether a cycle exists or not
        // boolean rec[] = new boolean[V]; //boolean array representing recursion stack

        // for(int i = 0; i<V;i++){
        //     if(!vis[i]){
        //         boolean isCycle = isCycleDirected(graph, vis, 0, rec);
        //         if(isCycle){
        //             System.out.println(isCycle);
        //             break;
        //         }
        //     }
        // }

        //Topological Sort
        createGraph(graph);
        // topSort(graph, V);

        //Dikjstra's algorithm
        // dikjstra(graph, 0, V);

        //Bellman Ford Algorithm
        // bellman(graph, 0, V);
        
        //Prims Algorithm
        // primsAlgo(graph, V);

        //Kosaraju's Algorithm
        kosarajuAlgo(graph, V);

        
    }
}

