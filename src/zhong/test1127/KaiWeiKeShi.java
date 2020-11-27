package zhong.test1127;

import java.util.Scanner;

/**
 * @author zhong
 * @description 开唯科识笔试复盘
 * @date 2020/11/27 17:56
 * @motto talk is cheap, show me your code!
 */
public class KaiWeiKeShi {

     static class ListNode{
        private int val;
        private ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode() {
        }

         public ListNode(int val) {
             this.val = val;
         }

         public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }

    public int binaryFind(int[] arr, int s, int e, int target) {
        while (s <= e) {
            int mid = (s + e)/2;

            if (arr[mid] == target) {
                return mid;
            } else {
                // 往左边找
                if (arr[mid] > target){
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            }
        }

        return -1;
    }

    public void print(int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= (2 * i - 1); j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.print(sb);
        StringBuilder sb2 = new StringBuilder();
        for (int i = n - 1; i >= 1; i--) {

            for (int j = 1; j <= (2 * i - 1); j++) {
                sb2.append("*");
            }
            sb2.append("\n");
        }
        System.out.println(sb2);
    }

    public static ListNode addListNode(ListNode first, ListNode second) {
        ListNode head = new ListNode();
        ListNode start = head;
        ListNode i = first;
        ListNode j = second;

        if (first.getNext() == null){
            return second;
        }
        if (second.getNext() == null){
            return first;
        }

        while (i != null && j != null) {
            if (i.getVal() < j.getVal()) {
                head.next = i;
                head = i;
                i = i.getNext();
            } else {
                head.next = j;
                head = j;
                j = j.getNext();
            }
        }
        if (i == null && j != null) {
            head.next = j;
        }
        if (i != null && j == null) {
            head.next = i;
        }
        return start.next;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNum = scanner.nextInt();
        int secondNum = scanner.nextInt();
        ListNode first = new ListNode();
        ListNode firstStart = first;
        ListNode second = new ListNode();
        ListNode secondStart = second;
        for (int i = 0; i < firstNum; i++) {
            ListNode t = new ListNode();
            t.setVal(scanner.nextInt());
            first.setNext(t);
            first = t;
        }

        for (int i = 0; i < secondNum; i++) {
            ListNode t = new ListNode();
            t.setVal(scanner.nextInt());
            second.setNext(t);
            second = t;
        }

        ListNode result = addListNode(firstStart.getNext(), secondStart.getNext());
    }
}
