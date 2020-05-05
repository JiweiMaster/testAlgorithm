import javax.swing.plaf.synth.SynthTextAreaUI;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    private static int MAX_SIZE = 10000;
    private static double[] dp = new double[MAX_SIZE];




    public static void main(String[] args) {

        for(int i=0;i<6;i++){
            String data = readConsole();
            System.out.println(data);
        }

    }

    static void calculate(){
        BigInteger big1 = new BigInteger("10256256526521526512152");
        BigInteger big2 = new BigInteger("10256256526521522512152");
        System.out.println(big1.multiply(big2));
    }

    static double fun( int i){
        if(i==0||i==1) return 1;
        if(dp[i] != 0){
            return dp[i];
        }else{
           dp[i] =  fun(i-1)+fun(i-2);
           return dp[i];
        }
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
