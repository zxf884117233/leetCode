package leetCode.string;

import java.util.*;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *  请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 暴力解法：
 * public int lengthOfLongestSubstring(String s){
 * int n=s.length();
 * int result=0;
 * for(int i=0;i<n;i++){
 * for(int j=i+1;j<=n;j++){
 * if(allUnique(s,i,j)) result=Math.max(result,j-i);
 * }
 * }
 * return result;
 * }
 * public boolean allUnique(String s,int start,int end){
 * Set<Character> set=new HashSet<>();
 * for(int i=start;i<end;i++){
 * Character ch=s.charAt(i);
 * if(set.contains(ch)) return false;
 * set.add(ch);
 * }
 * return true;
 * }
 */
public class LongestSubstringWithoutRepeatingCharacters {
    /*    public static int lengthOfLongestSubstring(String s) {
             int[] arr = new int[s.length()];
             for (int i = 0, count = 1; i < s.length(); i++) {
                 for (int j = i + 1; j < s.length(); j++) {
                     String substring = s.substring(i, j);
                     CharSequence charSequence = s.subSequence(j, j + 1);
                     if (!substring.contains(charSequence)) {
                         count++;
                         if (j == s.length() - 1) {
                             arr[i] = count;
                             count = 1;
                             break;
                         }
                     } else {
                         arr[i] = count;
                         count = 1;
                         break;
                     }
                 }
             }
             Arrays.sort(arr);
             return arr[arr.length - 1];
         }*/
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int start = 0, end = 0; end < n; end++) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)) {
                start = Math.max(map.get(ch), start);
            }
            result = Math.max(end - start + 1, result);
            map.put(ch, end + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(str));
    }
}
