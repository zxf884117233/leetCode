package algorithm.tree;

/**
 * 阶乘 n!
 */
public class Factorial {
    public Long factorial(long n) {
        if (n == 0 || n == 1) {
            return 1L;
        }
        return factorial(n - 1) * n;
    }

    public static void main(String[] args) {
        System.out.println(new Factorial().factorial(30));
    }
}
