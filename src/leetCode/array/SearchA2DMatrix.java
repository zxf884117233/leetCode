package leetCode.array;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * Example 1:
 * Input:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 * Example 2:
 * Input:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 13
 * Output: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            //将二维数组转化为一位数组看，第i个数字代表matrix（m,n）,i/n代表第几行，i%n代表第几列
            if (matrix[mid / n][mid % n] == target) return true;
            else if (matrix[mid / n][mid % n] > target) right = mid - 1;
            else if (matrix[mid / n][mid % n] < target) left = mid + 1;
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        for (int row = 0; row < matrix.length; row++) {
            int left = 0;
            int right = matrix[row].length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (matrix[row][mid] == target) return true;
                else if (matrix[row][mid] > target) right = mid - 1;
                else if (matrix[row][mid] < target) left = mid + 1;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        SearchA2DMatrix searchA2DMatrix = new SearchA2DMatrix();
        System.out.println(searchA2DMatrix.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 3));
        System.out.println(searchA2DMatrix.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 13));

    }
}
