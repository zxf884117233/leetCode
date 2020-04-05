package io;

import java.io.File;
import java.net.URISyntaxException;

public class Demo03 {
    public static void main(String[] args) throws Exception {

        File f1=new File("aa.txt");
        System.out.println(f1);
        //得到绝对路径
        System.out.println(f1.getAbsolutePath());
        System.out.println(f1.getAbsoluteFile());
        //标准化的路径
        System.out.println(f1.getCanonicalPath());
        System.out.println(f1.getCanonicalFile());

        File f=new File(Demo03.class.getResource("aaa.html").toURI());
        System.out.println(f);
        System.out.println(f.getPath());
        System.out.println(f.getName());
        System.out.println(f.getParent());

    }
}
