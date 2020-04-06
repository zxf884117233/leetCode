package leetCode.array;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须原地修改，只允许使用额外常数空间。
 * <p>
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 *
 * 思路：从后往前找第一个比后面一个数小的数，若存在，从末尾找比当前数大的数，交换位置，将当前数后面的数逆转。
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            swap(nums, i, j);
        }
    }

    public void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

/*
    public void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int i = start;
            int j = end;
            int curr = nums[i];
            while (i < j) {
                while (i < j && nums[j] <= curr) {
                    j--;
                }
                nums[i] = nums[j];
                while (i < j && nums[i] >= curr) {
                    i++;
                }
                nums[j] = nums[i];
            }
            nums[i] = curr;
            quickSort(nums, start, i);
            quickSort(nums, i + 1, end);
        }
    }

    public boolean isHavingNextNum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[0]) {
                return true;
            }
        }
        return false;
    }*/

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(new int[]{1, 3, 2});
    }
}
