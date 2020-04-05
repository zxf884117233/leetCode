package io;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] strings = {"surprise", "happy", "ctrip", "travel", "wellcome", "student", "system", "program", "editor"};
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] curs = new String[n];
        for (int i = 0; i < n; i++) {
            curs[i] = scanner.next();
        }
        findWords(curs, strings);
    }

    public static String findWords(String[] curs, String[] strings) {
        if(curs.length==0)
        for (String str : strings) {
            for (String s : curs) {
                int len = Math.abs(s.length() - str.length());
                if (len <= 2) {
                    for (int i = 1, count = 0; i < str.length(); i++) {
                        if (s.charAt(i) == str.charAt(i)) {
                            continue;
                        }
                    }
                }
            }
        }
        return null;
    }
}
