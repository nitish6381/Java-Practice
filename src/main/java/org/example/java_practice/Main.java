package org.example.java_practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Edge {
    int src, dest, weight;
    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

class Graph {
    int V;
    List<Edge> edges = new ArrayList<>();
    Graph(int vertices) {
        this.V = vertices;
    }
    void addEdge(int u, int v, int w) {
        edges.add(new Edge(u, v, w));
    }
    int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }
    void union(int[] parent, int[] rank, int x, int y) {
        int xroot = find(parent, x);
        int yroot = find(parent, y);
        if (rank[xroot] < rank[yroot]) {
            parent[xroot] = yroot;
        } else if (rank[xroot] > rank[yroot]) {
            parent[yroot] = xroot;
        } else {
            parent[yroot] = xroot;
            rank[xroot]++;
        }
    }
    List<Edge> KruskalMST() {
        List<Edge> result = new ArrayList<>();
        Collections.sort(edges, Comparator.comparingInt(o -> o.weight));
        int[] parent = new int[V];
        int[] rank = new int[V];
        for (int i = 0; i < V; ++i) {
            parent[i] = i;
            rank[i] = 0;
        }
        int e = 0;
        for (Edge edge : edges) {
            if (e == V - 1) {
                break;
            }
            int x = find(parent, edge.src);
            int y = find(parent, edge.dest);
            if (x != y) {
                result.add(edge);
                union(parent, rank, x, y);
                e++;
            }
        }
        return result;
    }
}

public class Main {

    public static int getMinMaxLatency(int g_nodes, int[] g_from, int[] g_to, int[] g_weight, int k) {
        Graph graph = new Graph(g_nodes);
        int num_edges = g_from.length;
        for (int i = 0; i < num_edges; i++) {
            graph.addEdge(g_from[i] - 1, g_to[i] - 1, g_weight[i]);
        }
        List<Edge> mst_edges = graph.KruskalMST();
        int networks = 1;
        while (networks < k) {
            if (!mst_edges.isEmpty()) {
                mst_edges.remove(mst_edges.size() - 1);
            }
            networks++;
        }
        if (mst_edges.isEmpty()) {
            return 0;
        }
        return mst_edges.get(mst_edges.size() - 1).weight;
    }

    public static void main(String[] args) {
//        int g_nodes = 3;
//        int[] g_from = {1,3,1};
//        int[] g_to = { 2,2,3};
//        int[] g_weight = {3,4,6};
//        int k = 1;
        int g_nodes = 2;
        int[] g_from = {1};
        int[] g_to = { 2};
        int[] g_weight = {3};
        int k = 1;
        int result = getMinMaxLatency(g_nodes, g_from, g_to, g_weight, k);
        System.out.println("The minimum latency after " + k + " networks is: " + result);
    }
}
