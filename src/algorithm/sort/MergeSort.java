package algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序：不断的拆分，直到不能拆分，最后在进行合并，采用的分治的算法
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1, 7, 2, 6, 3, 9};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            mergeSort(arr, low, middle);
            mergeSort(arr, middle + 1, high);
            merge(arr, low, middle, high);
        }
    }

    public static void merge(int[] arr, int low, int middle, int high) {
        int[] temp = new int[arr.length];
        //记录arr的左半部分索引
        int i = low;
        //记录arr的右半部分索引
        int j = middle + 1;
        //记录临时数组中的指针索引
        int index = low;
        while (i <= middle && j <= high) {
            if (arr[i] <= arr[j]) {
                temp[index++] = arr[i++];
            } else {
                temp[index++] = arr[j++];
            }
        }
        while (i <= middle) {
            temp[index++] = arr[i++];
        }
        while (j <= high) {
            temp[index++] = arr[j++];
        }
        for (int k = low; k <= high; k++) {
            arr[k] = temp[k];
        }
    }
}
