package leetCode.array;

import java.util.Arrays;

/**
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * <p>
 * Example:
 * Input: 3
 * Output:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n == 1) {
            return new int[][]{{1}};
        }
        int index = 1;
        for (int start = 0, end = matrix[0].length - 1; start <= end; start++, end--) {
            if (start == end) {
                matrix[start][end] = index;
            }
            for (int j = start; j < end; j++) {
                matrix[start][j] = index++;
            }
            for (int i = start; i < end; i++) {
                matrix[i][end] = index++;
            }
            for (int j = end; j > start; j--) {
                matrix[end][j] = index++;
            }
            for (int i = end; i > start; i--) {
                matrix[i][start] = index++;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        SpiralMatrixII spiralMatrixII = new SpiralMatrixII();
        System.out.println(Arrays.deepToString(spiralMatrixII.generateMatrix(4)));
    }
}
