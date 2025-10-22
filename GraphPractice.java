import java.util.*;
public class GraphPractice {
    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s, int d , int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge>graph){
        graph.add(new Edge(0, 1, 2));
        graph.add(new Edge(0, 2, 4));

        graph.add(new Edge(1, 2,-4));

        graph.add(new Edge(2, 3, 2));

        graph.add(new Edge(3, 4, 4));

        graph.add(new Edge(4, 1,-1));      
    }

    public static void bellman(ArrayList<Edge>graph,int V){
        int dist[] = new int[V];
        dist[0] = 0;
        for(int i=0; i<dist.length;i++){
            if(i!=0){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        
        for(int k=0; k<V-1;k++){
            for(int j=0;j<graph.size();j++){
                Edge e = graph.get(j);
                int u = e.src;
                int v = e.dest;
                if(dist[u]!= Integer.MAX_VALUE && dist[u]+e.wt<dist[v]){
                    dist[v] =dist[u]+e.wt;
                }
            }
        }
        for(int j=0;j<graph.size();j++){
            Edge e = graph.get(j);
            int u = e.src;
            int v = e.dest;
            if(dist[u]!= Integer.MAX_VALUE && dist[u]+e.wt<dist[v]){
                System.out.print("Negative weight cycle");
            }
        }

        for(int i =0; i<dist.length;i++){
            System.out.print(dist[i]+" ");
        }
    }
    public static void main(String[]args){
        ArrayList<Edge> graph = new ArrayList<>();
        createGraph(graph);
        int V = 5;
        bellman(graph,V);


    }
    
}
