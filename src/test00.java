import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 数塔问题
 */
public class test00 {
    static int MAX_SIZE = 10;
    static int[][] f = new int[MAX_SIZE][MAX_SIZE];
    static int[][] dp = new int [MAX_SIZE][MAX_SIZE];

    static int n;
//    5
//    8 3
//    12 7 16
    //自己写一下递归的代码

    public static void main (String[] args){
//        fun1();
        n = Integer.parseInt(readConsole());
        System.out.println("行数："+n);
        for(int i=1;i<=n;i++){
            String rowStr = readConsole();
            String[] rows = rowStr.split(" ");
            for(int j=1;j<=i;j++){
                f[i][j] = Integer.parseInt(rows[j-1]);
            }
        }
        //给最后一层赋值
        for(int i=1;i<=n;i++){
            dp[n][i] = f[n][i];
        }
        System.out.println(fun2(1,1));
    }

    //递归的写法
    static int fun2(int i,int j){
        if(j >= n || i>=n){
            return dp[i][j];
        }
        if(dp[i][j] == 0){
            dp[i][j] = max(fun2(i+1,j),fun2(i+1,j+1))+f[i][j];
        }
        return dp[i][j];
    }


    //迭代的写法
    static void fun1(){
        int n = Integer.parseInt(readConsole());
        System.out.println("行数："+n);
        for(int i=1;i<=n;i++){
            String rowStr = readConsole();
            String[] rows = rowStr.split(" ");
            for(int j=1;j<=i;j++){
                f[i][j] = Integer.parseInt(rows[j-1]);
            }
        }
        //给最后一层赋值
        for(int i=1;i<=n;i++){
            dp[n][i] = f[n][i];
        }
        //状态转移方程
        //dp[i][j] = max(dp[i+1][j],dp[i+1][j+1]) + f[i][j]
        for(int i=n-1;i>0;i--){
            for(int j=1;j<=i;j++){
                dp[i][j] = max(dp[i+1][j],dp[i+1][j+1])+f[i][j];
            }
        }
        System.out.println(dp[1][1]);
    }


    static int max(int a,int b){
        if(a>=b) return a;
        return b;
    }
    static String readConsole(){
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String str = reader.readLine();
            return str;
        }catch (Exception e){
            return null;
        }
    }
}
