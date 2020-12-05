package zhong.test202010.test1003;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @description: 彩票码随机生成数
 * @author: code-zero
 * @date: 2020/10/4 19:08
 */
public class LotteryTest {
    public static void main(String[] args) {
        int[] redNum = new int[5];
        int[] blueNum = new int[2];
        String color = "red";
        Set<Integer> redSet = new HashSet();
        Set<Integer> blueSet = new HashSet();
        while (true){
            //红区数字生成方法
            redSet.add(createNum(color));
            if (redSet.size() == 5) { break; }
        }
        color = "blue";
        while (true){
            blueSet.add(createNum(color));
            if (blueSet.size() == 2) { break; }
        }

        int i = 0;
        for (int j : redSet){
            redNum[i++] = j;
        }
        i = 0;
        for (int j : blueSet){
            blueNum[i++] = j;
        }

        Arrays.sort(redNum);
        Arrays.sort(blueNum);
        System.out.print("红区数字：");
        for (int j : redNum){
            System.out.print(j + " ");
        }
        System.out.print("\n" + "蓝区数字：");
        for (int j : blueNum){
            System.out.print(j + " ");
        }
        System.out.println();
    }

    /**
     * @description: 生成彩票的每一位数字。如果是红区数字，则是1-32；如果是蓝区数字，则是1-12
     * @param color
     * @return: int
     * @date: 2020/10/4 20:42
     */
    public static int createNum(String color){
        if (color == null){
            return -1;
        }
        int num = 0;
        switch (color){
            case "red":  num = (int)Math.ceil(Math.random() * 35); break;
            case "blue": num = (int)Math.ceil(Math.random() * 12); break;
            default: return num;
        }
        return num;
    }
}
