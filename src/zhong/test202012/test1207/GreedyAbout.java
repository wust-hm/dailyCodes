package zhong.test202012.test1207;

/**
 * @author zhong
 * @description 贪心算法有关的刷题
 * @date 2020/12/7 19:48
 * @motto talk is cheap, show me your code!
 */
public class GreedyAbout {

    /**
     * @param flowerbed
     * @param n
     * @return boolean
     * @description 种花问题
     * 核心思路：1、从头开始遍历。没次跳两格（注意不能越界）。如果是1就继续，是0就看前后有没有1，如果有，不能种；没有，可以种
     * @date 2020/12/7 19:49
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length, count = 0, tempCount = 0;

        // 0、特殊情况：只有1个的时候。
        if (len == 1) {
            if (flowerbed[0] == 1){ tempCount++;  }
            if (n > 0) { return false; }
            else { return true; }
        }

        /*长度至少为2*/
        // 1、处理头
        if (flowerbed[0] == 0){
            if (flowerbed[1] == 0) { count++;  flowerbed[0] = 1; }
        }

        // 2、处理中间：确保pre和next一定是在范围之内
        for (int i = 1; i < len - 1; ) {
            if (flowerbed[i] == 1) {
                i += 2;
            } else {
                int pre = i - 1;
                int next = i + 1;
                // 判断是否可以用这个范围

            }
        }

        // 3、处理尾
        return false;
    }
}
