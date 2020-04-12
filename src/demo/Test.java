package demo;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String s = "26655616";
        long n = Long.parseLong(s);
        System.out.println(n);
        Long[] arr = new Long[32];
        for (int i = 0; i < 32; i++) {
            arr[i] = n % 2;
            n = n / 2;
        }
        System.out.println(Arrays.toString(arr));
        int resule = 0;
        for (int i = 0; i < 32; i++) {
            resule += arr[i] * (Math.pow(2, 31 - i));
        }
        System.out.println(Math.pow(2, 4));
        System.out.println(resule);
    }
}
