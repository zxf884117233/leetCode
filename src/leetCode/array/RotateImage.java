package leetCode.array;

import java.util.Arrays;

/**
 * 旋转图像90度
 * 思路1：转置矩阵，每行行反转
 * 思路2：找4个顶点，按照规律循环旋转
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * <p>
 * Note:
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 * <p>
 * Example 1:
 * Given input matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * rotate the input matrix in-place such that it becomes:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * <p>
 * Example 2:
 * Given input matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * rotate the input matrix in-place such that it becomes:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-image
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        for (int start = 0, end = matrix[0].length - 1; start < end; start++, end--) {
            for (int i = start, j = end; i < end; i++, j--) {
                int temp = matrix[start][i];
                matrix[start][i] = matrix[j][start];
                matrix[j][start] = matrix[end][j];
                matrix[end][j] = matrix[i][end];
                matrix[i][end] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        new RotateImage().rotate(arr);
        System.out.println(Arrays.deepToString(arr));

    }
}
