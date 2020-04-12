package leetCode.string;

/**
 * N 字形变换
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * 示例 1:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() == 0) return s;
        StringBuilder stringBuilder = new StringBuilder();
        int d = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < s.length(); j += d) {
                stringBuilder.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + d - i < s.length()) {
                    stringBuilder.append(s.charAt(j + d - i));
                }
            }
        }
        return stringBuilder.toString();
    }

    public String convert2(String s, int numRows) {
        if (numRows == 1 || s.length() == 0) return s;
        StringBuilder[] arr = new StringBuilder[numRows];
        for (int i = 0; i < arr.length; i++) arr[i] = new StringBuilder();
        int dir = 1;
        int index = 0;
        for (char c : s.toCharArray()) {
            arr[index].append(c);
            index += dir;
            if (index == 0 || index == numRows - 1) dir = -dir;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (StringBuilder str : arr) stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        ZigZagConversion zigZagConversion = new ZigZagConversion();
        System.out.println(zigZagConversion.convert2("LEETCODEISHIRING", 3));
        System.out.println(zigZagConversion.convert2("LEETCODEISHIRING", 4));
    }
}
