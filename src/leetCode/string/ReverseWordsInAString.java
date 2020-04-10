package leetCode.string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 反转字符串
 * 思路：栈或者双端队列
 * Given an input string, reverse the string word by word.
 * <p>
 * Example 1:
 * Input: "the sky is blue"
 * Output: "blue is sky the"
 * <p>
 * Example 2:
 * Input: "  hello world!  "
 * Output: "world! hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * <p>
 * Example 3:
 * Input: "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 *  
 * Note:
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in the reversed string.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseWordsInAString {
    /*   public String reverseWords(String s) {
           Stack<String> stringStack = new Stack<>();
           int len = s.length();
           for (int start = 0; start < len; start++) {
               if (s.substring(start, start + 1).equals(" ")) continue;
               for (int end = start; end < len; end++) {
                   if (s.substring(end, end + 1).equals(" ") || end == len - 1) {
                       stringStack.push(s.substring(start, end));
                       start = end;
                       break;
                   }
               }
           }
           while (!stringStack.isEmpty()) {
               System.out.print(stringStack.pop());
           }
           return null;
       }*/
    public String reverseWords(String s) {
        Deque<String> deque = new ArrayDeque<>();
        int left = 0;
        int right = s.length() - 1;
        while (left < s.length() && s.charAt(left) == ' ') ++left;
        while (right >= 0 && s.charAt(right) == ' ') --right;
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);
            if (c != ' ') {
                sb.append(c);
            }
            if (c == ' ' && sb.length() != 0) {
                deque.push(sb.toString());
                sb.setLength(0);
            }
            if (left == right) {
                deque.push(sb.toString());
                break;
            }
            ++left;
        }
        return String.join(" ", deque);
    }

    public static void main(String[] args) {
        String s1 = "a good   example";
        ReverseWordsInAString reverseWordsInAString = new ReverseWordsInAString();
        System.out.println(reverseWordsInAString.reverseWords(s1));
    }
}
