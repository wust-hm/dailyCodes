package zhong.test202011.test1103;

/**
 * @description:
 * @author: zhong
 * @date: 2020/11/3 16:16
 * @motto: talk is cheap, show me your code!
 */
public class IsUnique {

    public static void main(String[] args) {
        String str = "abcrt";
        boolean flag = isUnique(str);
        System.out.println(flag);
    }

    /**
     * @description: 判断字符串里面是否有重复的字符
     * @params: astr
     * @return: boolean
     * @date: 2020/11/3 16:47
     */
    public static boolean isUnique(String astr) {
        //边界情况
        if (astr == null || "".equals(astr) || astr.length() == 1){
            return true;
        }

        //正常情况
        int flags[] = new int[26];
        int len = astr.length();
        for (int i = 0; i < len; i++){
            int index = astr.charAt(i) - 'a';
            int temp = ++flags[index];
            if (temp > 1){ return false; }
        }
        return true;
    }

    /**
     * @description 在board中查找有没有符合word的字符串路径
     * @param board
     * @param word
     * @return boolean
     * @date 2020/11/3 16:55
     */
    public static boolean exist0(char[][] board, String word) {
        //先考虑边界情况
        if (board == null || word == null) { return false;}

        //正常情况
        int row = board.length;
        int col = board[0].length;
        int[][] flag = new int[row][col];
        char[] wordChar = word.toCharArray();
        int k = 0;

        for (int i = 0; i < row; i++){
            for (int j = 0; j < board[i].length; j++){
                if (board[i][j] == wordChar[k]){
                    flag[i][j] = 1;
                    k++;
                    search(board, wordChar, k, flag, i + 1, j);
                    search(board, wordChar, k, flag, i, j + 1);
                    search(board, wordChar, k, flag, i - 1, j);
                    search(board, wordChar, k, flag, i, j - 1);
                }
            }
        }

        return false;
    }

    public static void search(char[][] board, char[] wordChar, int k, int[][] flag, int i, int j){
        int row = board.length;
        int col = board[0].length;
        if (i < 0 || i >= row || j < 0 || j >= col || board[i][j] != wordChar[k]){

        } else {
            if (board[i][j] == wordChar[k]){
                board[i][j] = 1;
                k++;

                search(board, wordChar, k, flag, i + 1, j);
                search(board, wordChar, k, flag, i, j + 1);
                search(board, wordChar, k, flag, i - 1, j);
                search(board, wordChar, k, flag, i, j - 1);
            }
        }
    }

    public boolean exist(char[][] board, String word) {
        char[] wordChar = word.toCharArray();
        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (dfs(board, wordChar, i, j, 0)) { return true; }
            }
        }
        return false;
    }

    /**
     * @description 深度优先算法
     * @param board
     * @param word
     * @param i
     * @param j
     * @param k
     * @return boolean
     * @date 2020/11/4 12:29
     */
    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        int row = board.length;
        int col = board[0].length;
        if (i < 0 || i >= row || j < 0 || j >= col || board[i][j] != word[k]) { return false; }
        if (k == word.length - 1) { return true; }
        char tmp = board[i][j];
        board[i][j] = '/';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i, j + 1, k + 1)
                || dfs(board, word, i - 1, j, k + 1) || dfs(board, word, i, j - 1, k + 1);
        board[i][j] = tmp;
        return res;
    }




}
