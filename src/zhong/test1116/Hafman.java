package zhong.test1116;

import java.util.HashMap;

/**
 * @author zhong
 * @description
 * @date 2020/11/16 12:25
 * @motto talk is cheap, show me your code!
 */
public class Hafman {
    public static void main(String[] args) {
        int[] array = new int[13];
        for(int i = 0; i < array.length; i++){
            array[i] = i + 1;
        }

        System.out.println(findLast(array, 3));
    }

    public static int findLast(int[] array, int n){
        Node head = new Node();

        initNode(array, head);

        Node start = head.next;

        while (start.next != start) {
            for(int i = 1; i < n - 1; i++){
                start = start.next;
            }
            int test_int = start.next.getVal();
            System.out.println(test_int);
            start.next = start.next.next;
            start = start.next;
        }

        return start.getVal();
    }

    /**
     * @description 初始化循环链表
     * @param array
     * @param head
     * @return void
     * @date 2020/11/16 14:55
     */
    public static void initNode(int[] array, Node head){
        Node secHead = head;
        for(int i : array){
            Node tmp = new Node(i, null);
            secHead.next = tmp;
            secHead = tmp;
        }
        secHead.next = head.next;
    }

    static class Node{
        int val;
        Node next;

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node() {
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

}
