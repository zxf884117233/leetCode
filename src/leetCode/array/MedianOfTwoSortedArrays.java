package leetCode.array;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MedianOfTwoSortedArrays {
    /* public double findMedianSortedArrays(int[] nums1, int[] nums2) {
         int[] arr = new int[nums1.length + nums2.length];
         int index = 0;
         int i = 0;
         int j = 0;
         while (i < nums1.length && j < nums2.length) {
             if (nums1[i] == nums2[j]) {
                 arr[index++] = nums1[i++];
                 arr[index++] = nums2[j++];
             } else if (nums1[i] < nums2[j]) {
                 arr[index++] = nums1[i++];
             } else {
                 arr[index++] = nums2[j++];
             }
         }
         while (i < nums1.length) {
             arr[index++] = nums1[i++];
         }
         while (j < nums2.length) {
             arr[index++] = nums2[j++];
         }
         double mid = 0;
         if (arr.length % 2 == 0) {
             double left = arr[arr.length / 2];
             double right = arr[arr.length / 2 - 1];
             mid = (left + right) / 2;
         } else {
             mid = arr[arr.length / 2];
         }
         return mid;
     }*/
/*    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        int start1 = 0;
        int start2 = 0;
        int left = -1;
        int right = -1;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (start1 < len1 && (start2 >= len2 || nums1[start1] <= nums2[start2])) {
                right = nums1[start1++];
            } else {
                right = nums2[start2++];
            }
        }
        if ((len & 1) == 0) {
            return (left + right) / 2.0;
        } else {
            return right;
        }
    }*/
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len % 2 == 0) {
            return (findKth(nums1, 0, nums2, 0, len / 2) + findKth(nums1, 0, nums2, 0, len / 2 + 1)) / 2.0;
        }
        return findKth(nums1, 0, nums2, 0, (len + 1) / 2);
    }

    private int findKth(int[] nums1, int left1, int[] nums2, int left2, int k) {
        if (left1 >= nums1.length) return nums2[left2 + k - 1];
        if (left2 >= nums2.length) return nums1[left1 + k - 1];
        if (k == 1) return Math.min(nums1[left1], nums2[left2]);
        int mid1 = left1 + k / 2 - 1 < nums1.length ? nums1[left1 + k / 2 - 1] : Integer.MAX_VALUE;
        int mid2 = left2 + k / 2 - 1 < nums2.length ? nums2[left2 + k / 2 - 1] : Integer.MAX_VALUE;
        if (mid1 <= mid2) {
            return findKth(nums1, left1 + k / 2, nums2, left2, k - k / 2);
        }
        return findKth(nums1, left1, nums2, left2 + k / 2, k - k / 2);
    }

    public static void main(String[] args) {
        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{1, 2, 3, 4, 6, 7, 8, 9}, new int[]{5}));
    }
}
