package zhong.test202012.test1207;

/**
 * @author zhong
 * @description 力扣中有关字符串相关的刷题
 * @date 2020/12/7 19:33
 * @motto talk is cheap, show me your code!
 */
public class StringAbout {

    /**
     * @description 矩阵的行列反转：
     * 核心思路：1、确定新数组的大小；2、将原来的二维数组按照列、行的顺寻遍历。
     * @param A
     * @return int[][]
     * @date 2020/12/7 19:42
     */
    public int[][] transpose(int[][] A) {
        //1、确定数组大小，几行几列。
        //2、把原有的列看成行，行看成列

        //特殊情况。A为null
        if (A.length == 0){
            return null;
        }


        int col = A.length;
        int row = A[0].length;
        int[][] result = new int[row][col];
        // 遍历原来的二维数组
        for (int j = 0; j <A[0].length; j++ ){
            for (int i = 0; i < A.length; i++){
                result[j][i] = A[i][j];
            }
        }
        return result;
    }



    public static void main(String[] args) {

    }
}
