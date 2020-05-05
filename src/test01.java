import java.io.BufferedReader;
import java.io.InputStreamReader;
//最大连续子序列和
public class test01 {
    //-2 11 -4 13 -5 -2
    //dp[0] = -2
    //dp[1] = 11 = max(A[1],A[1]+dp[0])
    //dp[2] = 7...
    //dp[i] = max(A[i],A[i]+dp[i-1])
    static int MAX_SIZE = 10;
    public static void main(String[] args){
        String data = readConsole();
        String[] dataArray = data.split(" ");
        int[] dp = new int[MAX_SIZE];
        int[] A = new int[MAX_SIZE];
        for(int i=0;i<dataArray.length;i++){
            A[i] = Integer.parseInt(dataArray[i]);
        }
        dp[0] = A[0];
        for(int i = 1;i<dataArray.length;i++){
            dp[i] = max(A[i],A[i]+dp[i-1]);
        }
        //获取最大的序列值
        int maxValue = dp[0];
        for(int i=0;i<dataArray.length; i++){
            if(maxValue < dp[i]) maxValue = dp[i];
        }
        System.out.println(maxValue);
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
