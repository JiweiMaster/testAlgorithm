public class test04 {
    /**
     * 最长回文串的问题
     * 从回文串的长度入手
     *
     * dp[i][j]=1 s[i]==s[j] && s[i+1]s[j-1] == 1
     * dp[i][j]=0
     *
     * dp[i][j] --> 表示从s[i]--s[j]表示的字符串是不是回文子串，0是 1不是
     * @param args
     */
    public static void main(String[] args){
        String dataStr = "PATZUJZTACCBCC";
        System.out.println(dataStr);
        String[] data = new String[dataStr.length()];
        for(int i=0;i<dataStr.length();i++){
            data[i] = String.valueOf(dataStr.charAt(i));
        }
        int dp[][] = new int[data.length][data.length];
        int res = 1;//回文串的最大长度
        for(int i=0;i<data.length;i++){
            dp[i][i] = 1;
            if(i< data.length -1){
                if(data[i].equals(data[i+1])){
                    dp[i][i+1] = 1;
                    res = 2;
                }
            }
        }
        //从长度为3的时候开始看起
        for(int L =3;L<data.length;L++){
            for(int i=0;i+L-1<data.length;i++){
                int j = i+L-1;//子串的右边的端点
                if(data[i].equals(data[j]) && dp[i+1][j-1] ==1){
                    dp[i][j] = 1;
                    res = L;
                }
            }
        }

        System.out.println(res);
    }
}
