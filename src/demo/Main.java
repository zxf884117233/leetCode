package demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static int calcMinStaff(int[][] arr) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i][0])) {
                if (map.get(arr[i][0]) != null && map.get(arr[i][0]) <= arr[i][0]) {
                    map.put(arr[i][0], arr[i][1]);
                } else {
                    count++;
                }
            } else {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res, n;
        n = in.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
        }
        res = calcMinStaff(arr);
        System.out.println(res);

    }
}
