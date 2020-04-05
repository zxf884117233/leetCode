package io;

import java.io.File;
import java.net.URI;



//Java在定义一个类的时候里面只能放方法和属性，这是规定死了的。
//System.out.println()是在调用一个叫println的函数，这里是函数的调用而不是类里面定义一个函数。
public class Demo02 {
    public static void main(String[] args) {
        File f1 = new File("aa.txt");
        System.out.println(f1);

        File f2 = new File("D:\\ufe\\aa.txt");
        System.out.println(f2);

        File f3 = new File("D:\\ufe");
        System.out.println(f3);

        File f4=new File(f3,"aa.txt");
        System.out.println(f4);

        System.out.println(f2.equals(f4));
        System.out.println(f2 == f4);

        try {
            URI uri= Demo02.class.getResource("/io/aaa.html").toURI();
            File f5=new File(uri);
            System.out.println(f5);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
