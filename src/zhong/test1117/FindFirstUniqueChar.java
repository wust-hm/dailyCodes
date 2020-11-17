package zhong.test1117;

import java.util.*;

/**
 * @author zhong
 * @description
 * @date 2020/11/17 16:40
 * @motto talk is cheap, show me your code!
 */
public class FindFirstUniqueChar {

    public static void main(String[] args) {
//        String s = "abaccdeff";
//        char c = firstUniqChar(s);
//        System.out.println(c);
        int[] ints = {3, 0, -2, -1, 1, 2};
        List<List<Integer>> lists = threeSum(ints);
    }

    /**
     * 找到字符串s中第一个只出现一次的字符
     *
     * @param s
     * @return
     */
    public static char firstUniqChar(String s) {
        int len = s.length();
        Map<Character, Integer> map = new LinkedHashMap<>(32);
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (map.get(c) == null) {
                map.put(c, 0);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            if (value == 0) {
                return entry.getKey();
            }
        }
        return ' ';
    }

    /**
     * @param nums
     * @return java.util.List<java.util.List < java.lang.Integer>>
     * @description 找出数组中a+b+c=0。超时了，鸡鸡
     * @date 2020/11/17 17:08
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;

        Set<List<Integer>> sets = new HashSet<>();
        for (int i = 0; i < len - 2; i++) {
            int a = nums[i];
            for (int j = i + 1; j < len - 1; j++) {
                int b = nums[j];
                for (int k = j + 1; k < len; k++) {
                    int c = nums[k];
                    if (a + b + c == 0) {
                        int[] array = new int[3];
                        array[0] = a;
                        array[1] = b;
                        array[2] = c;
                        Arrays.sort(array);
                        List<Integer> list = new ArrayList<>();
                        list.add(array[0]);
                        list.add(array[1]);
                        list.add(array[2]);
                        sets.add(list);
                    }
                }
            }
        }
        List<List<Integer>> lists = new ArrayList<>();
        for (List<Integer> t : sets) {
            lists.add(t);
        }

        return lists;
    }
}
