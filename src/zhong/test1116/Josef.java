package zhong.test1116;/**
 * @description
 * @author zhong
 * @date 2020/11/16 16:23
 * @motto talk is cheap, show me your code!
 */
public class Josef {
    public static void main(String[] args) {
        int[] array = new int[14];
        int[] flag = new int[14];
        for (int i = 0; i < array.length; i++){
            array[i] = i + 1;
        }

        int len = array.length;
        int out = 0, n = 3, i = 0, count = 0;
        // 控制次数
        while (out != len){
            while (true){
                if (flag[i] == 0){
                    count++;
                }
                if (count == n){
                    System.out.println(array[i]);
                    out ++;
                    flag[i] = 1;
                    if (out == len){
                        break;
                    }
                    count = 0;
                }
                i = (i + 1) % len;
            }
        }

    }
}
