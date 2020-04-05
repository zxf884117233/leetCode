package algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡：每趟结束的最大值放在末尾，遍历过程中存在交换。
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {4, 5, 7, 1, 9, 2, 5};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
