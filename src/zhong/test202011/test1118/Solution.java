package zhong.test202011.test1118;



import java.util.Arrays;

/**
 * @author zhong
 * @description 动态规划：最长上升子序列问题
 * @date 2020/11/18 15:04
 * @motto talk is cheap, show me your code!
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        int res = dp[0];
        for (int i = 1; i < len; i++) {
            // 看以前的，比它小的，说明可以接在后面形成一个更长的子序列
            // int curMax = Integer.MIN_VALUE; 不能这样写，万一前面没有比自己小的，
            // 这个值就得不到更新
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }

            // 在遍历的时候同时找 dp 数组的最大值
            res = Math.max(res, dp[i]);
        }
        return res;
    }


    /**
     * 注意，这种解法为自己的错误解法。
     * @param array 传入的数组
     * @return 最长子序列的长度
     */
    public int longestSubstr(int[] array){
        int len = array.length;

        int[] dp = new int[len];

        Arrays.fill(dp, 1);

        int res = dp[0];

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i]){
                    // res表示是从0~j中最大的数。注意，这里的错误是：不是和前面最大的比，即dp[]数组不一定是单调递增的，这点很重要
                    // 注意：dp[i]表示将下标为i的数字放入其中时，最大的长度（该数字一定要选取），自己的解法就是在这里错了！！！
                    dp[i] = Math.max(dp[j] + 1, res);
                }
            }
            res = Math.max(dp[i], res);
        }

        return res;
    }

    public int longestSubStr2(int[] nums){
        int len = 1, n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] d = new int[n + 1];
        d[len] = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
                int l = 1, r = len, pos = 0;
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }

    public int cuttingRope(int n) {
        double midTmp = Math.sqrt(n);

        // 同时表示有n个
        int mid = (int) midTmp;
        boolean flag = false;
        // 说明是整除
        if (mid * mid == n){
            flag = true;
        }

        int rest = n - mid;
        //剩下的数能整除
        if (rest % (mid - 1) == 0){

        }

        return 0;
    }

}
