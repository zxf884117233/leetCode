package demo;

import java.util.*;

public class SiKao {
    public static void main(String[] args) throws ClassNotFoundException {
        int[] arr = {1, 2, 3, 45, 6, 7, 3, 89, 13};
        int[] dp = new int[arr.length];
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int j = Arrays.binarySearch(dp, 0, res, arr[i]);
            if (j < 0) {
                j = -(j + 1);
            }
            dp[j] = arr[i];
            if (j == res) {
                ++res;
            }
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(res);
        Class<?> siKao = Class.forName("demo.SiKao");
        System.out.println(siKao);
        SiKao siKao1 = new SiKao();
        System.out.println(siKao1.getClass());
        Class<SiKao> s = SiKao.class;
        System.out.println(s);
    }

}
