package leetCode.array;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * The digits are stored such that the most significant digit is at the head of the list,
 * and each element in the array contain a single digit.
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 * <p>
 * Example 1:
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * <p>
 * Example 2:
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits.length == 0) return new int[]{0};
        Deque<Integer> queue = new ArrayDeque<>();
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += carry;
            if (i != 0 && digits[i] >= 10) {
                digits[i] = digits[i] % 10;
                queue.addFirst(digits[i]);
            } else if (i == 0 && digits[i] >= 10) {
                digits[i] = digits[i] % 10;
                queue.addFirst(digits[i]);
                queue.addFirst(1);
                carry = -1;
                break;
            } else {
                carry = i;
                break;
            }
        }
        for (int i = carry; i >= 0; i--) {
            queue.addFirst(digits[i]);
        }
        if (digits.length != queue.size()) {
            int[] result = new int[queue.size()];
            int i = 0;
            while (!queue.isEmpty()) {
                result[i++] = queue.poll();
            }
            return result;
        }
        return digits;
    }

    public int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        System.out.println(Arrays.toString(plusOne.plusOne2(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(plusOne.plusOne2(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(plusOne.plusOne2(new int[]{1, 2, 9})));
        System.out.println(Arrays.toString(plusOne.plusOne2(new int[]{9, 9})));
        System.out.println(Arrays.toString(plusOne.plusOne2(new int[0])));
    }
}
