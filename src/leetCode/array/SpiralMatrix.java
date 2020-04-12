package leetCode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * SpiralMatrix 螺旋矩阵，层次遍历，由外到内，考虑边界，单行单列的问题 r<=row && c<=col 必须同时成立 不管哪个为相等，即变为单行或单列
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * <p>
 * Example 1:
 * Input:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * <p>
 * Example 2:
 * Input:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return list;
        }
        for (int r = 0, row = matrix.length - 1, c = 0, col = matrix[0].length - 1; r <= row && c <= col; r++, c++, row--, col--) {
            for (int i = r; i < col; i++) {
                list.add(matrix[r][i]);
            }
            for (int j = c; j <= row; j++) {
                list.add(matrix[j][col]);
            }
            if (r < row && c < col) {
                for (int i = col - 1; i > r; i--) {
                    list.add(matrix[row][i]);
                }
                for (int j = row; j > r; j--) {
                    list.add(matrix[j][r]);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        System.out.println(spiralMatrix.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
        System.out.println(spiralMatrix.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        System.out.println(spiralMatrix.spiralOrder(new int[][]{{6, 9, 7}}));
        System.out.println(spiralMatrix.spiralOrder(new int[][]{{3}, {2}}));
    }
}
