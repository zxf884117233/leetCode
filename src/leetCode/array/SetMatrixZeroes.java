package leetCode.array;

import java.util.*;

/**
 * SetMatrixZeroes
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 * <p>
 * Example 1:
 * Input:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * Output:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * Example 2:
 * Input:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * Output:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/set-matrix-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 0) {
                    lists.add(Arrays.asList(r, c));
                }
            }
        }
        for (List<Integer> list : lists) {
            Integer row = list.get(0);
            Integer col = list.get(1);
            //向上,行变列不变
            for (int r = row; r >= 0; r--) {
                matrix[r][col] = 0;
            }
            //向下，行变列不变
            for (int r = row; r < matrix.length; r++) {
                matrix[r][col] = 0;
            }
            //向左，列变行不变
            for (int c = col; c >= 0; c--) {
                matrix[row][c] = 0;
            }
            //向右，列变行不变
            for (int c = col; c < matrix[row].length; c++) {
                matrix[row][c] = 0;
            }
        }

        System.out.println(Arrays.deepToString(matrix));
    }

    public static void main(String[] args) {
        SetMatrixZeroes matrixZeroes = new SetMatrixZeroes();
        matrixZeroes.setZeroes(new int[][]{{1}, {0}});
    }
}
