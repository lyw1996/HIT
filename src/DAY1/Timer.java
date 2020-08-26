package DAY1;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * <h3>JAVA</h3>
 * <p>定时器</p>
 *
 * @author : liuyuwei
 * @date : 2020-08-24 17:16
 **/



public class Timer {

    public static void main(String[] args) {
        //设置全局时间和存储空间
        int t=0;
        Cache cache=new Cache(60);
        //测试用例，100s
        for (int i = 0; i <100 ; i++) {
            t=t+1;
            int luckNum=new Random().nextInt(100)+1;
            cache.put(luckNum,t);
            cache.print(t,60);
        }

    }

}
class Node{
    public int key;
    public int time;
    public Node pre;
    public Node next;

    public Node(int key, int time) {
        this.key = key;
        this.time = time;
    }
}

class Cache{
    private Map<Integer, Node> cache = new HashMap<>();
    private int capacity;
    private Node head;
    private Node tail;

    public Cache(int capacity) {
        this.capacity = capacity;
    }

    /*
    设置头结点
     */
    private void setHead(Node node) {
        if (head != null) {
            node.next = head;
            head.pre = node;
        }
        node.pre = null;
        head = node;
        if (tail == null) {
            tail = node;
        }
    }

    /*
    删除该节点
     */
    private void removeNode(Node node) {
        // 如果是头结点
        if (node.pre == null) {
            head = node.next;
        } else {
            // 普通节点next指针处理
            node.pre.next = node.next;
        }
        // 如果是尾节点
        if (node.next == null) {
            tail = node.pre;
        } else {
            // 普通节点pre指针处理
            node.next.pre = node.pre;
        }
        // 释放node
        node.pre = null;
        node.next = null;
    }
    /*
    获取该节点
     */
    public Integer get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            removeNode(node);
            setHead(node);
            return node.time;
        }
        return null;
    }

    /*
    缓存中插入数据
     */
    public void put(int key, int time) {
        Node node = cache.get(key);
        if (node != null) {
            node.time = time;
            removeNode(node);
        } else {
            node=new Node(key,time);
            if(cache.size()>=capacity){
                cache.remove(tail.key);
                removeNode(tail);
            }
            cache.put(key,node);
        }
        setHead(node);
    }
    /*
    打印链表
     */
    public void print(int currentTime,int limitTime){
        StringBuilder str=new StringBuilder();
        str.append("[");
        Node node=head;
        while (node!=null){
            //超出存储时间
            if(currentTime-node.time>=limitTime) {
                break;
            }
            if(node!=null&&node!=head){
                str.append("->");
            }
            str.append("{number:"+node.key+",storeTime:"+String.valueOf(currentTime-node.time)+"}");

            node=node.next;
        }
        str.append("]");
        System.out.println(str.toString());
    }

}