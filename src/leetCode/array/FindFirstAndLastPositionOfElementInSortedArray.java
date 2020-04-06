package leetCode.array;

import java.util.Arrays;

/**
 * 搜索数组中目标值所在的左边下标和最右下标，思路
 * 1. 二分查找算法复杂度达到log(n)
 * 2. 左边界，右边界的寻找，以mid为界，不返回mid
 * 3. left<right,结果解读为比target小的值有left个，意思第left个即为当前值，若等于nums.length即为不存在
 * Given an array of integers nums sorted in ascending order,
 * find the starting and ending position of a given target value.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * If the target is not found in the array, return [-1, -1].
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = search(nums, target, true);
        if (left == nums.length || nums[left] != target) {
            return new int[]{-1, -1};
        }
        int right = search(nums, target, false) - 1;
        return new int[]{left, right};
    }

    public int search(int[] nums, int target, boolean isLeft) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target || (isLeft && nums[mid] == target)) {
                right = mid;
            } else if (nums[mid] < target || (!isLeft && nums[mid] == target)) {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FindFirstAndLastPositionOfElementInSortedArray().searchRange(new int[]{1, 2}, 4)));
    }
}
