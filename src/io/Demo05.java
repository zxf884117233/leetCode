package io;

import java.io.File;
import java.io.IOException;

public class Demo05 {
    public static void main(String[] args) throws Exception {
        File f=new File("E:\\a1.jpg");
        f.setExecutable(false);
        f.setReadable(false);
        f.setWritable(false);

        System.out.println(f.canExecute());
        System.out.println(f.canRead());
        System.out.println(f.canWrite());
        File f2=new File("E:\\a2.jpg");
        System.out.println(f.compareTo(f2));

        System.out.println(f2.createNewFile());
        System.out.println(f2.delete());
    }
}
