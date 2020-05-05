package tree;

import util.GsonUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    /**
     *  * linklist是一种Queue对象
     *      * 操作：
     *      * offer add -- >添加数据
     *      * poll remove -- > 队列中删除第一个元素
     *      * peek element -- > 查询队列的第一个元素
     */
    static int MAX_SIZE = 100;
    public static void main(String[] args) throws  Exception{
        String[] dataPre = {"1","2","4","5","3","6","7"};
        String[] dataIn = {"4","2","5","1","6","3","7"};
        String[] dataPost = {"4","5","2","6","7","3","1"};
//        Node node = create(dataPre,dataIn,0,dataPre.length-1,0,dataIn.length-1);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] inOrder = reader.readLine().split(" ");
        String[] postOrder = reader.readLine().split(" ");
        //  1 2 3 4 5 6 7
        //  2 3 1 5 7 6 4
        Node node = createInPost(inOrder,postOrder,0,dataIn.length-1,0,dataPost.length-1);
        layerOrder(node);
//        System.out.println("先序：");
//        preOrder(node);
//        System.out.println("\n中序：");
//        inOrder(node);
//        System.out.println("\n后序：");
//        postOrder(node);
//        System.out.println("\n层次：");
//        layerOrder(node);
    }

    //根据先序和中序构建二叉树
    public static Node create(String[] dataPre,String[] dataIn,int preL,int preR,int inL, int inR){
        if(preL > preR){
            return null;
        }
        Node root = new Node();
        root.data = dataPre[preL];
        int k;
        for(k=inL;k<inR;k++){
            if(dataIn[k].equals(dataPre[preL])){
                //此时i的位置用来确定子节点的位置
                break;
            }
        }
        int numLeft = k-inL;
        root.left = create(dataPre,dataIn,preL+1,preL+numLeft,inL,k-1);
        root.right = create(dataPre,dataIn,preL+numLeft+1,preR,k+1,inR);
        return root;
    }

    public static Node createInPost(String[] dataIn,String[] dataPost,int inL,int inR,int postL,int postR){
        if(postL > postR){
            return null;
        }
        Node root = new Node();
        root.data = dataPost[postR];
        int k;
        for(k=inL;k<inR;k++){
            if(dataIn[k].equals(dataPost[postR])){
                break;
            }
        }
        int numLeft = k-inL;
        root.left = createInPost(dataIn, dataPost, inL, inL+numLeft-1, postL, postL+numLeft-1);
        root.right = createInPost(dataIn,dataPost, inL+numLeft+1,inR,postL+numLeft,postR-1);
        return root;
    }

    //先序遍历
    public static void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.data+" ");
        preOrder(node.left);
        preOrder(node.right);
    }
    //中序遍历
    public static void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.data+" ");
        inOrder(node.right);
    }
    //后续遍历
    public static void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data+" ");
    }

    public static void layerOrder(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node node1 = queue.poll();
            System.out.print(node1.data+" ");
            if(node1.left != null){
                queue.offer(node1.left);
            }
            if(node1.right != null){
                queue.offer(node1.right);
            }
        }
    }

}

class Node{
    String data;
    Node left;
    Node right;
}

