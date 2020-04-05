package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class Demo13 {
    public static void main(String[] args) throws Exception{
        OutputStream os=new FileOutputStream("D:bb.txt");
        for(int i=65;i<65+26;i++){
            os.write(i);
        }
        os.flush();
        os.close();
        FileInputStream fi=new FileInputStream("D:\\bb.txt");

        byte[] buffer=new byte[1024];

        int  len=fi.read(buffer,6,36);

        System.out.println(Arrays.toString(buffer));

        System.out.println(new String(buffer,0,len,"utf-8"));
    }
}
