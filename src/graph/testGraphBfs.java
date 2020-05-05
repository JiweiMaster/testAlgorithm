package graph;

import java.util.LinkedList;
import java.util.Queue;

public class testGraphBfs {
    static int MAX_SIZE = 100;
    static int n,G[][] = new int[MAX_SIZE][MAX_SIZE];
    static boolean inQueue[] = new boolean[MAX_SIZE];
    public static void main(String[] args){
        System.out.println("adsad");
    }

    public static void BFS(Integer root){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);
        inQueue[root] = true;
        while (!queue.isEmpty())
        {
            Integer u = queue.poll();
            for(int v = 0; v < n; v++){
                if(!inQueue[v] && G[u][v] != 0){
                    queue.offer(v);
                    inQueue[v] = true;
                }
            }
        }
    }

    public static void BFSTrave(){
        for(int u=0;u<n;u++){
            if(!inQueue[u]){
                BFS(u);
            }
        }
    }
}
