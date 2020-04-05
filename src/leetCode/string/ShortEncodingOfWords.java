package leetCode.string;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。
 * <p>
 * 例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。
 * <p>
 * 对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。
 * <p>
 * 那么成功对给定单词列表进行编码的最小字符串长度是多少呢？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/short-encoding-of-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ShortEncodingOfWords {
    public int minimumLengthEncoding(String[] words) {
        Comparator<String> cmp = (s1, s2) -> {
            int n1 = s1.length();
            int n2 = s2.length();
            for (int i = 0; i < Math.min(n1, n2); i++) {
                char c1 = s1.charAt(n1 - 1 - i);
                char c2 = s2.charAt(n2 - 1 - i);
                int c = Character.compare(c1, c2);
                if (c != 0) {
                    return c;
                }
            }
            return Integer.compare(n1, n2);
        };
        Arrays.sort(words, cmp);
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            if (!(i + 1 < words.length && words[i + 1].endsWith(words[i]))) {
                res += words[i].length() + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(new ShortEncodingOfWords().minimumLengthEncoding(new String[]{"time", "me", "bell"}));

        /*String[] strings = {"time", "me", "lime", "kk", "me", "sometime", "somkbme", "hell", "shell"};
        Comparator<String> cmp = (s1, s2) -> {
            int N1 = s1.length();
            int N2 = s2.length();
            for (int i = 0; i < Math.min(N1, N2); i++) {
                char c1 = s1.charAt(N1 - 1 - i);
                char c2 = s2.charAt(N2 - 1 - i);
                int c = Character.compare(c1, c2);
                if (c != 0) {
                    return c;
                }
            }
            return Integer.compare(N1, N2);
        };
        Arrays.sort(strings, cmp);
        char a='a';
        String s="b";
        System.out.println(Arrays.toString(strings));*/
/*     String str = "newLifefefefe";
     str.endsWith()*/
      /*  StringBuilder stringBuilder = new StringBuilder();
        System.out.println(stringBuilder.append(str).append("#").append("asd"));
        System.out.println(stringBuilder.replace(0, str.length(), "asd"));*/
        //System.out.println(str.replace(str, "asd"));
        //System.out.println(Arrays.toString(str.toCharArray()));
        // System.out.println(str.lastIndexOf("fe"));
        //System.out.println(str.subSequence(2, 5));
        //System.out.println(str.replace("e", "K"));
        //int [] arr={1,5,6,7,4,8};
        //int i1 = Arrays.binarySearch(arr, 4);
        //System.out.println(i1);
        //  System.out.println(str.lastIndexOf("e", 5));
      /*  char[] chars = new char[str.length()];
        str.getChars(1, 3, chars, 5);
        System.out.println(Arrays.toString(chars));*/
        //System.out.println(str.codePointAt(0));
      /*  byte[] bytes = str.getBytes();
        System.out.println(Arrays.toString(bytes));*/
      /*  for (int i = 1; i < str.length(); i++) {
            //System.out.println(str.charAt(i));
            //System.out.print(str.toLowerCase().charAt(i));
            //System.out.println(str.charAt(i)+"-"+str.codePointAt(i)+"-"+str.codePointBefore(i)+"-"+str.codePointCount(i-1,i+1));

        }*/
        //System.out.println("我的名字是 ".concat("Runoob"));
        /*float floatVar = 5;
        int intVar = 1;
        String stringVar = "a";
        System.out.printf("浮点型变量的值为 " +
                "%f, 整型变量的值为 " +
                " %d, 字符串变量的值为 " +
                "is %s", floatVar, intVar, stringVar);*/
       /* String Str1 = "www.runoob.com";
        String Str2 = "com";
        String Str3 = "RUNOOB";

        System.out.print("返回值 :" );
        System.out.println(Str1.regionMatches(4, Str2, 0, 5));

        System.out.print("返回值 :" );
        System.out.println(Str1.regionMatches(11, Str2, 0, 3));

        System.out.print("返回值 :" );
        System.out.println(Str1.regionMatches(true, 4, Str3, 0, 7));*/
    }
}
