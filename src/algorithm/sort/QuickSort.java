package algorithm.sort;

import java.util.Arrays;

/**
 * 快排：设置哨兵值，每趟排序完成其右边的数均比其大，左边的数均比其小。采用分治的算法。
 */

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {8, 6, 8, 9, 5, 2, 5, 5, 7, 9,};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int temp = arr[start];
            int low = start;
            int high = end;
            while (low < high) {
                while (low < high && arr[high] >= temp) {
                    high--;
                }
                arr[low] = arr[high];
                while (low < high && arr[low] <= temp) {
                    low++;
                }
                arr[high] = arr[low];
            }
            arr[high] = temp;
            //-1而不是+1是临界问题，+1或者-1有可能在正好是最后一个元素或者第一个元素
            quickSort(arr, start, low);
            quickSort(arr, low + 1, end);
        }
    }
}
