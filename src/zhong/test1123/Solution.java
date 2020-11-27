package zhong.test1123;

/**
 * @author zhong
 * @description
 * @date 2020/11/23 15:33
 * @motto talk is cheap, show me your code!
 */
public class Solution {
    public static void main(String[] args) {
        int x = 1, y = 2, z = 3;
        int i, j, k;
        for (i = 1; i <= 3; i++) {
            for (j = 1; j <= 3; j++) {
                for (k = 1; k <= 3; k++) {
                    if (i != 1 && j != 2 && j != 3 && i != j && j != k && i != k){
                        System.out.println(i);
                    }
                }
            }
        }
    }
}
