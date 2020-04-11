package leetCode.array;

/**
 * 最大子序列和：动态规划，分治 ,贪心
 * Given an integer array nums,find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 * <p>
 * Example:
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * <p>
 * Follow up:
 * If you have figured out the O(n) solution,
 * try coding another solution using the divide and conquer approach, which is more subtle.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximumSubarray {
    /**
     * 贪心算法，一般用于处理一维度的问题
     * 时间：O(n)  空间O（1）
     */
    public int maxSubArray(int[] nums) {
        int currIndexSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //当前位置最大和
            currIndexSum = Math.max(nums[i] + currIndexSum, nums[i]);
            //迄今为止的最大和
            maxSum = Math.max(maxSum, currIndexSum);
        }
        return maxSum;
    }

    /**
     * dp 动态规划，适合于解决二维或三维问题，同时也可以解决一维问题  时间O（N） 空间(1s)
     * 在整个数组或在固定大小的滑动窗口中找到总和或最大值或最小值的问题可以通过动态规划（DP）在线性时间内解决。
     * 有两种标准 DP 方法适用于数组：
     * 1.常数空间，沿数组移动并在原数组修改。
     * 2.线性空间，首先沿 left->right 方向移动，然后再沿 right->left 方向移动,合并结果。
     */
    public int maxSubArrayDp(int[] nums) {
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //当前位置的最大和
            if (nums[i - 1] > 0) nums[i] += nums[i - 1];
            //迄今为止的最大和
            maxSum = Math.max(maxSum, nums[i]);
        }
        return maxSum;
    }

    /**
     * 分治
     */
    public int crossSum(int[] nums, int left, int right, int mid) {
        if (right == left) return nums[left];
        //局部利用贪心算法，每次子结果为最优
        int leftSum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i = mid; i > left - 1; --i) {
            currSum += nums[i];
            leftSum = Math.max(currSum, leftSum);
        }
        //局部利用贪心算法，每次子结果为最优
        int rightSum = Integer.MIN_VALUE;
        currSum = 0;
        for (int i = mid + 1; i < right + 1; ++i) {
            currSum += nums[i];
            rightSum = Math.max(currSum, rightSum);
        }
        return leftSum + rightSum;
    }

    public int helper(int[] nums, int left, int right) {
        if (left == right) return nums[left];

        int mid = (left + right) / 2;

        int leftSum = helper(nums, left, mid);
        int rightSum = helper(nums, mid + 1, right);
        int crossSum = crossSum(nums, left, right, mid);

        return Math.max(Math.max(leftSum, rightSum), crossSum);
    }

    public int maxSubArrayMerge(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        System.out.println(maximumSubarray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maximumSubarray.maxSubArrayDp(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        int i = maximumSubarray.maxSubArrayMerge(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(i);
    }
}

