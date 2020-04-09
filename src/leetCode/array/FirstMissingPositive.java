package leetCode.array;

/**
 * 缺失的第一个正整数，求未排序数组中的最小的缺失的值
 * Given an unsorted integer array, find the smallest missing positive integer.
 * <p>
 * Example 1:
 * Input: [1,2,0]
 * Output: 3
 * <p>
 * Example 2:
 * Input: [3,4,-1,1]
 * Output: 2
 * <p>
 * Example 3:
 * Input: [7,8,9,11,12]
 * Output: 1
 * <p>
 * Note:
 * Your algorithm should run in O(n) time and uses constant extra space.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-missing-positive
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FirstMissingPositive {
    /*    public int firstMissingPositive(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 1;
            }
            int first = 1;
            Arrays.sort(nums);
            for (int num : nums) {
                if (num < first) continue;
                if (num > first + 1) return first;
                if (num == first) {
                    first++;
                }
            }
            return first;
        }*/

    /**
     * 思路为hash-map的变种
     * 由题意可知该数K的为正整数，取值范围为[1,n+1],n为数组长度，当K=n+1时，该数组一定为[1,n]的等差数列
     * 数组存在小于0或者大于n的数，K一定在[1,n]之间
     * [1,3,-1,4]
     * nums[nums[i]-1]表示应该存储当前元素的位置的值，例如当下标为1，nums[1]=3,而应该存在3的下标为2，
     * nums[i]-1=2表示应该存在当前元素的位置，若该位置没有当前nums[nums[i]-1]的值，将该值替换过来，替换的值为-1,
     * 若该值存在，继续寻找替换过来的值应该放的位置，不存在结束当前循环，继续下一次遍历。
     * <p>
     * nums[nums[1]-1]=3即nums[2]=3表示存放3的索引是2，不是1
     * 此时查看索引2位置的值是否是当前值3，若是，结束循环，若不是，将当前索引1的值与索引为2的值进行交换
     * 然后继续查看索引为1的值是否是当前索引所匹配的值。
     */
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] >= 1 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /* *
     * 思路：变种的hash-map，K的取值[1,n+1] 索引为键，元素为值
     * 具体做法
     * 1. 检查1是否在数组中，若不存在，表明最小为1，结束
     * 2. 若数组只有1个元素，即nums=[1],返回2
     * 3. 将负数和大于n的数均赋值为1,
     * 4. 循环遍历当前数组，若数组存在当前索引（key），将改值改为-nums[i],不存在不做操作。
     * [1,n-1]对应数组中存在的值，0保存n对应的值，或者[0,n-1]->[1,n]
     * 5. 循环遍历数组，遇到的第一个大于0的数，便是当前最小的正整数，若不存在，则是n+1
     *
     * @param nums
     * @return*/
/*

    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        int first = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 1) {
                first++;
                break;
            }
        }
        if (first == 0) {
            return 1;
        }
        if (len == 1) {
            return 2;
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0 || nums[i] > len) {
                nums[i] = 1;
            }
        }
        for (int i = 0; i < len; i++) {
            int x = Math.abs(nums[i]);
            if (x == len) {
                nums[0] = -Math.abs(nums[i]);
            } else {
                nums[x] = -Math.abs(nums[x]);
            }
        }
        for (int i = 1; i < len; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }
        if (nums[0] > 0) {
            return len;
        }
        return len + 1;
    }
*/

    public static void main(String[] args) {
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        System.out.println(firstMissingPositive.firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(firstMissingPositive.firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(firstMissingPositive.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
    }
}
