import java.io.BufferedReader;
import java.io.InputStreamReader;

public class testTree {

    /**

     *
     */
    static int N,W,C,maxValue;//物品件数，背包容量，价值总量
    static int maxSize = 100;
    static int[] w = new int[maxSize];
    static int[] c = new int[maxSize];



    public static void main(String[] args) throws Exception{
        maxValue = -1;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String content = reader.readLine();
        N = Integer.parseInt(content.split(" ")[0]);
        W = Integer.parseInt(content.split(" ")[1]);
        String[] weight = reader.readLine().split(" ");
        for(int i=0;i<weight.length;i++){
            w[i] = Integer.parseInt(weight[i]);
        }
        String[] value = reader.readLine().split(" ");
        for(int i=0;i<value.length;i++){
            c[i] = Integer.parseInt(value[i]);
        }
        DFS(0,0,0);
        System.out.println("test tree maxvalue=>"+maxValue);

    }


    //背包问题的dfs解法
    //n件物品的不同选法
    static void DFS(int index, int sumW, int sumC){
        if(index == N){
            if(sumW <= W && sumC > maxValue){
                maxValue = sumC;
            }
            return;//边界，结束了
        }
        DFS(index+1,sumW,sumC);
        DFS(index+1,sumW+w[index],sumC+c[index]);
    }
}
