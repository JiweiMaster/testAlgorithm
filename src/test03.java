public class test03 {
    /**
     * LCS 最长公共子序列的问题
     * sadstory
     * adminsorry
     * d[i][j] 表示第一个序列的i个位置和第二个序列的j个位置的最长公共子序列
     * 看 asd  d[3][5]
     * 看 admin
     *
     * --->d[i][j] = d[i-1][j-1]+1, A[i]==B[j]
     * --->d[i][j] = max{d[i-1][j],d[i][j-1]}, A[i] != B[j]
     *
     * @param args
     */

    public static int MAX_SIZE = 100;
    public static void main(String[] args){

        String[] a = {"s","a","d","q","q","o","r","y"};
        String[] b = {"a","d","m","i","n","s","o","r","r","y"};

        int[][] dp = new int[a.length][b.length];

        for(int i=0;i<a.length;i++){
            for(int j=0;j<b.length;j++){
                if(a[i].equals(b[j])){
                    if(i==0 || j==0){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = dp[i-1][j-1]+1;
                    }
                }else{
                    if(i == 0 || j ==0){
                        dp[i][j] = 0;
                    }else{
                        dp[i][j] = max(dp[i-1][j],dp[i][j-1]);
                    }
                }
            }
        }

        System.out.println(dp[a.length-1][b.length-1]);

    }

    public static int max(int i, int j){
        if(i < j){
            return j;
        }
        return i;
    }
}
