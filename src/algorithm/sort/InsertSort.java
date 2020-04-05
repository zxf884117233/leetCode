package algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序，前i个有序，每次将第i个插入到前比其小，后比其大的位置
 * 首先遍历后一个比前一个小的数，然后依次将大的数往后移动，直到某个数比当前数小的，这个位置便是当前数的位置
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {5, 8, 3, 1, 16, 12, 7};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                int temp = arr[i];
                int j;
                for (j = i - 1; j >= 0 && arr[j] > temp; j--) {
                    arr[j + 1] = arr[j];
                }
                arr[j + 1] = temp;
            }
        }
    }
}
