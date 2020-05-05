package tree;

import util.GsonUtil;

public class testHeap {
    /**
     * 数组结构能够很好表表现出堆的特性,但是数组的第一个单元不能用
     */

    public static void main(String[] args){
        int[] heap = {0,3,1,2,4,5,6,7,8,9};

        for(int i= heap.length/2;i>=1;i--){
            downAdjust(heap,i,heap.length-1);
        }
        System.out.println(GsonUtil.ObjectToJson(heap));
    }

    public static void createHead(int[] heap){
        /**
         * 从非叶子结点开始调整，大于 n/2都是叶子结点
         */
        for(int i = heap.length/2;i>=1;i--){
            downAdjust(heap,i,heap.length-1);
        }
    }

    /**
     * 向下调整
     * @param heap
     * @param low
     * @param high
     * @return
     */
    public static int[] downAdjust(int [] heap,int low, int high){
        int i = low;
        int j = i*2;
        while(j<=high){
            if(j + 1 <= high && heap[j+1] > heap[j]){//获取最大的那个子节点
                j = j+1;
            }
            //如果最大的孩子结点大于目标结点，需要调整
            if(heap[j] > heap[i]){
                heap = swap(heap,i,j);
                i = j;
                j = i*2;
            }else{
                break;
            }
        }
        return heap;
    }

    public static int[] swap(int[] data,int i,int j){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
        return data;
    }
}
