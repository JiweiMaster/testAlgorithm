package tree;

import util.GsonUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class testHafuman {
    /**
     * 优先队列解决哈夫曼树的问题
     * @param args
     */
    public static void main(String[] args){
        System.out.println("asdsd");
        int[] data  = {14,6,8,3,1,2,5,2,3};

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0;i<data.length;i++){
            queue.offer(data[i]);
        }
        int ans = 0;
        while(!queue.isEmpty()){

            int x = queue.poll();
            if(!queue.isEmpty()){
                int y = queue.poll();
                int sum = x+y;
                ans = ans +sum;
                queue.offer(sum);
            }
        }
        System.out.println(ans);
    }
}
