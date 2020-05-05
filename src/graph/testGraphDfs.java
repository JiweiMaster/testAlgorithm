package graph;

public class testGraphDfs {

    static int MAX_SIZE = 100;
    static boolean[] visit = new boolean[MAX_SIZE];
    static int n;
    static int G[][] = new int[MAX_SIZE][MAX_SIZE];
    public static void main(String[] args){

    }

    public static void DFSTrave(){
        for(int u=0;u<n;u++){
            if(visit[u] == false){
                DFS(u,1);
            }
        }
    }

    public static void DFS(int u, int depth){
        visit[u] = true;
        //这边可以进行一些对于结点的操作
        //下面对从U出发能到达的分支结点进行枚举
        for(int v = 0;v<n;v++){
            if(!visit[v] && G[u][v] != 0){
                DFS(v,depth+1);
            }
        }
    }
}

