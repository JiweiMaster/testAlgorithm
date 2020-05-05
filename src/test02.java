import java.io.*;

public class test02 {
    /**最长不下降子序列 -----LIS---->简化重复计算
     *  {1,2,3,-1,-2,7,9}
     * @param args
     * dp[0]={1}
     * dp[1]={1,2}  dp[1]=max{1,dp[0]+1}
     * ...
     * dp[i]=max{1,dp[j]+1} <== j<i
     *
     * 返回最大的序列的长度
     */
    public static int MAX_SIZE = 100;

    public static void main(String[] args){
        System.out.println("test02");
        String str = readFile("C:/Users/jiwei/Desktop/test/test02.txt");
        String[] data = str.split(" ");
        int[] A = new int[data.length];
        for(int i=0;i<data.length;i++){
            A[i] = Integer.parseInt(data[i]);
        }

        int res = -1;
        int[] dp = new int[MAX_SIZE];
        for(int i=0;i<A.length;i++){
            dp[i] = 1;
            for(int j=0;j<i;j++){
                if(A[i] >= A[j] && (dp[j]+1 >= dp [i])){
                    dp[i] = dp[j] + 1;
                }
            }
            if(res < dp[i]){
                res = dp[i];
            }
        }
        System.out.println(res);
        writeFile("result=>"+Integer.toString(res),"C:/Users/jiwei/Desktop/test/test02_result.txt");
    }

    /**
     * 读取数据
     * @param filePath
     * @return
     */
    public static String readFile(String filePath){
        try{
//            String filePath = "C:/Users/jiwei/Desktop/test/test02.txt";
            File file = new File(filePath);
            if(file.exists()){
                InputStreamReader isr = new InputStreamReader(new FileInputStream(file));
                BufferedReader reader = new BufferedReader(isr);
                String content = null;
                String returnStr = "";
                while ((content = reader.readLine()) != null){
                    returnStr = returnStr + content;
                }
                reader.close();
                return returnStr;
            }
            return null;
        }catch (Exception e){
            return null;
        }
    }

    /**
     * 写入数据
     * @param result
     * @param filePath
     */
    public static void writeFile(String result,String filePath){
        try{
            File file = new File(filePath);
            if(!file.exists()){
                file.createNewFile();
            }
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            writer.write(result);
            writer.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
