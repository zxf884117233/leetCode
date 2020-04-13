package algorithm.tree;

/**
 * 菲波那切数列
 */
public class Fibonacci {
  public int fibonacci(int n) {
    if (n < 0) {
      return 0;
    }
    if (n == 1 || n == 2) {
      return 1;
    }
    if (n >= 3) {
      return fibonacci(n - 2) + fibonacci(n - 1);
    }
    return 0;
  }

  public static void main(String[] args) {
    System.out.println(new Fibonacci().fibonacci(6));
  }
}
