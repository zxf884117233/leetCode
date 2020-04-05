package demo;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        Random random = new Random();
        int[] nums = new int[16];
        Random r = new Random();
        int n = r.nextInt(16) + 1;
        while (n < 6) {
            n = r.nextInt(16) + 1;
        }
        for (int i = 0; i < n; i++) {
            do {
                nums[i] = random.nextInt(123);
                if (nums[i] >= 0 && nums[i] <= 9) {
                    System.out.print(nums[i]);
                    break;
                } else if (nums[i] >= 65 && nums[i] <= 90) {
                    char num = (char) nums[i];
                    System.out.print(num);
                    break;
                } else if (nums[i] >= 97 && nums[i] <= 122) {
                    char num = (char) nums[i];
                    System.out.print(num);
                    break;
                }
            } while (true);
        }
    }
}

