package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Demo15 {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream=new FileInputStream("E:\\2017java\\12.5\\ch13_io.zip");
        FileOutputStream fileOutputStream=new FileOutputStream("D:\\ch13_io.zip");

        byte[] bytes=new byte[2048];
        int len=-1;
        while ((len=fileInputStream.read(bytes))>0){
            fileOutputStream.write(bytes);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
