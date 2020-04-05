package io;

import java.io.File;
import java.util.*;


public class Demo01 {
    public static void main(String[] args) {
        //目录分隔符
        System.out.println(File.separator);
        System.out.println(File.separatorChar);
        //路径分隔符
        System.out.println(File.pathSeparator);
        System.out.println(File.pathSeparatorChar);
        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[]{1, 2, 1, 2, 2, 3, 3, 4, 5, 4, 5, 5, 5};
        for (int i = 0; i < arr.length; i++) {
            int value = 1;
            if (map.containsKey(arr[i])) {
                value = map.get(arr[i]);
                value++;
            }
            map.put(arr[i], value);
        }
        map.forEach((key, value) -> {
            if (value < arr.length / 2) {
                System.out.println(key);
            }
        });
        List<Integer>   list=new ArrayList<>();
    }
}
