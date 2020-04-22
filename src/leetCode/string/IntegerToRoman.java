package leetCode.string;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, two is written as II in Roman numeral, just two one's added together.
 * Twelve is written as, XII, which is simply X + II.
 * The number twenty seven is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is written as IV.
 * Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX.
 * <p>
 * There are six instances where subtraction is used:
 * I can be placed before V (5) and X (10) to make 4 and 9. 
 * X can be placed before L (50) and C (100) to make 40 and 90. 
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * <p>
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 * <p>
 * Example 1:
 * Input: 3
 * Output: "III"
 * Example 2:
 * Input: 4
 * Output: "IV"
 * Example 3:
 * Input: 9
 * Output: "IX"
 * Example 4:
 * Input: 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 * Example 5:
 * Input: 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-to-roman
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        StringBuilder str = new StringBuilder();
        if (num < 1 || num > 3999) return null;
        int k = 0;
        if (num >= 1000) {
            k = num / 1000;
            for (int i = 0; i < k; i++) {
                str.append("M");
            }
            num = num % 1000;
        }
        if (num >= 500) {
            if (num / 100 == 9) {
                str.append("CM");
                num = num % 100;
            } else {
                k = num / 500;
                for (int i = 0; i < k; i++) {
                    str.append("D");
                }
                num = num - 500;
            }
        }
        if (num >= 100) {
            if (num / 100 == 4) str.append("CD");
            else {
                k = num / 100;
                for (int i = 0; i < k; i++) {
                    str.append("C");
                }
            }
            num = num % 100;
        }
        if (num >= 50) {
            if (num / 10 == 9) {
                str.append("XC");
                num = num % 10;
            } else {
                k = num / 50;
                for (int i = 0; i < k; i++) {
                    str.append("L");
                }
                num = num - 50;
            }
        }
        if (num >= 10) {
            if (num / 10 == 4) str.append("XL");
            else {
                k = num / 10;
                for (int i = 0; i < k; i++) {
                    str.append("X");
                }
            }
            num = num % 10;
        }
        if (num >= 5) {
            if (num == 9) {
                str.append("IX");
                num = 0;
            } else {
                k = num / 5;
                for (int i = 0; i < k; i++) {
                    str.append("V");
                }
                num = num - 5;
            }
        }
        if (num >= 1) {
            if (num == 4) {
                str.append("IV");
            } else {
                for (int i = 0; i < num; i++) {
                    str.append("I");
                }
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        IntegerToRoman integerToRoman = new IntegerToRoman();
        System.out.println(integerToRoman.intToRoman(3));
        System.out.println(integerToRoman.intToRoman(4));
        System.out.println(integerToRoman.intToRoman(9));
        System.out.println(integerToRoman.intToRoman(60));
        System.out.println(integerToRoman.intToRoman(2994));
    }
}
