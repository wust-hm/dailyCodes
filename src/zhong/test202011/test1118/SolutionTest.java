package zhong.test202011.test1118;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution solution;

    @Before
    public void setUp() throws Exception {
        solution = new Solution();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void lengthOfLIS() {
        int[] intArray = {4, 10, 6, 4, 5};
        int[] result = {2, 3, 7, 101};
        assertEquals(result.length, solution.lengthOfLIS(intArray));
    }

    @Test
    public void longestSubstr() {
        int[] array = {4, 10, 6, 4, 5};
        int res = 4;
        assertEquals(res, solution.longestSubstr(array));
    }

    @Test
    public void longestSubStr2() {
        int[] array = {4, 10, 6, 4, 5};
        int res = 4;
        assertEquals(res, solution.longestSubStr2(array));
    }
}