package zhong.test202011.test1127;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;


public class KaiWeiKeShiTest {

    KaiWeiKeShi shi;

    @Before
    public void setUp() throws Exception {
        shi = new KaiWeiKeShi();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void binaryFind() {
        int[] arr = {5, 6, 7, 8, 9, 10};
        int target = 10;
        Assert.assertEquals(5, shi.binaryFind(arr, 0, arr.length - 1, target));
    }

    @Test
    public void print() {
        shi.print(3);
    }

    @Test
    public void addListNode() {
        Scanner scanner = new Scanner(System.in);
        int firstNum = scanner.nextInt();
        int secondNum = scanner.nextInt();
        KaiWeiKeShi.ListNode first = new KaiWeiKeShi.ListNode();
        KaiWeiKeShi.ListNode firstStart = first;
        KaiWeiKeShi.ListNode second = new KaiWeiKeShi.ListNode();
        KaiWeiKeShi.ListNode secondStart = second;
        for (int i = 0; i < firstNum; i++) {
            KaiWeiKeShi.ListNode t = new KaiWeiKeShi.ListNode();
            t.setVal(scanner.nextInt());
            first.setNext(t);
            first = t;
        }

        for (int i = 0; i < secondNum; i++) {
            KaiWeiKeShi.ListNode t = new KaiWeiKeShi.ListNode();
            t.setVal(scanner.nextInt());
            second.setNext(t);
            second = t;
        }

        shi.addListNode(firstStart.getNext(), secondStart.getNext());

    }
}